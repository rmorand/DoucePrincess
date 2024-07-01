package Application;

import Domaine.Resultat;
import Donnees.Bdd;

import java.util.ArrayList;

public class StatCourse {

    //La liste des résultats
    private static ArrayList<Resultat> resultats;

    /**
     * Méthode principale qui lancera les autres afin d'afficher les statistiques de la course
     */
    public static void afficherStat() {
        resultats = chargerResultats();
        afficherResultats(resultats);
        plusRapide(resultats);

        //Example avec le dossard 116
        nbFois(116);
    }

    public static ArrayList<Resultat> chargerResultats() {
        ArrayList<Resultat> resultats = new ArrayList<>();
        Resultat resultat = null;
        for (int dossard : Bdd.recupererLesDossards()) {
            for (double temps : Bdd.recupererLesTemps()) {
                resultat = new Resultat(dossard, temps);
            }
            resultats.add(resultat);
        }
        return resultats;
    }

    public static void afficherResultats(ArrayList<Resultat> resultats) {
        System.out.println(resultats.size() + " résultats : ");
        for (Resultat resultat : resultats) {
            System.out.println(resultat);
        }
    }

    public static void plusRapide(ArrayList<Resultat> resultats) {
        Resultat meilleurResultat = resultats.get(0);
        for (Resultat resultat : resultats) {
            if (resultat.getTemps() < meilleurResultat.getTemps()) {
                meilleurResultat = resultat;
            }
        }
        System.out.println("\nPlus rapide: " + meilleurResultat);
    }

    public static void nbFois(Integer numDossardRecherche){
        Integer nbOccurence = 0;
        for (Resultat resultat : resultats) {
            if(resultat.getNumDossard().equals(numDossardRecherche)){
                nbOccurence += 1;
            }
        }
        System.out.println("Le skieur au dossard " + numDossardRecherche + " a effectué " + nbOccurence + " fois la course");
    }


}
