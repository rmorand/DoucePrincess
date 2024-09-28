package domaine;

public class TableSpeciale implements Comparable<TableSpeciale> {
    private final Table table;
    private final Integer epaisseur;
    private final Integer poids;
    private final Bordure bordure;

    public TableSpeciale(String code, Integer nbPlace, Matiere matiere, Integer diametre, Integer epaisseur, Integer poids, Bordure bordure) {
        this.table = new TableRonde(code, nbPlace, matiere, diametre);

        this.epaisseur = epaisseur;
        this.poids = poids;
        this.bordure = bordure;
    }

    public TableSpeciale(String code, Integer nbPlace, Matiere matiere, Integer diametre, Integer epaisseur, Integer poids, Bordure bordure, Integer rallonge) {
        this.table = new TableRondeRallonge(code, nbPlace, matiere, diametre, rallonge);

        this.epaisseur = epaisseur;
        this.poids = poids;
        this.bordure = bordure;
    }

    public TableSpeciale(String code, Integer nbPlace, Matiere matiere, Integer longueur, Integer largeur, Integer epaisseur, Integer poids, Bordure bordure) {
        this.table = new TableRectangle(code, nbPlace, matiere, longueur, largeur);

        this.epaisseur = epaisseur;
        this.poids = poids;
        this.bordure = bordure;
    }

    public TableSpeciale(String code, Integer nbPlace, Matiere matiere, Integer longueur, Integer largeur, Integer epaisseur, Integer poids, Bordure bordure, Integer rallonge) {
        this.table = new TableRectRallonge(code, nbPlace, matiere, longueur, largeur, rallonge);

        this.epaisseur = epaisseur;
        this.poids = poids;
        this.bordure = bordure;
    }

    public Integer getSurfaceTableSpeciale() {
        return this.table.surfaceTable();
    }


    public Matiere getMatiere() {
        return this.table.getMatiere();
    }

    @Override
    public int compareTo(TableSpeciale o) {
        return this.table.compareTo(o.table);
    }

    public int compareBySurface(TableSpeciale o) {
        return o.getSurfaceTableSpeciale() - this.getSurfaceTableSpeciale();
    }

    public String toString() {
        String result = this.table + ", épaisseur: " + this.epaisseur + ", " + this.poids + " kg, bordure " + this.bordure.name();
        if (this.table.getCode().endsWith("+")) {
            result += ", avec rallonge";
        }
        return result;
    }

}
