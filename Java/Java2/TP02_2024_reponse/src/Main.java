import domaine.Matiere;
import metier.*;

public class Main {

    public static void main(String[] args) {

        GestionTableSpeciale g = new GestionTableSpeciale();

        g.afficherTableParMatiere(Matiere.BOIS);
        System.out.println("\n");
        g.afficherTableParSurface();
        System.out.println("\n");
    }

}