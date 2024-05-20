import java.time.temporal.WeekFields;
import java.util.*;

public class Test {
    // Variable "livres" permettant de stocker les livres
    private static ArrayList<Livre> livres = new ArrayList<>();
    //    private static HashMap<String, HashSet<Recette>> planning = new HashMap<>();
    private static ArrayList<String> week = new ArrayList<>(Arrays.asList("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"));
    private static ArrayList<HashSet<Recette>> planning = new ArrayList<>();


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

        afficherLivres();
        genererPlanning();
        afficherPlanning();
        System.out.println("");
        rechercheRecette(new Recette("Jaret de porc", 10, 2, 60));
        rechercheRecette(new Recette("Jaret de boeuf", 10, 2, 60));
        rechercheRecettePlanning(new Recette("Jaret de porc", 10, 2, 60));

    }

    /**/
    private static void afficherLivres() {
        for (Livre myBook : livres) {
            System.out.println(myBook);
        }
    }

    private static void genererPlanning() {
//        planning.put("Lundi", getRandomRecettes());
//        planning.put("Mardi", getRandomRecettes());
//        planning.put("Mercredi", getRandomRecettes());
//        planning.put("Jeudi", getRandomRecettes());
//        planning.put("Vendredi", getRandomRecettes());
//        planning.put("Samedi", getRandomRecettes());
//        planning.put("Dimanche", getRandomRecettes());
        while (planning.size() < 7) {
            planning.add(getRandomRecettes());
        }
    }

    private static HashSet<Recette> getRandomRecettes() {
        HashSet<Recette> result = new HashSet<>();

        while (result.size() < 2) {
            Integer indexBook = getRandomNumberInRange(0, livres.size() - 1);
            Integer indexRecipe = getRandomNumberInRange(0, (livres.get(indexBook)).getRecettes().size() - 1);
            result.add(livres.get(indexBook).getRecettes().get(indexRecipe));
        }
        return result;
    }

    private static Integer getRandomNumberInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static void afficherPlanning() {
//        planning.forEach((jour, recettes) -> {
//            System.out.println(jour + " : " + recettes);
//        });

        for (String day : week) {
            System.out.println(day + " : " + planning.get(week.indexOf(day)));
        }
    }

    private static void rechercheRecette(Recette recipeToFind) {
        ArrayList<String> titlebookWithRecipe = new ArrayList<>();
        for (Livre myBook : livres) {
            for (Recette myRecipe : myBook.getRecettes()) {
                if (myRecipe.equals(recipeToFind)) {
                    titlebookWithRecipe.add(myBook.getTitre());
                }
            }
        }
        if (titlebookWithRecipe.size() == 0) {
            System.out.println("Aucun livre ne contient cette recette.\n");
        }
        if (titlebookWithRecipe.size() == 1) {
            System.out.println("Le livre \"" + titlebookWithRecipe.get(0) + "\" contient cette recette.");
        }
        if (titlebookWithRecipe.size() > 1) {
            System.out.print("Les livres \"");
            for (String myTitle : titlebookWithRecipe) {
                if (titlebookWithRecipe.indexOf(myTitle) != 0)
                    System.out.print(", ");
                System.out.print(myTitle);
            }
            System.out.println("\" contiennent cette recette.\n");
        }
    }

    private static void rechercheRecettePlanning(Recette recipeToFind) {
        HashSet<String> dayWithRecipes = new HashSet<>();
        for (HashSet<Recette> mesRecettes : planning) {
            for (Recette maRecette : mesRecettes) {
                if (maRecette.equals(recipeToFind)) {
                    dayWithRecipes.add(week.get(planning.indexOf(mesRecettes)));
                }
            }
        }
        if (dayWithRecipes.isEmpty()) {
            System.out.println("Le planning ne contient pas cette recette.");
        } else {
            System.out.print("Cette recette est prévue : ");

            boolean isFirst = true;
            for (String day : dayWithRecipes) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    System.out.print(", ");
                }
                System.out.print(day);
            }
        }
    }
}
