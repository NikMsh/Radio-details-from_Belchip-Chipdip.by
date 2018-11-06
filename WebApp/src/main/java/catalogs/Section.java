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

@WebServlet("/nik_msh/section")
public class Section extends HttpServlet {
    private String urlSection = "/nik_msh/product?urls=";
    private String subUrlSection = "/nik_msh/subsection?urls=";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        BelChipParser main = new BelChipParser();
        ChipDipParser parse = new ChipDipParser();

        String urls = request.getParameter("urls");
        List<CatalogInfo> catalogs = new ArrayList<>();
        List<CatalogInfo> subCatalog = new ArrayList<>();

        if (urls.contains("catalog")) {
            subCatalog = parse.getSubsectionCatalog(urls);
            if (subCatalog.isEmpty()) subCatalog = parse.getCatalog(urls,"catalog__g2_row");
            int flag = 0;
            for (int i = 0;i<subCatalog.size();i++) {
               if (subCatalog.get(i).getURL().contains("product")) {
                   catalogs.add(subCatalog.get(i));
                   flag = 1;
               }
            }
            if (flag == 1) subCatalog.removeAll(subCatalog);
            request.setAttribute("catalogs",catalogs);
            request.setAttribute("urlSection",urlSection);
            }
            else {
            catalogs = main.getCatalog(urls,"cat-item");
            Integer pages = main.getNumOfPages(urls);
            if (pages!=null) {
                while (pages>1) {
                    catalogs.addAll(main.getCatalog(urls+"&page="+pages,"cat-item"));
                    pages--;
                }
            }
            for (int i=0;i<catalogs.size();i++) {
                if (catalogs.get(i).getURL().contains("section/?selected_section=")) {
                    subCatalog.add(catalogs.get(i));
                    catalogs.removeAll(catalogs);
                    break;
                }
            }
            request.setAttribute("catalogs",catalogs);
            request.setAttribute("urlSection",urlSection);
        }


        request.setAttribute("subCatalog",subCatalog);
        request.setAttribute("subUrlSection",subUrlSection);

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/catalog.jsp");
        dispatcher.forward(request, response);
    }
}
