package com.infoshareacademy.jjdd6.properties;

import java.io.IOException;

public class PropMain {
    public static void main(String[] args) {
        ApplicationProperties applicationProperties = new ApplicationProperties();
        try {
            applicationProperties.loadAppProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        applicationProperties.getProperties();

    }
}
