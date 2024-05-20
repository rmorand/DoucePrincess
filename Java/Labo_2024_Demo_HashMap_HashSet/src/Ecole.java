package Collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Ecole {

    private int id;
    private String nom;
    private String type;

    private HashMap<Filliere, HashSet<Etudiant>> donnees;

    public Ecole(int id, String nom, String type) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.donnees = new HashMap<>();
    }
    public void addFilliere(Filliere f){
        this.donnees.put(f, new HashSet<>());
    }
    public void addEtudiant(Filliere f, Etudiant e){
        this.donnees.get(f).add(e);
    }


    @Override
    public boolean equals(Object obj){
        Ecole e = (Ecole) obj;
        return Objects.equals(this.id, e.id);
    }

    @Override
    public String toString() {
        return "Ecole{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' + donnees;
    }

    public String getNom() {
        return this.nom;
    }

    public boolean testPublique() {
        return this.type.equals("Publique");
    }
}
