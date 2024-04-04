package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class ConnectionDB {

    private static Connection connection;
    private static final String url = "jdbc:mysql://localhost:3306/hotel_sistem";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnectionDB() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } else {
            return connection;
        }
    }
}
