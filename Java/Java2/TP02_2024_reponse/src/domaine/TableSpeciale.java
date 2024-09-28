package domaine;

public class TableSpeciale {
    private Table table;
    private Integer epaisseur;
    private Integer poids;
    private Bordure bordure;


    public TableSpeciale(Table table, Integer epaisseur, Integer poids, Bordure bordure) {
        this.table = table;
        this.epaisseur = epaisseur;
        this.poids = poids;
        this.bordure = bordure;
    }

    public Table getTable() {
        return table;
    }
}
