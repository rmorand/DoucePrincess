public class Moto extends Vehicule {
    final int cylindree;

    public Moto(String immatriculation, String marque, String modele, String etat, int cylindree){
        super(immatriculation, marque, modele, etat);
        this.cylindree = cylindree;
    }

    public int getCylindree() {
        return cylindree;
    }

    @Override
    public String toString() {
        return "Moto "  + this.getCylindree() + "cc : " + this.getMarque() + " " + this.getModele() + " immatriculée : " + this.getImmatriculation() + ".";
    }
}
