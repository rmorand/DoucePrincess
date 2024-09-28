package TP02;

import java.util.Objects;

public class Personne {
    private String nom;
    private int age;

    private Voiture voiture;

    public Personne(String nom, int age, Voiture voiture) {
        this.nom = nom;
        this.age = age;
        this.voiture = voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public String getNom() {
        return nom;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    @Override
    public String toString() {
        return "Nom de la personne : " + nom + voiture;
    }
}
