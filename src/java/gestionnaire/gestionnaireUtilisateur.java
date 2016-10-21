
package gestionnaire;

import entities.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class gestionnaireUtilisateur {
    @PersistenceContext(unitName = "FrenchChic_ProjectPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Utilisateur creeUtilisateur(String pseudo, String password, String profil, String nom, String prenom) {
        Utilisateur u = new Utilisateur(pseudo, password, profil, nom, prenom);
        em.persist(u);
        return u;
    }
    
    public void CreerUserTest(){      
       
       creeUtilisateur("domitile", "domitile", "admin","cheroutre","domitille");
       creeUtilisateur("daniel", "daniel", "client","arasu","daniel");
       creeUtilisateur("david", "david", "client","micallef","david");
       creeUtilisateur("walid", "walid", "client","rhazadi","walid");
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
    
    public Utilisateur findByPseudo(String pseudo) {
        List<Utilisateur> u = (List<Utilisateur>)em.createQuery("select u from Utilisateur u where u.pseudo = :pseudo").setParameter("pseudo", pseudo).setMaxResults(1).getResultList();
        if(u.size() > 0 ) {
            return u.get(0);
        }
        return null;
    }

}
