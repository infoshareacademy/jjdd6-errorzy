package com.infoshareacademy.jjdd6.errorzy.upload;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@RequestScoped
public class FileUploadProcessorBean {

    private static final String SETTINGS_FILE = "settings.properties";

    private static final Logger LOGGER = LogManager.getLogger(FileUploadProcessorBean.class.getName());

    public File uploadFile(Part filePart) throws IOException {
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        File file = new File(getUploadFilesPath() + fileName);

        Files.deleteIfExists(file.toPath());

        InputStream fileContent = filePart.getInputStream();

        Files.copy(fileContent, file.toPath());

        fileContent.close();

        LOGGER.info("File has been saved  " + file.toPath() + " and size file is " + file.length());

        return file;
    }

    public String getUploadFilesPath() throws IOException {
        Properties settings = new Properties();
        settings.load(Thread.currentThread()
                .getContextClassLoader().getResource(SETTINGS_FILE).openStream());
        LOGGER.info("Loaded files with settings " + SETTINGS_FILE);
        return settings.getProperty("Upload.Path");
    }
}
