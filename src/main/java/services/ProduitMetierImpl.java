package services;

import java.util.List;
import dao.Produits;
import dao.ProduitDAP;
import dao.ProduitImpl;

public class ProduitMetierImpl implements ProduitMetir {
    private static ProduitMetierImpl instance;
    private ProduitDAP dao;

    private ProduitMetierImpl() {
        dao = new ProduitImpl();
        ((ProduitImpl) dao).init();
    }

    public static ProduitMetierImpl getInstance() {
        if (instance == null) {
            instance = new ProduitMetierImpl();
        }
        return instance;
    }

    @Override
    public void addProduit(Produits p) { dao.addProduit(p); }

    @Override
    public void deleteProduit(Long id) { dao.deleteProduit(id); }

    @Override
    public Produits getProduitById(Long id) { return dao.getProduitById(id); }

    @Override
    public List<Produits> getAllProduits() { return dao.getAllProduits(); }

    @Override
    public void updateProduit(Produits p) { dao.updateProduit(p); }
}