package Domaine;

public abstract class Cafe extends Boisson{
    private String provenance;
    private int force;

    public Cafe(String nom, double prix, int taille, String provenance, int force) {
        super(nom, prix, taille);
        this.provenance = provenance;
        this.force = force;
    }

    @Override
    public String toString() {
        return super.toString() + " " + provenance + ", intensité " + force + ",";
    }
}
