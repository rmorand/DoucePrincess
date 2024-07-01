package dao;

import domaine.Matiere;
import domaine.Plateau;
import domaine.PlateauRectangle;
import domaine.PlateauRond;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bdd {
    public static List<Plateau> getListePlateaux() {
        List<Plateau> data = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("LstPlateaux.csv"));
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] champs = ligne.split(";");
                if (champs[0].startsWith("R")) {
                    data.add(new PlateauRectangle(champs[0], Integer.parseInt(champs[1]), Matiere.valueOf(champs[2]),
                            Integer.parseInt(champs[3]), Integer.parseInt(champs[4])));
                } else {
                    data.add(new PlateauRond(champs[0], Integer.parseInt(champs[1]), Matiere.valueOf(champs[2]), Integer.parseInt(champs[3])));
                }
            }
            reader.close();
        } catch (IOException e) {
        }
        return data;
    }
}