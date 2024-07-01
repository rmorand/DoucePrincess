package TP02;

public class MainTP02 {
    public static void main(String[] args) {
        //main
        //Creation des instance :
        //v1
        Voiture v1 = new Voiture("Porsche", "Cayenne", 2000);
        Personne p1 = new Personne("Alpha", 20, v1);

        //v2
        Personne p2 = new Personne("Beta", 30, null);
        Voiture v2 = new Voiture("Ferrari", "420", 2005);
        p2.setVoiture(v2);

        //v3
        Personne p3 = new Personne("Charlie", 40, new Voiture("McClarren", "2000", 2010));


        //Affichages :
        //v1 afficher la voiture de p3 : getter
        System.out.println(p3.getVoiture().getMarque());
        System.out.println("Nom de la personne : " + p3.getNom() + ", possède une : " + p3.getVoiture().getMarque());

        //v2 : toString()
        System.out.println(p3);
        System.out.println(p1);


        //Affichages de toutes les personnes
        Personne[] tableauPersonne = new Personne[10];
        tableauPersonne[0] = p1;
        tableauPersonne[1] = p2;
        tableauPersonne[2] = p3;

        //Parcours v1 tableau
        System.out.println("--------Affichage tableau v1--------------");
        for(int i = 0; i<tableauPersonne.length ; i++){
            System.out.println(tableauPersonne[i]);
        }

        System.out.println("--------Affichage tableau v2--------------");
        for(Personne pers : tableauPersonne){
            System.out.println(pers);
        }












    }
}