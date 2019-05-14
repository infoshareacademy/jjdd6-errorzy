package com.infoshareacademy.jjdd6.errorzy.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Properties;

public class NextBikeAPI {
    private static final Logger LOG = LogManager.getLogger(NextBikeAPI.class);
    private final static String FILE_URL = "https://nextbike.net/maps/nextbike-official.xml";
    private final static String FILE_NAME = "NextBike.xml";
    private static final String SETTINGS_FILE = "settings.properties";

    public void loadXMLFromURL() {
        try {
            URL url = new URL(FILE_URL);
            InputStream stream = url.openStream();

            File file = new File(getUploadFilesPath() + FILE_NAME);
            Files.deleteIfExists(file.toPath());

            Files.copy(stream, file.toPath());
            stream.close();

            LOG.info("File has been saved  " + file.toPath() + " and size file is " + file.length());

        } catch (IOException e) {
            LOG.warn("Problem with loading NextBike XML file from URL: " + e);
        }
    }

    private String getUploadFilesPath() throws IOException {
        Properties settings = new Properties();
        settings.load(Objects.requireNonNull(Thread.currentThread()
                .getContextClassLoader().getResource(SETTINGS_FILE)).openStream());
        return settings.getProperty("Upload.Path");
    }

}
