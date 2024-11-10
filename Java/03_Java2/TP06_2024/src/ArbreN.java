/**
 * Structures de données : Les Arbres n-aires
 * Version : fils implémentés dans un ArrayList
 *
 * @author Ch. Stettler - HEG-Genève
 */

import java.util.ArrayList;
import java.util.List;

// Version avec un ArrayList des fils
public class ArbreN {
	private Noeud racine;

	public ArbreN(int valeur) {
		this.racine = new Noeud(valeur);
	}

	// ===== Définition d'un Noeud ================================================
	public static class Noeud {
		int valeur;
		List<Noeud> listeFils;

		public Noeud(int val) {  // Constructeur
			this.valeur = val;
			this.listeFils = new ArrayList<>();
		}

		@Override
		public String toString() {
			return " valeur = " + valeur;
		}

	}

// ===== Méthodes de l'Arbre ==================================================

	public void inserer(int val, Noeud n) {  // n = Noeud Père, val = valeur du Noeud Fils ajouté
		n.listeFils.add(new Noeud(val));
	}


	public Noeud chercher(int val) {
		return chercherRecursive(racine, val);
	}

	public Noeud chercherRecursive(Noeud n, int val) {
		if (val == n.valeur) {
			return n;
		}
		for (Noeud noeud : n.listeFils) {
			Noeud noeudCherche = chercherRecursive(noeud, val);
			if (noeudCherche != null) {
				return noeudCherche;
			}
		}
		return null;
	}


	// Parcours PREfixe
	public void parcoursPrefixe() {
		parcoursPrefixeRecursive(racine);
	}

	private void parcoursPrefixeRecursive(Noeud n) {
		System.out.println(n.valeur);
		for (Noeud noeud : n.listeFils) {
			parcoursPrefixeRecursive(noeud);
		}
	}

	// Parcours POSTfixe
	public void parcoursPostfixe() {
		parcoursPostfixeRecursive(racine);
	}

	private void parcoursPostfixeRecursive(Noeud n) {
		for (Noeud noeud : n.listeFils) {
			parcoursPostfixeRecursive(noeud);
		}
		System.out.println(n.valeur);
	}


	public int taille() { // retourne le nb total de noeuds dans l'arbre
		if (racine == null) {
			return 0;
		}
		return tailleRecursive(racine);
	}

	public int tailleRecursive(Noeud n) {
		// Le nombre de noeuds commence à 1 pour inclure le noeud actuel
		int taille = 1;
		// Parcourir tous les fils et additionner leurs tailles
		for (Noeud fils : n.listeFils) {
			taille += tailleRecursive(fils);
		}
		return taille;
	}


}