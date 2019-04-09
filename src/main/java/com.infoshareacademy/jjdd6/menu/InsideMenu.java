package com.infoshareacademy.jjdd6.menu;

import java.util.Scanner;

public class InsideMenu {
    public static void run() {

        Scanner scanner = new Scanner(System.in);
        int number = 1;

        while (true) {
            System.out.println("To return to the main menu press 0");
            try {
                number = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("This is not a number!");
            }
            if (number == 0) {
                break;

            }
        }
    }
}

