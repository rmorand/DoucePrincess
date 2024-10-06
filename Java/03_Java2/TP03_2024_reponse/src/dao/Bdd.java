package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bdd {

    private static String FILENAME = "LstTables.csv";

    /** @return tout le fichier LstTables.csv dans des String */
    public static List<String[]> getDonneesDesTables() {
        List<String[]> data = new ArrayList<>();

        URL path = Bdd.class.getClassLoader().getResource(FILENAME);
        if (path == null) {
            throw new RuntimeException("Impossible de trouver le fichier [" + FILENAME + "]\n Avez-vous défini un dossier ressources ?");
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path.getPath()));
            String ligne;
            while ((ligne = reader.readLine()) != null) { data.add(ligne.split(";")); }
            reader.close();
        } catch (IOException e) { }
        return data;
    }
}