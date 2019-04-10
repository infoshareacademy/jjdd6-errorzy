package com.infoshareacademy.jjdd6.errorzy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Statistics {
    private static final Logger LOGGER = LogManager.getLogger(Statistics.class.getName());

    public void countryStats(Country country) {
        LOGGER.info("Statistics for country: " + country.getCountryName() + " created.");
        System.out.println("There is: " + country.getCityList().size() + " bike stations in "+ country.getCountryName());
    }

    public void cityStats(City city) {
        LOGGER.info("Statistics for city: " + city.getName() + " created.");
        System.out.println("There is: " + city.getPlaceList().size() + " bike stations in "+ city.getName());
    }
}