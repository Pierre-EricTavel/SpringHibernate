package net.itta.springhibernate.pojo;

public class Voiture  implements java.io.Serializable {


     private int id;
     private Personne personnes;
     private String name;

    public Voiture() {
    }

	
    public Voiture(int id) {
        this.id = id;
    }
    public Voiture(int id, Personne personnes, String name) {
       this.id = id;
       this.personnes = personnes;
       this.name = name;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Personne getPersonnes() {
        return this.personnes;
    }
    
    public void setPersonnes(Personne personnes) {
        this.personnes = personnes;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
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
        final Voiture other = (Voiture) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Voiture{" + "id=" + id + ", personnes=" + personnes + ", name=" + name + '}';
    }




}


