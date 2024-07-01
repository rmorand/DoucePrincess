import java.net.URL;
import java.util.*;

public class Fourriere {

    static Map<String, List<Vehicule>> vehiculeTypes = new HashMap<>();
    static Map<String, List<Vehicule>> vehiculeEtats = new HashMap<>();

    private static void afficherParTypeVehicule() {
        System.out.println("_________Affichage par type de véhicule _________");
        boolean first = true;
        for (String type : vehiculeTypes.keySet()) {
            if (!vehiculeTypes.get(type).isEmpty()) {
                if (!first) {
                    System.out.println("------------------");
                }
                first = false;
                for (Vehicule v : vehiculeTypes.get(type)) {
                    System.out.println(v.toString());
                }
            }
        }
    }

    private static void afficherParEtat() {
        System.out.println("_________Affichage par etat _________");
        for (String etat : vehiculeEtats.keySet()) {
            if (!vehiculeEtats.get(etat).isEmpty()) {
                System.out.println("--- " + etat + " ---");
                for (Vehicule v : vehiculeEtats.get(etat)) {
                    System.out.println(v.toString());
                }
            }
        }
    }

    private static void insertionHashMap(Vehicule v) {
        if (!vehiculeTypes.containsKey(v.getType())) {
            vehiculeTypes.put(v.getType(), new ArrayList<>());
        }
        vehiculeTypes.get(v.getType()).add(v);
        if (!vehiculeEtats.containsKey(v.getEtat())) {
            vehiculeEtats.put(v.getEtat(), new ArrayList<>());
        }
        vehiculeEtats.get(v.getEtat()).add(v);
    }

    private static void liberationVehicule() {
        for (Iterator<Vehicule> vehiculeIterator = vehiculeEtats.get("Casse").iterator(); vehiculeIterator.hasNext(); ) {
            Vehicule value = vehiculeIterator.next();
            vehiculeTypes.get(value.getType()).remove(value);
        }
        vehiculeEtats.get("Casse").removeAll(vehiculeEtats.get("Casse"));
        for (Iterator<Vehicule> vehiculeIterator = vehiculeEtats.get("Abandon").iterator(); vehiculeIterator.hasNext(); ) {
            Vehicule value = vehiculeIterator.next();
            vehiculeTypes.get(value.getType()).remove(value);
        }
        vehiculeEtats.get("Abandon").removeAll(vehiculeEtats.get("Abandon"));
    }

    private static void chargerDonnees(String path) {
        for (String line : FileToStr.lireCsv(path)) {
            String[] cells = line.split(";");
            if (cells[0].equals("Moto")) {
                Moto moto = new Moto(cells[1], cells[2], cells[3], cells[4], Integer.parseInt(cells[5]));
                insertionHashMap(moto);
            } else if (cells[0].equals("Voiture")) {
                Voiture voiture = new Voiture(cells[1], cells[2], cells[3], cells[4], Integer.parseInt(cells[5]));
                insertionHashMap(voiture);
            } else {
                System.out.println("Erreur à la ligne [" + line + "]");
                System.out.println("Type de véhicule inconnue [" + cells[0] + "]");
            }
        }
    }

    public static void main(String[] args) {
        URL path = Fourriere.class.getClassLoader().getResource("vehicules.csv");
        if (path == null) {
            throw new RuntimeException("Impossible de trouver le fichier vehicules");
        }
        chargerDonnees(path.getPath());

        afficherParTypeVehicule();
        afficherParEtat();
        liberationVehicule();
        System.out.println();
        afficherParTypeVehicule();
        afficherParEtat();
    }
}
