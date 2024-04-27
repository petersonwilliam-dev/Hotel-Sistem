package hotel.roomReservation;

import hotel.guest.Guest;
import hotel.room.Room;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RoomReservation {

    private int id;
    private Guest guest;
    private Room room;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private double totalValueOfStay;

    public RoomReservation(Guest guest, Room room, LocalDate arrivalDate, LocalDate departureDate) {
        this.guest = guest;
        this.room = room;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.totalValueOfStay = daysOfStayCalculator() * room.getDailyValue();
    }

    public RoomReservation(int id, Guest guest, Room room, LocalDate arrivalDate, LocalDate departureDate) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.totalValueOfStay = daysOfStayCalculator() * room.getDailyValue();
    }

    public int getId() {
        return id;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public double getTotalValueOfStay() {
        return totalValueOfStay;
    }

    private long daysOfStayCalculator() {
        return ChronoUnit.DAYS.between(this.arrivalDate, this.departureDate);
    }
}
