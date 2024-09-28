package domaine;

public class TableRectangle extends Table {
    private final Integer longueur;
    private final Integer largeur;

    public TableRectangle(String code, Integer nbPlace, Matiere matiere, Integer longueur, Integer largeur) {
        super(code, nbPlace, matiere);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public Integer surfaceTable() {
        return longueur * largeur;
    }

    public String toString() {
        return "Table rectangle (" +
        super.toString() +
        " de " + this.longueur + " X " + this.largeur;
    }

}
