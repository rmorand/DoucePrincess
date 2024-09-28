package metier;

import dao.Bdd;
import domaine.Matiere;
import domaine.Table;
import domaine.TableSpeciale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GestionTableSpeciale {
    private List<TableSpeciale> tablesSpeciales;


    public GestionTableSpeciale() {
        this.tablesSpeciales = Bdd.getDatas();
    }

    public void afficherTableParMatiere(Matiere matiere) {
        List<TableSpeciale> data = new ArrayList<>();

        for (TableSpeciale myTable : this.tablesSpeciales) {
            if (matiere == myTable.getTable().getMatiere()){
                data.add(myTable);
            }
        }
        Collections.sort(data);

        System.out.println("Liste des tables en " + matiere.name() + " (triées par code) :");
        for (TableSpeciale myTable: data) {
            System.out.println(myTable);
        }
    }

    public void afficherTableParSurface() {

        Collections.sort(this.tables, new Comparator<Table>() {
            @Override
            public int compare(Table o1, Table o2) {
                return o2.surface() - o1.surface();
            }
        });

        System.out.println("Liste des tables triées par surface (de la plus grande à la plus petite) :");
        for (Table myTable: this.tables) {
            System.out.println(myTable);
        }
    }

}
