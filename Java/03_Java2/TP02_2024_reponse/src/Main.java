import domaine.Matiere;
import metier.*;

public class Main {

    public static void main(String[] args) {

        GestionTable g = new GestionTable();

        g.afficherTableParMatiere(Matiere.BOIS);
        System.out.println("\n");
        g.afficherTableParMatiere(Matiere.VERRE);
        System.out.println("\n");
        g.afficherTableParMatiere(Matiere.METAL);
        System.out.println("\n");
        g.afficherTableParSurface();
        System.out.println("\n");


    }

}