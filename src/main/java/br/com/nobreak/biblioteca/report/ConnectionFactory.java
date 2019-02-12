package br.com.nobreak.biblioteca.report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "biblioteca", "b1bl10t3c4");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
