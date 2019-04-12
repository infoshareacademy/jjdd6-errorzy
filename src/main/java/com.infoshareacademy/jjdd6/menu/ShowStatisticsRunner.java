package com.infoshareacademy.jjdd6.menu;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.Statistics;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.FindCity;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.FindCountry;
import com.infoshareacademy.jjdd6.listOfPlaces.ListOfCountries;
import com.infoshareacademy.jjdd6.userinput.GetUserInput;

import javax.xml.bind.JAXBException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class ShowStatisticsRunner {
    public static void run() throws JAXBException {
        FindCountry findCountry = new FindCountry();
        Statistics statistics = new Statistics();

        FindCity findCity = new FindCity();
        String countryName;
        String cityName;

        statisticsMenu();

        int select = GetUserInput.getIntegerFromUser("Choose an option: ");
        switch (select) {
            case 1:
                System.out.println("List of available Country");
                countryName = GetUserInput.getStringFromUser("Insert your Country name from list");
               listOfCountry(countryName);

//Country country = countries.stream().distinct();
//statistics.countryStats(country);
                break;
            case 2:
                System.out.println("Show Statistics for Cities");
                listOfCities();
                cityName = GetUserInput.getStringFromUser("Insert your City name from list");
                break;
            default:
                System.out.println("Select number one more time");

        }

        InsideMenu.run();

    }

    private static List<Country> listOfCountry(String countryNm) throws JAXBException {
        FindCountry findCountry = new FindCountry();
        AtomicInteger index = new AtomicInteger();
        List<Country> countries = findCountry.getCountries();
        List<City> cities = countries.stream().filter(x->x.getCountryName().equals(countryNm)).flatMap(c -> c.getCityList().stream()).collect(Collectors.toList());
        List<Place> places = cities.stream().flatMap(c -> c.getPlaceList().stream()).collect(Collectors.toList());

        cities.stream().map(c -> c.getName()).forEach(System.out::println);
        Map<String, Integer> countriesMap = new HashMap<>();

        for(Country country: countries){
            if(!countriesMap.containsKey(country.getCountryName())){
                countriesMap.put(country.getCountryName(), 0);
            }

            countriesMap.put(country.getCountryName(), 1+countriesMap.get(country.getCountryName()));
        }





//                map(m -> m.getCountryName()).distinct().sorted().forEach(n -> System.out.println(index.incrementAndGet() + ". " + n));
    return countries;
    }

    private static void listOfCities() throws JAXBException {
        FindCity findCity = new FindCity();
        AtomicInteger index = new AtomicInteger();
        findCity.getCities().stream().map(m -> m.getName()).distinct().sorted().forEach(n -> System.out.println(index.incrementAndGet() + ". " + n));
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

