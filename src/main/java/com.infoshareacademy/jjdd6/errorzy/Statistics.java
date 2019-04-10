package com.infoshareacademy.jjdd6.errorzy;

public class Statistics {

    public void countryStats(Country country) {
        System.out.println("There is: " + country.getCityList().size() + " bike stations in " + country.getCountryName());
    }
    public void cityStats(City city) {
        System.out.println("There is: " + city.getPlaceList().size() + " bike stations in " + city.getName());
    }
}
