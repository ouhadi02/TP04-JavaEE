package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Produits;
import services.ProduitMetir;
import services.ProduitMetierImpl;

public class UpdateProduitSrvlet extends HttpServlet {

    private static final ProduitMetir metier = ProduitMetierImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	
    	
    	
        String idStr       = req.getParameter("idProduit");
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
            Long id     = Long.parseLong(idStr.trim());
            Double prix = Double.parseDouble(prixStr.trim());

            Produits p = new Produits();
            p.setIdProduit(id);
            p.setNom(nom.trim());
            p.setDescription(description.trim());
            p.setPrix(prix);

            metier.updateProduit(p);
            req.setAttribute("messageSucces", "Produit modifié avec succès.");

        } catch (NumberFormatException e) {
            req.setAttribute("messageErreur", "Données invalides.");
        }

        req.setAttribute("listeProduits", metier.getAllProduits());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}