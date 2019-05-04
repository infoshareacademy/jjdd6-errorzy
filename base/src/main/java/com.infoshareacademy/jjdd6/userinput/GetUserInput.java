package com.infoshareacademy.jjdd6.userinput;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class GetUserInput {
    private static final Logger LOGGER = LogManager.getLogger(GetUserInput.class.getName());
    private static Scanner scanner = new Scanner(System.in);

    public static String getStringFromUser(String displayText) {
        System.out.println(displayText);
        return scanner.nextLine();
    }

    public static int getIntegerFromUser(String displayText) {
        System.out.println(displayText);
        while (true) {
            try {
                LOGGER.info("User picked option number: " + displayText + ".");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input! Please insert again.");
                LOGGER.warn("User gave wrong input, waiting for the good value.");
            }
        }
    }

    public static Double getDoubleFromUser(String displayText) {
        System.out.println(displayText);
        while (true) {
            try {
                LOGGER.info("User picked option number: " + displayText + ".");
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input! Please insert again.");
                LOGGER.warn("User gave wrong input, waiting for the good value.");
            }
        }
    }
}