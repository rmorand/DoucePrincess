package TP03;

import java.util.ArrayList;

public class Filliere {
    private String code;
    private String nom;
    private ArrayList<Etudiant> listeEtudiant;

    public Filliere(String code, String nom) {
        this.code = code;
        this.nom = nom;
        this.listeEtudiant = new ArrayList<>();
    }

    public void addEtudiant(Etudiant e){
        this.listeEtudiant.add(e);
    }
}
