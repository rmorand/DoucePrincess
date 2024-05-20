public class Main {
    public static void main(String[] args)
    {
        Ecole e1 = new Ecole("Haute école de gestion", "Route de drize 19", "Publique",5,"Tertiaire","Gestion",1500);
        Ecole e2 = new Ecole("Schultz", "Route du lac 29", "Privée",2,"Secondaire","Economie",200);
        Ecole e3 = new Ecole("Collège Saint-Louis", "Route de Corzier 23", "Privée",3,"Secondaire","Général",400);
        Ecole e4 = new Ecole("Collège Saint-Louis", "Route de Corzier 23", "Privée",1,"Secondaire","Mathématiques",50);
        Ecole e5 = new Ecole("Collège de Carouge", "Route des centenaires 34", "Publique",4,"Secondaire","Général",1500);
        Ecole e6 = new Ecole("Collège de Carouge", "Route des centenaires 34", "Publique",4,"Secondaire","Général",500);

        System.out.println("Affichage des écoles :");
        System.out.println("---------------------------------------------");
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e3.toString());
        System.out.println(e4.toString());
        System.out.println(e5.toString());
        System.out.println(e6.toString());
        System.out.println("");
        System.out.println("Test des égalités entre écoles");
        System.out.println("---------------------------------------------");
        if (e3.equals(e4)==false)
        {
            System.out.println(e3.toString());
            System.out.println("-------------- n'est pas égal à --------------");
            System.out.println(e4.toString());
            System.out.println("");
            System.out.println("");
        }
        else
        {
            System.out.println(e3.toString());
            System.out.println("-------------- est égal à --------------");
            System.out.println(e4.toString());
            System.out.println("");
            System.out.println("");
        }

        if (e5.equals(e6)==false)
        {
            System.out.println(e5.toString());
            System.out.println("-------------- n'est pas égal à --------------");
            System.out.println(e6.toString());
            System.out.println("");
            System.out.println("");
        }
        else
        {
            System.out.println(e5.toString());
            System.out.println("-------------- est égal à --------------");
            System.out.println(e6.toString());
            System.out.println("");
            System.out.println("");
        }

        //------------------------------------------------------------------------------

        //Rajoutez vos instances de Personne pour réaliser vos différents tests

        Personne p1 = new Personne("Dupont", "Jean", 25, "1 rue de la paix", e1);
        Personne p2 = new Personne("Deschamps", "Isabelle", 22, "3 rue des coquelicots", e2);
        Personne p3 = new Personne("Muller", "Helmut", 30, "1 route de Genève", e3);

        System.out.println("Affichage du nom des écoles :");
        p1.afficherNomEcole();
        p2.afficherNomEcole();
        p3.afficherNomEcole();

        System.out.println("\nAffichage des informations des écoles :");
        p1.afficherInfoEcole();
        p2.afficherInfoEcole();
        p3.afficherInfoEcole();

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());




    }
}