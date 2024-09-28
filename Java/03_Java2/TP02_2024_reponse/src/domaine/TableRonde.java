package domaine;

public class TableRonde extends Table {
    private final Integer diametre;

    public TableRonde(String code, Integer nbPlace, Matiere matiere, Integer diametre) {
        super(code, nbPlace, matiere);
        this.diametre = diametre;
    }

    @Override
    public Integer surfaceTable() {
        return (Integer) (int) (Math.PI * (Math.pow((diametre/2), 2)));
    }

    public String toString() {
        String result = "Table ronde (";
        result += super.toString();
        result += " de diamètre " + this.diametre;
        return result;
    }

}
