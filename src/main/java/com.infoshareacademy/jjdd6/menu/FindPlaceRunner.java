package com.infoshareacademy.jjdd6.menu;


import com.infoshareacademy.jjdd6.geoservice.ClosestStation;
import com.infoshareacademy.jjdd6.userinput.GetUserInput;

public class FindPlaceRunner {
    public static void run() {

        ClosestStation closestStation = new ClosestStation();
        GetUserInput.getStringFromUser("Please insert your localisation.");
        double latitude = GetUserInput.getDoubleFromUser("Insert your latitude: ");
        double longitude = GetUserInput.getDoubleFromUser("Insert your longitude");

        closestStation.findTheClosestPlace(latitude, longitude);

        InsideMenu.run();

    }
}
