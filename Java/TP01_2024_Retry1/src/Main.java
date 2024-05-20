public class Main {
    public static void main(String[] args) {

        Entreprise entr = new Entreprise("Agrofi", "Chemin de l'usine 82b", "Privée", 3, "Alimentaire", 42, "Charles Agrofi");
        entr.afficher(true);
        entr.changerNbBatiment(5);
        entr.afficher(true);
        entr.changerNbEmploye(10);
        entr.afficher(true);
        entr.changerType("Publique");
        entr.afficher(true);

        Employe emp = new Employe("Dupont", "Jean", "Chemin de la route 35", "Comptable", 7, 10000);
        emp.afficher();
        emp.changerAdresse("Chemin de la foret");
        emp.changerNbAnneeAnciennete(15);
        emp.afficher();


    }
}