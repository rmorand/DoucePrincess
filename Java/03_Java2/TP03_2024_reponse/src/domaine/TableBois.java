package domaine;

public class TableBois implements SurfaceCalculable {
    Table table;
    String typeBois;

    public TableBois(Table table, String typeBois) {
        this.table = table;
        this.typeBois = typeBois;
    }

    public boolean estEn(Matiere matiere) {
        return true;
    }


    @Override
    public Integer surface() {
        return null;
    }
}
