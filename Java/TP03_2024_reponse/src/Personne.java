public class Personne {
    //Attributs
    private String nom;
    private String prenom;
    private int age;
    private String adresse;
    private Ecole ecole;

    //Constructeur
    public Personne(String nom, String prenom, int age, String adresse, Ecole ecole) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.ecole = ecole;
    }

    //Getter/Setter


    //Méthodes
    public void afficherNomEcole() {
        System.out.println(this.ecole.getNom());
    }


    public void afficherInfoEcole() {
        System.out.println(this.ecole);
    }

    @Override
    public String toString() {
        String affichage = "";
        String infoEtudiant = "\nInformations de l'étudiant :"
                + "\nNom: " + prenom + " " + nom
                + "\nAge: " + age
                + "\nAdresse : " + adresse;
        if (this.ecole.getType().equals("Publique")) {
            //affichage de l'école en passant par son toString
            affichage = infoEtudiant;
            if (this.ecole.getDegre().equals("Tertiaire")) {
                affichage += "\nEtudiant de niveau " + ecole.getDegre();
            }
            affichage += "\nEcole: \n" + ecole; //pas besoin d'écrire ecole.toString()
        } else {
            affichage = infoEtudiant + "\nEcole " + ecole.getType() + " " + ecole.getNom();
        }
        return affichage;
    }


}
