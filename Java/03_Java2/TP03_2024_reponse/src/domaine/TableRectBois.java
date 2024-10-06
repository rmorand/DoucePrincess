package domaine;

public class TableRectBois extends TableRect implements TableBois{
    String typeBois;

    public TableRectBois(String code, int nbPlaces, Matiere matiere, int longueur, int largeur, String typeBois) {
        super(code, nbPlaces, matiere, longueur, largeur);
        this.typeBois = typeBois;
    }

    @Override
    public String getTypeBois() {
        return typeBois;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + this.typeBois + ")";
    }
}
