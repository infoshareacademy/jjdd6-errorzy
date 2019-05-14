package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.Bike;
import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CityStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CountryStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.PlaceStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.BikeSearch;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CitySearch;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.PlaceSearch;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/bike-servlet/*")
public class BikeServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(BikeServlet.class.getName());

    @Inject
    private CountrySearch countrySearch;

    @Inject
    private CitySearch citySearch;

    @Inject
    private PlaceSearch placeSearch;

    @Inject
    private BikeSearch bikeSearch;

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private CityStatisticsDao cityStatisticsDao;
    @Inject
    private CountryStatisticsDao countryStatisticsDao;
    @Inject
    private PlaceStatisticsDao placeStatisticsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Bike servlet loaded.");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        if (!(req.getParameter("country") == null)) {
            LOGGER.warn("Country doesn't exist.");
            Map<String, City> cityMap = citySearch.getMapOfCitiesForCountry(req.getParameter("country"));
            createRootMap(writer, cityMap, "cityRoot");

            countryStatisticsDao.addToStatistics(req.getParameter("country"));
        } else if (!(req.getParameter("city") == null)) {
            LOGGER.warn("City doesn't exist.");
            Map<String, Place> placeMap = placeSearch.getMapOfPlaces(req.getParameter("city"));
            createRootMap(writer, placeMap, "placeRoot");

            cityStatisticsDao.addToStatistics("city");
        } else if (!(req.getParameter("place") == null)) {

            LOGGER.warn("Place doesn't exist.");
            Map<String, Bike> bikeMap;

            placeStatisticsDao.addToStatistics("place");
            try {
                bikeMap = bikeSearch.getMapOfBikesForPlace(req.getParameter("place"));
                createRootMap(writer, bikeMap, "bikeRoot");
                LOGGER.info("Map of bikes has been generated.");
            } catch (Exception e) {
                LOGGER.warn("Exception caught when loading bikes");
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

        } else {

            Map<String, Country> countryMap = countrySearch.getMapOfCountries();
            createRootMap(writer, countryMap, "countryRoot");
        }
    }

    private void createRootMap(PrintWriter writer, Object mapWithBikeData, String rootName) {
        Map<String, Object> mapForFreemarker = new HashMap<>();
        mapForFreemarker.put(rootName, mapWithBikeData);
        try {
            processTemplate(writer, mapForFreemarker);
        } catch (IOException e) {
            LOGGER.warn("None map found :" + e);
        }
    }

    private void processTemplate(PrintWriter writer, Map<String, Object> templateMap) throws IOException {
        try {
            Template template = templateProvider.getTemplate(getServletContext(), "bike-servlet.ftlh");
            template.process(templateMap, writer);
        } catch (TemplateException e) {
            LOGGER.warn("Template Not Found :" + e);
        }
    }
}