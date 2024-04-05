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
            Room room = new Room(rooms.getInt(1), rooms.getString(2), rooms.getString(3), rooms.getString(4), rooms.getInt(5), rooms.getDouble(6));
            listRooms.add(room);
        }

        return listRooms;
    }

    public Room getRoomByNumber(int numberRoom) throws SQLException{
        ResultSet resultSet = new RoomDAO().getRoom(numberRoom);
        
        if (resultSet.next()) {
            int number = resultSet.getInt(1);
            String type = resultSet.getString(2);
            String description = resultSet.getString(3);
            String availability = resultSet.getString(4);
            int capacity = resultSet.getInt(5);
            double price = resultSet.getDouble(6);
            resultSet.close();
            return new Room(number, type, description, availability, capacity, price);
        }

        return null;
    }

    public void alterRoom(Room room) throws SQLException{
        new RoomDAO().editRoom(room);
    }
}
