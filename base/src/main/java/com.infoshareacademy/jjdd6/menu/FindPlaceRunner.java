package com.infoshareacademy.jjdd6.menu;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.PlaceSearch;
import com.infoshareacademy.jjdd6.geoservice.ClosestStation;
import com.infoshareacademy.jjdd6.geoservice.StationsInMyArea;
import com.infoshareacademy.jjdd6.properties.ApplicationProperties;
import com.infoshareacademy.jjdd6.userinput.GetUserInput;

import java.io.IOException;
import java.util.List;

public class FindPlaceRunner {

    public static void run() {

        ApplicationProperties applicationProperties = new ApplicationProperties();
        try {
            applicationProperties.loadAppProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ClosestStation closestStation = new ClosestStation();
        StationsInMyArea stationsInMyArea = new StationsInMyArea();
        PlaceSearch placeSearch = new PlaceSearch();
        List<Place> placeList = placeSearch.getPlaces();

        double latitude = GetUserInput.getDoubleFromUser("Insert your latitude: ");
        double longitude = GetUserInput.getDoubleFromUser("Insert your longitude: ");


        Place closestPlace = closestStation.findTheClosestPlace(latitude, longitude);
        double distanceToClosestPlace = kilometersToMeters(applicationProperties,
                closestStation.getDistanceBetweenTwoGeoPoints(latitude, longitude, closestPlace));

        printChooseMenu();
        int select = GetUserInput.getIntegerFromUser("Choose an option: ");

        switch (select) {
            case 1:
                chooseFindClosestStation(applicationProperties, closestPlace, distanceToClosestPlace);
                break;
            case 2:
                chooseStationsInMyArea(stationsInMyArea, latitude, longitude, placeList);
                break;
            default:
                System.out.println("There is no such option.");
        }

        InsideMenu.run();
    }

    private static void chooseFindClosestStation(ApplicationProperties applicationProperties, Place closestPlace, double distance) {
        System.out.println(String.format("The closest bike stand is %s, you are %.3f %s from it.", closestPlace.getName(),
                distance, applicationProperties.getDistanceUnit()));
    }

    private static void chooseStationsInMyArea(StationsInMyArea stationsInMyArea, double latitude, double longitude, List<Place> placeList) {
        double distanceInKm = GetUserInput.getDoubleFromUser("You are interested in station in distance of (km): ");
        List<Place> listStationsInArea = stationsInMyArea.findStationsWithinRadius(latitude, longitude, distanceInKm, placeList);

        System.out.println("There are: " + listStationsInArea.size() +
                " stations in vicinity of " + distanceInKm + " km");

        listStationsInArea.stream()
                .map(p -> p.getName())
                .forEach(System.out::println);
    }

    private static double kilometersToMeters(ApplicationProperties applicationProperties, double distance) {
        if (applicationProperties.getDistanceUnit().equals("m")) {
            return distance = distance * 1000.0;
        }
        return distance;
    }

    private static void printChooseMenu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("               Choose an option");
        System.out.println("     ****************************************");
        System.out.println("     1. Find the nearest station");
        System.out.println("     2. Find the stations in certain distance from you");
        System.out.println();
    }
}