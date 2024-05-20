public class Personne {
    private String nom;
    private String prenom;
    private String adresse;
    private Integer age;
    private Voiture voiture;
    private Maison maison;

    //Constructeur 1: sans voiture ni maison
    public Personne(String nom, String prenom, String adresse, Integer age){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age;
        this.voiture = null;
        this.maison = null;
    }
    //Constructeur 2: avec une voiture, sans maison
    public Personne(String nom, String prenom, String adresse, Integer age, Voiture voiture){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age;
        this.voiture = voiture;
        this.maison = null;
    }
    //Constructeur 3: sans voiture, avec une maison
    public Personne(String nom, String prenom, String adresse, Integer age, Maison maison){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age;
        this.voiture = null;
        this.maison = maison;
    }
    //Constructeur 4: avec une voiture, avec une maison
    public Personne(String nom, String prenom, String adresse, Integer age, Voiture voiture, Maison maison){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age;
        this.voiture = voiture;
        this.maison = maison;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public void setVoiture(Voiture nouvelleVoiture){
        this.voiture = nouvelleVoiture;
    }

    public void setMaison(Maison nouvelleMaison){
        this.maison = nouvelleMaison;
    }

    public String afficher(){
        String affichage = "";
        affichage = this.nom + " " + this.prenom + "(" + this.age + "), " + this.adresse + "\nPossession(s) : ";
        if(this.voiture != null && this.maison != null){
            affichage += this.voiture + "" + this.maison;
        }
        if(this.voiture != null && this.maison == null){
            affichage += this.voiture;
        }
        if(this.voiture == null && this.maison != null){
            affichage += this.maison;
        }
        if(this.voiture == null && this.maison == null){
            affichage += "Aucunes";
        }
        return affichage;
    }





}
