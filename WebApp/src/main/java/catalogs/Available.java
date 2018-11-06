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
import java.util.List;

@WebServlet("/nik_msh/available")
public class Available extends HttpServlet {
    private String urlSection = "/nik_msh/section?urls=";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        BelChipParser main = new BelChipParser();
        ChipDipParser parse = new ChipDipParser();

        List<CatalogInfo> catalogs;
        String urls = request.getParameter("urls");
        if (urls.contains("catalog")) {
            catalogs = parse.getCatalog(urls,"catalog__header");
        } else {
            catalogs = main.getCatalog(urls, "list-item");
        }

        request.setAttribute("catalogs",catalogs);
        request.setAttribute("urlSection",urlSection);

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/catalog.jsp");
        dispatcher.forward(request, response);
    }
}
