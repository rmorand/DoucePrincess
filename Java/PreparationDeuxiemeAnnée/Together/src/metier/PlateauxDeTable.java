package metier;

import dao.Bdd;
import domaine.Matiere;
import domaine.Plateau;

import java.util.Comparator;
import java.util.List;

public class PlateauxDeTable {
    private static List<Plateau> listePlateaux = Bdd.getListePlateaux();

    public PlateauxDeTable() {
        afficherPlateauxEn(Matiere.BOIS); System.out.println();
        afficherPlateauxParSurface();
    }

    private void afficherPlateauxEn(Matiere matiere) {
        System.out.println("Liste des plateaux en " + matiere + " (triés par code) :");
        listePlateaux.sort(null);
        for (Plateau pl : listePlateaux) {
            if (pl.estEn(matiere)) { System.out.println(pl); }
        }
    }

    private void afficherPlateauxParSurface() {
        System.out.println("Liste des plateaux triés par surface (du plus grand au plus petit) :");
        listePlateaux.sort(new Comparator<Plateau>() {
            @Override
            public int compare(Plateau o1, Plateau o2) { return o2.compareSurface(o1); }
        });
        for (Plateau pl : listePlateaux) {
            System.out.println(pl);
        }
    }
}