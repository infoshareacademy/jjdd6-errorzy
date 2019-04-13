package com.infoshareacademy.jjdd6.menu;

import com.infoshareacademy.jjdd6.listOfPlaces.ListOfCities;
import com.infoshareacademy.jjdd6.listOfPlaces.ListOfCountries;
import com.infoshareacademy.jjdd6.errorzy.statistics.Statistics;
import com.infoshareacademy.jjdd6.userinput.GetUserInput;

import javax.xml.bind.JAXBException;


public class ShowStatisticsRunner {
    public static void run() throws JAXBException {
        Statistics statistics = new Statistics();
        ListOfCountries listOfCountries = new ListOfCountries();
        ListOfCities listOfCities = new ListOfCities();

        String countryName;
        String cityName;

        statisticsMenu();

        int select = GetUserInput.getIntegerFromUser("Choose an option: ");
        switch (select) {
            case 1:
                System.out.println("List of available Country");
                listOfCountries.run();
                countryName = GetUserInput.getStringFromUser("Insert your Country name from list");
                statistics.statisticsForCountry(countryName);


                break;
            case 2:
                System.out.println("Show Statistics for Cities");
                listOfCities.run();
                cityName = GetUserInput.getStringFromUser("Insert your City name from list");
                statistics.statisticsForCities(cityName);
                break;
            default:
                System.out.println("Sory bad input try again");

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

