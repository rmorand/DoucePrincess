public class Employe {
    private String nom;
    private String prenom;
    private String adresse;
    private String fonction;
    private Integer nbAnneeAnciennete;
    private float salaireMensuel;

    public Employe(String nom, String prenom, String adresse, String fonction, Integer nbAnneeAnciennete, float salaireMensuel) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.fonction = fonction;
        this.nbAnneeAnciennete = nbAnneeAnciennete;
        this.salaireMensuel = salaireMensuel;
    }

    public void changerAdresse(String nouvelleAdresse) {
        this.adresse = nouvelleAdresse;
    }

    public void changerNbAnneeAnciennete(Integer nouveauNbAnneeAnciennete) {
        this.nbAnneeAnciennete = nouveauNbAnneeAnciennete;
    }

    public float calculerBonus(){
        float bonus = 0;
        bonus = this.salaireMensuel + ((this.nbAnneeAnciennete * this.salaireMensuel) / 100);
        return bonus;
    }

    public void afficher(){
        String affichage = "";
        affichage = this.nom + " " + this.prenom + ", " + this.adresse + ". Fonction: " + this.fonction +
                "\n" + this.nbAnneeAnciennete + " années dans l'entreprise. Salaire: " + calculerBonus() + "Chf par mois, " +
                this.salaireMensuel + "Chf sans bonus\n";
        System.out.println(affichage);
    }

}
