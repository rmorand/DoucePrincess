import java.util.*;

public class Test {
    // Variable "livres" permettant de stocker les livres
    private static ArrayList<Livre> livres = new ArrayList<>();

    //Vos autres variables ici...

    //Gestion du planning
    private static Map<String, Set<Recette>> planning = new HashMap<>();

    //Gestion des jours de la semaine
    private static String[] jours = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};



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

    /**
     * Methode permettant d'afficher les livres (l'affichage est géré par la méthode toString de la classe Livre)
     */
    public static void afficherLivres(){
        for(Livre l : livres){
            System.out.println(l);
        }
    }

    /**
     * Methode permettant de générer un planning de recettes
     */
    public static void genererPlanning() {
        Random r = new Random();
        //Pour chaque jour de la semaine, on tire 2 recettes au hasard dans les livres
        for (String jour : jours) {
            //On garde les recettes dans un Set pour éviter les doublons
            Set<Recette> recettes = new HashSet<>();
            //Utilisation d'une boucle while pour s'assurer qu'on a bien 2 recettes différentes
            while (recettes.size() < 2) {
                //On peut utiliser la methode nextInt(int bound) de la classe Random pour tirer un entier entre 0 et la taille de la liste - 1
                Livre l = livres.get(r.nextInt(livres.size()));
                ArrayList<Recette> recettesLivre = l.getRecettes();
                Recette recette = recettesLivre.get(r.nextInt(recettesLivre.size()));

                //Pas besoin de vérifier si la recette est déjà dans le set, car un set ne peut pas contenir de doublons
                recettes.add(recette);
            }
            //On ajoute le jour et les recettes au planning, directement dans la map créée plus haut
            planning.put(jour, recettes);
        }
    }

    /**
     * Methode permettant d'afficher le planning
     */
    public static void afficherPlanning() {
        //affichage au plus simple, on parcourt les jours et on affiche directement le valeur associée selon le jour qui est la clé dans notre dictionnaire
        for (String jour : jours) {
            System.out.print(jour + " : ");
            //On affiche directement le set de recettes, mais on pourrait aussi utiliser une boucle pour afficher chaque recette une par une
            System.out.println(planning.get(jour));
        }
    }

    /**
     * Methode permettant de rechercher une recette dans les livres
     */
    public static void rechercheRecette(Recette r) {
        boolean trouve = false;
        //On parcourt les livres et pour chaque livre, on parcourt les recettes
        for (Livre l : livres) {
            for (Recette recette : l.getRecettes()) {
                if (recette.equals(r)) {
                    System.out.println("Le livre \"" + l.getTitre() + "\" contient cette recette.");
                    trouve = true;
                }
            }
        }
        if(!trouve){
            System.out.println("Aucune livre ne contient cette recette.");
        }
    }

    /**
     * Methode permettant de rechercher une recette dans le planning
     * @param r
     */
    public static void rechercheRecettePlanning(Recette r) {
        boolean trouve = false;
        //On parcourt les jours du planning, et pour chaque jour, on vérifie si la valeur associée contient la recette recherchée
        for (String jour : jours) {
            if (planning.get(jour).contains(r)) {
                System.out.println("La recette est prévue : " + jour);
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Le planning ne contient pas cette recette");
        }
    }
}
