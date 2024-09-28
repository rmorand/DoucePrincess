package metier;

import dao.Bdd;
import domaine.Matiere;
import domaine.TableSpeciale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionTable {

    private final List<TableSpeciale> tableSpeciales;


    public GestionTable() {
        this.tableSpeciales = Bdd.getDataTableSpeciales();
    }


    public void afficherTableParMatiere(Matiere matiere) {
        List<TableSpeciale> data = new ArrayList<>();

        for (TableSpeciale myTable : this.tableSpeciales) {
            if (matiere == myTable.getMatiere()){
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

        this.tableSpeciales.sort(TableSpeciale::compareBySurface);

        System.out.println("Liste des tables triées par surface (de la plus grande à la plus petite) :");
        for (TableSpeciale myTable: this.tableSpeciales) {
            System.out.println(myTable);
        }
    }
}
