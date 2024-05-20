package Collections;

import java.util.HashSet;

public class ExempleHashSet {
    public static void main(String[] args) {
        //HashSet
        //dico, mais que avec des clé
        //clés uniques

        HashSet<Integer> set = new HashSet<>();

        //ajout
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10);

        //parcours
        for(Integer cle : set){
            System.out.println(cle);
        }
        System.out.println(set);
    }
}
