package Collections;


import java.util.ArrayList;
import java.util.HashMap;

public class ExempleHashMap {
    public static void main(String[] args) {
        //HashMap : equivalent des dictionnaires en python
        //système de clé / valeur
        //clés uniques
        //en java : TYPER clé et valeur

        HashMap<Integer, ArrayList<String>> dico = new HashMap<>();

        //donnees
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("test1");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("coucou");
        list2.add("test2");
        //ajout
        dico.put(1, list1);
        dico.put(2, list2);

        //récupérer le mot "Test"
        System.out.println(dico.get(2));

        //Parcourir le dico :
        for(Integer key : dico.keySet()){
            System.out.println(key + " : ");
            for(String val : dico.get(key)){
                System.out.println(val);
            }
        }

    }

}
