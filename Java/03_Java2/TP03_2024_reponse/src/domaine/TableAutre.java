package domaine;

public class TableAutre extends Table {

    public TableAutre(String code, int nbPlaces, Matiere matiere) {
        super(code, nbPlaces, matiere);
    }

    @Override
    public int surface() {
        return 0;
    }
}
