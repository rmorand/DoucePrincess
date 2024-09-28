import java.util.Objects;

public class Recette {
    private String nom;
    private int page;
    private int nbPersonnes;
    private int temps;

    public Recette(String nom, int page, int nbPersonnes, int temps) {
        this.nom = nom;
        this.page = page;
        this.nbPersonnes = nbPersonnes;
        this.temps = temps;
    }

    public String getNom(){
        return this.nom;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recette)) return false;
        Recette recette = (Recette) o;
        return Objects.equals(this.nom, recette.nom);
    }

   // A developper

    public String toString(){
        String affichage = "";
        affichage += this.nom + " (Page " + this.page + ") pour " + this.nbPersonnes + " personnes. Durée de la recette : " + this.temps + " minutes.";
        return affichage;
    }



}
