package Application;

import Domaine.Resultat;

import javax.naming.spi.DirStateFactory;
import java.util.ArrayList;
import java.util.List;

public class StatCourse {

    //La liste des résultats
    private static List<Resultat> resultats;

    /**
     * Méthode principale qui lancera les autres afin d'afficher les statistiques de la course
     */
    public static void afficherStat() {
        resultats = chargerResultats();
        afficherResultats(resultats);
        System.out.println();
        plusRapide(resultats);

        //Example avec le dossard 116
        nbFois(116);
    }


    /**
     * Methode permettant de créer les resultats stockés dans la liste
     *
     * @return la liste des resultats
     */
    private static List<Resultat> chargerResultats() {
        int[] dossards = Donnees.Bdd.recupererLesDossards();
        double[] temps = Donnees.Bdd.recupererLesTemps();
        List<Resultat> resultats = new ArrayList<Resultat>();

        //La taille des deux tableaux est la même : on peut donc les parcourir en même temps
        //On crée un objet Resultat pour chaque dossard et temps
        for (int i = 0; i < dossards.length; i++) {
            Resultat r = new Resultat(dossards[i], temps[i]);
            resultats.add(r);
        }

        return resultats;
    }

    /**
     * Affiche tous les résultats
     *
     * @param resultats la liste des résultats à afficher
     */
    private static void afficherResultats(List<Resultat> resultats) {
        System.out.println(resultats.size() + " résultats :");
        for (Resultat r : resultats) {
            System.out.println(r);
        }

    }

    /**
     * Methode qui affiche le skieur le plus rapide selon son temps
     *
     * @param resultats la liste des résultats
     */
    private static void plusRapide(List<Resultat> resultats) {
        //On initialise le plus rapide avec le premier résultat : on le changera si on trouve plus rapide
        Resultat plusRapide = resultats.get(0);

        //On parcourt tous les résultats pour trouver le plus rapide
        for (Resultat r : resultats) {
            //Si le temps du résultat actuel est plus petit que le temps du plus rapide, on change le plus rapide
            if (r.getTemps() < plusRapide.getTemps()) {
                plusRapide = r;
            }
        }
        System.out.println("Plus rapide : " + plusRapide);
    }

    /**
     * Methode qui affiche le nombre de fois qu'un skieur avec un dossard a effectué la course
     *
     * @param numeroDossard le dossard à chercher
     */
    private static void nbFois(int numeroDossard) {
        int nbFois = 0;
        //On pourrait utiliser des getters pour récupérer le dossard et comparer les int mais...

        //Utilisation plus propre de la méthode equals, qui compare les objets selon leur dossard
        //Variable Resultat qui servira à chercher le dossard
        Resultat resultatCherche = new Resultat(numeroDossard, 0);
        for (Resultat r : resultats) {
            if (r.equals(resultatCherche)) {
                nbFois++;
            }
        }
        System.out.println("Le skieur au dossard '" + numeroDossard + "' a effectué " + nbFois + " fois la course");

    }


}
