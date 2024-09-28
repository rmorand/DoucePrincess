package domaine;

public class PlateauRond extends Plateau {
    private final int diametre;

    public PlateauRond(String code, int nbPlaces, Matiere matiere, int diametre) {
        super();
        this.diametre = diametre;
    }

    @Override
    public String toString() {
        return "Plateau rond " + super.toString() + " de diamètre " + diametre;
    }

    @Override
    public Double getSurface() {
        return Math.PI * Math.pow(diametre / 2, diametre / 2);
    }
}