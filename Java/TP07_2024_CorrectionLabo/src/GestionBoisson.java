public class GestionBoisson {

    public static void chargerData(String path){
        //Charger les données dans un tableau
        String[] donnees = FileToStr.lireCsv(path);
        for (String ligne : donnees){
            System.out.println(ligne);
            //Une ligne : la quantité + instance de boisson
            //Chaque ligne du tableau de doonée sera un tableau de String
            // Split sépare les éléments de la ligne et renvoit un tableau de String
            String[] valeurs = ligne.split(";");
            Boisson b = null;
            if (valeurs[1].equals("chocolat")){
                b = new Chocolat(valeurs[1], Double.parseDouble(valeurs[2]), Integer.parseInt(valeurs[3]), valeurs[4]);
            } else if (valeurs[1].equals("espresso")) {
                b = new Espresso(valeurs[1], Double.parseDouble(valeurs[2]), Integer.parseInt(valeurs[3]), valeurs[4],
                        Integer.parseInt(valeurs[5]), Integer.parseInt(valeurs[6]));
            } else if (valeurs[1].equals("macchiato")) {
                b = new Macchiato(valeurs[1], Double.parseDouble(valeurs[2]), Integer.parseInt(valeurs[3]), valeurs[4],
                        Integer.parseInt(valeurs[5]), Integer.parseInt(valeurs[6]));
            }
            boissonsMap.put(b, Integer.parseInt(valeurs[0]));
        }

    }

}
