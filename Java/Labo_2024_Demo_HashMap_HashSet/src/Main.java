package Collections;

public class Main {
    public static void main(String[] args) {
        //Gestion d'une école : 4 fillières,  chaque fillière a ses propres étudiants
        //Faire le tout sans arraylist
        Ecole heg = new Ecole(1,"Heg", "Publique");
        Filliere f1 = new Filliere("IG", "Informatique de gestion");
        Etudiant e1 = new Etudiant("R", "A", 29);
        Etudiant e2 = new Etudiant("T", "B", 19);
        heg.addFilliere(f1);
        heg.addEtudiant(f1, e1);
        heg.addEtudiant(f1, e2);
        System.out.println(heg);
    }
}
