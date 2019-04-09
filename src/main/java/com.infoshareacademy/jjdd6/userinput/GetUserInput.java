package com.infoshareacademy.jjdd6.userinput;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetUserInput {
    static Logger logger = LogManager.getLogger(GetUserInput.class.getName());

    private static Scanner scanner = new Scanner(System.in);

    public static String getStringFromUser(String displayText) {
        System.out.println(displayText);
        return scanner.nextLine();
    }

    public static int getIntegerFromUser(String displayText) {
        System.out.println(displayText);
        while (true) {
            try {
                logger.info("User picked option number: "+ displayText);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input! Please insert again.");
                logger.warn("User gave wrong input, waiting for the good value.");
            }
        }
    }

    public static Double getDoubleFromUser(String displayText) {
        System.out.println(displayText);
        while (true) {
            try {
                logger.info("User picked option number: " + displayText);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input! Please insert again.");
                logger.warn("User gave wrong input, waiting for the good value.");
            }
        }
    }
}