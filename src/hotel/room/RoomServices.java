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

    public void alterRoom(Room room) throws SQLException{
        new RoomDAO().editRoom(room);
    }
}
