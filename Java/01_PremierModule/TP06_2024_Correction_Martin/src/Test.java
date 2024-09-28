import java.util.*;

public class Test {
    // Variable "livres" permettant de stocker les livres
    private static ArrayList<Livre> livres = new ArrayList<>();

    //Vos autres variables ici...


    /**
     * Charger les données des livres à partir d'un fichier csv : NE PAS MODIFIER
     * @param path
     */
    public static void chargerData(String path){
        String[] textRecette = FileToStr.lireCsv(path);
        String[] ligne = textRecette[0].split(",");
        Livre l = new Livre(ligne[0],ligne[1], Integer.parseInt(ligne[2]));
        for(int i = 1; i < textRecette.length; i++){
            ligne = textRecette[i].split(",");
            l.ajoutRecette(new Recette(ligne[0],Integer.parseInt(ligne[1]),Integer.parseInt(ligne[2]),Integer.parseInt(ligne[3])));
        }
        livres.add(l);
    }

    public static void main(String[] args){
        String localDir = System.getProperty("user.dir");
        chargerData(localDir + "\\src\\Ressources\\livre1.csv");
        chargerData(localDir + "\\src\\Ressources\\livre2.csv");

        // Methodes à developper
        afficherLivres();
        genererPlanning();
        afficherPlanning();
        System.out.println("");
        rechercheRecette(new Recette("Jaret de porc",10,2,60));
        rechercheRecette(new Recette("Jaret de boeuf",10,2,60));
        rechercheRecettePlanning(new Recette("Jaret de porc",10,2,60));

    }

    public static void afficherLivres(){}

    public static void genererPlanning(){}

    public static void afficherPlanning(){}

    public static void rechercheRecette(Recette r){}

    public static void rechercheRecettePlanning(Recette r){}


}
