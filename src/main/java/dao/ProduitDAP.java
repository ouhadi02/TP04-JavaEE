package dao;

import java.util.List;

public interface ProduitDAP {

    void addProduit(Produits p);
    void deleteProduit(Long id);
    Produits getProduitById(Long id);
    List<Produits> getAllProduits();
    void updateProduit(Produits p);
}