public class Chocolat extends Boisson{
    private String typeChocolat;

    public Chocolat(String nom, Double prix, int taille, String typeChocolat){
        super(nom, prix, taille);
        this.typeChocolat = typeChocolat;
    }


    public String toString() {
        String affichage = "";
        affichage += this.nom + "(" + this.prix + "Chf) - " + this.taille + "cl chocolat " + this.typeChocolat;
        return affichage;
    }

}
