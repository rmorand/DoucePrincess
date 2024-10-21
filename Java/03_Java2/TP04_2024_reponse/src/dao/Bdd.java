package dao;

import domaine.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bdd {
    /** @return la liste des consultants (du fichier "Consultants.csv"). */
    public static List<Consultant> getConsultants() {
        List<Consultant> data = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Consultants.csv"));
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] champs = ligne.split(";");
                data.add(new Consultant(Integer.parseInt(champs[0]), champs[1], champs[2]));
            }
            reader.close();
        } catch (IOException e) { }
        return data;
    }

    /** @return la liste des mandats (du fichier "Mandats.csv"). */
    public static List<Mandat> getMandats() {
        List<Mandat> data = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Mandats.csv"));
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] champs = ligne.split(";");
                data.add(new Mandat(Integer.parseInt(champs[0]), champs[1], champs[2]));
            }
            reader.close();
        } catch (IOException e) { }
        return data;
    }
}