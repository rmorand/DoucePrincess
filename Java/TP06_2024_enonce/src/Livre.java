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
}

