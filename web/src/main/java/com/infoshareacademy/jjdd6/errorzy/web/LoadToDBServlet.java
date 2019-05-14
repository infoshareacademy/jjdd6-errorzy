package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.api.NextBikeAPI;
import com.infoshareacademy.jjdd6.errorzy.service.CountryXmlToDBLoader;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/loadToDB")
public class LoadToDBServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LoadToDBServlet.class.getName());

    @Inject
    private CountryXmlToDBLoader countryXmlToDBLoader;
    @Inject
    private NextBikeAPI nextBikeAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Loading to DB started.");

//        countryXmlToDBLoader.loadCountryModelAtStart();
    }
}
