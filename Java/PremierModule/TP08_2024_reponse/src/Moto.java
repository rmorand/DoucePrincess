public class Moto extends Vehicule{
    private int cylindree;

    public Moto(String marque, String modele, int annee, String plaqueImmatriculation, int anneeRevision, int cylindree){
        super(marque, modele, annee, plaqueImmatriculation, anneeRevision);
        this.cylindree = cylindree;
    }

    public String toString() {
        String affichage = "Moto : ";
        affichage += super.toString();
        affichage += this.cylindree + "cm3";
        return affichage;
    }

}
