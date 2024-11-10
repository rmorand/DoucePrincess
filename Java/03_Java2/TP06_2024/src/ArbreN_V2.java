import java.util.ArrayList;
import java.util.List;

// Version avec une liste chainée des frères
public class ArbreN_V2 {
    private Noeud racine;

    public ArbreN_V2(int valeur) {
        this.racine = new Noeud(valeur);
    }

    // ===== Définition d'un Noeud ================================================
    public static class Noeud {
        int valeur;
        Noeud premierFils;
        Noeud frere;

        public Noeud(int val) {  // Constructeur
            this.valeur = val;
        }

        @Override
        public String toString() {
            return " valeur = " + valeur;
        }

    }

// ===== Méthodes de l'Arbre ==================================================

    public void inserer(int val, Noeud n) {  // n = Noeud Père, val = valeur du Noeud Fils ajouté
        Noeud nouveauNoeud = new Noeud(val);

        if (n.premierFils == null) {
            // Le père n'a pas encore de fils
            n.premierFils = nouveauNoeud;
        } else {
            // Parcourir les frères pour ajouter à la fin
            Noeud frere = n.premierFils;
            while (frere.frere != null) {
                frere = frere.frere;
            }
            frere.frere = nouveauNoeud;
        }
    }


    public Noeud chercher(int val) {
        return chercherRecursive(racine, val);
    }

    public Noeud chercherRecursive(Noeud n, int val) {
        if (n == null) {
            return null;
        }
        if (n.valeur == val) {
            return n;
        }
        // Recherche dans le premier fils
        Noeud noeudTrouve = chercherRecursive(n.premierFils, val);
        if (noeudTrouve != null) {
            return noeudTrouve;
        }
        // Recherche dans les frères
        return chercherRecursive(n.frere, val);
    }


    // Parcours PREfixe
    public void parcoursPrefixe() {
        parcoursPrefixeRecursive(racine);
    }

    private void parcoursPrefixeRecursive(Noeud n) {
        if (n == null) {
            return;
        }
        // Affiche la valeur du noeud actuel
        System.out.println(n.valeur);
        // Parcours du premier fils
        parcoursPrefixeRecursive(n.premierFils);
        // Parcours des frères
        parcoursPrefixeRecursive(n.frere);
    }

    // Parcours POSTfixe
    public void parcoursPostfixe() {
        parcoursPostfixeRecursive(racine);
    }

    private void parcoursPostfixeRecursive(Noeud n) {
        if (n == null) {
            return;
        }
        // Parcours du premier fils
        parcoursPostfixeRecursive(n.premierFils);
        // Parcours des frères
        parcoursPostfixeRecursive(n.frere);
        // Affiche la valeur du noeud actuel
        System.out.println(n.valeur);
    }


    public int taille() { // retourne le nb total de noeuds dans l'arbre
        return tailleRecursive(racine);
    }

    public int tailleRecursive(Noeud n) {
        if (n == null) {
            return 0;
        }
        // Taille commence à 1 pour inclure le noeud actuel
        int taille = 1;
        // Ajouter la taille de tous les fils
        taille += tailleRecursive(n.premierFils);
        // Ajouter la taille de tous les frères
        taille += tailleRecursive(n.frere);
        return taille;
    }


}
