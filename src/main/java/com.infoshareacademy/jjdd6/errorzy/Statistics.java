package com.infoshareacademy.jjdd6.errorzy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Statistics {

    Logger logger = LogManager.getRootLogger();






    public static void countryStats(Integer bikeStations, String country) {
        System.out.println("There is: " + bikeStations + " bike stations in "+country);
    }

    public static void cityStats(Integer bikeStations, String city) {
        System.out.println("There is: " + bikeStations + " bike stations in "+city);

    }
}