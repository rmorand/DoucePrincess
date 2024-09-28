public class Personne {
    /**
     * Classe Personne servant à instancier des objets personne
     */
    //Attributs
    private String nom;
    private String prenom;
    private String adresse;
    private int age;
    private Voiture voiture;
    private Maison maison;

    //Constructeurs
    public Personne(String nom, String prenom, String adresse, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age;
        this.voiture = null;
        this.maison = null;
    }

    public Personne(String nom, String prenom, String adresse, int age, Voiture voiture) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age;
        this.voiture = voiture;
        this.maison = null;
    }

    public Personne(String nom, String prenom, String adresse, int age, Maison maison) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age;
        this.maison = maison;
        this.voiture = null;
    }

    public Personne(String nom, String prenom, String adresse, int age, Voiture voiture, Maison maison) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age;
        this.voiture = voiture;
        this.maison = maison;
    }

    //Getters et Setters
    public String getPrenom() {
        return this.prenom;
    }

    public void setVoiture(Voiture nouvelleVoiture) {
        this.voiture = nouvelleVoiture;
    }

    public void setMaison(Maison nouvelleMaison) {
        this.maison = nouvelleMaison;
    }


    //Méthodes

    /**
     * Fonction servant à afficher les informations de la personne
     *
     * @return retourne les info
     */
    public String afficher() {

        String affichage_base = nom + " " + prenom + "(" + age + "), " + adresse + "\nPossession(s) : ";

        if (this.voiture != null && this.maison != null) {
            affichage_base = affichage_base
                    + voiture.getMarque() + " " + voiture.getModele() + " de " + voiture.getAnnee() + "."
                    + " Maison d'une surface de " + maison.getSurface() + "m2 comportant " + maison.getNbPiece() + " pièces.";
            if (maison.getLocation()) {
                return affichage_base
                        + " Le loyer est de " + maison.getPrix() + "Chf mensuel.";
            } else {
                return affichage_base
                        + " Le prix est de " + maison.getPrix() + "Chf.";
            }
        }

        if (this.voiture == null && this.maison != null) {
            affichage_base = affichage_base
                    + " Maison d'une surface de " + maison.getSurface() + "m2 comportant " + maison.getNbPiece() + " pièces.";
            if (maison.getLocation()) {
                return affichage_base
                        + " Le loyer est de " + maison.getPrix() + "Chf mensuel.";
            } else {
                return affichage_base
                        + " Le prix est de " + maison.getPrix() + "Chf.";
            }
        }

        if (this.voiture != null && this.maison == null) {
            return affichage_base
                    + voiture.getMarque() + " " + voiture.getModele() + " de " + voiture.getAnnee() + ".";
        }

        return affichage_base + "Aucunes";
    }
}
