package com.infoshareacademy.jjdd6.menu;
import com.infoshareacademy.jjdd6.listOfPlaces.CityPrinter;
import com.infoshareacademy.jjdd6.listOfPlaces.CountryPrinter;
import com.infoshareacademy.jjdd6.errorzy.statistics.Statistics;
import com.infoshareacademy.jjdd6.userinput.GetUserInput;
import javax.xml.bind.JAXBException;


public class ShowStatisticsRunner {
    public static void run() throws JAXBException {
        Statistics statistics = new Statistics();
        CountryPrinter listOfCountries = new CountryPrinter();
        CityPrinter listOfCities = new CityPrinter();
        String countryName;
        String cityName;

        statisticsMenu();

        int select = GetUserInput.getIntegerFromUser("Choose an option: ");
        switch (select) {
            case 1:
                System.out.println("List of available Country");
                listOfCountries.printCountryList();
                countryName = GetUserInput.getStringFromUser("Insert your Country name from list");
                int countryResult = statistics.getStatisticsForCountry(countryName);
                System.out.println(countryResult);
                break;
            case 2:
                System.out.println("Show Statistics for Cities");
                listOfCities.printCityList();
                cityName = GetUserInput.getStringFromUser("Insert your City name from list");
                int cityResult = statistics.statisticsForCities(cityName);
                System.out.println(cityResult);
                break;
            default:
                System.out.println("Sorry bad input try again");
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

