package login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/check")
public class LoginUser extends HttpServlet{

    private HttpSession session;
    private String retPage = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        session = request.getSession();
        if (session.getAttribute("user")==null) {
            String userName = request.getParameter("userName");
            String userPassword = request.getParameter("userPassword");

            try {
                if (DBConnection.check(userName, userPassword)) {
                    session = request.getSession();
                    session.setAttribute("user", userName);
                    retPage = "/nik_msh";
                } else retPage = "/error";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else retPage = "/nik_msh";

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher(retPage);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
