package com.infoshareacademy.jjdd6.errorzy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Statistics {
    Logger logger = LogManager.getLogger(Statistics.class.getName());




    public void countryStats(Integer bikeStations, String country) {
        logger.info("Statistics for country: " + country + " created.");
        System.out.println("There is: " + bikeStations + " bike stations in "+country);
    }

    public void cityStats(Integer bikeStations, String city) {
        logger.info("Statistics for city: " + city + " created.");
        System.out.println("There is: " + bikeStations + " bike stations in "+city);

    }
}