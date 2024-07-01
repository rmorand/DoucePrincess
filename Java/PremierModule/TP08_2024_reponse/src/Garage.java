import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Garage {

    // les variables de Garage permettant de gérer les vehicules à l'intérieur de celui-ci
    private ArrayList<Vehicule> vehicules = new ArrayList<>();

    public void main() {
        Moto m1 = new Moto("kawasaki", "z900", 2017, "BE0202022", 2019, 948);
        Moto m2 = new Moto("Suzuki", "SV650", 2014, "VS0203045", 2017, 650);
        Voiture v1 = new Voiture("Renault", "Clio", 2010, "GE1234567", 2012, 98);
        Voiture v2 = new Voiture("Porsche", "911", 2016, "GE0987654", 2017, 368);
        entreeVehicule(m1);
        entreeVehicule(m2);
        entreeVehicule(v1);
        entreeVehicule(v2);
        System.out.println();
        System.out.println("Affichage liste des vehicules : ");
        afficherVehicules();
        System.out.println();

        System.out.println("Affichage carnet : ");

        HashMap<Integer, ArrayList<Vehicule>> carnetVehicules = creerCarnetVehicule(vehicules);

        afficherCarnetVehicule(carnetVehicules);
        System.out.println();

        System.out.println("Email : ");
        envoiPromotion();
        System.out.println();

        System.out.println("Révision de tous les véhicules puis affichage !");
        reviserTousLesVehicules();
        afficherVehicules();
        System.out.println();

        System.out.println("Affichage carnet (après révision): ");

        HashMap<Integer, ArrayList<Vehicule>> carnetVehicules2 = creerCarnetVehicule(vehicules);

        afficherCarnetVehicule(carnetVehicules2);
        System.out.println();

        System.out.println("Email : ");
        envoiPromotion();
        System.out.println();

        System.out.println("Sortie de la suzuki, puis affichage");
        sortieVehicule(m2);
        afficherVehicules();
        System.out.println();

        System.out.println("Affichage carnet final: ");
        afficherCarnetVehicule(carnetVehicules2);

    }

    public void entreeVehicule(Vehicule vehiculeAEntrer) {
        vehicules.add(vehiculeAEntrer);
    }

    public void sortieVehicule(Vehicule vehiculeASortir) {
//      Trouver l'index du véhicule dans la liste, si le vehicule n'est pas dans la liste, indexOf() retourne -1
        int index = vehicules.indexOf(vehiculeASortir);
//      Vérifier si le véhicule est présent dans la liste
        if (index != -1) {
            vehicules.remove(index);
        } else {
            System.out.println("Le véhicule n'existe pas dans le garage.");
        }
    }

    public void reviserTousLesVehicules() {
        for (Vehicule vehicule : vehicules) {
            vehicule.anneeRevision = 2024;
        }
    }

    public void afficherVehicules() {
        for (Vehicule vehicule : vehicules) {
            System.out.println(vehicule);
        }
    }

    public void vehiculePresent(String plaqueImmatriculation) {
        System.out.print("Le véhicule immatriculé " + plaqueImmatriculation);
        Boolean estPresent = false;
        for (Vehicule vehicule : vehicules) {
            if (vehicule.plaqueImmatriculation.equals(plaqueImmatriculation)) {
                estPresent = true;
            }
        }
        if (estPresent) {
            System.out.println(" est présent dans le garage");
        } else {
            System.out.println(" n'est pas présent dans le garage");
        }
    }

    public HashMap<Integer, ArrayList<Vehicule>> creerCarnetVehicule(ArrayList<Vehicule> vehicules) {
        HashMap<Integer, ArrayList<Vehicule>> carnetVehicules = new HashMap<>();
        for (Vehicule vehicule : vehicules) {
            Integer anneeRef = vehicule.anneeRevision;
            if (carnetVehicules.containsKey(anneeRef)) {
                ArrayList<Vehicule> temp = carnetVehicules.get(anneeRef);     //temp = temporaire
                temp.add(vehicule);
//              carnetVehicules.get(anneeRef).add(vehicule);              Autre facon
            } else {
                ArrayList<Vehicule> vehiculesParAnneeRevision = new ArrayList<>();
                vehiculesParAnneeRevision.add(vehicule);
                carnetVehicules.put(anneeRef, vehiculesParAnneeRevision);
            }
        }
        return carnetVehicules;
    }

    public void afficherCarnetVehicule(HashMap<Integer, ArrayList<Vehicule>> carnetVehicules) {
        for (Integer anneeRevision : carnetVehicules.keySet()) {
            System.out.println("----" + anneeRevision + "----");
            for (Vehicule vehicule : carnetVehicules.get(anneeRevision)) {
                System.out.println(vehicule);
            }
        }
    }

    public void envoiPromotion() {
        ArrayList<Vehicule> vehiculeAvecBesoinRevision = new ArrayList();
        boolean besoinRevision = false;
        for (Vehicule vehicule : vehicules) {
            if (vehicule.anneeRevision <= 2018) {
                besoinRevision = true;
                vehiculeAvecBesoinRevision.add(vehicule);
            }
        }
        if (besoinRevision) {
            System.out.println("Un email de promotion sur la révision a été envoyé aux propriétaires de :");
            for (Vehicule vehicule : vehiculeAvecBesoinRevision) {
                System.out.println(vehicule);
            }
        } else {
            System.out.println("Aucun client ne répond aux critères");
        }
    }


}




