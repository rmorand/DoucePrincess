package domaine;

public class TableRondeBois extends TableRonde implements TableBois{
    String typeBois;

    public TableRondeBois(String code, int nbPlaces, Matiere matiere, int diametre, String typeBois) {
        super(code, nbPlaces, matiere, diametre);
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
