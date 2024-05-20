import java.util.Objects;

public class Recette {
    private final String nom;
    private final int page;
    private final int nbPersonnes;
    private final int temps;

    public Recette(String nom, int page, int nbPersonnes, int temps) {
        this.nom = nom;
        this.page = page;
        this.nbPersonnes = nbPersonnes;
        this.temps = temps;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Recette))
            return false;

        return Objects.equals(nom, ((Recette) o).nom);
    }

    public String toString(){
        return this.nom + " (Page " + this.page + ") pour " + this.nbPersonnes + " personnes. Durée de la recette : " + this.temps + " minutes.";
    }

}
