package Domaine;

public class Resultat {
    private int dossard;
    private double temps;

    public Resultat(int dossard, double temps) {
        this.dossard = dossard;
        this.temps = temps;
    }

    public int getDossard() {
        return dossard;
    }

    public double getTemps() {
        return temps;
    }

    public String toString() {
        return "Dossard " + dossard + " : " + temps;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Resultat r = (Resultat) obj;
        return r.getDossard() == this.getDossard();
    }
}
