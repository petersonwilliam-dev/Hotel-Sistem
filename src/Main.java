import ui.MenuUi;
import util.Util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        do {
            MenuUi.initialMenu();
            int option = Util.getInteger(scanner, "ENTER THE DESIRED OPTION: ");
        } while (!exit);
    }
}