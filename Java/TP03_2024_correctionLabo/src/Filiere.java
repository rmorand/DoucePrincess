import java.lang.reflect.Array;
import java.util.ArrayList;

public class Filiere {
    private String code;
    private String nom;
    private ArrayList<Etudiant> listeEtudiant; //On precise ce qu'il y a dans la liste

    public Filiere(String code, String nom){
        this.code = code;
        this.nom = nom;
        this.listeEtudiant = new ArrayList<>();
    }

    //L'ajout d'étudiant se fait dans la classe Filiere
    public void addEtudiant(Etudiant e){
        this.listeEtudiant.add(e);
    }

}
