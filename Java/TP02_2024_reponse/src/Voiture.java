public class Voiture {
    /**
     * Classe Voiture servant à instancier des objets voiture
     */
    //Attributs
    private String marque;
    private String modele;
    private int annee;

    //Constructeurs
    public Voiture(String marque, String modele, int annee) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
    }

    //Getters et Setters
    public String getMarque() {
        return this.marque;
    }

    public String getModele() {
        return this.modele;
    }

    public int getAnnee() {
        return this.annee;
    }

}
