public class Maison {
    private float surface;
    private Integer nbPiece;
    private boolean location;
    private float prix;

    public Maison(float surface, Integer nbPiece, boolean location, float prix){
        this.surface = surface;
        this.nbPiece = nbPiece;
        this.location = location;
        this.prix = prix;
    }

    public String toString(){
        String affichage = "";
        affichage += "Maison d'une surface de " + (int)this.surface + "m2 comportant " + this.nbPiece + " pièces.";
        if(location){
            affichage += " Le loyer est de " + (int)this.prix + "Chf mensuel.";
        }
        else{
            affichage += "Le prix est de " + (int)this.prix + "Chf";
        }
        return affichage;
    }


}
