public class Voiture extends Vehicule{
    private final int nbPorte;

    public Voiture(String immatriculation, String marque, String modele, String etat, int nbPorte){
        super(immatriculation, marque, modele, etat);
        this.nbPorte = nbPorte;
    }

    public int getNbPorte() {
        return nbPorte;
    }

    @Override
    public String toString() {
        return "Voiture "  + this.getNbPorte() + " portes : " + this.getMarque() + " " + this.getModele() + " immatriculée : " + this.getImmatriculation() + ".";
    }
}
