public class Main {
    public static void main(String[] args) {
        Ecole e1 = new Ecole(1,"HEG", "Publique");
        Ecole e2 = new Ecole(2,"HEPIA", "Publique");

        // Toutes les classes ont equals par defaut
        // De base equals compare les references mémoires
        // On va modifier la méthode pour comparer les valeures des attributs
        System.out.println(e1.equals(e2));
        System.out.println(e1.compareEcole(e2));

        //On aimerait pouvoir gerer les écoles de la hesso, leurs fillieres et tous les etudiants de chaque filiere.
        //Une ecole dispose de plusieurs filieres, chaque filiere a ses propres etudiants
        // 3 classes: Ecole, Filiere, Etudiant
        // Ecole : HEG : 4 filieres -> Tableau 4 éléments
        // La filiere a plusieurs Etudiants : ArrayList
        // Ecole -> Liste de filieres -> Liste d'étudiants
        // 1er parcours: chaque filiere, 2eme parcours: chaque étudiant -> Ne pas faire 2 boucles, mais mettre Filiere dans Etudiant

    }
}