public abstract class Vehicule {
    //variables de la classe Vehicule
    protected String marque;
    protected String modele;
    protected int annee;
    protected String plaqueImmatriculation;
    protected int anneeRevision;

    public Vehicule(String marque, String modele, int annee, String plaqueImmatriculation, int anneeRevision){
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.plaqueImmatriculation= plaqueImmatriculation;
        this.anneeRevision = anneeRevision;
    }


    public String toString(){
        String affichage = this.marque + " " + this.modele + " de " + this.annee + " - " + this.plaqueImmatriculation
                + " Année de révision : " + this.anneeRevision + " ";
        return affichage;
    }

}
