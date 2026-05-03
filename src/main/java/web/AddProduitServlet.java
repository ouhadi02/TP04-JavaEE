package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Produits;
import services.ProduitMetir;
import services.ProduitMetierImpl;

public class AddProduitServlet extends HttpServlet {

    private static final ProduitMetir metier = ProduitMetierImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nom         = req.getParameter("nom");
        String description = req.getParameter("description");
        String prixStr     = req.getParameter("prix");

        if (nom == null || nom.trim().isEmpty()
                || description == null || description.trim().isEmpty()
                || prixStr == null || prixStr.trim().isEmpty()) {

            req.setAttribute("messageErreur", "Tous les champs sont obligatoires.");
            req.setAttribute("listeProduits", metier.getAllProduits());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }

        try {
            Double prix = Double.parseDouble(prixStr.trim());
            metier.addProduit(new Produits(nom.trim(), description.trim(), prix));
            req.setAttribute("messageSucces", "Produit ajouté avec succès.");
        } catch (NumberFormatException e) {
            req.setAttribute("messageErreur", "Le prix doit être un nombre valide (ex: 1500.0).");
        }

        req.setAttribute("listeProduits", metier.getAllProduits());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}