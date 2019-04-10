package com.infoshareacademy.jjdd6.menu;


import com.infoshareacademy.jjdd6.listOfPlaces.ListOfCities;

public class ListOfCountriesRunner {
    public static void run() {


        ListOfCities listOfCities = new ListOfCities();
        listOfCities.getMockedCities();
        System.out.println();

        InsideMenu.run();


    }
}
