package metier;

import domaine.Consultant;
import domaine.Mandat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionMandatsConsultants {
    private final List<Consultant> consultants = dao.Bdd.getConsultants();
    private final List<Mandat> mandats = dao.Bdd.getMandats();

    private File<Consultant> fileDeConsultants = new MaFile<>();
    private File<Mandat> fileDeMandats = new MaFile<>();

    private Map<Mandat, Consultant> mandatsAffectesAConsultants = new HashMap<>();


    public GestionMandatsConsultants() {
        // TODO (déjà fait) : ajoutez les mandats et quelques consultants dans les files d'attente,
        // TODO (déjà fait) : puis effectuez quelques affectations et affichez les résultats
        for (Mandat m : mandats) {
            nouveauMandat(m);
        }
        ajouterConsultantDansLaFile(consultants.get(3));
        ajouterConsultantDansLaFile(consultants.get(12));
        ajouterConsultantDansLaFile(consultants.get(16));
        ajouterConsultantDansLaFile(consultants.get(5));
        affecter();
        affecter();
        affecter();
        affecter();
        affecter();
        afficherQuiFaitQuoi();
    }

    private void ajouterConsultantDansLaFile(Consultant c) {
        // TODO: Ajoute le consultant c dans la file d'attente.
        fileDeConsultants.add(c);
    }

    private void nouveauMandat(Mandat mandat) {
        // TODO: Ajoute le mandat dans la file d'attente.
        fileDeMandats.add(mandat);

    }

    private void affecter() {
        // TODO: Affecte le prochain mandat au premier consultant de la file d'attente.
        // TODO: Retire le consultant et le mandat des files d'attente.

        try {
            mandatsAffectesAConsultants.put(fileDeMandats.remove(), fileDeConsultants.remove());
        } catch (RuntimeException e) {}

    }

    private void afficherQuiFaitQuoi() {
        // TODO: Affiche la liste des affectations (liste des mandats affectés, avec le nom du consultant)


        for(Mandat mandat: mandatsAffectesAConsultants.keySet()) {
            System.out.println(mandat + " est affecté à " + mandatsAffectesAConsultants.get(mandat));
        }


    }


}