package metier;

import dao.Bdd;
import domaine.Producteur;
import domaine.Statistique;
import org.bson.Document;
import org.neo4j.driver.Result;

import java.util.*;

import static dao.Bdd.*;

public class ProducteursDeCourges {

    public ProducteursDeCourges() {
        Bdd.connect(); // Connexion aux 3 bdd (jedis, mongo, neo4j)
        afficherGrosProducteurs("Carouge", "Potiron", 60);
        ajouterNouveauFournisseurPour("Muscade", "Migros");
        enregistrerLeTotalRedisDansStatMongo();
        afficherGrosProducteurs("Carouge", "Spaghetti", 80);
    }

    /* Méthode 1 | Objectif : Lister les producteurs situés dans un lieu donné (lieu) qui ont produit cette année une quantité supérieure à un seuil (nb)
                              d’un type de courge donné (courge). Ajouter également la liste des magasins qui se fournissent chez eux.
     -----------------------------------------------------------------------------------------------------------------------------------------------------*/

	private void afficherGrosProducteurs(String lieu, String courge, int nb) {
        // TODO: Créez des instances de la classe Producteur pour chaque producteur de <lieu> (la liste des producteurs et leur lieu sont dans MongoDB)
        //       pour autant que ce producteur ait déjà produit plus de <nb> <courges> cette année (donc selon les nombres indiqués dans Redis)
        //       indiquez également les magasins qui se fournissent chez ce producteur (cette liste est indiquée avec <FOURNIT> dans Neo4j)
        //       puis affichez l'ArrayList producteurs (aucun autre affichage dans cette procédure, uniquement l'ArrayList !)

        List<Producteur> producteurs = new ArrayList<>();

        // 1. Accès aux producteurs dans MongoDB en fonction du "lieu" (Récupérer les producteurs depuis MongoDB)
        for (Document doc : Bdd.mongo.getCollection("Producteurs").find(new Document("lieu", lieu))) { // Cherche un lieu précis dans la collection Producteurs
            String nom = doc.getString("nom"); // Nom du producteur du lieu indiqué

            // 2. Vérifier les quantités dans Redis (et comparer à "nb")
            String quantiteStr = Bdd.jedis.hget(nom, courge); // valeur (quantité) associée à un producteur(nom) et un type de courge(courge) [ex. hget Merisier Potiron]
            int quantite = quantiteStr != null ? Integer.parseInt(quantiteStr) : 0; // Récupérer la quantité de courge produite et convertit en int
            if (quantite > nb) {
                // 3. récupérer les magasins depuis Neo4j
                List<String> magasins = new ArrayList<>();
                Result res = neo4j.run("MATCH(p:Producteur {nom:'" + nom + "'}) -[:FOURNIT]-> (m:Magasin) RETURN m.nom AS nom");
                while (res.hasNext()) {
                    magasins.add(res.next().get("nom").asString());
                }

                // 4. Création des statistiques associées au producteur
                List<Statistique> stats = new ArrayList<>();
                for (Document stat : doc.getList("stat", Document.class)) {
                    stats.add(new Statistique(stat.getInteger("annee"), stat.getInteger("nb")));
                }
                // 5. Création de l'instance de Producteur
                producteurs.add(new Producteur(nom, lieu, stats, magasins));
            }
        }
        // 6. Afficher la liste de producteurs
        System.out.println("Liste des producteurs de " + lieu + " qui ont déjà produit cette année plus de " + nb + " " + courge + " :");
        for (Producteur p : producteurs) System.out.println(p);  // l'affichage des gros producteurs de <lieu> doit se faire ici
    }

    /* Méthode 2 | Objectif : Ajouter un lien FOURNIT dans Neo4j entre un magasin et les producteurs qui cultivent actuellement une courge spécifique (courge).
     ---------------------------------------------------------------------------------------------------------------------------------------------------------*/

    private void ajouterNouveauFournisseurPour(String courge, String magasin) {
        // TODO: Indiquez dans Neo4j que chaque Producteur qui cultive actuellement des <courge> fournit dorénavant le magasin spécifié

        List<String> producteursAjoutes = new ArrayList<>();

        // 1. Trouver et récupérer les producteurs cultivant la courge demandée (producteurs qui ont une relation CULTIVE avec la courge demandée)
        Result res = neo4j.run(
                "MATCH (p:Producteur) -[r:CULTIVE]-> (c:Courge {nom:'" + courge + "'}) " + // Trouver les producteurs qui cultivent la courge demandée
                "WHERE r.annee IS NULL " + // l'année de culture de la courge par le producteur ne doit pas être existante
                "RETURN p.nom AS nom"
        );
        while (res.hasNext()) {
            producteursAjoutes.add(res.next().get("nom").asString());
        }

        // 2. Ajouter les relations FOURNIT pour les producteurs qui fournissent les magasins
        for (String producteur : producteursAjoutes) {
            Bdd.neo4j.run(
                    "MATCH (p:Producteur {nom:'" + producteur + "'}), (m:Magasin {nom:'" + magasin +"'}) CREATE (p) -[:FOURNIT]-> (m)"
            );
        }

        // 3. Afficher les producteurs ajoutés
        System.out.println("On a ajouté ces producteurs de courges '" + courge + "' comme nouveau fournisseur de la " + magasin + " (car ils cultivent des " + courge + " cette année) :");
        for (String p : producteursAjoutes) System.out.println(" - " + p);
    }

    /* Méthode 3 | Objectif : Pour chaque producteur, calculer la somme des quantités de toutes les courges dans Redis et ajouter cette somme comme
                              une nouvelle statistique dans MongoDB pour l’année 2023.
     ----------------------------------------------------------------------------------------------------------------------------------------------*/

    private void enregistrerLeTotalRedisDansStatMongo() {
        // TODO: Ajoutez à chaque Producteur de MongoDB une nouvelle stat pour l'année 2023 avec les quantités actuelles (faire la somme des valeurs dans Redis pour ce producteur)

        System.out.println("Voici les productions actuelles, qui vont être enregistrées dans MongoDB :");

        // 1. Récupérer les producteurs depuis Redis
        for (String producteur : Bdd.jedis.keys("*")) { // Liste de toutes les clés dans la BDD Redis (ici chaque clé correspond au nom du producteur)
            if ("hash".equals(Bdd.jedis.type(producteur))) { // Vérifier si toutes les clés sont des HashMap. S'il y a d'autres types dans la clé ça fera des erreurs
                Map<String, String> courges = Bdd.jedis.hgetAll(producteur); // Récupère toutes les paires clé-valeur (type et quantité de courge)

                // 2. Filtrer les valeurs non numériques, négatives et calculer la somme des quantités actuelles
                int total = 0;
                for (String value : courges.values()) {
                    // Vérifier si la valeur est un nombre
                    if (value.matches("\\d+")) { // Si la valeur est un entier positif
                        total += Integer.parseInt(value); // Convertir en entier et ajouter au total
                    }
                }

                // 3. Ajouter une nouvelle statistique dans MongoDB pour la mettre à jour
                Bdd.mongo.getCollection("Producteurs").updateOne(
                        new Document("nom", producteur),
                        new Document("$push", new Document("stat", new Document("annee", 2023).append("nb", total)))
                );
                // 4. Afficher le résultat
                System.out.println(" - " + producteur + ": 2023:" + total);
            } else {
                //System.out.println("Clé ignorée (type non hash) : " + producteur);
            }
        }
    }
}