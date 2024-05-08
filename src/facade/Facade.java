package facade;

import connection.ConnectionDB;
import hotel.guest.Guest;
import hotel.guest.GuestServices;
import hotel.room.Room;
import hotel.room.RoomServices;
import hotel.roomReservation.RoomReservation;
import hotel.roomReservation.RoomReservationServices;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Facade {

    private Guest loggedGuest;
    private RoomReservationServices roomReservationServices;
    private RoomServices roomServices;
    private GuestServices guestServices;

    public Facade() {
        this.loggedGuest = null;
        this.roomReservationServices = new RoomReservationServices();
        this.guestServices = new GuestServices();
        this.roomServices = new RoomServices();
    }

    // GUEST

    public void loginGuest(String ITR, String password) throws SQLException, RuntimeException{
        this.loggedGuest = guestServices.getGuest(ITR, password);
    }

    public void logoutGuest() {
        this.loggedGuest = null;
    }

    public boolean guestIsLogged() {
        return this.loggedGuest != null;
    }

    // Room

    public String getRooms() throws SQLException{
        String rooms = "";
        for (Room room : roomServices.getRooms()) {
            rooms += room;
        }
        return rooms;
    }

    // Room Reservations

    public void addRoomReservation(LocalDate arrivalDate, LocalDate departureDate, int numberRoom) throws SQLException, RuntimeException{
        Room room = roomServices.getRoomByNumber(numberRoom);
        RoomReservation roomReservation = new RoomReservation(loggedGuest, room, arrivalDate, departureDate);
        roomReservationServices.addRoomReservation(roomReservation);
    }

    public String getGuestReservations() throws SQLException{
        String guestReservations = "";
        for (RoomReservation roomReservation : roomReservationServices.getGuestReservations(this.loggedGuest.getId())) {
            guestReservations += roomReservation;
        }
        return guestReservations;
    }

    public void deleteRoomReservation(int id) throws SQLException{
        roomReservationServices.deleteRoomReservation(id);
    }

    public void closeConnection() throws SQLException{
        ConnectionDB.closeConnection();
    }
}
