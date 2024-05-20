import java.awt.event.WindowStateListener;
import java.util.Objects;

public class Cafe extends Boisson {
    protected String provenance;
    protected int force;

    public Cafe(String nom, double prix, int taille, String provenance, int force) {
        super(nom, prix, taille);
        this.provenance = provenance;
        this.force = force;
    }

    @Override
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
        Cafe cafe = (Cafe) o;

        return Objects.equals(this.nom, cafe.nom)
                && Objects.equals(this.prix, cafe.prix)
                && Objects.equals(this.taille, cafe.taille)
                && Objects.equals(this.provenance, cafe.provenance)
                && Objects.equals(this.force, cafe.force);
    }

    @Override
    public void servir() {
        System.out.println(this.nom + "(" + this.prix + ") - " + this.taille + "cl " + this.nom + " " + this.provenance + " intensité: " + this.force + " servi. Santé !");
    }

    @Override
    public boolean allergie() {
        return false;
    }

}
