import java.util.ArrayList;

public class Menu {
    //Attributs
    private String nom;
    private int prix;
    private ArrayList<Plat> plats;  //autre possibilité: tableau: private Plat[5] plats;

    //Constructeur
    public Menu(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
        this.plats = new ArrayList<Plat>();
    }

    // Getter/ Setter
    public String getNom() { return this.nom; }

    public int getPrix() {return this.prix;}

    public ArrayList<Plat> getPlats(){return this.plats;}

    //Méthode
    public void ajoutPlat(Plat p) {
        //Ajout de plats dans la liste de plats
        //On ne peut pas mettre 2 fois le même plat
        if (this.plats.contains(p)){
            System.out.println("Erreur: Le menu contient déja ce plat.");
        }
        // 5 plats max
        if (this.plats.size() < 6) {
            this.plats.add(p);
        } else {
            System.out.println("Erreur: il ne peut pas y avoir plus que 5 plats dans un menu.");
        }
    }

    public boolean contientPlat(Plat p) {
        //Recherche d'un plat dans la liste de plats
        boolean result = true;
        for (int i = 0; i < plats.size(); i++) {
            if (plats.contains(p)) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }


    public void afficherMenu(){
        System.out.println("Le menu " + this.nom + " est composé de :");
        for (int i = 0; i < plats.size(); i++){
            System.out.print(plats.get(i).getNom() + ", ");
        }
        System.out.println();
    }


}
