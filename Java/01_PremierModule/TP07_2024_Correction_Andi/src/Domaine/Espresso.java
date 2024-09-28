package Domaine;

public class Espresso extends Cafe{
    private int quantiteCreme;

    public Espresso(String nom, double prix, int taille, String provenance, int force, int quantiteCreme) {
        super(nom, prix, taille, provenance, force);
        this.quantiteCreme = quantiteCreme;
    }

    @Override
    public String allergie() {

        if(this.quantiteCreme > 0) {
            return "\n\t- Contient du lactose.\n";
        }
        return "\n";
    }

    @Override
    public String toString() {
        return super.toString() + quantiteCreme + "cl de crème";
    }
}
