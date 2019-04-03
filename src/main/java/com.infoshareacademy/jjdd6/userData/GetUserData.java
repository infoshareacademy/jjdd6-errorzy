package com.infoshareacademy.jjdd6.userData;

import java.util.Scanner;

public class GetUserData {
    private static Scanner scanner = new Scanner(System.in);

    public static String getStringFromUser() {
        System.out.println("Please insert string: ");
        return scanner.nextLine();
    }

    public static int getIntegerFromUser() {
        System.out.println("Please insert integer: ");
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input! Please insert integer.");
            }
        }
    }

    public static Double getDoubleFromUser() {
        System.out.println("Please insert double: ");
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input! Please insert double.");
            }
        }
    }
}