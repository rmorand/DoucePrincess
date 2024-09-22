package dao;

import domaine.Table;
import domaine.TableRectangle;
import domaine.TableRonde;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Bdd {
    public static List<Table> getListTable() {
        List<Table> tables = new ArrayList<>();
        try {
            BufferedReader fichier = new BufferedReader(new FileReader("LstTables.csv"));
            String ligne;
            while ((ligne = fichier.readLine()) != null) {
                String[] champs = ligne.split(";");
                if (champs[0].startsWith("R")) {
                    tables.add(new TableRectangle(champs[0], Integer.parseInt(champs[1]), champs[2], Integer.parseInt(champs[3]), Integer.parseInt(champs[4])));
                } else {
                    tables.add(new TableRonde(champs[0], Integer.parseInt(champs[1]), champs[2], Integer.parseInt(champs[3])));
                }
            }
        } catch (IOException e) { }
        return tables;
    }
}
