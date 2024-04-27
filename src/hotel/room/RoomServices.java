package hotel.room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomServices {

    public List<Room> getRooms() throws SQLException {
        ResultSet rooms = new RoomDAO().getAllRooms();
        List<Room> listRooms = new ArrayList<>();

        while (rooms.next()) {
            int number = rooms.getInt(1);
            String type = rooms.getString(2);
            String description = rooms.getString(3);
            int capacity = rooms.getInt(5);
            double dailyValue = rooms.getDouble(6);
            listRooms.add(new Room(number, type, description, capacity, dailyValue));
        }

        return listRooms;
    }

    public Room getRoomByNumber(int numberRoom) throws SQLException{
        ResultSet resultSet = new RoomDAO().getRoom(numberRoom);

        if (resultSet.next()) {
            int number = resultSet.getInt(1);
            String type = resultSet.getString(2);
            String description = resultSet.getString(3);
            int capacity = resultSet.getInt(5);
            double dailyValue = resultSet.getDouble(6);
            resultSet.close();
            return new Room(number, type, description, capacity, dailyValue);
        }

        return null;
    }
}
