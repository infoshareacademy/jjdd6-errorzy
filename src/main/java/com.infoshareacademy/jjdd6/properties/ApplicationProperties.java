package com.infoshareacademy.jjdd6.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {
    private Properties properties = new Properties();

    public void loadAppProperties() throws IOException {
        properties.load(new FileInputStream("src/data/dataConfig.properties"));
    }

    public void getProperties() {

        properties.list(System.out);
//        Map<String, String> configMap = new HashMap<>();
//        properties.getProperty("version");
//        properties.getProperty("name", "Errzorzy_App");
//        properties.getProperty("group");

    }
}
