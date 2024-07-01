public class Personne {
    private String nom;
    private String prenom;
    private Integer age;
    private Ecole ecole;

    public Personne(String nom, String prenom, Integer age, Ecole ecole) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.ecole = ecole;
    }

    public Ecole getEcole() {
        return this.ecole;
    }

    public String afficherNomEcole(){
        return this.ecole.getNom();
    }

    public String toString() {
        String affichage = "";
        affichage += this.nom + " " + this.prenom + " étudie à :\n";
        if(this.ecole.getType().equals("Publique") && this.ecole.getDegre().equals("Tertiaire")){
            affichage += "(Etudiant de niveau " + this.ecole.getDegre() + ")\n" + this.ecole;
        }
        if(this.ecole.getType().equals("Publique") && !this.ecole.getDegre().equals("Tertiaire")){
            affichage += this.ecole;
        }
        else{
            affichage += this.ecole.getNom() + ", Ecole " + this.ecole.getType() + "\n";
        }
        return affichage;
    }
}
