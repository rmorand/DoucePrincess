public class Entreprise {
    //Attributs
    private String nom;
    private String adresse;
    private String type;
    private int nbBatiment;
    private String domaine;
    private int nbEmploye;
    private String detenteurMajoritaire;


    //Constructeur
    public Entreprise (String nom, String adresse, String type, int nbBatiment, String domaine, int nbEmploye, String detenteurMajoritaire){
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.nbBatiment = nbBatiment;
        this.domaine = domaine;
        this.nbEmploye = nbEmploye;
        this.detenteurMajoritaire = detenteurMajoritaire;
    }

    //Méthodes
    public void changerNbBatiment(int nouveau_nbBatiment){
        nbBatiment = nouveau_nbBatiment;
    }

    public void changerNbEmploye(int nouveau_nbEmploye){
        nbEmploye = nouveau_nbEmploye;
    }

    public void afficher(boolean test){
        if (test == true) {
            System.out.println(nom + ", " + adresse);
            System.out.println("Entreprise " + type + " détenue par " + detenteurMajoritaire + " dans le domaine " + domaine);
            System.out.println("L'entreprise possède " + nbBatiment + " bâtiments pour " + nbEmploye + " employés.\n");
        }
        else {
            System.out.println(nom + ", " + adresse);
        }
    }

    public void changerType(String  nouveau_Type){
        type = nouveau_Type;
        if (type == "Publique") {  // if type.equals("publique"){this.detenteurMajoritaire = "L'etat"}
            detenteurMajoritaire = "L'Etat";
        }
    }

}
