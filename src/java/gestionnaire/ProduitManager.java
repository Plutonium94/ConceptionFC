/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaire;

import javax.ejb.Stateless;
import entities.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class ProduitManager {
    
    @PersistenceContext(unitName = "FrenchChic_ProjectPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
    public void creerProduit(Produit p) {
        em.persist(p);
    }
    
    public List<Produit> getAllProduits() {
        return em.createQuery("Select p from Produit p").getResultList();
    }
    
    public void decrementer(Produit p) {
        em.createQuery("Update Produit SET stock = stock - 1 where p.id = :id and p.stock > 0").setParameter("id", p.getId());
    }
    
    public void incrementer(Produit p, int n) {
        em.createQuery("Update Produit SET stock = stock + :n where p.id = :id").setParameter("id", p.getId()).setParameter("n", n);
    }
    
    
    
    public Produit getProduitDuJour() {
         return (Produit)em.createQuery("Select p from Produit p where p.duJour = TRUE").setMaxResults(1).getResultList().get(0);
    }
    
    public void creerProduits() {
        creerProduit(new Produit("Pantalon", 10, 3, false));
        creerProduit(new Produit("Chemise", 12, 34, true));
        creerProduit(new Produit("Pull", 16, 3, false));
    }
    
    

    public void persist(Object object) {
        em.persist(object);
    }
}
