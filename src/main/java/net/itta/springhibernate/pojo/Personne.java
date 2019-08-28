package net.itta.springhibernate.pojo;
// Generated Aug 26, 2019 10:06:50 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Personne  implements java.io.Serializable {


     private int id;
     private Date naissance;
     private String nom;
     private String prenom;
     private Set voitures = new HashSet(0);

    public Personne() {
    }

	
    public Personne(int id) {
        this.id = id;
    }
    public Personne(int id, Date naissance, String nom, String prenom, Set voitures) {
       this.id = id;
       this.naissance = naissance;
       this.nom = nom;
       this.prenom = prenom;
       this.voitures = voitures;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Date getNaissance() {
        return this.naissance;
    }
    
    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Set getVoitures() {
        return this.voitures;
    }
    
    public void setVoitures(Set voitures) {
        this.voitures = voitures;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personne other = (Personne) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", naissance=" + naissance + ", nom=" + nom + ", prenom=" + prenom + ", voitures=" + voitures + '}';
    }




}


