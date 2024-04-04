import util.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int name = Util.getInteger(scanner, "TYPE IN INTEGER NUMBER: ");

        System.out.println(name);
    }
}