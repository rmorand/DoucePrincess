import java.util.ArrayList;
import java.util.Random;
public class Livre {
    private String titre;
    private String auteur;
    private int nbPage;
    private ArrayList<Recette> recettes = new ArrayList<>();

    public Livre(String titre, String auteur, int nbPage) {
        this.titre = titre;
        this.auteur = auteur;
        this.nbPage = nbPage;
    }

    public void ajoutRecette(Recette r){
            recettes.add(r);
    }

    // A développer
    public String toString(){

        return "\"" + titre + "\" de " + auteur + " (" + nbPage + " pages) contient les recettes : \n" + affichageRecettes();
    }

    private String affichageRecettes() {
        //l'affichage des recettes est géré par la méthode toString de la classe Recette
        String res = "";
        for(Recette r : recettes){
            //le caractère \t permet de faire une tabulation, le caractère \n permet de faire un retour à la ligne
            res += "\t" + r + "\n";
        }
        return res;
    }

    public ArrayList<Recette> getRecettes() {
        return this.recettes;
    }

    public String getTitre() {
        return this.titre;
    }
}

