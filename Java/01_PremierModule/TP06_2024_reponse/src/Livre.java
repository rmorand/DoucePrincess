import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
public class Livre {
    private final String titre;
    private final String auteur;
    private final int nbPage;
    private final ArrayList<Recette> recettes = new ArrayList<>();

    public Livre(String titre, String auteur, int nbPage) {
        this.titre = titre;
        this.auteur = auteur;
        this.nbPage = nbPage;
    }

    public String getTitre(){
        return this.titre;
    }

    public ArrayList<Recette> getRecettes() {
        return this.recettes;
    }


    public String toString(){
        String result = "\"" + this.titre + "\" de " + this.auteur + " (" + this.nbPage + " pages) contient les recettes :\n";
        for (Recette myRecipe: this.recettes) {
            result = result.concat("\t" + myRecipe + "\n");
        }
        return result;
    }

    public void ajoutRecette(Recette r){
        recettes.add(r);
    }


}

