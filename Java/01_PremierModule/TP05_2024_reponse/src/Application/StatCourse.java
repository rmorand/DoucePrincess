package Application;

import Domaine.Resultat;
import Donnees.Bdd;

import java.util.ArrayList;
import java.util.List;

public class StatCourse {
    //Attributs
    //La liste des résultats
    private static List<Resultat> resultats; // Pourquoi pas une ArrayList???


    //Méthodes

    /**
     * Méthode principale qui lancera les autres afin d'afficher les statistiques de la course
     */
    public static void afficherStat() {
        // On stocke l'ArrayList retournée dans la variable "resultats"
        resultats = chargerResultats();
        // System.out.println(resultats); // -> Test
        afficherResultats(resultats);
        System.out.println(plusRapide(resultats));
        //Example avec le dossard 116
        nbFois(116);
    }


    /**
     * Méthode qui récupère les résultats de la course, puis retourne une liste contenant tous ces résultats.
     */
    public static List<Resultat> chargerResultats() {
        // Déclaration et instanciation d'une ArrayList "resultats"
        List<Resultat> resultats = new ArrayList<>();
        // Appel de 2 fonctions qui retournent 1 tableau de int et 1 tableau de double
        // Affectation de ces tableaux à 2 variables (dossards et temps), qui sont des tableaux
        int[] dossards = Bdd.recupererLesDossards();
        double[] temps = Bdd.recupererLesTemps();
        // Chaque instance de "resultats" est composé des 2 valeurs de chaque tableau (dossards et temps)
        // Parcours du tableau "dossards"
        for (int i = 0; i < dossards.length; i++) {     // tableaux-> utiliser .length
            // A chaque tour de boucle, on déclare et instancie un objet "r" de type Resultat
            // Chaque instance "r" recoit en attributs une valeur de "dossards" et une valeur de "temps"
            Resultat r = new Resultat(dossards[i], temps[i]);
            // On ajoute les instances de Resultat dans la liste "resultats"
            resultats.add(r);
        }
        // On retourne la liste "resultats"
        return resultats;
    }


    /**
     * Méthode qui affiche la liste de résultats recue en paramètre
     *
     * @param resultats: liste de résultats
     */
    public static void afficherResultats(List<Resultat> resultats) {
        System.out.println(resultats.size() + " résultats :");
        for (int i = 0; i < resultats.size(); i++) {
            System.out.println(resultats.get(i));
        }
    }


    /**
     * Méthode qui retourne le meilleur résultat de la course
     *
     * @param resultats : liste de resultats
     */
    public static String plusRapide(List<Resultat> resultats) {
        Resultat meilleurResultat = resultats.get(0);
        for (int i = 1; i < resultats.size(); i++) {
            if (resultats.get(i).getTpsEffectue() < meilleurResultat.getTpsEffectue()) {
                meilleurResultat = resultats.get(i);
            }
        }
        return "\nPlus rapide : " + meilleurResultat;
    }


    /**
     * Méthode qui indique combien de fois un dossard apparait dans la liste
     *
     * @param numDossard: le numero du dossard, dont on veut savoir combien de course il a effectué
     */
    public static void nbFois(int numDossard) {
        String affichage = "Le skieur au dossard '" + numDossard + "' ";
        int nbOccurence = 0;
        for (int i = 0; i < resultats.size(); i++) {
            if (resultats.get(i).getNumDossard() == numDossard) {
                nbOccurence += 1;
            }
        }
        if (nbOccurence == 0) {
            affichage += "n'a jamais effectué la course";
        } else {
            affichage += "a effectué " + nbOccurence + " fois la course";
        }
        System.out.println(affichage);
    }


}
