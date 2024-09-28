package domaine;

public class TableRondeRallonge extends TableRonde implements RallongeInterface {
    private final Integer surfaceRallonge;


    public TableRondeRallonge(String code, Integer nbPlace, Matiere matiere, Integer diametre, Integer surfaceRallonge) {
        super(code, nbPlace, matiere, diametre);
        this.surfaceRallonge = surfaceRallonge;
    }

    @Override
    public Integer calculeSurfaceTotaleMax() {
        return this.surfaceTable() + surfaceRallonge;
    }
}
