package services;

import java.util.List;
import dao.Produits;

public interface ProduitMetir {

    void addProduit(Produits p);
    void deleteProduit(Long id);
    Produits getProduitById(Long id);
    List<Produits> getAllProduits();
    void updateProduit(Produits p);
}