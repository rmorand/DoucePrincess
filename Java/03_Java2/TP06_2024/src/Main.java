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

        System.out.println("\n==============Version avec un ArrayList des fils========================\n");
        System.out.println("Parcours PREfixe (ordre d'ajout des noeuds) (de gauche à droite, de haut en bas): D'abord le noeud puis les fils");
        a.parcoursPrefixe();  System.out.println();
        System.out.println("Parcours POSTfixe (de gauche à droite, de bas en haut): (avec ArrayList): D'abord les fils puis le noeud ");
        a.parcoursPostfixe(); System.out.println();

        n = a.chercher(12);
        System.out.println("Méthode chercher:");
        System.out.println("Chercher 12: " + a.chercher(12));
        System.out.println("Méthode taille (nb de noeuds dans l'arbre):");
        System.out.println("Taille: " + a.taille());



        // Version avec une liste chainée des frères
        ArbreN_V2 arbre = new ArbreN_V2(0);
        ArbreN_V2.Noeud noeud;
        noeud = arbre.chercher(0);   arbre.inserer(1, noeud); arbre.inserer(2, noeud); arbre.inserer(3, noeud); arbre.inserer(4, noeud);
        noeud = arbre.chercher(1);   arbre.inserer(11, noeud); arbre.inserer(12, noeud); arbre.inserer(13, noeud); arbre.inserer(14, noeud);
        noeud = arbre.chercher(12);  arbre.inserer(121, noeud); arbre.inserer(122, noeud); arbre.inserer(123, noeud);
        noeud = arbre.chercher(122); arbre.inserer(1221, noeud);
        noeud = arbre.chercher(3);   arbre.inserer(31, noeud); arbre.inserer(32, noeud);
        noeud = arbre.chercher(31);  arbre.inserer(311, noeud); arbre.inserer(312, noeud); arbre.inserer(313, noeud);
        noeud = arbre.chercher(4);   arbre.inserer(41, noeud);

        System.out.println("\n==============Version avec une liste chainée des frères========================\n");
        System.out.println("Parcours PREfixe (De gauche à droite, de haut en bas): (avec listeChainee) d'abord le noeud, puis les fils, puis les freres");
        arbre.parcoursPrefixe();  System.out.println();
        System.out.println("Parcours POSTfixe (de droite à gauche, de bas en haut): (avec listeChainee) d'abord les fils, puis les freres puis le noeud ");
        arbre.parcoursPostfixe(); System.out.println();

        noeud = arbre.chercher(12);
        System.out.println("Méthode chercher:");
        System.out.println("Chercher 12: " + arbre.chercher(12));
        System.out.println("Méthode taille (nb de noeuds dans l'arbre):");
        System.out.println("Taille: " + arbre.taille());


    }


}