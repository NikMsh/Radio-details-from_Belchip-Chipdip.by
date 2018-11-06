package searching;

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

@WebServlet("/nik_msh/search")
public class SearchAll extends HttpServlet{
    private String urlSection = "/nik_msh/product?urls=";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        BelChipParser main = new BelChipParser();
        ChipDipParser parse = new ChipDipParser();
        String urlsBelchip = "/search_fuzzy/?query=";
        String urlsChipDip = "/search?searchtext=";
        String find = request.getParameter("find").replaceAll("\\s+", "+");
        //find.replaceAll("\\s+", "+");
        List<CatalogInfo> catalogs = main.getCatalog(urlsBelchip+find,"cat-item");
        List<CatalogInfo> catalogs2 = parse.getSubsectionCatalog(urlsChipDip+find);

        if (catalogs2 != null || !(catalogs2.isEmpty())) {
            catalogs.addAll(catalogs2);
        }
        if (catalogs.isEmpty()) {
            request.setAttribute("product","<h4>К сожалению, по вашему запросу ничего не найдено</h4>");
        }
        else {
            request.setAttribute("catalogs", catalogs);
            request.setAttribute("urlSection", urlSection);
        }
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/catalog.jsp");
        dispatcher.forward(request, response);
    }
}
