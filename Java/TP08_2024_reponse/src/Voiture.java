public class Voiture extends Vehicule {
    private int chevaux;

    public Voiture(String marque, String modele, int annee, String plaqueImmatriculation, int anneeRevision, int chevaux) {
        super(marque, modele, annee, plaqueImmatriculation, anneeRevision);
        this.chevaux = chevaux;
    }

    public String toString() {
        String affichage = "Voiture : ";
        affichage += super.toString();
        affichage += this.chevaux + " chevaux";
        return affichage;
    }


}
