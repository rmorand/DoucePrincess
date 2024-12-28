package dao;

import java.sql.*;

public class Bdd {
    private Connection connection;

    public Bdd() {
        try {
            this.connection = connect();
        } catch (SQLException sqlException) {
            System.out.println("Connection failed: " + sqlException.getMessage());
            this.connection = null; // explicitly set to null on failure
        }
    }

    public Connection connect() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + "XE", "system", "system");
            return connection;
        } catch (SQLException e) {
            throw new SQLException("Failed to establish connection: " + e.getMessage(), e);
        }
    }


    // Pour les requêtes de type SELECT qui retournent un ResultSet
    // Prend une chaîne de caractères représentant une requête SQL de type SELECT
    // et retourne un ResultSet qui contient les résultats de la requête
    public ResultSet query(String rqt) throws SQLException {
        if (connection == null) {
            throw new SQLException("Connection is not established.");
        }
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(rqt);
    }

    // Pour les requêtes de type INSERT, UPDATE, DELETE ou autres exécutions qui ne retournent pas de ResultSet
    // Prend une chaîne de caractères représentant une requête SQL qui ne retourne pas de ResultSet (par exemple, INSERT, UPDATE, DELETE)
    // et retourne un booléen indiquant si la première résultante est un ResultSet
    public boolean exec(String rqt) throws SQLException {
        if (connection == null) {
            throw new SQLException("Connection is not established.");
        }
        Statement stmt = connection.createStatement();
        return stmt.execute(rqt);
    }


}
