public class AnalyseException extends Exception {
    int line;
    String analyseType;

    public AnalyseException(int line, String analyseType) {
        this.line = line + 1;
        this.analyseType = analyseType;
    }

    @Override
    public String toString() {
        return "\t- Erreur de type à la ligne " + line + ". Le type \"" + analyseType + "\"est inconnu !";
    }
}
