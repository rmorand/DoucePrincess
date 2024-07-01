package Domaine;

public class Resultat {
    private Integer numDossard;
    private double temps;

    public Resultat(Integer numDossard, double temps) {
        this.numDossard = numDossard;
        this.temps = temps;
    }

    public Integer getNumDossard(){
        return this.numDossard;
    }

    public double getTemps(){
        return this.temps;
    }

    public String toString() {
        String affichage = "";
        affichage += "Dossard " + this.numDossard + " : " + this.temps;
        return affichage;
    }

}
