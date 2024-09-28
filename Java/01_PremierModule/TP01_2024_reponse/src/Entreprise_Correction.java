public class Entreprise_Correction {
    //variables: Toutes les variables doivent etre private, toujours commence en minuscule

    private String nom;
    private String adresse;
    private String type;
    private int nbBatiment;
    private int nbEmploye;
    private String detenteurMajoritaire;

    //Constructeurs
    public Entreprise_Correction(String nom, String adresse, String type, int nbBatiment, int nbEmploye, String detenteurMajoritaire){
        this.nom = nom;  //this.nom => attribut de l'objet, nom => paramètre de la méthode
        this.adresse = adresse;
        this.type = type;
        this.nbBatiment = nbBatiment;
        this.nbEmploye = nbEmploye;
        this.detenteurMajoritaire = detenteurMajoritaire;
    }

    //Getters/Setters => seulement ceux qui sont necessaires: type, nbBatiment, nbEmploye
    public int recupererNbBatiment(){
        return this.nbBatiment;
    }

    public void setType(String type){
        this.type = type;
    }


    //Méthodes de la classe
    public void changerNbBatiment(int nombreBatiment){
        this.nbBatiment = nombreBatiment;
    }

    public void afficherInfos(boolean affichageComplet){
        if(affichageComplet){
            //affichage complet
            System.out.println(nom + ", " + adresse);
            System.out.println("reste affichage des infos...");
        }
        else{
            // affichage partiel
            System.out.println(nom + " adresse");
        }
    }

}
