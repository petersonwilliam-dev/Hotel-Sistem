package util;

import java.time.LocalDate;
import java.util.Scanner;

public class Util {

    public static String getString(Scanner scanner, String message) {
        String response;
        System.out.print(message);
        response = scanner.nextLine();
        while (response.isEmpty()) {
            System.out.println("EMPTY ENTER");
            System.out.print(message);
            response = scanner.nextLine();
        }
        return response;
    }

    public static double getDouble(Scanner scanner, String message) {
        String response;
        System.out.print(message);

        response = scanner.nextLine();

        while (!response.matches("[0-9]+")) {
            System.out.println("ENTER A NUMBER VALUE!");
            System.out.print(message);
            response = scanner.nextLine();
        }

        return Double.parseDouble(response);
    }

    public static int getInteger(Scanner scanner, String message) {
        String response;
        System.out.print(message);
        response = scanner.nextLine();

        while (!response.matches("[0-9]+")) {
            System.out.println("ENTER A NUMBER VALUE!");
            System.out.print(message);
            response = scanner.nextLine();
        }

        return Integer.parseInt(response);
    }

    public static LocalDate getLocalDate(Scanner scanner, String message) {
        LocalDate response;
        String date = getString(scanner, message);
        response = LocalDate.parse(date);

        return response;
    }
}
