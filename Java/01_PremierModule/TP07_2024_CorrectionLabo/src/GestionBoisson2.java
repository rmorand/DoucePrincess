public class GestionBoisson2 {

    public static void chargerData(String path) {
        //charger les données dans un tableau
        String[] donnees = FileToStr.lireCsv(path);
        for (String ligne : donnees) {
            System.out.println(ligne);
            String[] elements = ligne.split(";");
            String nom = elements[1];
            Boisson b;
            if (nom.equals("chocolat")) {
                b = new Chocolat(nom, Double.parseDouble(elements[2]), Integer.parseInt(elements[3]), elements[4]);
            } else if (nom.equals("espresso")) {
                b = new Espresso(nom, Double.parseDouble(elements[2]), Integer.parseInt(elements[3]), elements[4],
                        Integer.parseInt(elements[5]), Integer.parseInt(elements[6]));
            } else if (nom.equals("macchiato")) {
                b = new Macchiato(nom, Double.parseDouble(elements[2]), Integer.parseInt(elements[3]), elements[4],
                        Integer.parseInt(elements[5]), Integer.parseInt(elements[6]));
            }
            //Ajout hashMap
            boissonsMap.put(b, Integer.parseInt(elements[0]));
        }


        private void afficherStock() {
            //parcours HashMap
            for (Boisson b : boissonsMap.keySet()) {
                System.out.println(b);
            }
        }

    }


}

}
