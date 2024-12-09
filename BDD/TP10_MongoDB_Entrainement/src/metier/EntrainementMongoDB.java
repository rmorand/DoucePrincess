package metier;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import dao.Bdd;
import domaine.Participant;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntrainementMongoDB {
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public EntrainementMongoDB() {
        this.database = Bdd.connectToDatabase("CompetitionDB");
        this.collection = database.getCollection("Participants");
        System.out.println("Base de données et collection configurées !");
    }

    // Méthode pour convertir un Participant en Document MongoDB
    private Document participantToDocument(Participant participant) {
        return new Document("nom", participant.getNom())
                .append("club", participant.getClub())
                .append("competitions", participant.getCompetitions());
    }

    // Méthode pour convertir un Document MongoDB en Participant
    private Participant documentToParticipant(Document document) {
        return new Participant(
                document.getString("nom"),
                document.getString("club"),
                document.getList("competitions", String.class)
        );
    }

    // Ajouter un participant
    public void ajouterParticipant(Participant participant) {
        collection.insertOne(participantToDocument(participant));
        System.out.println("Participant ajouté : " + participant);
    }

    // Ajouter plusieurs participants
    public void ajouterParticipants(List<Participant> participants) {
        List<Document> documents = new ArrayList<>();
        for (Participant participant : participants) {
            documents.add(participantToDocument(participant));
        }
        collection.insertMany(documents);
        System.out.println("Participants ajoutés : " + participants);
    }

    // Trouver un participant par nom
    public Participant trouverParticipant(String nom) {
        Document document = collection.find(Filters.eq("nom", nom)).first();
        if (document != null) {
            return documentToParticipant(document);
        }
        return null;
    }

    // Trouver tous les participants
    public List<Participant> trouverTousParticipants() {
        List<Participant> participants = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find().cursor();
        while (cursor.hasNext()) {
            participants.add(documentToParticipant(cursor.next()));
        }
        return participants;
    }

    // Trouver des participants dont le nom commence par une lettre donnée
    public List<Participant> trouverParticipantsParFiltre(String lettre) {
        List<Participant> participants = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find(Filters.regex("nom", "^" + lettre)).cursor();
        while (cursor.hasNext()) {
            participants.add(documentToParticipant(cursor.next()));
        }
        return participants;
    }

    // Mettre à jour un participant
    public void mettreAJourParticipant(String nom, Participant miseAJour) {
        collection.updateOne(
                Filters.eq("nom", nom),
                Updates.combine(
                        Updates.set("club", miseAJour.getClub()),
                        Updates.set("competitions", miseAJour.getCompetitions())
                )
        );
        System.out.println("Participant mis à jour : " + miseAJour);
    }

    // Supprimer un participant
    public void supprimerParticipant(String nom) {
        collection.deleteOne(Filters.eq("nom", nom));
        System.out.println("Participant supprimé : " + nom);
    }

    // Supprimer plusieurs participants
    public void supprimerParticipantsParFiltre(String club) {
        collection.deleteMany(Filters.eq("club", club));
        System.out.println("Participants du club " + club + " supprimés.");
    }



}
