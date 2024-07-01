import java.util.Objects;

public class Ecole {
    private String nom;
    private String adresse;
    private String type;
    private Integer nbBatiment;
    private String degre;
    private String domaine;
    private Integer nbEtudiant;

    public Ecole(String nom, String adresse, String type, Integer nbBatiment, String degre, String domaine, Integer nbEtudiant) {
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.nbBatiment = nbBatiment;
        this.degre = degre;
        this.domaine = domaine;
        this.nbEtudiant = nbEtudiant;
    }

    public String getNom(){
        return this.nom;
    }

    public String getType(){
        return this.type;
    }

    public String getDegre(){
        return this.degre;
    }

    public void setNbBatiment(Integer nouveauNbBatiment) {
        this.nbEtudiant = nouveauNbBatiment;
    }

    public void setNbEtudiant(Integer nouveauNbEtudiant) {
        this.nbEtudiant = nouveauNbEtudiant;
    }

    public void setDegre(String nouveauDegre) {
        this.degre = nouveauDegre;
        if (this.type.equals("Publique") && (this.degre.equals("Primaire") || this.degre.equals("C.O."))) {
            this.domaine = "Général";
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Ecole ecole = (Ecole) o;

        if (this.type.equals("Privée") && ecole.type.equals("Privée")) {
            return Objects.equals(this.nom, ecole.nom)
                    && Objects.equals(this.adresse, ecole.adresse)
                    && Objects.equals(this.domaine, ecole.domaine);
        } else {
            return Objects.equals(this.nom, ecole.nom)
                    && Objects.equals(this.adresse, ecole.adresse);
        }
    }

    public String toString() {
        String affichage = "";
        affichage += this.nom + ", " + this.adresse +
                "\nEcole " + this.type + " de degré " + this.degre + " dans le domaine " + this.domaine +
                "\nIl y a " + this.nbBatiment + " bâtiments pour " + this.nbEtudiant + " étudiants.\n";
        return affichage;
    }


}
