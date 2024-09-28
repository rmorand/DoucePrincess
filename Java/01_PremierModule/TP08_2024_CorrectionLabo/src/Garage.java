import java.util.ArrayList;
import java.util.HashMap;

public class Garage {

    HashMap<Integer, ArrayList<Vehicule>> vehiculeDico = new HashMap<>();

    public boolean vehiculePresent(String plaque){
        //Il faut un objet de type vehicule avec la plaque
        Vehicule vehiculeTest = new Vehicule(plaque);
        for(Vehicule v : vehicules){

        }
        return false;
    }

    public void chargerMap(){
        vehiculeDico = new HashMap<>();
        //Parcours de la liste pour les inserer dans le dictionnaire
        for(Vehicule v : vehicules){
            //Dico: clé = année, valeur = liste de véhicule
            if(!vehiculeDico.containsKey(v.anneeRevision)){
                vehiculeDico.put(v.AnneeRevision, new ArrayList<>());
            }
            vehiculeDico.v.anneeRevision.add(v);
        }
    }

    public void afficherCarnetVehicule(){
        for(Integer annee: vehiculeDico.keyset()){
            System.out.println("---" + annee + "----");
            for(Vehicule v : vehiculeDico.annee){
                System.out.println(v);
            }
        }
    }


    public void envoiPromotion(){
        //Utiliser la HashMap!!
        boolean mailEnvoye = false;
        for(Integer annee: vehiculeDico.keyset()){
            if(annee<=2018){
                mailEnvoye = true;
                for(Vehicule v : vehiculeDico.annee){
                    
                }
            }
        }
    }

}
