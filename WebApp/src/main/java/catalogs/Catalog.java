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


@WebServlet("/nik_msh")
public class Catalog extends HttpServlet {
    private String urlSection = "/nik_msh/available?urls=";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        BelChipParser main = new BelChipParser();
        ChipDipParser parse = new ChipDipParser();
        Thread thread = new Thread(parse);
        thread.start();
        List<CatalogInfo> catalogs = main.getCatalog("catalog", "list-item");
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catalogs.addAll(parse.getList());

        request.setAttribute("nik_msh", "nik_msh/");
        request.setAttribute("catalogs", catalogs);
        request.setAttribute("urlSection", urlSection);


        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/catalog.jsp");
        dispatcher.forward(request, response);
    }

}

