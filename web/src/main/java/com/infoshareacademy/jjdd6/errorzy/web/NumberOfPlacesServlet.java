package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.errorzy.numberOfPlaces.NumberOfPlacesValidator;
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
    private NumberOfPlacesValidator statisticsValidator;
    @Inject
    private CitySearch citySearch;
    @Inject
    private CountrySearch countrySearch;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "number-of-places-servlet.ftlh");
        PrintWriter writer = resp.getWriter();

        String countryName = req.getParameter("country");
        String cityName = req.getParameter("city");
        boolean cityResult = statisticsValidator.checkIfCityExists(cityName);
        boolean countryResult = statisticsValidator.checkIfCountryExists(countryName);

        //Map<String, City> cityMap = citySearch.getMapOfCitiesForCountry(req.getParameter("country"));
        Map<String, Country> countryMap = countrySearch.getMapOfCountries();
        Map<String, Object> mapOfCountries = new HashMap<>();
        mapOfCountries.put("countryRoot", countryMap);

//        if (!(cityResult || countryResult)) {
//            throw new IllegalStateException("Sorry, there is no nextbike in this country or city");
//        } else if (cityName == null) {
//            resp.getWriter().println(Statistics.getStatisticsForCountry(countryName));
//
//        } else if (countryName == null) {
//            resp.getWriter().println(Statistics.getStatisticsForCities(cityName));
//
//        } else if (countryName == null && cityName == null) {
//            throw new IllegalStateException("Sorry, you must enter the name of the country or city");
//
//        }

        try {
            template.process(mapOfCountries, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}
