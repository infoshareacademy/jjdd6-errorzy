package com.infoshareacademy.jjdd6.menu;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsideMenu {
    private static final Logger LOGGER = LogManager.getLogger(InsideMenu.class.getName());

    public static void run() {
        LOGGER.info("Inside menu has been runned.");
        Scanner scanner = new Scanner(System.in);
        int number = 1;

        while (true) {
            System.out.println("To return to the main menu press 0");
            try {
                number = Integer.parseInt(scanner.nextLine());
                LOGGER.info("User took number: " + number +".");
            } catch (NumberFormatException e) {
                System.err.println("This is not a number!");
                LOGGER.warn("User took invalid number.");
            }
            if (number == 0) {
                break;
            }
        }
    }
}

