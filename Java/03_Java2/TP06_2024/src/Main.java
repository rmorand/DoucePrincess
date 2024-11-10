public class Main {
    public static void main(String[] args) {
        // ===== main: test: création de l'arbre, appel des méthodes ==================

        // Version avec un ArrayList des fils
        ArbreN a = new ArbreN(0);
        ArbreN.Noeud n;
        n = a.chercher(0);   a.inserer(1, n); a.inserer(2, n); a.inserer(3, n); a.inserer(4, n);
        n = a.chercher(1);   a.inserer(11, n); a.inserer(12, n); a.inserer(13, n); a.inserer(14, n);
        n = a.chercher(12);  a.inserer(121, n); a.inserer(122, n); a.inserer(123, n);
        n = a.chercher(122); a.inserer(1221, n);
        n = a.chercher(3);   a.inserer(31, n); a.inserer(32, n);
        n = a.chercher(31);  a.inserer(311, n); a.inserer(312, n); a.inserer(313, n);
        n = a.chercher(4);   a.inserer(41, n);

        System.out.println("Parcours PREfixe :");
        a.parcoursPrefixe();  System.out.println();
        System.out.println("Parcours POSTfixe :");
        a.parcoursPostfixe(); System.out.println();

        n = a.chercher(12);
        System.out.println("Méthode chercher:");
        System.out.println("Chercher 12: " + a.chercher(12));
        System.out.println("Méthode taille (nb de noeuds dans l'arbre):");
        System.out.println("Taille: " + a.taille());
    }



// Version avec une liste chainée des frères


}