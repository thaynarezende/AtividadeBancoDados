package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/atividadethayna";
        Connection conn = DriverManager.getConnection(url, "postgres", "mycap.4546");
        return conn;
    }

}
