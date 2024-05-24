public class Espresso extends Cafe {
    private int quantiteCreme;

    public Espresso(String nom, Double prix, int taille, String provenance, int force, int quantiteCreme) {
        super(nom, prix, taille, provenance, force);
        this.quantiteCreme = quantiteCreme;
    }

    public String toString() {
        String affichage = "";
        affichage += this.nom + "(" + this.prix + "Chf) - " + this.taille + "cl " + this.provenance + ", intensité " +
                this.force + ", " + this.quantiteCreme + "cl de crème";
        return affichage;
    }

    public boolean allergie() {
        boolean contientAllergie = false;
        if (this.quantiteCreme > 0) {
            contientAllergie = true;
        }
        return contientAllergie;
    }

}
