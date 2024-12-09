import domaine.Participant;
import metier.EntrainementRedis;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        // Démonstration des méthodes
        EntrainementRedis entrainement = new EntrainementRedis();
        String collection = "Participants";

        // Afficher le nom de la base
        entrainement.afficherNomBase();
        System.out.println();

        // Créer une collection
        entrainement.creerCollection(collection);

        // Ajouter des participants
        Participant p1 = new Participant("Alice", "Club Alpha", Arrays.asList("Compétition 1", "Compétition 2"));
        Participant p2 = new Participant("Bob", "Club Beta", Arrays.asList("Compétition 2", "Compétition 3"));
        entrainement.ajouterParticipant(collection, p1);
        entrainement.ajouterParticipant(collection, p2);

        // Trouver un participant
        System.out.println("Trouver Bob : " + entrainement.trouverParticipant(collection, "Bob"));

        // Trouver tous les participants
        entrainement.trouverTousParticipants(collection);

        // Mettre à jour un participant
        p2.setCompetitions(Arrays.asList("Compétition 3", "Compétition 4"));
        entrainement.mettreAJourParticipant(collection, p2);

        // Supprimer un participant
        entrainement.supprimerParticipant(collection, "Alice");

        // Trouver tous les participants après suppression
        entrainement.trouverTousParticipants(collection);


    }
}