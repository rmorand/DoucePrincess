import java.util.ArrayList;
import java.util.Objects;

public class Menu {
    private String nom;
    private double prix;
    private ArrayList<Plat> plats;


    public Menu(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
        plats = new ArrayList<Plat>();
    }

    public ArrayList<Plat> getPlats() {
        return this.plats;
    }


    public void ajoutPlat(Plat platAjoute) {
        if (plats.size() < 5) {
            plats.add(platAjoute);
            System.out.println("Le plat " + platAjoute + " a bien été ajouté dans le menu " + this.nom);
        } else {
            System.out.println("Erreur : Il ne peut pas y avoir plus de 5 plats dans un menu");
        }
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
        Menu menu = (Menu) o;

        return Objects.equals(this.nom, menu.nom);
    }


    public String toString(){
        String affichage = "";
        affichage += "\tMenu " + this.nom + " à " + this.prix + "Chf composé de :\n\t" ;
        for(Plat plat: plats){
            affichage += plat + " ";
        }
        return affichage;
    }

}
