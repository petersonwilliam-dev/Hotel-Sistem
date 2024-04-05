package hotel.room;

import connection.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDAO {

    private static Connection connection;

    public RoomDAO() throws SQLException {
        connection = ConnectionDB.getConnectionDB();
    }

    public ResultSet getAllRooms() throws SQLException{

        String sql = "SELECT * FROM rooms";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        return preparedStatement.getResultSet();
    }

    public ResultSet getRoom(int number) throws SQLException{
        String sql = "SELECT * FROM rooms WHERE number = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, number);
        preparedStatement.execute();

        return preparedStatement.getResultSet();
    }

    public void editRoom(Room room) throws SQLException{

        String sql = "UPDATE rooms SET availability = ? WHERE number = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(room.getAvailability()));
        preparedStatement.setInt(2, room.getNumber());

        preparedStatement.execute();
        preparedStatement.close();
    }
}
