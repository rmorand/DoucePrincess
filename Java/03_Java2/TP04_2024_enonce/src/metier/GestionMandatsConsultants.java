package metier;

import domaine.Consultant;
import domaine.Mandat;

import java.util.List;

public class GestionMandatsConsultants {
    private final List<Consultant> consultants = dao.Bdd.getConsultants();
    private final List<Mandat> mandats = dao.Bdd.getMandats();

    public GestionMandatsConsultants() {
        // TODO (déjà fait) : ajoutez les mandats et quelques consultants dans les files d'attente,
        // TODO (déjà fait) : puis effectuez quelques affectations et affichez les résultats
        for (Mandat m : mandats) { nouveauMandat(m); }
        ajouterConsultantDansLaFile(consultants.get(3));
        ajouterConsultantDansLaFile(consultants.get(12));
        ajouterConsultantDansLaFile(consultants.get(16));
        ajouterConsultantDansLaFile(consultants.get(5));
        affecter(); affecter(); affecter(); affecter(); affecter();
        afficherQuiFaitQuoi();
    }

    private void ajouterConsultantDansLaFile(Consultant c) {
        // TODO: Ajoute le consultant c dans la file d'attente.
    }

    private void nouveauMandat(Mandat mandat) {
        // TODO: Ajoute le mandat dans la file d'attente.
    }

    private void affecter() {
        // TODO: Affecte le prochain mandat au premier consultant de la file d'attente.
        // TODO: Retire le consultant et le mandat des files d'attente.
    }

    private void afficherQuiFaitQuoi() {
        // TODO: Affiche la liste des affectations (liste des mandats affectés, avec le nom du consultant)
    }
}