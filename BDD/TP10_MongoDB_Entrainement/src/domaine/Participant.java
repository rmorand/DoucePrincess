package domaine;

import java.util.List;

public class Participant {
    private String nom;
    private String club;
    private List<String> competitions;

    public Participant(String nom, String club, List<String> competitions) {
        this.nom = nom;
        this.club = club;
        this.competitions = competitions;
    }

    public String getNom() {
        return nom;
    }

    public String getClub() {
        return club;
    }

    public List<String> getCompetitions() {
        return competitions;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setCompetitions(List<String> competitions) {
        this.competitions = competitions;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "nom='" + nom + '\'' +
                ", club='" + club + '\'' +
                ", competitions=" + competitions +
                '}';
    }
}

