package Collections;

import java.util.ArrayList;

public class Filliere {
    private String code;
    private String nom;


    public Filliere(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return "Filliere{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
