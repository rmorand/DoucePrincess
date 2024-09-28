public class Employe {
    //Attributs
    //Propriétés
    private String nom;
    private String prenom;
    private String adresse;
    private String fonction;
    private int anneeDansLentreprise;
    private int salaireMensuel;


    //Constructeur
    public Employe(String nom, String prenom, String adresse, String fonction, int anneeDansLentreprise, int salaireMensuel){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.fonction = fonction;
        this.anneeDansLentreprise = anneeDansLentreprise;
        this.salaireMensuel = salaireMensuel;
    }

    //Méthodes
    public void changerAdresse(String nouvelle_Adresse){
    adresse = nouvelle_Adresse;
    }

    public void changerNBAnnee(int nouveau_NbAnnee){
    anneeDansLentreprise = nouveau_NbAnnee;
    }

    public double calculBonus(){
        return salaireMensuel + ((double)anneeDansLentreprise / 100 * salaireMensuel);
    }

    public void afficher(){
        System.out.println(nom + " " + prenom + ", " + adresse + ". Fonction : " + fonction);
        System.out.println(anneeDansLentreprise + " années dans l'entreprise. Salaire : " + calculBonus() + "Chf par mois, " + salaireMensuel + "Chf sans bonus.");
    }
}
