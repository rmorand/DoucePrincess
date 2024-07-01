package Domaine;

public class Macchiato extends Cafe{
    private int quantiteLait;

    public Macchiato(String nom, double prix, int taille, String provenance, int force, int quantiteLait) {
        super(nom, prix, taille, provenance, force);
        this.quantiteLait = quantiteLait;
    }


    @Override
    public String allergie() {
        if(this.quantiteLait > 0) {
            return "\n\t- Contient du lactose.\n";
        }
        return "\n";
    }

    @Override
    public String toString() {
        return super.toString() + quantiteLait + "cl de lait";
    }
}
