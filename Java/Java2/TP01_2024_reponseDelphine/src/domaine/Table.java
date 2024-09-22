package domaine;

public abstract class Table {
    private String code;
    private Integer nbPlace;
    private String matiere;


    public Table(String code, Integer nbPlace, String matiere) {
        this.code = code;
        this.nbPlace = nbPlace;
        this.matiere = matiere;
    }

    public abstract Integer surface();

    public String toString() {
        String result = this.code + ") : " + this.nbPlace +  " places, en " + this.matiere;
        return result;
    }

    public String getMatiere() {
        return matiere;
    }

}
