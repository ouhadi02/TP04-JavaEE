package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    private static final String LOGIN = "admin";
    private static final String PASSWORD = "admin123";

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String login    = req.getParameter("login");
        String password = req.getParameter("password");

        if (LOGIN.equals(login) && PASSWORD.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("utilisateur", login);
            resp.sendRedirect("listProduits");
        } else {	

            req.setAttribute("erreurLogin", "Identifiants incorrects. Veuillez réessayer.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}