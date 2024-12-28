package metier;

import dao.Bdd;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {
    Bdd bdd;

    public Application() {
        // Créé la connection
        this.bdd = new Bdd();
        if (this.bdd == null || !isConnected()) {
            System.out.println("Failed to initialize the database connection.");
        }
    }

    private boolean isConnected() {
        try {
            return this.bdd.connect() != null;
        } catch (SQLException e) {
            return false;
        }
    }

    // Test de la méthode query pour exécuter une requête SELECT
    public void testQuery() throws SQLException {
        ResultSet res1 = bdd.query("SELECT * FROM exe_employe");
        while (res1.next()) {
            System.out.println(res1.getString("emp_nom"));
        }
    }

    // Test de la méthode exec pour exécuter une requête SELECT INSERT
    public void testExec() throws SQLException {
        // Récupérer le nombre actuel d'employés
        int newEmpNo = 0;
        String countQuery = "SELECT COUNT(*) AS total FROM exe_employe";
        ResultSet res = bdd.query(countQuery);
        if (res.next()) {
            // Incrémenter le nombre de 1
            newEmpNo = res.getInt("total") + 1;
        }
        // Insérer le nouvel employé
        String insertQuery = "INSERT INTO exe_employe (emp_no, emp_nom, emp_prenom) VALUES (" + newEmpNo + ", 'DOE', 'John')";
        bdd.exec(insertQuery);
    }


    // 1) Méthode qui retourne le nombre de participants

    public int nbParticpant(int noCompet) {
        // requete SQL
        String requete = "SELECT COUNT(*) AS nbParticipant " +
                "           FROM heg_competition " +
                "           JOIN heg_participe ON com_no=par_com_no " +
                "           WHERE com_no=" + noCompet;
        System.out.println("Requete : " + requete);
        // creer le res avec le try/catch
        try {
            ResultSet res = bdd.query(requete);
            // curseur : soit avec if soit avec while
            if (res.next()) {
                return res.getInt("nbParticipant");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ;
        }
        return 0;
    }

    // 2) Méthode Java qui affiche la liste des participants à une compétition

    public boolean afficherParticipant(int noCompet) {
        String requete = "SELECT * FROM heg_personne\n" +
                "           JOIN heg_participe ON par_per_no=per_no\n" +
                "           JOIN heg_competition ON com_no=par_com_no\n" +
                "           WHERE com_no=" + noCompet;
        System.out.println("Requete : " + requete);
        try {
            ResultSet res = bdd.query(requete);
            while (res.next()) {
                String prenom = res.getString("per_prenom");
                String nom = res.getString("per_nom");
                System.out.println(prenom + " " + nom);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ;
        }
        return true;
    }


}
