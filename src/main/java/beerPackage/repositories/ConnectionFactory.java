package beerPackage.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jbdc:mysql://moktok.intecbrussel.org:33062/JAVAJANAviva", "JAVAJANAviva", "Aviva2022");
    }
}
