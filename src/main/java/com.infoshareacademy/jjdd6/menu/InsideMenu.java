package com.infoshareacademy.jjdd6.menu;

import java.util.Scanner;

public class InsideMenu {
    public static void run() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("To return to the main menu press 0");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                System.err.println("This is not a number!");
            }
            if (Integer.parseInt(scanner.nextLine()) == 0) {
                break;

            }
        }
    }
}

