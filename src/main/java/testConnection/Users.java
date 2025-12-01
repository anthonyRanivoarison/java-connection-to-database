package testConnection;

import connection.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {

    public static void main(String[] args) throws SQLException {
        try (var connection = DatabaseConnection.getConnection()) {
            String sqlQuery = "SELECT email FROM \"user\"";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DatabaseConnection.closeConnection();
    }

}
