package domaine;

public class TableRectRallonge extends TableRectangle implements RallongeInterface {
    private final Integer surfaceRallonge;


    public TableRectRallonge(String code, Integer nbPlace, Matiere matiere, Integer longueur, Integer largeur, Integer surfaceRallonge) {
        super(code, nbPlace, matiere, longueur, largeur);
        this.surfaceRallonge = surfaceRallonge;
    }

    @Override
    public Integer calculeSurfaceTotaleMax() {
        return this.surfaceTable() + surfaceRallonge;
    }
}
