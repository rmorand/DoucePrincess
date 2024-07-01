import java.io.File;
import java.util.HashMap;

public class GestionBoisson {

    private HashMap<Boisson, Integer> stockMap = new HashMap<Boisson, Integer>();


    public static void main(String[] args) {

        GestionBoisson gB = new GestionBoisson();

        String localDir = System.getProperty("user.dir");
        gB.chargerData(localDir + File.separator + "src" + File.separator + "stock.csv");

        System.out.println("------ Affichage du Stock ------- \n");
        gB.afficherStock();
        System.out.println();

        System.out.println("------ Ventes de produits ------- \n");
        Boisson b = new Chocolat("Chocolat", 1.5, 25, "au lait");
        gB.servirProduit(b);
        gB.servirProduit(b);
        gB.servirProduit(b);
        System.out.println();

        System.out.println("------ Affichage du Stock ------- \n");
        gB.afficherStock();

    }

    public void chargerData(String path) {
        String[] stockTableau = FileToStr.lireCsv("stock.csv");
        for (int i = 0; i < stockTableau.length; i++) {
            String[] ligne = stockTableau[i].split(";");
            for (int j = 0; j < ligne.length; j++) {
                if (ligne[1].equals("Chocolat")) {
                    Boisson chocolat = new Chocolat(ligne[1], Double.parseDouble(ligne[2]), Integer.parseInt(ligne[3]), ligne[4]);
                    stockMap.put(chocolat, Integer.parseInt(ligne[0]));
                    break;
                }
                if (ligne[1].equals("Macchiato")) {
                    Boisson macchiato = new Macchiato(ligne[1], Double.parseDouble(ligne[2]), Integer.parseInt(ligne[3]), ligne[4], Integer.parseInt(ligne[5]), Integer.parseInt(ligne[6]));
                    stockMap.put(macchiato, Integer.parseInt(ligne[0]));
                    break;
                }
                if (ligne[1].equals("Espresso")) {
                    Boisson espresso = new Espresso(ligne[1], Double.parseDouble(ligne[2]), Integer.parseInt(ligne[3]), ligne[4], Integer.parseInt(ligne[5]), Integer.parseInt(ligne[6]));
                    stockMap.put(espresso, Integer.parseInt(ligne[0]));
                    break;
                }
            }
        }
    }

    public void afficherStock() {
        String affichage = "";
        for (Boisson boisson : stockMap.keySet()) {
            affichage += boisson + " : " + stockMap.get(boisson) + " unités.";
            if (stockMap.get(boisson) < 2) {
                affichage += " /!\\ A réapprovisionner !";
            }
            if (boisson.allergie()) {
                affichage += "\n- Contient du lactose.\n\n";
            } else {
                affichage += "\n\n";
            }
        }
        System.out.println(affichage);
    }


    public void servirProduit(Boisson boissonAServir) {
        String affichage = "";
        Integer quantiteMiseAJour = 0;
        for (Boisson boisson : stockMap.keySet()) {
            if (boissonAServir.equals(boisson)) {
                if (stockMap.get(boisson) > 0) {
                    affichage += boisson + " servi. Santé !";
                    quantiteMiseAJour = stockMap.get(boisson) - 1;
                    stockMap.put(boisson, quantiteMiseAJour);
                } else {
                    System.out.println("Impossible de réaliser l'opération, le produit désiré n'est plus disponible.");
                }
            }
        }
        System.out.println(affichage);
    }


}



