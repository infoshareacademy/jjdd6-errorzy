package com.infoshareacademy.jjdd6.errorzy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Statistics {
    private static final Logger LOGGER = LogManager.getLogger(Statistics.class.getName());

    public void countryStats(Integer bikeStations, String country) {
        LOGGER.info("Statistics for country: " + country + " created.");
        System.out.println("There is: " + bikeStations + " bike stations in "+country);
    }

    public void cityStats(Integer bikeStations, String city) {
        LOGGER.info("Statistics for city: " + city + " created.");
        System.out.println("There is: " + bikeStations + " bike stations in "+city);
    }
}