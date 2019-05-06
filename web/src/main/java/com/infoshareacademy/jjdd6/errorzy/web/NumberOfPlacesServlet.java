package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.errorzy.numberOfPlaces.Statistics;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CitySearch;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/number-of-places")
public class NumberOfPlacesServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(NumberOfPlacesServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private CitySearch citySearch;
    @Inject
    private CountrySearch countrySearch;
    @Inject
    private Statistics statistics;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = resp.getWriter();

        Map<String, Object> mapForFreemarker = new HashMap<>();

        if (!(req.getParameter("country") == null)) {

            Map<String, City> cityMap = citySearch.getMapOfCitiesForCountry(req.getParameter("country"));
            Integer numberOfCountries = statistics.getStatisticsForCountry(req.getParameter("country"));
            mapForFreemarker.put("numberOfCountries", numberOfCountries);
            mapForFreemarker.put("cityRoot", cityMap);
            createRootMap(writer, mapForFreemarker);
        } else if (!(req.getParameter("city") == null)) {

            Integer numberOfCities = statistics.getStatisticsForCities(req.getParameter("city"));
            mapForFreemarker.put("numberOfCities", numberOfCities);
            createRootMap(writer, mapForFreemarker);

        } else {

            Map<String, Country> countryMap = countrySearch.getMapOfCountries();
            mapForFreemarker.put("countryRoot", countryMap);
            createRootMap(writer, mapForFreemarker);
        }
    }

    private void createRootMap(PrintWriter writer, Map<String, Object> mapForFreemarker) {
        try {
            processTemplate(writer, mapForFreemarker);
        } catch (IOException e) {
            LOGGER.warn("Map Not Found :" + e);
        }
    }

    private void processTemplate(PrintWriter writer, Map<String, Object> templateMap) throws IOException {
        try {
            Template template = templateProvider.getTemplate(getServletContext(), "number-of-places-servlet.ftlh");
            template.process(templateMap, writer);
        } catch (TemplateException e) {
            LOGGER.warn("Template Not Found :" + e);
        }
    }
}





