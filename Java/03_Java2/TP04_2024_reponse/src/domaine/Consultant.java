package domaine;

import java.util.Objects;

public class Consultant {
    private int no;
    private String nom;
    private String prenom;

    public Consultant(int no, String nom, String prenom) {
        this.no = no;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultant that = (Consultant) o;
        return no == that.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    @Override
    public String toString() {
        return no + ":" + prenom + " " + nom;
    }
}