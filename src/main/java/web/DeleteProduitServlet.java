package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ProduitMetir;
import services.ProduitMetierImpl;

public class DeleteProduitServlet extends HttpServlet {

    private static final ProduitMetir metier = ProduitMetierImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");

        try {
            Long id = Long.parseLong(idParam);

            if (metier.getProduitById(id) == null) {
                resp.sendRedirect("listProduits?erreur=Produit+introuvable");
                return;
            }

            metier.deleteProduit(id);
            resp.sendRedirect("listProduits");

        } catch (NumberFormatException e) {
            resp.sendRedirect("listProduits?erreur=ID+invalide");
        }
    }
}