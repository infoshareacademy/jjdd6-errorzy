package com.infoshareacademy.jjdd6.menu;

import com.infoshareacademy.jjdd6.listOfPlaces.ListOfCities;

import javax.xml.bind.JAXBException;


public class ListOfCitiesRunner {
    public static void run() throws JAXBException {

        ListOfCities listOfCities = new ListOfCities();
        listOfCities.run();
        InsideMenu.run();

    }
}
