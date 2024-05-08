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
            int number = rooms.getInt("number");
            String type = rooms.getString("type");
            String description = rooms.getString("description");
            int capacity = rooms.getInt("capacity");
            double dailyValue = rooms.getDouble("price");
            listRooms.add(new Room(number, type, description, capacity, dailyValue));
        }

        return listRooms;
    }

    public Room getRoomByNumber(int numberRoom) throws SQLException{
        ResultSet resultSet = new RoomDAO().getRoom(numberRoom);

        if (resultSet.next()) {
            int number = resultSet.getInt("number");
            String type = resultSet.getString("type");
            String description = resultSet.getString("description");
            int capacity = resultSet.getInt("capacity");
            double dailyValue = resultSet.getDouble("price");
            resultSet.close();
            return new Room(number, type, description, capacity, dailyValue);
        }

        return null;
    }
}
