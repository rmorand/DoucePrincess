import dao.Bdd;
import metier.Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Application app = new Application();

        System.out.println("Test de la méthode query pour exécuter une requête SELECT");
        app.testQuery();
        System.out.println();

        System.out.println("Test de la méthode exec pour exécuter une requête INSERT");
        app.testExec();
        app.testQuery();
        System.out.println();

        System.out.println("Question 1");
        System.out.println(app.nbParticpant(1));
        System.out.println();

        System.out.println("Question 2");
        System.out.println(app.afficherParticipant(1));

    }


}