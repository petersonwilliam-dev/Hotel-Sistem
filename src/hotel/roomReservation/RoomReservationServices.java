package hotel.roomReservation;

import hotel.guest.Guest;
import hotel.guest.GuestServices;
import hotel.room.Room;
import hotel.room.RoomServices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomReservationServices {

    public void addRoomReservation(RoomReservation roomReservation) throws SQLException, RuntimeException{
        if (reservationIsAllowed(roomReservation)) {
            new RoomReservationDAO().addRoomReservation(roomReservation);
        } else {
            throw new RuntimeException("RESERVATION CANNOT BE MADE, THERE ARE DATE SHOCKS!");
        }
    }

    public List<RoomReservation> getRoomReservations() throws SQLException {
        ResultSet resultSet = new RoomReservationDAO().getRoomReservations();
        List<RoomReservation> roomReservations = new ArrayList<>();

        while (resultSet.next()) {
                int id = resultSet.getInt("id");
                LocalDate arrivalDate = resultSet.getDate("arrival_date").toLocalDate();
                LocalDate departureDate = resultSet.getDate("departure_date").toLocalDate();
                double totalValueOfStay = resultSet.getDouble("total_value_of_stay");
                Guest guest = new GuestServices().getGuest(resultSet.getInt("id_guest"));
                Room room = new RoomServices().getRoomByNumber(resultSet.getInt("id_room"));
                roomReservations.add(new RoomReservation(id, guest, room, arrivalDate, departureDate, totalValueOfStay));
        }

        resultSet.close();
        if (!roomReservations.isEmpty()) {
            return roomReservations;
        } else {
            throw new RuntimeException("NO RESERVATIONS MADE");
        }
    }

    public List<RoomReservation> getGuestReservations(int idGuest) throws SQLException{
        ResultSet resultSet = new RoomReservationDAO().getGuestReservations(idGuest);
        List<RoomReservation> roomReservations = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                LocalDate arrivalDate = resultSet.getDate("arrival_date").toLocalDate();
                LocalDate departureDate = resultSet.getDate("departure_date").toLocalDate();
                double totalValuOfStay = resultSet.getDouble("total_value_of_stay");
                Guest guest = new GuestServices().getGuest(resultSet.getInt("id_guest"));
                Room room = new RoomServices().getRoomByNumber(resultSet.getInt("id_room"));
                roomReservations.add(new RoomReservation(id, guest, room, arrivalDate, departureDate, totalValuOfStay));
            }

        resultSet.close();
        if (!roomReservations.isEmpty()) {
            return roomReservations;
        } else {
            throw new RuntimeException("THERE ARE NO RESERVATIONS MADE BY YOU");
        }
    }

    public void deleteRoomReservation(int id) throws SQLException, RuntimeException{
        new RoomReservationDAO().deleteRoomReservation(id);
    }

    private boolean reservationIsAllowed(RoomReservation roomReservation) throws SQLException{
        for (RoomReservation roomReservations : getRoomReservations()) {
            if (roomReservations.getRoom().getNumber() == roomReservation.getRoom().getNumber()) {
                if (((roomReservation.getArrivalDate().isBefore(roomReservations.getDepartureDate())) && (roomReservation.getArrivalDate().isAfter(roomReservations.getArrivalDate()))) || ((roomReservation.getDepartureDate().isBefore(roomReservations.getDepartureDate())) && (roomReservation.getDepartureDate().isAfter(roomReservations.getArrivalDate())))) {
                    return false;
                }
            }
        }

        return true;
    }
}
