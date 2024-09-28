package domaine;

import java.util.Objects;

public abstract class Plateau {

    private String code;
    private int nbPlace;
    private Matiere matiere;

    public Plateau(String code, int nbPlaces, Matiere matiere) {
        this.code = code;
        this.nbPlace = nbPlaces;
        this.matiere = matiere;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public abstract Double getSurface();

    public abstract Double compareSurface(Plateau o1)
}