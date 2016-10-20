
package gestionnaire;

import entities.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class gestionnaireUtilisateur {
    @PersistenceContext(unitName = "FrenchChic_ProjectPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Utilisateur creeUtilisateur(String pseudo, String password, String profil) {
        Utilisateur u = new Utilisateur(pseudo, password, profil);
        em.persist(u);
        return u;
    }
    
    public void CreerUserTest(){      
       
       creeUtilisateur("domitile", "domitile", "admin");
       creeUtilisateur("daniel", "daniel", "client");
       creeUtilisateur("david", "david", "client");
       creeUtilisateur("walid", "walid", "client");
    }
    
    public boolean Authentification(String pseudo, String password) {

        Query q = em.createQuery("select u from Utilisateur u where u.pseudo=:pseudo and u.password=:password");
        q.setParameter("pseudo", pseudo);
        q.setParameter("password", password);

        if (q.getResultList().size() > 0) {
            return true;
        } else {
            return false;
        }
    }

}
