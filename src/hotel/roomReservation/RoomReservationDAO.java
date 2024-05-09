package hotel.roomReservation;

import connection.ConnectionDB;

import java.sql.*;

public class RoomReservationDAO {

    private static Connection connection;

    public RoomReservationDAO() throws SQLException {
        connection = ConnectionDB.getConnectionDB();
    }

    public void addRoomReservation(RoomReservation roomReservation) throws SQLException {

        String sql = "INSERT INTO room_reservations (arrival_date, departure_date, total_value_of_stay, id_room, id_guest) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, Date.valueOf(roomReservation.getArrivalDate()));
        preparedStatement.setDate(2, Date.valueOf(roomReservation.getDepartureDate()));
        preparedStatement.setDouble(3, roomReservation.getTotalValueOfStay());
        preparedStatement.setInt(4, roomReservation.getRoom().getNumber());
        preparedStatement.setInt(5, roomReservation.getGuest().getId());

        preparedStatement.execute();
        preparedStatement.close();
    }

    public ResultSet getRoomReservations() throws SQLException {

        String sql = "SELECT * FROM room_reservations";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        return preparedStatement.getResultSet();
    }

    public ResultSet getRoomReservationById(int id) throws SQLException {

        String sql = "SELECT * FROM room_reservations WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();

        return preparedStatement.getResultSet();
    }

    public ResultSet getGuestReservations(int id) throws SQLException{

        String sql = "SELECT * FROM room_reservations WHERE id_guest = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();

        return preparedStatement.getResultSet();
    }

    public void deleteRoomReservation(int id) throws SQLException, RuntimeException{

        String sql = "DELETE FROM room_reservations WHERE id = ?";

        PreparedStatement preparedStatement  = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int affectedLines = preparedStatement.executeUpdate();
        preparedStatement.close();
        if (affectedLines == 0) {
            throw new RuntimeException("THIS RESERVATION DOES NOT EXISTS");
        }
    }
}
