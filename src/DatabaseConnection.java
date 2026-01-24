package util;
import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/restaurant_db";
        return DriverManager.getConnection(url, "postgres", "password");
    }
}