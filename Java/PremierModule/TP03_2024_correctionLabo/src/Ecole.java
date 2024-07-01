import java.util.Objects;

public class Ecole {
    private int id;
    private String nom;
    private String type;
    private Filiere[] listeFiliere; //Il y a plusieures filieres par école
    private int cpt = 0;

    public Ecole(int id, String nom, String type, int nbFiliere){
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.listeFiliere = new Filiere[nbFiliere]; //instancie un tableau filiere de 4 éléments,
        // si on connait le nombre d'éléments, taille fixe,  on peut faire un tableau
        // boucle:

    }

    public String getNom(){
        return this.nom;
    }

    public boolean compareEcole(Ecole e2){
        return this.nom.equals(e2.nom); //compare les noms
    }

    public boolean equals(Object obj){ //laisser les meme parametres pour avoir la meme signature
        Ecole e = (Ecole) obj; // considere l'objet en parametre comme une ecole
        return Objects.equals(this.id, e.id);

    }


    public boolean testPublique(){
        return type.equals("Publique"); //On laisse la responsabilité a la classe Ecole
    }


    public void addFiliere(Filiere f){
        //ajouter dans le tableau
        this.listeFiliere[cpt] = f;
        cpt ++;
    }





}
