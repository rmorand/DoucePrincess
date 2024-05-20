public class TypeException extends Exception{
    private int ligneErreur;
    private String typeErreur;

    public TypeException(String message, int ligneErreur, String typeErreur){
        super(message);
        this.ligneErreur = ligneErreur;
        this.typeErreur = typeErreur;
    }


    public String getMessage(){
        return super.getMessage() + ligneErreur + ". Le type " + " est inconnu";
    }

}
