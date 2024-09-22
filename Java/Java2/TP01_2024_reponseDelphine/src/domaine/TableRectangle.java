package domaine;

public class TableRectangle extends Table {
    private Integer longueur;
    private Integer largeur;

    public TableRectangle(String code, Integer nbPlace, Matiere matiere, Integer longueur, Integer largeur) {
        super(code, nbPlace, matiere);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public Integer surface() {
        Integer result = longueur * largeur;
        return result;
    }

    public String toString() {
        String result = "Table rectangle (";
        result += super.toString();
        result += " de " + this.longueur + " X " + this.largeur;
        return result;
    }

}
