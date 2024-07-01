public abstract class Cafe extends Boisson {
    protected String provenance;
    protected int force;

    public Cafe(String nom, Double prix, int taille, String provenance, int force) {
        super(nom, prix, taille);
        this.provenance = provenance;
        this.force = force;
    }

}
