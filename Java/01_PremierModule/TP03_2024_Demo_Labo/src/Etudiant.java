package TP03;

public class Etudiant {
    private String nom;
    private String prenom;
    private int age;
    private Ecole ecole;

    private Filliere filliere;

    public Etudiant(String nom, String prenom, int age, Ecole ecole) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.ecole = ecole;
    }

    @Override
    public String toString() {
        //on affiche les infos de l'etudiant
        String affichage = nom +" " +prenom;
        //Si l'ecole est publique, on affiche les infos de l'ecole
        if(ecole.testPublique()){

            affichage += ecole;
        }
        else{
            affichage += ecole.getNom();
        }
        return affichage;


        //sinon, juste le nom
    }
}
