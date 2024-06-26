package modelos.lab10_20211602.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseRepository {
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Falla conexion");
        }

        String username = "root";
        String password = "root";
        String database = "lab7";
        String params = "serverTimezone=America/Lima&useSSL=false&allowPublicKeyRetrieval=true";
        String url = "jdbc:mysql://34.139.185.159:3306/" + database + "?" + params;

        return DriverManager.getConnection(url, username, password);

    }

}
