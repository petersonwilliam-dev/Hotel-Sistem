import facade.Facade;
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
                        MenuUi.menuGuestReservations();
                        option = Util.getInteger(scanner, "TYPE YOUR OPTION: ");
                        if (option == 1) {
                            int optionRemoveReservation = Util.getInteger(scanner, "ENTER THE RESERVATION NUMBER YOU WANT TO REMOVE (TYPE 0 TO GO BACK): ");
                            if (optionRemoveReservation != 0) {
                                try {
                                    facade.deleteRoomReservation(optionRemoveReservation);
                                    System.out.println("RESERVATION "+optionRemoveReservation+" SUCCESSFULLY DELETED");
                                } catch (Exception exception) {
                                    System.out.println(exception.getMessage());
                                }
                            }
                        }
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
                    try {
                        facade.loginGuest(ITR, password);
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                } else if (option == 2) {
                    System.out.println("=-=-=-=-=-=-=-= CREATE REGISTER =-=-=-=-=-=-=-=");
                    String name = Util.getString(scanner, "ENTER YOUR NAME: ");
                    String surname = Util.getString(scanner, "ENTER YOUR SURNAME: ");
                    LocalDate dateOfBirth = Util.getLocalDate(scanner, "ENTER YOUR DATE OF BIRTH (YYYY-MM-DD): ");
                    String ITR = Util.getString(scanner, "ENTER YOUR ITR: ");
                    String numberPhone = Util.getString(scanner, "ENTER YOUR NUMBER PHONE: ");
                    String identificationCard = Util.getString(scanner, "ENTER YOUR IDENTIFICATION CARD: ");
                    String password = Util.getString(scanner, "ENTER YOUR PASSWORD: ");
                    try {
                        facade.createGuest(name, surname, dateOfBirth, ITR, numberPhone, identificationCard, password);
                        System.out.println("GUEST " + name + " CREATED");
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