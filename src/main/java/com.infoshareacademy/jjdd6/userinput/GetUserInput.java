package com.infoshareacademy.jjdd6.userinput;

import java.util.Scanner;

public class GetUserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getStringFromUser(String displayText) {
        System.out.println(displayText);
        return scanner.nextLine();
    }

    public static int getIntegerFromUser(String displayText) {
        System.out.println(displayText);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input! Please insert again.");
            }
        }
    }

    public static Double getDoubleFromUser(String displayText) {
        System.out.println(displayText);
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input! Please insert again.");
            }
        }
    }
}