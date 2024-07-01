import java.util.Objects;

public class Chocolat extends Boisson {
    private String typeChocolat;

    public Chocolat(String nom, double prix, int taille, String typeChocolat) {
        super(nom, prix, taille);
        this.typeChocolat = typeChocolat;
    }

    public String getTypeChocolat() {
        return typeChocolat;
    }

    public String toString() {
        String affichage = "\n" + nom + "(" + prix + "Chf) - " + taille + "cl chocolat " + typeChocolat + " : ";
        return affichage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()){
            return false;
        }
        Chocolat chocolat = (Chocolat) o;
        return Objects.equals(this.nom, chocolat.nom)
                && Objects.equals(this.prix, chocolat.prix)
                && Objects.equals(this.taille, chocolat.taille)
                && Objects.equals(this.typeChocolat, chocolat.typeChocolat);
    }

    @Override
    public void servir(){
        System.out.println(this.nom + "(" + this.prix + ") - " + this.taille + "cl " + this.nom + " " + this.typeChocolat + " servi. Santé !");
    }

    @Override
    public boolean allergie(){
        if (typeChocolat.equals("noir")){
            return false;
        }
        return true;
    }

}
