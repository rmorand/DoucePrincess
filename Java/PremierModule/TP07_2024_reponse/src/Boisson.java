import java.util.Objects;

public abstract class Boisson {
    protected String nom;
    protected double prix;
    protected int taille;

    public Boisson(String nom, double prix, int taille){
        this.nom = nom;
        this.prix = prix;
        this.taille = taille;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public void servir(){
        System.out.println("undefined function: servir() in " + this.getClass());
    }

    public abstract boolean allergie();

}
