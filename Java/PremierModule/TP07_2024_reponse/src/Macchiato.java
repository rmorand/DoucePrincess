import java.util.Objects;

public class Macchiato extends Cafe {
    private int quantiteLait;

    public Macchiato(String nom, double prix, int taille, String provenance, int force, int quantiteLait) {
        super(nom, prix, taille, provenance, force);
        this.quantiteLait = quantiteLait;
    }

    public String toString() {
        String affichage = "\n" + nom + "(" + prix + "Chf) - " + taille + "cl " + provenance + ", intensité " + force + ", " + quantiteLait + "cl de lait : ";
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
        Macchiato macchiato = (Macchiato) o;

        return Objects.equals(this.nom, macchiato.nom)
                && Objects.equals(this.prix, macchiato.prix)
                && Objects.equals(this.taille, macchiato.taille)
                && Objects.equals(this.provenance, macchiato.provenance)
                && Objects.equals(this.force, macchiato.force)
                && Objects.equals(this.quantiteLait, macchiato.quantiteLait);
    }

    @Override
    public boolean allergie(){
        if (quantiteLait <= 0){
            return false;
        }
        return true;
    }

}
