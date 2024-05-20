public class Entreprise {
    private String nom;
    private String adresse;
    private String type;
    private Integer nbBatiment;
    private String domaine;
    private Integer nbEmploye;
    private String detenteurMajoritaire;


    public Entreprise(String nom, String adresse, String type, Integer nbBatiment, String domaine, Integer nbEmploye, String detenteurMajoritaire){
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.nbBatiment = nbBatiment;
        this.domaine = domaine;
        this.nbEmploye = nbEmploye;
        this.detenteurMajoritaire = detenteurMajoritaire;
    }

    public void changerNbBatiment(Integer nouveauNbBatiment){
        this.nbBatiment = nouveauNbBatiment;
    }

    public void changerNbEmploye(Integer nouveauNbEmploye){
        this.nbEmploye = nouveauNbEmploye;
    }

    public void changerType(String nouveauType){
        this.type = nouveauType;
        if (this.type.equals("Publique")){
            this.detenteurMajoritaire = "L'Etat";
        }
    }

    public void afficher(Boolean estComplet){
        String affichage = "";
        if(estComplet){
            affichage = this.nom + ", " + this.adresse +
                    "\nEntreprise \"" + this.type + "\" détenue par \"" + this.detenteurMajoritaire + "\" dans le domaine " + this.domaine +
                    "\nL'entreprise possède " + this.nbBatiment + " batiments pour " + this.nbEmploye + " employés.\n";
        }
        else{
            affichage = this.nom + ", " + this.adresse + "\n";
        }
        System.out.println(affichage);
    }



}