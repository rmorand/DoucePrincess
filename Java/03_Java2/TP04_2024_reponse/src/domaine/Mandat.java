package domaine;

import java.util.Objects;

public class Mandat {
    private int no;
    private String description;
    private String mandant;

    public Mandat(int no, String description, String mandant) {
        this.no = no;
        this.description = description;
        this.mandant = mandant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mandat mandat = (Mandat) o;
        return no == mandat.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    @Override
    public String toString() {
        return "Mandat n°" + no + ": " + description + " pour " + mandant;
    }
}