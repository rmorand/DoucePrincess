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

    public String getTitre(){
        return this.titre;
    }

    public ArrayList<Recette> getRecettes(){
        return this.recettes;
    }

    public void ajoutRecette(Recette r){
            recettes.add(r);
    }

    // A développer

    public String toString(){
        String affichage = "";
        affichage += "\"" + this.titre + "\" de " + this.auteur + " (" + this.nbPage + " pages) contient les recettes : \n";
        for(Recette recette : recettes){
            affichage += "\t" + recette + "\n";
        }
        return affichage;
    }

}

