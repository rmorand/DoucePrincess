package dao;

import java.sql.*;

public class Bdd {
    private Connection connection;

    public Bdd() {
        try {
            this.connection = connect();
        } catch(SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public Connection connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + "XE", "system", "system");
        return connection;
    }


    // Pour les requêtes de type SELECT qui retournent un ResultSet
    // Prend une chaîne de caractères représentant une requête SQL de type SELECT
    // et retourne un ResultSet qui contient les résultats de la requête
    public ResultSet query(String rqt) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(rqt);
    }

    // Pour les requêtes de type INSERT, UPDATE, DELETE ou autres exécutions qui ne retournent pas de ResultSet
    // Prend une chaîne de caractères représentant une requête SQL qui ne retourne pas de ResultSet (par exemple, INSERT, UPDATE, DELETE)
    // et retourne un booléen indiquant si la première résultante est un ResultSet
    public boolean exec(String rqt) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.execute(rqt);
    }



}
