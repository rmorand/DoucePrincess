package domaine;

public class TableAutre implements SurfaceCalculable {
    Table table;

    public boolean estEn(Matiere matiere) {
        return true;
    }

    @Override
    public Integer surface() {
        return null;
    }
}
