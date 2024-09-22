package metier;

import dao.Bdd;
import domaine.Matiere;
import domaine.Table;

import java.util.*;

public class GestionTable {
    private List<Table> tables;

    public GestionTable() {
        this.tables = Bdd.getDatas();
    }


    public void afficherTableParMatiere(Matiere matiere) {
        List<Table> data = new ArrayList<>();

        for (Table myTable : this.tables) {
            if (matiere == myTable.getMatiere()){
                data.add(myTable);
            }
        }
        Collections.sort(data);

        System.out.println("Liste des tables en " + matiere.name() + " (triées par code) :");
        for (Table myTable: data) {
            System.out.println(myTable);
        }
    }

    public void afficherTableParSurface() {

        Collections.sort(this.tables);
//                , new Comparator<Table>() {
//            @Override
//            public int compare(Table o1, Table o2) {
//                return o2.surface() - o1.surface();
//            }
//        });

        System.out.println("Liste des tables triées par surface (de la plus grande à la plus petite) :");
        for (Table myTable: this.tables) {
            System.out.println(myTable);
        }
    }
}
