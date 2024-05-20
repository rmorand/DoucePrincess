public class Menu {
    //Initialiser la liste dans le constructeur plutot que dans la variable







    public boolean existePlat(Plat platRecherche){
        //version1:
        for(Plat platParcouru: plats){
            if(platRecherche.equals(platParcouru)){
                return true;
            }
        }
        return false;
        /*
        //Version2: Méthode contains()
        return plats.contains(platRecherche); //La méthode contains fait une boucle et retourne un boolean
         */

    }
}
