package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Produits;
import services.ProduitMetir;
import services.ProduitMetierImpl;

public class EditProduitServlet extends HttpServlet {

    private static final ProduitMetir metier = ProduitMetierImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");

        try {
            Long id = Long.parseLong(idParam);
            Produits p = metier.getProduitById(id);

            if (p == null) {
                req.setAttribute("messageErreur", "Produit introuvable.");
                req.setAttribute("listeProduits", metier.getAllProduits());
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                return;
            }

            req.setAttribute("produitEdit", p);
            req.setAttribute("listeProduits", metier.getAllProduits());
            req.getRequestDispatcher("index.jsp").forward(req, resp);

        } catch (NumberFormatException e) {
            req.setAttribute("messageErreur", "ID invalide.");
            req.setAttribute("listeProduits", metier.getAllProduits());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}