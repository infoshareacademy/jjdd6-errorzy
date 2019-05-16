package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.api.NextBikeAPI;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.dbloaders.CountryXmlToDBLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/db-load")
public class DbLoaderServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(DbLoaderServlet.class.getName());

    @Inject
    private CountryXmlToDBLoader countryXmlToDBLoader;
    @Inject
    private NextBikeAPI nextBikeAPI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info(DbLoaderServlet.class.getName() + " called.");
        nextBikeAPI.loadXMLFromURL();

        Runnable task = () -> countryXmlToDBLoader.loadCountryModelAtStart();
        new Thread(task).start();
    }
}
