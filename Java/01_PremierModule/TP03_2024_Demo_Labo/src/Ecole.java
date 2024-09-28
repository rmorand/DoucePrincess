package TP03;

import java.util.Objects;

public class Ecole {

    private int id;
    private String nom;
    private String type;
    private Filliere[] listeFilliere;

    private int cpt = 0;

    public Ecole(int id, String nom, String type, int nbFiliere) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.listeFilliere = new Filliere[nbFiliere];
    }

    public void addFiliere(Filliere f){
        //ajouter dans le tableau :
        this.listeFilliere[cpt] = f;
        cpt++;
    }

    public boolean compareEcole(Ecole e2) {
        return this.nom.equals(e2.nom);
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
                ", type='" + type + '\'' +
                '}';
    }

    public String getNom() {
        return this.nom;
    }

    public boolean testPublique() {
        return this.type.equals("Publique");
    }
}
