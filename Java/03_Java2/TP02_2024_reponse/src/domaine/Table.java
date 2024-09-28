package domaine;

public abstract class Table implements Comparable<Table> {
    private String code;
    private Integer nbPlace;
    private Matiere matiere;


    public Table(String code, Integer nbPlace, Matiere matiere) {
        this.code = code;
        this.nbPlace = nbPlace;
        this.matiere = matiere;
    }

    public abstract Integer surface();

    public Matiere getMatiere() {
        return matiere;
    }

    @Override
    public int compareTo(Table o) {
        return this.code.compareToIgnoreCase(o.code);
    }

    public String toString() {
        String result = this.code + ") : " + this.nbPlace +  " places, en " + this.matiere;
        return result;
    }

}
