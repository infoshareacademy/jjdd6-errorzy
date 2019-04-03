package com.infoshareacademy.jjdd6.errorzy;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    //public static void main(String[] args) {


    public static int StartAplicationMenu() {
        System.out.println();
        System.out.println();
        System.out.println("                                          $\"   *.      \n" +
                "              d$$$$$$$P\"                  $    J\n" +
                "                  ^$.                     4r  \"\n" +
                "                  d\"b                    .db\n" +
                "                 P   $                  e\" $\n" +
                "        ..ec.. .\"     *.              zP   $.zec..\n" +
                "    .^        3*b.     *.           .P\" .@\"4F      \"4\n" +
                "  .\" *       d\"  ^b.    *c        .$\"  d\" * $      *  %\n" +
                " /     *    P      $.    \"c      d\"   @    * r    *    3\n" +
                "4        .eE........$r===e$$$$eeP    J       *.. *      b\n" +
                "$       $$$$$       $   4$$$$$$$     F       d$$$.      4\n" +
                "$ * * * $$$$$ * * * $   4$$$$$$$     L * * * *$$$\"* * * 4\n" +
                "4         \"      \"\"3P ===$$$$$$\"     3         \"        P\n" +
                " *      *   *      $       \"\"\"        b      *   *     J\n" +
                "  \".  *       *  .P                    %. *        *  @\n" +
                "    %.         z*\"                      ^%.        .r\"\n" +
                "       \"*==*\"\"                             ^\"*==*\"\"   ");
        System.out.println();
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Find free Bike");
        System.out.println("     2. Find the nearest place");
        System.out.println("     3. Show list of Countries");
        System.out.println("     4. Show list of Cities");
        System.out.println("     5. Show statistics for Countries or Cities");
        System.out.println();
        System.out.println("     To start available options select number ");
        System.out.println("     To exit press 0 ");



        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int select = StartAplicationMenu();

        while (select !=0){
            switch (select){
                case 1: Bike bike = new Bike();
                break;
                case 2: Place place = new Place();
                break;
                case 3: Country country = new Country();
                break;
                case 4: City cities = new City();
                break;
                case 5:
                    break;
            }
        }

    }

}
