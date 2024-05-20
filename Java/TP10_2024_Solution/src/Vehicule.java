import java.util.Objects;

public abstract class Vehicule {

    private final String immatriculation;
    private final String marque;
    private final String modele;
    private final String etat;

    public Vehicule(String immatriculation, String marque, String modele, String etat) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.etat = etat;
    }

    public String getType() {
        return this.getClass().getName();
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getEtat() {
        return etat;
    }
}
