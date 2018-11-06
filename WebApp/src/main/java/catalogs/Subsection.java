package catalogs;

import information.CatalogInfo;
import parsers.BelChipParser;
import parsers.ChipDipParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/nik_msh/subsection")
public class Subsection extends HttpServlet {
    private String urlSection = "/nik_msh/product?urls=";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        BelChipParser main = new BelChipParser();
        ChipDipParser parse = new ChipDipParser();
        String urls = request.getParameter("urls");

        List<CatalogInfo> catalogs;
        List<CatalogInfo> subCatalog = new ArrayList<>();

        if (urls.contains("catalog") || urls.contains("catalog-show")) {
            subCatalog = parse.getSubsectionCatalog(urls);
        } else {
            catalogs = main.getCatalog(urls,"cat-item");
            for (int i=0;i<catalogs.size();i++) {
                if (catalogs.get(i).getURL().contains("section/?selected_section=")) {
                    catalogs.removeAll(catalogs);
                    break;
                }
            }
            subCatalog.addAll(catalogs);
            request.setAttribute("catalogs",catalogs);
            request.setAttribute("urlSection",urlSection);
        }


        request.setAttribute("subCatalog",subCatalog);
        request.setAttribute("subUrlSection",urlSection);

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/catalog.jsp");
        dispatcher.forward(request, response);
    }
}
