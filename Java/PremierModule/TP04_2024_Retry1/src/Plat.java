import java.util.Objects;

public class Plat {
    private String nom;
    private String typePlat;


    public Plat(String nom, String typePlat){
        this.nom = nom;
        this.typePlat = typePlat;
    }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Plat plat = (Plat) o;

        return Objects.equals(this.nom, plat.nom)
                && Objects.equals(this.typePlat, plat.typePlat);

    }

    public String toString(){
        String affichage = "";
        affichage += this.nom + " (" + this.typePlat + ")";
        return affichage;
    }


}
