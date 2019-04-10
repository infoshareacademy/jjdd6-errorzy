package com.infoshareacademy.jjdd6.menu;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.geoservice.ClosestStation;
import com.infoshareacademy.jjdd6.geoservice.StationsInMyArea;
import com.infoshareacademy.jjdd6.userinput.GetUserInput;

import java.util.List;

public class FindPlaceRunner {
    public static void run() {

        ClosestStation closestStation = new ClosestStation();
        StationsInMyArea stationsInMyArea = new StationsInMyArea();
        double latitude = GetUserInput.getDoubleFromUser("Insert your latitude: ");
        double longitude = GetUserInput.getDoubleFromUser("Insert your longitude");

        printChooseMenu();
        int select = GetUserInput.getIntegerFromUser("Choose an option: ");

        switch (select) {

            case 1:
                Place closestPlace = closestStation.findTheClosestPlace(latitude, longitude);

                System.out.println(closestPlace.getName() + " is "
                        + closestStation.getDistanceBetweenTwoGeoPoints(latitude, longitude, closestPlace) + " from you.");
            case 2:
                double distanceInKm = GetUserInput.getDoubleFromUser("You are interested in station in distance of: ");
                List<Place> listStationsInArea = stationsInMyArea.findStationsWithinRadius(latitude, longitude, distanceInKm);

                System.out.println("There are: " + stationsInMyArea.getNumberOfStationsWithinRadius(listStationsInArea) +
                        " stations in vicinity of " + distanceInKm);
                listStationsInArea.stream()
                        .map(p -> p.getName())
                        .forEach(System.out::println);
        }
        InsideMenu.run();
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