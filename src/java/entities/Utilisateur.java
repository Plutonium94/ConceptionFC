
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String pseudo;
    private String password;
    private String profil;

    
    public Utilisateur(){}
    
    public Utilisateur(String pseudo, String password, String profil) {
        this.pseudo = pseudo;
        this.password = password;
        this.profil = profil;
    }

    
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }

    public String getProfil() {
        return profil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Utilisateur[ id=" + id + " ]";
    }
    
}
