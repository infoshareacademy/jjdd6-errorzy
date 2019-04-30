package com.infoshareacademy.jjdd6.errorzy.numberOfPlaces;


public class NumberOfPlacesValidator {
    public static boolean checkIfCityExists(String city) {
        if ((Statistics.getStatisticsForCities(city) == 0)) {
        }
        return false;
    }

    public static boolean checkIfCountryExists(String country) {
        if ((Statistics.getStatisticsForCountry(country) == 0)) {
        }
        return false;
    }
}

