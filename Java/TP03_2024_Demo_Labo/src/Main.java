package TP03;

public class Main {
    public static void main(String[] args) {
        Ecole e1 = new Ecole(1, "Heg", "Publique", 4);
        Ecole e2 = new Ecole(2, "Hepia", "Publique", 8);

        System.out.println(e1.equals(e2));
        System.out.println(e1.compareEcole(e2));

        //On veut gerer les ecoles de la hesso ainsi que leurs fillières, chaque fillière possède des etudiants
        //HEG : a 4 fillière, chaque fillière dispose d'etudiants
        //Classe Ecole - Classe Filliere - Classe etudiant
        //Ecole -> Liste de Fillieres <-> Liste d'etudiants
        //1er parcours : chaque fillieres
            //2eme parcours pour les etudiants de la filières



    }
}
