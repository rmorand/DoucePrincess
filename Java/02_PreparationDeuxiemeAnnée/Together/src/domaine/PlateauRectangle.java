package domaine;

public class PlateauRectangle extends Plateau {
    private final int longueur;
    private final int largeur;

    public PlateauRectangle(String code, int nbPlaces, Matiere matiere, int longueur, int largeur) {
        super(code, nbPlaces, matiere);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public String toString() { return "Plateau rectangulaire " + super.toString() + " de " + longueur + "x" + largeur; }

    @Override
    public Double getSurface() {
        return Double.valueOf(longueur * largeur);
    }
}