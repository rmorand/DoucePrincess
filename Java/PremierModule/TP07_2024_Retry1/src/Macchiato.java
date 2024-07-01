public class Macchiato extends Cafe {
    private int quantiteLait;

    public Macchiato(String nom, Double prix, int taille, String provenance, int force, int quantiteLait) {
        super(nom, prix, taille, provenance, force);
        this.quantiteLait = quantiteLait;
    }

    public String toString() {
        String affichage = "";
        affichage += this.nom + "(" + this.prix + "Chf) - " + this.taille + "cl " + this.provenance + ", intensité " +
                this.force + ", " + this.quantiteLait + "cl de lait";
        return affichage;
    }

    public boolean allergie() {
        boolean contientAllergie = false;
        if (this.quantiteLait > 0) {
            contientAllergie = true;
        }
        return contientAllergie;
    }

}
