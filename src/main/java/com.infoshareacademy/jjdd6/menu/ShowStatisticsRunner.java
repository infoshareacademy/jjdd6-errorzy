package com.infoshareacademy.jjdd6.menu;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.Statistics;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.FindCountry;
import com.infoshareacademy.jjdd6.userinput.GetUserInput;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ShowStatisticsRunner {
    public static void run() throws JAXBException {

        statisticsMenu();


        Statistics statistics = new Statistics();
        FindCountry findCountry = new FindCountry();
        findCountry.getCountries().stream().map(country -> country.getCityList()).distinct().collect(Collectors.toList());

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        int select = GetUserInput.getIntegerFromUser("Choose an option: ");
        switch (select) {
            case 1:
                System.out.println("Show Statistics for Country");


                break;
            case 2:
                System.out.println("Show Statistics for Cities");

                break;


        }

        InsideMenu.run();
    }


    private static void statisticsMenu() {

        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *            Statistics Menu           *");
        System.out.println("     ****************************************");
        System.out.println("     1. Show Statistics for Country");
        System.out.println("     2. Show Statistics for Cities");
        System.out.println();
        System.out.println();
        System.out.println("     To start available options select number ");
        System.out.println("     To exit press 0 ");
        System.out.println("     Select number ");
        System.out.println();
    }
}

