package catalogs;

import parsers.BelChipParser;
import parsers.ChipDipParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/nik_msh/product")
public class Product extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        BelChipParser main = new BelChipParser();
        ChipDipParser parse = new ChipDipParser();

        String urls = request.getParameter("urls");

        String product;
        if (urls.contains("selected_product") && !urls.contains("product0"))
             product = main.getProduct(urls);
        else product = parse.getProduct(urls);

        if (product.isEmpty()) {
            product = "Товара нет в наличии";
        }

        request.setAttribute("product",product);

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/catalog.jsp");
        dispatcher.forward(request, response);
    }
}