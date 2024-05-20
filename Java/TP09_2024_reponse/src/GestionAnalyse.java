import java.util.ArrayList;

public class GestionAnalyse {

    public static void chargerAnalyses(ArrayList<String[]> fichier) {
        //A compléter
        for(String[] ligne: fichier){
            for()
            System.out.println(ligne);
        }

    }

    public static void afficherAnalyses() {
        //A compléter
    }

    public static void main(String[] args) {

        System.out.println("----- Chargement du fichier : LstAnalyses.csv -----");
        chargerAnalyses(FileToStr.lireFichier("LstAnalyses.csv"));
//        System.out.println("----- Chargement du fichier : LstAnalyses2.csv  -----");
//        chargerAnalyses(FileToStr.lireFichier("LstAnalyses2.csv"));
//
//        System.out.println("");
//        afficherAnalyses();



    }
}

