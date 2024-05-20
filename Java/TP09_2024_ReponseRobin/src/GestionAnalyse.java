import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestionAnalyse {

    private static final List<String> authorisedAnalyse = Arrays.asList("PLA", "VHA", "TOX");
    private static final List<Analyse> analyses = new ArrayList<>();

    public static void chargerAnalyses(ArrayList<String[]> fichier) {

        try {
            for (String[] dataLine : fichier) {
                if (authorisedAnalyse.contains(dataLine[1])){
                    Analyse analyse;
                    if ("PLA".equals(dataLine[1])){
                        analyse = new AnalyseSanguine(dataLine[0], dataLine[1], dataLine[2], dataLine[3], dataLine[4]);
                    } else {
                        analyse = new AnalyseVirale(dataLine[0], dataLine[1], dataLine[2], dataLine[3], dataLine[4]);
                    }
                    analyses.add(analyse);
                } else {
                    throw new AnalyseException(fichier.indexOf(dataLine), dataLine[1]);
                }
            }
            System.out.println("\t- Aucune erreur détectée");
        } catch (AnalyseException ae) {
            System.out.print(ae);
            System.out.print(" La suite du fichier n'est pas prise en compte.");
        }

    }

    public static void afficherAnalyses() {
        System.out.println();
        System.out.println("----- Affichage des analyses -----");
        for (Analyse analyse : analyses) {
            System.out.println(analyse);
        }
    }

    public static void main(String[] args) {

        System.out.println("----- Chargement du fichier : LstAnalyses.csv -----");
        chargerAnalyses(FileToStr.lireFichier("LstAnalyses.csv"));
        System.out.println("----- Chargement du fichier : LstAnalyses2.csv  -----");
        chargerAnalyses(FileToStr.lireFichier("LstAnalyses2.csv"));

        System.out.println("");
        afficherAnalyses();
    }
}

