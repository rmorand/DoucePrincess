package TP02;

public class Voiture {
    private String marque;
    private String modele;
    private int annee;

    public Voiture(String marque, String modele, int annee) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
    }

    public String getMarque() {
        return marque;
    }

    @Override
    public String toString() {
        return ", possède une : " + marque + " " + annee;
    }
}
