package metier;

import com.google.gson.Gson;
import dao.Bdd;
import redis.clients.jedis.Jedis;
import domaine.*;

import java.util.Arrays;

public class EntrainementRedis {
    private final Jedis jedis;
    private final Gson gson;

    public EntrainementRedis() {
        System.out.println("TP09: Entrainement des instructions Redis : ");

        // Connexion à la BDD
        this.jedis = Bdd.connectRedis();
        this.gson = new Gson();
    }

    // Afficher le nom de la base de données
    public void afficherNomBase() {
        System.out.println("Nom de la base de données (Redis DB Index): " + jedis.info("server"));
    }

    // Créer une collection
    public void creerCollection(String collection) {
        System.out.println("La collection " + collection + " est créée et prête à être utilisée\n.");
    }

    // Ajouter un document (participant) dans la collection
    public void ajouterParticipant(String collection, Participant participant) {
        String participantJson = gson.toJson(participant);
        jedis.hset(collection, participant.getNom(), participantJson);
        System.out.println("Participant ajouté : " + participant);
    }

    // Trouver un participant par nom
    public Participant trouverParticipant(String collection, String nom) {
        String participantJson = jedis.hget(collection, nom);
        if (participantJson != null) {
            return gson.fromJson(participantJson, Participant.class);
        }
        return null;
    }

    // Trouver tous les participants
    public void trouverTousParticipants(String collection) {
        System.out.println("Tous les participants :");
        jedis.hgetAll(collection).forEach((nom, participantJson) -> {
            Participant participant = gson.fromJson(participantJson, Participant.class);
            System.out.println(participant);
        });
    }

    // Mise à jour d'un participant
    public void mettreAJourParticipant(String collection, Participant participant) {
        if (jedis.hexists(collection, participant.getNom())) {
            String participantJson = gson.toJson(participant);
            jedis.hset(collection, participant.getNom(), participantJson);
            System.out.println("Participant mis à jour : " + participant);
        } else {
            System.out.println("Participant introuvable : " + participant.getNom());
        }
    }

    // Supprimer un participant
    public void supprimerParticipant(String collection, String nom) {
        if (jedis.hdel(collection, nom) > 0) {
            System.out.println("Participant supprimé : " + nom);
        } else {
            System.out.println("Participant introuvable : " + nom);
        }
    }



}

