import Domaine.Boisson;
import Domaine.Chocolat;
import Domaine.Espresso;
import Domaine.Macchiato;

import java.io.File;
import java.util.HashMap;

public class GestionBoisson {

    public static HashMap<Boisson, Integer> stock = new HashMap<Boisson, Integer>();
    public static void main(String[] args){
        GestionBoisson gB = new GestionBoisson();
        String localDir = System.getProperty("user.dir");
        gB.chargerData(localDir + File.separator +"stock.csv");
        System.out.println("------ Affichage du Stock ------- \n");
        gB.afficherStock();
        System.out.println();
        System.out.println("------ Ventes de produits ------- \n");
        Boisson b = new Chocolat("Chocolat",1.5, 25,"au lait");
        gB.servirProduit(b);
        gB.servirProduit(b);
        gB.servirProduit(b);
        System.out.println();
        System.out.println("------ Affichage du Stock ------- \n");
        gB.afficherStock();

    }



    /**
     * Permet de charger les données du fichier csv dans le stock
     * @param path : chemin du fichier csv
     */
    public void chargerData(String path){
        // On lit le fichier csv
        String[] data = FileToStr.lireCsv(path);

        // On parcourt les lignes du fichier
        for (String ligne : data){
            // On sépare les données de la ligne par le délimiteur ;
            // et on les stocke dans un tableau
            String[] donnees = ligne.split(";");

            // On crée un objet Boisson, en fonction du type de boisson
            Boisson b = null;
            if (donnees[1].equals("Chocolat")){
                b = new Chocolat(donnees[1], Double.parseDouble(donnees[2]), Integer.parseInt(donnees[3]), donnees[4]);
            }
            else if (donnees[1].equals("Espresso")){
                b = new Espresso(donnees[1], Double.parseDouble(donnees[2]), Integer.parseInt(donnees[3]), donnees[4], Integer.parseInt(donnees[5]), Integer.parseInt(donnees[6]));
            }
            else if (donnees[1].equals("Macchiato")){
                b = new Macchiato(donnees[1], Double.parseDouble(donnees[2]), Integer.parseInt(donnees[3]), donnees[4], Integer.parseInt(donnees[5]), Integer.parseInt(donnees[6]));
            }
            else {
                System.out.println("Erreur de lecture du fichier");
            }
            stock.put(b, Integer.parseInt(donnees[0]));
        }
    }

    /**
     * Permet d'afficher le stock de boissons
     */
    public void afficherStock(){
        for (Boisson b : stock.keySet()){
            System.out.println(b.toString() + " : " + stock.get(b) + " unités." + b.allergie());

        }
    }

    public void servirProduit(Boisson b) {
        if (stock.containsKey(b)){
            if (stock.get(b) > 0){
                stock.put(b, stock.get(b) - 1);
                System.out.println(b.toString() + " servi. Santé !");
            }
            else {
                System.out.println("Impossible de réaliser l'opération. Le produit désiré n'est plus disponible.");
            }
        }
        else {
            System.out.println("Impossible de réaliser l'opération. Le produit désiré n'est plus disponible.");

        }
    }
}
