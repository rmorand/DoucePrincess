import Metier.DList;
import Metier.VotreDList;

/**
 * 63-31 - Structures de données : Liste doublement chaînée
 * @author Ch. Stettler - HEG-Genève
 */
public class TestListeDblCh {

	public static void main(String[] args) {
		DList lst = new VotreDList();
      remplirDEntiers(lst);
      traiterToutDepuisLePremier(lst);
      remplirDEntiers(lst);
      traiterToutDepuisLeDernier(lst);
   }

   private static void remplirDEntiers(DList lst) {
		lst.addFirst(1); lst.addFirst(2); lst.addFirst(3); lst.addFirst(4);
		lst.addLast(6); lst.addLast(7); lst.addLast(8); lst.addLast(9);
   }

   private static void remplirDeString(DList lst) {
		lst.addFirst("Ana"); lst.addFirst("Bob"); lst.addFirst("Cloe"); lst.addFirst("Dan");
		lst.addLast("Ryan"); lst.addLast("Sam"); lst.addLast("Tara"); lst.addLast("Ugo");
   }

   private static void traiterToutDepuisLePremier(DList lst) {
      while (!lst.isEmpty()) {
			System.out.print(lst.removeFirst() + " ");
		}
      System.out.println();
   }
   private static void traiterToutDepuisLeDernier(DList lst) {
      while (!lst.isEmpty()) {
			System.out.print(lst.removeLast() + " ");
		}
      System.out.println();
	}
}