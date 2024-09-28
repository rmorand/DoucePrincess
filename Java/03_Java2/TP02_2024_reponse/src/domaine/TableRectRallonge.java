package domaine;

public class TableRectRallonge extends TableRectangle implements SurfaceTotaleMaxCalculable{
    private Integer surfaceRallonge;


    public TableRectRallonge(String code, Integer nbPlace, Matiere matiere, Integer longueur, Integer largeur, Integer surfaceRallonge) {
        super(code, nbPlace, matiere, longueur, largeur);
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
