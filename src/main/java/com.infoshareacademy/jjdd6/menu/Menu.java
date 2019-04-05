package com.infoshareacademy.jjdd6.menu;


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
        System.out.println("     Select number of options ");


        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }

    public static void main(String[] args) {

        int select = -1;
        while (select != 0) {
            select = StartAplicationMenu();
            switch (select) {
                case 1:
                    System.out.println("Find free Bike");
                    FindBikeRunner.run();
                    break;
                case 2:
                    System.out.println("Find the nearest place");
                    FindPlaceRunner.run();
                    break;
                case 3:
                    System.out.println("Show list of Countries");
                    ListOfCountriesRunner.run();
                    break;
                case 4:
                    System.out.println("Show list of Cities");
                    ListOfCitiesRunner.run();
                    break;
                case 5:
                    System.out.println("Show statistics for Countries or Cities");
                    // Tu bedzie jeszcze jednak klasa;
                    break;
                case 0:
                    System.out.println("Bye-bye!");
                    break;
                default:
                    System.out.println("Select number one more time");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}



