package dao;

import domaine.Matiere;
import domaine.Table;
import domaine.TableRectangle;
import domaine.TableRonde;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;


public class Bdd {

    private Bdd() {
    }

    private static String read(String fileName) {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
            StringBuilder b = new StringBuilder(in.available());

            for(int c = in.read(); c != -1; c = in.read()) {
                b.append((char)c);
            }

            in.close();
            return b.toString();
        } catch (FileNotFoundException var4) {
            var4.printStackTrace();
            return "";
        } catch (IOException var5) {
            var5.printStackTrace();
            return "";
        }
    }

    public static String[] lireCsv(String fileName) {
        String str = read(fileName);
        new ArrayList();
        StringTokenizer sT = new StringTokenizer(str, "\n\r");
        String[] data = new String[sT.countTokens()];

        for(int cpt = 0; sT.hasMoreTokens(); ++cpt) {
            data[cpt] = sT.nextToken();
        }

        return data;
    }
    public static List<Table> getDatas() {
        List<Table> datas;

        System.out.println("\n\n------Chargement des données------");

        URL path = Bdd.class.getClassLoader().getResource("LstTables.csv");
        if (path == null) {
            throw new RuntimeException("Impossible de trouver le fichier [LstTables.csv]\n Avez-vous défini un dossier ressources ?");
        }
        datas = loadDatas(lireCsv(path.getPath()));
        System.out.println(datas);
        System.out.println("\n------Chargement des données terminé------");

        return loadDatas(lireCsv(path.getPath()));
    }

    private static List<Table> loadDatas(String[] lines){
        List<Table> result = new ArrayList<>();

        for (String line : lines) {
            String[] champs = line.split(";");

            if (champs[0].startsWith("R")) {
                result.add(new TableRectangle(champs[0], Integer.parseInt(champs[1]), findMatiere(champs[2]), Integer.parseInt(champs[3]), Integer.parseInt(champs[4])));
            } else {
                result.add(new TableRonde(champs[0], Integer.parseInt(champs[1]), findMatiere(champs[2]), Integer.parseInt(champs[3])));
            }
        }

        return result;
    }

    private static Matiere findMatiere(String matiere) {
        if (Objects.equals(matiere, Matiere.BOIS.name())) {
            return Matiere.BOIS;
        } else if (Objects.equals(matiere, Matiere.VERRE.name())) {
            return Matiere.VERRE;
        }

        return Matiere.METAL;
    }
}
