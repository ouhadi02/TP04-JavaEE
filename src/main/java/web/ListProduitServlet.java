package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Produits;
import services.ProduitMetir;
import services.ProduitMetierImpl;

public class ListProduitServlet extends HttpServlet {
    private static final ProduitMetir metier = ProduitMetierImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("idProduit");
        List<Produits> liste = new ArrayList<>();

        try {
            if (idParam != null && !idParam.trim().isEmpty()) {
                Long id = Long.parseLong(idParam.trim());
                Produits p = metier.getProduitById(id);
                if (p != null) {
                    liste.add(p);
                } else {
                    req.setAttribute("messageInfo", "Aucun produit trouvé avec l'ID : " + id);
                    liste = metier.getAllProduits();
                }
            } else {
                liste = metier.getAllProduits();
            }
        } catch (NumberFormatException e) {
            req.setAttribute("messageErreur", "ID invalide. Veuillez saisir un nombre entier.");
            liste = metier.getAllProduits();
        }

        req.setAttribute("listeProduits", liste);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}