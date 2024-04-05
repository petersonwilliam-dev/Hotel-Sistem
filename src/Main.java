import hotel.room.Room;
import hotel.room.RoomServices;

public class Main {
    public static void main(String[] args) {
        try {
            Room room = new RoomServices().getRoomByNumber(2);
            System.out.println(room);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}