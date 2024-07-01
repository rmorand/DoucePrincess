import java.util.ArrayList;

public class Restaurant {

    private ArrayList<Menu> menus;


    public Restaurant() {
        menus = new ArrayList<>();
    }

    public ArrayList<Menu> getMenus() {
        return this.menus;
    }

    public void recherchePlat(Plat platRecherche) {
        System.out.println("Recherche de " + platRecherche);
        boolean estDansMenu = false;
        ArrayList<Menu> menusDansLesquelsLePlatEstTrouve = new ArrayList<>();
        for (Menu menu : menus) {
            for (Plat plat : menu.getPlats()) {
                if (platRecherche.equals(plat)) {
                    estDansMenu = true;
                    menusDansLesquelsLePlatEstTrouve.add(menu);
                }
            }
        }
        if (estDansMenu) {
            System.out.println("\tLe plat " + platRecherche + " se trouve dans les menus suivants:  ");
            for (Menu menu : menusDansLesquelsLePlatEstTrouve) {
                System.out.println(menu);
            }
        } else {
            System.out.println("\tLe plat " + platRecherche + " n'est dans aucun menu.");
        }
    }


}