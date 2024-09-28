package domaine;

public abstract class Table implements Comparable<Table> {
    private final String code;
    private final Integer nbPlace;
    private final Matiere matiere;


    public Table(String code, Integer nbPlace, Matiere matiere) {
        this.code = code;
        this.nbPlace = nbPlace;
        this.matiere = matiere;
    }

    public abstract Integer surfaceTable();

    public String toString() {
        return this.code + ") : " + this.nbPlace +  " places, en " + this.matiere;
    }

    public String getCode() {
        return this.code;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    @Override
    public int compareTo(Table o) {
        return this.code.compareToIgnoreCase(o.code);
    }

}
