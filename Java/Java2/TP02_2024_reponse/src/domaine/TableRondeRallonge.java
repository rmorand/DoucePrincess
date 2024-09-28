package domaine;

public class TableRondeRallonge extends TableRonde implements SurfaceTotaleMaxCalculable{
    private Integer surfaceRallonge;


    public TableRondeRallonge(String code, Integer nbPlace, Matiere matiere, Integer diametre, Integer surfaceRallonge) {
        super(code, nbPlace, matiere, diametre);
        this.surfaceRallonge = surfaceRallonge;
    }


    @Override
    public String toString() {
        String result = super.toString();
        result += " avec rallonge";
        return result;
    }

    @Override
    public Integer calculeSurfaceTotaleMax() {
        Integer surfaceTotaleMax = this.surface() + surfaceRallonge;
        return surfaceTotaleMax;
    }
}
