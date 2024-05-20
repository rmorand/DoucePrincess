import java.util.ArrayList;

public class GestionAnalyse {

    private static ArrayList<GestionAnalyse> analyses = new ArrayList<>();

    public static void chargerAnalyses(ArrayList<String[]> fichier) {
        //On veut gérer les analyses correctes : PLA, TOX, VHA
        //Sinon : erreur
        int ligneErreur = 0;
        for(String[] ligne: fichier){
            String type = ligne[1];
            ligneErreur += 1;
            if(type.equals("PLA")){
                Analyse a = new AnalyseSanguine(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[4]),
                        Integer.parseInt(ligne[3]), type, Integer.parseInt(ligne[2]) );
                analyses.add(2);
            } else if(type.equals("VHA") || type.equals("TOX")){
                Analyse a = new AnalyseVirale(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[4]),
                        Integer.parseInt(ligne[3]), type, Boolean.parseBoolean(ligne[2]) );
                analyses.add(2);
            }
            else{
                throw new TypeException("Erreur à la ligne ", ligneErreur, type);
            }
        }
        System.out.println("Le fichier a bien été chargé");
    }

    public static void afficherAnalyses() {
        //A compléter
        System.out.println("---- Affichages des analyses ----");
        for(Analyse a : analyses){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {

        System.out.println("----- Chargement du fichier : LstAnalyses.csv -----");
        try {
            chargerAnalyses(FileToStr.lireFichier("LstAnalyses.csv"));
        }catch(TypeException e){
            System.out.println(e.getMessage());
        }

        System.out.println("----- Chargement du fichier : LstAnalyses2.csv  -----");
        chargerAnalyses(FileToStr.lireFichier("LstAnalyses2.csv"));

        System.out.println("");
        afficherAnalyses();
    }
}

