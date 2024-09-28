public class GestionPersonnages {

    public static void main(String[] args) {
        //charger les personnages
        System.out.println("\n\n------Chargement des personnages------");
        chargerPersonnages(FileToStr.lireCsv("personnages.csv"));


        //afficher les personnages
        System.out.println("\n\n------Affichage des personnages------");
        afficherPersonnages();

        //Creer un combat aléatoire
        System.out.println("\n\n------Lancement d'un combat aléatoire------");
        creerCombatAleatoire();
    }
}
