package hotel.guest;

import connection.ConnectionDB;

import java.sql.*;

public class GuestDAO {

    private static Connection connection;

    public GuestDAO() throws SQLException {
        connection = ConnectionDB.getConnectionDB();
    }

    public void createGuest(Guest guest) throws SQLException{

        String sql = "INSERT INTO guests (name, surname, date_of_birth, itr, number_phone, identification_card, password_guest) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, guest.getName());
        preparedStatement.setString(2, guest.getSurname());
        preparedStatement.setDate(3, Date.valueOf(guest.getDateOfBirth()));
        preparedStatement.setString(4, guest.getITR());
        preparedStatement.setString(5, guest.getNumberPhone());
        preparedStatement.setString(6, guest.getIdentificationCard());
        preparedStatement.setString(7, guest.getPassword());

        preparedStatement.execute();
        preparedStatement.close();
    }

    public ResultSet AllGuests() throws SQLException{

        String sql = "SELECT * FROM guests";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        return preparedStatement.getResultSet();
    }

    public ResultSet getGuestByITR(String ITR) throws SQLException{

        String sql = "SELECT * FROM guests WHERE itr = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, ITR);
        preparedStatement.execute();

        return preparedStatement.getResultSet();
    }

    public ResultSet getGuestById(int id) throws SQLException{

        String sql = "SELECT * FROM guests WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();

        return preparedStatement.getResultSet();
    }

    public void editGuest(Guest guest) throws SQLException{

        String sql = "UPDATE guests SET name = ?, surname = ?, number_phone = ?, password_guest = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, guest.getName());
        preparedStatement.setString(2, guest.getSurname());
        preparedStatement.setString(3, guest.getNumberPhone());
        preparedStatement.setString(4, guest.getPassword());
        preparedStatement.setInt(5, guest.getId());

        preparedStatement.execute();
        preparedStatement.close();
    }

    public void deleteGuest(int id) throws SQLException{

        String sql = "DELETE FROM guests WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        preparedStatement.execute();
        preparedStatement.close();
    }
}
