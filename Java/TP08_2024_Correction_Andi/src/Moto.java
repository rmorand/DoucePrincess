public class Moto extends Vehicule{
    //A compléter...
    private int cylindre;

    public Moto(String marque, String modele, int annee, String plaqueImmatriculation, int anneeRevision, int cylindre) {
        super(marque, modele, annee, plaqueImmatriculation, anneeRevision);
        this.cylindre = cylindre;
    }

    @Override
    public String toString() {
        return super.getMarque() +
                "cylindre=" + cylindre +
                '}';
    }
}
