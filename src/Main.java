import hotel.room.Room;

public class Main {
    public static void main(String[] args) {
        Room room = new Room(1, "Suit", "Room has smart TV, 2 bathrooms, 1 bed, window overlooking the road", "AVAILABLE", 2, 500);
        System.out.println(room);
    }
}