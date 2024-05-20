public class Voiture {
    private String marque;
    private String modele;
    private Integer annee;

    public Voiture(String marque, String modele, Integer annee) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
    }

    public String toString(){
        String affichage = "";
        affichage += this.marque + " " + this.modele + " de " + this.annee + ". ";
        return affichage;
    }

}
