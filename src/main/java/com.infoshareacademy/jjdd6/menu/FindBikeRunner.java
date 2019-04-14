package com.infoshareacademy.jjdd6.menu;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CitySearch;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.PlaceSearch;
import com.infoshareacademy.jjdd6.userinput.GetUserInput;

import javax.xml.bind.JAXBException;
import java.util.Map;

public class FindBikeRunner {
    private CitySearch citySearch = new CitySearch();
    private CountrySearch countrySearch = new CountrySearch();
    private PlaceSearch placeSearch = new PlaceSearch();

    public void run() {

        try {

            Map<String, Country> countryMap = countrySearch.getMapOfCountries();
            countryMap.keySet().forEach(System.out::println);
            System.out.println();
            String chosenCountry = GetUserInput.getStringFromUser("Choose a country: ");
            printCitiesForCountry(countryMap, chosenCountry);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        InsideMenu.run();

    }

    private void printCitiesForCountry(Map<String, Country> countryMap, String chosenCountry) throws JAXBException {
        if (countryMap.containsKey(chosenCountry)) {
            Map<String, City> cityMap = citySearch.getMapOfCitiesForCountry(chosenCountry);
            cityMap.keySet().forEach(System.out::println);
            System.out.println();

            String chosenCity = GetUserInput.getStringFromUser("Choose a city: ");

            printPlacesForCity(chosenCountry, cityMap, chosenCity);

        } else {
            System.out.println("There is no such country on the list.");
        }
    }

    private void printPlacesForCity(String chosenCountry, Map<String, City> cityMap, String chosenCity) throws JAXBException {
        if (cityMap.containsKey(chosenCity)) {
            Map<String, Place> placeMap = placeSearch.getMapOfPlaces(chosenCity);
            for (Place place : placeMap.values()) {
                System.out.println(place.getName() + " -----> Available bikes: " + place.getBikes());
            }
            System.out.println();

            String chosenPlace = GetUserInput.getStringFromUser("Choose a place: ");
            printBikesForPlace(placeMap, chosenPlace);
        } else {
            System.out.println("There is no such city in " + chosenCountry + ".");
        }
    }

    private void printBikesForPlace(Map<String, Place> placeMap, String chosenPlace) {
        if (placeMap.containsKey(chosenPlace)) {
            if (placeMap.get(chosenPlace).getBikes() == 0) {
                System.out.println("There are no bikes here.");
            } else {
                System.out.println("Number of available bikes: " + placeMap.get(chosenPlace).getBikes());

                System.out.println(placeMap.get(chosenPlace).getBikeNumbers());
            }
        } else {
            System.out.println("There is no such place.");
        }
    }

}