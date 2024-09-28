public class UnknowTypePersonnageException extends Exception {
    String personnageName;

    public UnknowTypePersonnageException(String personnageName) {
        this.personnageName = personnageName;
    }

    @Override
    public String toString() {
        return "Le personnage " + personnageName + " n'est pas reconnu";
    }
}
