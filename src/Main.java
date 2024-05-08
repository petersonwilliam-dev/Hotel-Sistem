import facade.Facade;
import hotel.guest.Guest;
import hotel.guest.GuestServices;
import hotel.room.Room;
import hotel.room.RoomDAO;
import hotel.room.RoomServices;
import hotel.roomReservation.RoomReservation;
import hotel.roomReservation.RoomReservationServices;
import ui.MenuUi;
import util.Util;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        Facade facade = new Facade();

        do {
            if (facade.guestIsLogged()) {
                MenuUi.loggedInGuestMenu();
                int option = Util.getInteger(scanner, "TYPE YOUR OPTION: ");
                if (option == 1) {
                    try {
                        System.out.println(facade.getRooms());
                        int numberRoom = Util.getInteger(scanner, "TYPE YOUR ROOM OPTION: ");
                        LocalDate arrivalDate = Util.getLocalDate(scanner, "ENTER ARRIVAL DATE (YYYY-MM-DD): ");
                        LocalDate departureDate = Util.getLocalDate(scanner, "ENTER DEPARTURE DATE (YYYY-MM-DD): ");
                        facade.addRoomReservation(arrivalDate, departureDate, numberRoom);
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                } else if (option == 2) {
                    try {
                        System.out.println(facade.getGuestReservations());
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                } else {
                    facade.logoutGuest();
                }
            } else {
                MenuUi.initialMenu();
                int option = Util.getInteger(scanner, "TYPE YOUR OPTION: ");
                if (option == 1) {
                    System.out.println("=-=-=-=-=-=-= LOGIN GUEST =-=-=-=-=-=-=");
                    String ITR = Util.getString(scanner, "ENTER YOUR ITR: ");
                    String password = Util.getString(scanner, "ENTER YOUR PASSWORD: ");
                    try{
                        facade.loginGuest(ITR, password);
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                } else {
                    try {
                        facade.closeConnection();
                        exit = true;
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                }
            }
        } while (!exit);
    }
}