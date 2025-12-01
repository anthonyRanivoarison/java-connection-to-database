package connection;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String databaseName = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String connectionUrl = "jdbc:postgresql://" + host + ":5432/" + databaseName;

        return DriverManager.getConnection(connectionUrl, user, password);
    }

    public static void closeConnection() throws SQLException {
        var connection = getConnection();

        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
