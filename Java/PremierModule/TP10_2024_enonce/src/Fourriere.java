public class Fourriere {


    private static void afficherParTypeVehicule(){
    }

    private static void afficherParEtat(){
        
    }

    private static void insertionHashMap(Vehicule v, String etat){
        
    }

    private static void liberationVehicule(){
        
    }

    private static void chargerDonnees(String path){

    }

    public static void main(String[] args) {
        String localDir = System.getProperty("user.dir");
        if(System.getProperty("os.name").contains("Windows")){
            chargerDonnees(localDir + "\\src\\vehicules.csv");
        }else{
            chargerDonnees(localDir + "/src/vehicules.csv");
        }
        afficherParTypeVehicule();
        afficherParEtat();
        liberationVehicule();
        System.out.println();
        afficherParTypeVehicule();
        afficherParEtat();
    }
}
