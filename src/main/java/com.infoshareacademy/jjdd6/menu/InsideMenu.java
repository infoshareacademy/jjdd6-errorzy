package com.infoshareacademy.jjdd6.menu;

import java.util.Scanner;

public class InsideMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void getNumberOfOptions(String displayText) {
        System.out.println(displayText);
        while (true) {
            System.out.println("press 0");
            if (Integer.parseInt(scanner.nextLine()) == 0) {
                break;
            }
        }
    }
}