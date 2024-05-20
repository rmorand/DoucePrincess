import java.util.ArrayList;

//La gestion des menus est géré par la classe restaurant
//La gestion des plats est géré par la classe menu
//La classe plat gère l'affichage des plats
//La classe menu gère l'affichage des menus

public class Restaurant {
    //Gérer les menus: dans une liste
    private static ArrayList<Menu> menus = new ArrayList<>();//On ne peut pas appeler une variable non static dans une méthode static, comme le main





    public static void main(String[] args) {

        //Méthode recherche: pour afficher la docstring faire /** Enter
        /**
         * Métode permettant d'afficher un plat s'il est trouvé dans un menu du restaurant
         * @param p :plat recherché
         */
        public static void recherchePlat(Plat platRecherche){
            boolean platTrouve = false; //Tant qu'un plat n'est pas trouvé, la variable est Faux
            //1. 1er parcours de chaque menu: utilisation d'un foreach:
            for(Menu menuParcouru : menus){
                //vérifier si le platRecherche existe dans le menu
                //2eme parcours d'un menu pour trouver un plat: dans la classe Menu
                //Fonction : si le plat existe dans le menu
                platTrouve = menuParcouru.existePlat(platRecherche);
               if(platTrouve){
                   System.out.println("Ce plat a été trouvé dans le menu : " + menuParcouru);
                   platTrouve = true;
               }
            }
            if(!platTrouve){                            //Ne pas mettre de else dans la boucle, pour ne pas sortir tout de suite de la boucle
                System.out.println("Plat non trouvé");
            }
        }

    }
}