public class Maison {
    /**
     * Classe Maison servant à instancier des objets maison
     */
    //Attributs
    private int surface;
    private int nbPiece;
    private boolean location;
    private int prix;


    //Constructeurs
    public Maison(int surface, int nbPiece, boolean location, int prix) {
        this.surface = surface;
        this.nbPiece = nbPiece;
        this.location = location;
        this.prix = prix;
    }

    //Getters et Setters
    public int getSurface() {
        return this.surface;
    }

    public int getNbPiece() {
        return this.nbPiece;
    }

    public boolean getLocation() {
        return this.location;
    }

    public int getPrix() {
        return this.prix;
    }

}
