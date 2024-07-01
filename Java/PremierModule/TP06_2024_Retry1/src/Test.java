import java.util.*;

public class Test {
    // Variable "livres" permettant de stocker les livres
    private static ArrayList<Livre> livres = new ArrayList<>();

    private static HashMap<String, HashSet<Recette>> planning = new HashMap<>();

    //Vos autres variables ici...


    /**
     * Charger les données des livres à partir d'un fichier csv : NE PAS MODIFIER
     *
     * @param path
     */
    public static void chargerData(String path) {
        String[] textRecette = FileToStr.lireCsv(path);
        String[] ligne = textRecette[0].split(",");
        Livre l = new Livre(ligne[0], ligne[1], Integer.parseInt(ligne[2]));
        for (int i = 1; i < textRecette.length; i++) {
            ligne = textRecette[i].split(",");
            l.ajoutRecette(new Recette(ligne[0], Integer.parseInt(ligne[1]), Integer.parseInt(ligne[2]), Integer.parseInt(ligne[3])));
        }
        livres.add(l);
    }

    public static void main(String[] args) {
        String localDir = System.getProperty("user.dir");
        chargerData(localDir + "\\src\\Ressources\\livre1.csv");
        chargerData(localDir + "\\src\\Ressources\\livre2.csv");

        // Methodes à developper
        afficherLivres();
        genererPlanning();
        afficherPlanning();
        System.out.println("");
        rechercheRecette(new Recette("Jaret de porc", 10, 2, 60));
        rechercheRecette(new Recette("Jaret de boeuf", 10, 2, 60));
        System.out.println();
        rechercheRecettePlanning(new Recette("Jaret de porc", 10, 2, 60));
        rechercheRecettePlanning(new Recette("Quiche Poireaux Tomates", 4, 8, 120));

    }

    public static void afficherLivres() {
        for (Livre livre : livres) {
            System.out.println(livre);
        }
    }


    public static void genererPlanning() {
        String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        Random r = new Random();

        for (String jour : jours) {
            HashSet<Recette> recettesParJour = new HashSet<>();
            while (recettesParJour.size() < 2) {
                int randomLivre = r.nextInt(livres.size());
                int randomRecette = r.nextInt(livres.get(randomLivre).getRecettes().size());
                Recette recetteAAjouter = livres.get(randomLivre).getRecettes().get(randomRecette);
                recettesParJour.add(recetteAAjouter);
            }
            planning.put(jour, recettesParJour);
        }
    }

    public static void afficherPlanning() {
        for (String jour : planning.keySet()) {
            System.out.println(jour + " : " + planning.get(jour));
        }
    }

    public static void rechercheRecette(Recette recetteRecherche) {
        boolean trouve = false;
        Livre livreAvecRecette = null;
        for (Livre livre : livres) {
            for (Recette recette : livre.getRecettes()) {
                if (recette.equals(recetteRecherche)) {
                    trouve = true;
                    livreAvecRecette = livre;
                }
            }
        }
        if (trouve) {
            System.out.println("Le livre \"" + livreAvecRecette.getTitre() + "\" contient la recette \"" + recetteRecherche.getNom() + "\"");
        } else {
            System.out.println("Aucun livre ne contient la recette \"" + recetteRecherche.getNom() + "\"");
        }
    }


    public static void rechercheRecettePlanning(Recette recetteRecherche) {
        boolean trouve = false;
        String jourAvecRecette = null;
        for (String jour : planning.keySet()) {
            for (Recette recette : planning.get(jour)) {
                if (recette.equals(recetteRecherche)) {
                    trouve = true;
                    jourAvecRecette = jour;
                }
            }
        }
        if (trouve) {
            System.out.println("La recette \"" + recetteRecherche.getNom() + "\" est prévue : " + jourAvecRecette);
        } else {
            System.out.println("Le planning ne contient pas la recette \"" + recetteRecherche.getNom() + "\"");
        }
    }


}
