package metier;

import dao.Bdd;
import domaine.Producteur;

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

	private void afficherGrosProducteurs(String lieu, String courge, int nb) {
        List<Producteur> producteurs = new ArrayList<>();
        // TODO: Créez des instances de la classe Producteur pour chaque producteur de <lieu> (la liste des producteurs et leur lieu sont dans MongoDB)
        //       pour autant que ce producteur ait déjà produit plus de <nb> <courges> cette année (donc selon les nombres indiqués dans Redis)
        //       indiquez également les magasins qui se fournissent chez ce producteur (cette liste est indiquée avec <FOURNIT> dans Neo4j)
        //       puis affichez l'ArrayList producteurs (aucun autre affichage dans cette procédure, uniquement l'ArrayList !)

        System.out.println("Liste des producteurs de " + lieu + " qui ont déjà produit cette année plus de " + nb + " " + courge + " :");
        for (Producteur p : producteurs) System.out.println(p);  // l'affichage des gros producteurs de <lieu> doit se faire ici
    }

    private void ajouterNouveauFournisseurPour(String courge, String magasin) {
        // TODO: Indiquez dans Neo4j que chaque Producteur qui cultive actuellement des <courge> fournit dorénavant le magasin spécifié
        System.out.println("On a ajouté ces producteurs de courges '" + courge + "' comme nouveau fournisseur de la " + magasin + " (car ils cultivent des " + courge + " cette année) :");
    }

    private void enregistrerLeTotalRedisDansStatMongo() {
        // TODO: Ajoutez à chaque Producteur de MongoDB une nouvelle stat pour l'année 2023 avec les quantités actuelles (faire la somme des valeurs dans Redis pour ce producteur)
        System.out.println("Voici les productions actuelles, qui vont être enregistrées dans MongoDB :");
    }
}