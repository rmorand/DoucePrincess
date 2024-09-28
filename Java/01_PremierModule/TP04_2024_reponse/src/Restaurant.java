import java.util.ArrayList;
//Bonus: Faire en sorte de ne pas pouvoir mettre deux fois le même plat dans un menu

public class Restaurant {
    //Attribut static : n'est pas instancié
    private static ArrayList<Menu> menus = new ArrayList<Menu>();

    //Méthode static
    //Scinder la méthode Recherche en fonction des responsabilités de chaque classe
    public static void recherche(Plat plat) {
        //Recherche un plat dans la liste de menu
        boolean isInMenu = false;
        System.out.println("\nRecherche de " + plat.getNom() + " (" + plat.getType() + ")");
        // for(Menu m : menuPlat) {m.recherchePlat(p)}
        // Boucle qui parcourt la liste des menus du restaurant
        for (int i = 0; i < menus.size(); i++) {
            if (menus.get(i).contientPlat(plat)) {
                isInMenu = true;
                System.out.println("\tLe plat " + plat.getNom() + " (" + plat.getType() + ") se trouve dans le Menu "
                        + menus.get(i).getNom() + " à " + menus.get(i).getPrix() + "Chf composé de :");
                //Boucle qui parcourt la liste des plats du menu
                for (int j = 0; j < menus.get(i).getPlats().size(); j++) {
                    System.out.print("\t" + menus.get(i).getPlats().get(j).getNom() +
                            " (" + menus.get(i).getPlats().get(j).getType() + ")");
                }
                System.out.println("\n");
            }
        }
        if (!isInMenu) {
            System.out.println("\tLe plat " + plat.getNom() + " (" + plat.getType() + ") n'est dans aucun menu.");
        }
    }


    public static void main(String[] args) {

        Plat p1 = new Plat("Cassoulet", "Plat");
        Plat p2 = new Plat("Pâtes au saumon", "Plat");
        Plat p3 = new Plat("Salade verte", "Entrée");
        Plat p4 = new Plat("Assiette Valaisanne", "Entrée/Plat");
        Plat p5 = new Plat("Coupe Danemark", "Dessert");
        Plat p6 = new Plat("Quiche Lorraine", "Plat");
        Plat p7 = new Plat("Pizza 4 saisons", "Plat");
        Plat p8 = new Plat("Tartare d'aubergines", "Entrée");
        Plat p9 = new Plat("Salade Niçoise", "Entrée/Plat");
        Plat p10 = new Plat("Profiteroles", "Dessert");
        Menu m1 = new Menu("du jour", 35);
        Menu m2 = new Menu("de saison", 40);
        Menu m3 = new Menu("duo", 60);
        Menu m4 = new Menu("enfant", 25);
        Menu m5 = new Menu("découverte", 45);

        m1.ajoutPlat(p1);
        m1.ajoutPlat(p10);
        menus.add(m1);
        m2.ajoutPlat(p9);
        m2.ajoutPlat(p1);
        m2.ajoutPlat(p10);
        menus.add(m2);
        m3.ajoutPlat(p1);
        m3.ajoutPlat(p2);
        m3.ajoutPlat(p3);
        m3.ajoutPlat(p4);
        m3.ajoutPlat(p5);
        menus.add(m3);
        m4.ajoutPlat(p1);
        m4.ajoutPlat(p2);
        menus.add(m4);
        recherche(p1);
        recherche(p6);

        System.out.println("\nAffichage du menu:");
        m1.afficherMenu();

        System.out.println("\nAjout de 2 fois le même plat dans un menu:");
        m1.ajoutPlat(p1);




    }


}