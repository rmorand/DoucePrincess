import domaine.Participant;
import metier.EntrainementMongoDB;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Démonstration des fonctionnalités

        EntrainementMongoDB entrainement = new EntrainementMongoDB();

        // Créer des participants
        Participant p1 = new Participant("Alice", "Club Alpha", Arrays.asList("Compétition 1", "Compétition 2"));
        Participant p2 = new Participant("Bob", "Club Beta", Arrays.asList("Compétition 2", "Compétition 3"));
        Participant p3 = new Participant("Charlie", "Club Alpha", Arrays.asList("Compétition 1", "Compétition 4"));

        // Ajouter des participants
        entrainement.ajouterParticipant(p1);
        entrainement.ajouterParticipants(Arrays.asList(p2, p3));

        // Trouver un participant
        System.out.println("Trouver Bob : " + entrainement.trouverParticipant("Bob"));

        // Trouver tous les participants
        System.out.println("Tous les participants : " + entrainement.trouverTousParticipants());

        // Trouver les participants dont le nom commence par 'A'
        System.out.println("Participants dont le nom commence par 'A' : " + entrainement.trouverParticipantsParFiltre("A"));

        // Mettre à jour un participant
        p2.setClub("Club Gamma");
        entrainement.mettreAJourParticipant("Bob", p2);

        // Supprimer un participant
        entrainement.supprimerParticipant("Alice");

        // Supprimer plusieurs participants
        entrainement.supprimerParticipantsParFiltre("Club Alpha");

        // Afficher les participants restants
        System.out.println("Participants restants : " + entrainement.trouverTousParticipants());
    }
}