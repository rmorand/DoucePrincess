package Domaine;

import java.util.Objects;

public abstract class Boisson {
    private String nom;
    private double prix;
    private int taille;

    public Boisson(String nom, double prix, int taille) {
        this.nom = nom;
        this.prix = prix;
        this.taille = taille;
    }

    public abstract String allergie();

    @Override
    public String toString() {
        return nom + "(" + prix + "Chf) - " + taille + "cl";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boisson boisson = (Boisson) o;
        return Double.compare(prix, boisson.prix) == 0 && taille == boisson.taille && Objects.equals(nom, boisson.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prix, taille);
    }
}
