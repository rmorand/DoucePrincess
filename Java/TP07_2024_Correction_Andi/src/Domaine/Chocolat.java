package Domaine;

public class Chocolat extends Boisson{
    private String typeChocolat;

    public Chocolat(String nom, double prix, int taille, String typeChocolat) {
        super(nom, prix, taille);
        this.typeChocolat = typeChocolat;
    }

    @Override
    public String allergie() {

        if(!this.typeChocolat.equals("noir")) {
            return "\n\t- Contient du lactose.\n";
        }
        return "\n";
    }

    @Override
    public String toString() {
        return super.toString() + " Chocolat " + typeChocolat;
    }

}
