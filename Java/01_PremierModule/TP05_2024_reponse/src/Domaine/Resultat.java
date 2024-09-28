package Domaine;

public class Resultat {
    //Attributs
    private int numDossard;
    private double tpsEffectue;

    //Constructeur
    public Resultat(int numDossard, double tpsEffectue) {
        this.numDossard = numDossard;
        this.tpsEffectue = tpsEffectue;
    }

    //Getter/Setter
    public int getNumDossard() {
        return numDossard;
    }

    public double getTpsEffectue() {
        return tpsEffectue;
    }


    //Méthodes
    @Override
    public String toString() {
        return "Dossard " + numDossard + " : " + tpsEffectue;
    }


}
