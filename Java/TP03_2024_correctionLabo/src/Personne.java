public class Personne {
    private String nom;
    private String prenom;
    private int age;
    private Ecole ecole;

    public Personne(String nom, String prenom, int age, Ecole ecole){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.ecole = ecole;
    }

    public String toString(){
        //On affiche les infos de l'étudiant
        String affichage = this.nom + " " + this.prenom;
        //si l'école est publique, on affiche les info de l'école
        if(ecole.testPublique()){
            affichage += ecole;
        }
        //sinon on affiche juste le nom
        else{
            affichage += ecole.getNom();
        }
        return affichage;
    }

}
