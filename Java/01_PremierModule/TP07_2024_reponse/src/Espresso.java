import java.util.Objects;

public class Espresso extends Cafe {
    private int quantiteCreme;

    public Espresso(String nom, double prix, int taille, String provenance, int force, int quantiteCreme) {
        super(nom, prix, taille, provenance, force);
        this.quantiteCreme = quantiteCreme;
    }


    public String toString() {
        String affichage = "\n" + nom + "(" + prix + "Chf) - " + taille + "cl " + provenance + ", intensité " + force + ", " + quantiteCreme + "cl de lait : ";
        return affichage;
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
        Espresso espresso = (Espresso) o;

        return Objects.equals(this.nom, espresso.nom)
                && Objects.equals(this.prix, espresso.prix)
                && Objects.equals(this.taille, espresso.taille)
                && Objects.equals(this.provenance, espresso.provenance)
                && Objects.equals(this.force, espresso.force)
                && Objects.equals(this.quantiteCreme, espresso.quantiteCreme);
    }

    @Override
    public boolean allergie(){
        if (quantiteCreme <= 0){
            return false;
        }
        return true;
    }
}
