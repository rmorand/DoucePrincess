package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bdd {
    /** @return tout le fichier LstTables.csv dans des String */
    public static List<String[]> getDonneesDesTables() {
        List<String[]> data = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("LstTables.csv"));
            String ligne;
            while ((ligne = reader.readLine()) != null) { data.add(ligne.split(";")); }
            reader.close();
        } catch (IOException e) { }
        return data;
    }
}