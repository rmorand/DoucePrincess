/** 
 * Structures de données : Les Arbres n-aires
 *    Version : fils implémentés dans un ArrayList
 * @author Ch. Stettler - HEG-Genève
 */
import java.util.ArrayList;
import java.util.List;

public class ArbreN {

	

// ===== Définition d'un Noeud ================================================
	

// ===== Méthodes de l'Arbre ==================================================



// ===== main: test: création de l'arbre, appel des méthodes ==================

	public static void main (String[] args) {
		ArbreN a = new ArbreN(0);
		Noeud n;
		n = a.chercher(0);   a.inserer(1, n); a.inserer(2, n); a.inserer(3, n); a.inserer(4, n);
		n = a.chercher(1);   a.inserer(11, n); a.inserer(12, n); a.inserer(13, n); a.inserer(14, n); 
		n = a.chercher(12);  a.inserer(121, n); a.inserer(122, n); a.inserer(123, n); 
		n = a.chercher(122); a.inserer(1221, n); 
		n = a.chercher(3);   a.inserer(31, n); a.inserer(32, n); 
		n = a.chercher(31);  a.inserer(311, n); a.inserer(312, n); a.inserer(313, n); 
		n = a.chercher(4);   a.inserer(41, n);

		a.parcoursPrefixe();  System.out.println();
		a.parcoursPostfixe(); System.out.println();

		n = a.chercher(12);
		System.out.println("Chercher 12: " + a.chercher(12));
		System.out.println("Taille: " + a.taille());
	}
}