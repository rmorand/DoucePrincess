package metier.TP03_2024_enonce.src.metier;

import metier.TP03_2024_enonce.src.dao.Bdd;
import metier.TP03_2024_enonce.src.domaine.Matiere;

public class GestionPileDeTables {
    // TODO: définir correctement les 2 piles nécessaires :
    private static Object pileBois = new Object();  // TODO: ce n'est certainement pas des Object !!
    private static Object pileAutre = new Object();


    public GestionPileDeTables() {
        stockerListeTablesDansLesPiles();
        // TODO: décommenter les affichages ci-desous : (ne rien modifier, ça doit fonctionner ainsi !)
/*      System.out.println("Surface  totale  de la pile Bois : " + pileBois.surfaceTotale());
        System.out.println("Surface  totale  de l'autre pile : " + pileAutre.surfaceTotale());
        System.out.println("Table au sommet  de la pile Bois : " + pileBois.pop());
        System.out.println("Table au sommet  de l'autre pile : " + pileAutre.pop());
        System.out.println("Surface restante de la pile Bois : " + pileBois.surfaceTotale());
        System.out.println("Surface restante de l'autre pile : " + pileAutre.surfaceTotale());
*/    }

    private void stockerListeTablesDansLesPiles() {
        for (String[] champs : Bdd.getDonneesDesTables()) {
            /* Pour vous simplifier la vie, chaque ligne du fichier a été stockée dans les champs ci-dessous : */
            String code  = champs[0];
            int nbPlaces = Integer.parseInt(champs[1]);
            Matiere matiere = Matiere.valueOf(champs[2]);
            int longueur = code.startsWith("R") ? Integer.parseInt(champs[3]) : -1;
            int largeur  = code.startsWith("R") ? Integer.parseInt(champs[4]) : -1;
            int diametre = code.startsWith("R") ? -1 : Integer.parseInt(champs[3]);
            String arbre = matiere== Matiere.BOIS ? champs[champs.length-1] : null;

            // TODO: utiliser les champs ci-dessus pour stocker la tables sur la bonne pile (pileBois ou pileAutre) :
            // TODO: du style:   pileBois.push(uneTableEnBois);   ou   pileAutre.push(uneAutreTable);

        }
    }
}