public class Main {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

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
        restaurant.getMenus().add(m1);
        System.out.println();

        m2.ajoutPlat(p9);
        m2.ajoutPlat(p1);
        m2.ajoutPlat(p10);
        restaurant.getMenus().add(m2);
        System.out.println();

        m3.ajoutPlat(p1);
        m3.ajoutPlat(p2);
        m3.ajoutPlat(p3);
        m3.ajoutPlat(p4);
        m3.ajoutPlat(p5);
        m3.ajoutPlat(p6);
        restaurant.getMenus().add(m3);
        System.out.println();

        m4.ajoutPlat(p1);
        m4.ajoutPlat(p2);
        restaurant.getMenus().add(m4);
        System.out.println();

        restaurant.recherchePlat(p1);
        System.out.println();
        restaurant.recherchePlat(p6);


    }
}
