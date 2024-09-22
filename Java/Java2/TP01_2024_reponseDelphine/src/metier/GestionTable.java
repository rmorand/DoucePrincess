package metier;

import dao.Bdd;
import domaine.Table;

import java.util.List;

public class GestionTable {
    private List<Table> tables = Bdd.getListTable();

    public GestionTable() {
        afficherTableParMatiere("Bois");  // Pourquoi???
    }


    private void afficherTableParMatiere(String matiere) {
        String result ="Liste des tables en ";
        if (matiere.equals("Bois")) {
            result += "BOIS (trié par code) :";
            System.out.println(result);
            for (Table table : tables) {
                if (table.getMatiere().equals("BOIS")) {
                    System.out.println(table);
                }
            }
        }
    }

}
