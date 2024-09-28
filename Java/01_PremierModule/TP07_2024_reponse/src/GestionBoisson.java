public class GestionBoisson {
    public static void main(String[] args){
        GestionBoisson gB = new GestionBoisson();
        String localDir = System.getProperty("user.dir");
        gB.chargerData(localDir + File.separator +"src"+ File.separator +"stock.csv");
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
}
