package dao;

import java.util.ArrayList;
import java.util.List;

public class ProduitImpl implements ProduitDAP {
    private List<Produits> produits = new ArrayList<>();
    private Long compteurId = 0L;

    public void init() {
        addProduit(new Produits("PC 1", "Sony Vaio 1", 7000.0));
        addProduit(new Produits("PC 2", "Sony Vaio 2", 6000.0));
        addProduit(new Produits("PC 3", "Sony Vaio 3", 4000.0));
    }

    @Override
    public void addProduit(Produits p) {
        compteurId++;
        p.setIdProduit(compteurId);
        produits.add(p);
    }

    @Override
    public void deleteProduit(Long id) {
        Produits aSupprimer = getProduitById(id);
        if (aSupprimer != null) {
            produits.remove(aSupprimer);
        }
    }

    @Override
    public Produits getProduitById(Long id) {
        for (Produits p : produits) {
            if (p.getIdProduit().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Produits> getAllProduits() {
        return produits;
    }

    @Override
    public void updateProduit(Produits p) {
        for (int i = 0; i < produits.size(); i++) {
            if (produits.get(i).getIdProduit().equals(p.getIdProduit())) {
                produits.get(i).setNom(p.getNom());
                produits.get(i).setDescription(p.getDescription());
                produits.get(i).setPrix(p.getPrix());
                break;
            }
        }
    }
}