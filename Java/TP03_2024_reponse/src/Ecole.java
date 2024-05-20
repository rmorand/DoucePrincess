public class Ecole {
    // Attributs
    private String nom;
    private String adresse;
    private String type;
    private int nbBatiment;
    private String degre;
    private String domaine;
    private int nbEtudiant;

    //Constructeur
    public Ecole(String nom, String adresse, String type, int nbBatiment, String degre, String domaine, int nbEtudiant) {
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.nbBatiment = nbBatiment;
        this.degre = degre;
        this.domaine = domaine;
        this.nbEtudiant = nbEtudiant;
    }

    //Getter/Setter
    public String getType() { return this.type; }

    public String getNom() { return this.nom; }

    public String getDegre() { return this.degre; }

    public void setNbBatiment(int nouveauNbBatiment) {
        this.nbBatiment = nouveauNbBatiment;
    }

    public void setNbEtudiant(int nouveauNbEtudiant) {
        this.nbEtudiant = nouveauNbEtudiant;
    }


    //Méthodes
    @Override
    public String toString() {
        return nom + ", " + adresse
                + "\nEcole " + type + " de degré " + degre + " dans le domaine " + domaine
                + "\nIl y a " + nbBatiment + " bâtiments " + " pour " + nbEtudiant + " étudiants";
    }

    public boolean equals(Ecole autreEcole) {
        if (this.type.equals("Privée") && autreEcole.type.equals("Privée")) {
            if (this.nom.equals(autreEcole.nom) && this.adresse.equals(autreEcole.adresse) && this.domaine.equals(autreEcole.domaine)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (this.nom.equals(autreEcole.nom) && this.adresse.equals(autreEcole.adresse)) {
                return true;
            } else {
                return false;
            }
        }
    }


    public void SetDegre(String nouveauDegre) {
        this.degre = nouveauDegre;
        if (this.type.equals("Publique")) {
            if (this.degre.equals("Primaire") || this.degre.equals("C.O.")) {
                this.domaine = "Général";
            }
        }
    }


}
