package Collections;

public class Etudiant {
    private String nom;
    private String prenom;
    private int age;


    public Etudiant(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    @Override
    public String toString() {
        //on affiche les infos de l'etudiant
        String affichage = nom +" " +prenom;
        //Si l'ecole est publique, on affiche les infos de l'ecole
        return affichage;


        //sinon, juste le nom
    }
}
