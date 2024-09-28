package Application;

public class StatCourse {

    //La liste des résultats
    private static List<Resultat> resultats;

    /**
     * Méthode principale qui lancera les autres afin d'afficher les statistiques de la course
     */
    public static void afficherStat(){
        resultats = chargerResultats();
        afficherResultats(resultats);
        plusRapide(resultats);

        //Example avec le dossard 116
        nbFois(116);
    }
    


}
