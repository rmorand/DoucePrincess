package domaine;

public class TableRonde extends Table {
    private Integer diametre;

    public TableRonde(String code, Integer nbPlace, Matiere matiere, Integer diametre) {
        super(code, nbPlace, matiere);
        this.diametre = diametre;
    }

    @Override
    public Integer surface() {
        Integer result = (int) (Math.PI * (Math.pow((diametre/2), 2)));
        return result;
    }

    public String toString() {
        String result = "Table ronde (";
        result += super.toString();
        result += " de diamètre " + this.diametre;
        return result;
    }

}
