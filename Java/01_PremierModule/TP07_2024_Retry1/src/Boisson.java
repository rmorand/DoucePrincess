import java.util.Objects;

public abstract class Boisson {
    protected String nom;
    protected Double prix;
    protected int taille;

    public Boisson(String nom, Double prix, int taille) {
        this.nom = nom;
        this.prix = prix;
        this.taille = taille;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Boisson boisson = (Boisson) o;

        return Objects.equals(this.nom, boisson.nom)
                && Objects.equals(this.prix, boisson.prix)
                && Objects.equals(this.taille, boisson.taille);
    }

    public abstract boolean allergie();


}
