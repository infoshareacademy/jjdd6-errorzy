package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.dbloader.dao.PlaceDao;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.BikeModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.BikeService;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.CityService;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.CountryService;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.PlaceService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/bike-servlet2/*")
public class BikeServlet2 extends HttpServlet {

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

    @Inject
    private CountryService countryService;
    @Inject
    private CityService cityService;
    @Inject
    private PlaceService placeService;
    @Inject
    private BikeService bikeService;
    @Inject
    private PlaceDao placeDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Bike servlet loaded.");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        // TODO add list of places for country, single place, etc.

        if (!(req.getParameter("country") == null)) {
            LOGGER.warn("Country doesn't exist.");
            Map<String, City> cityMap = citySearch.getMapOfCitiesForCountry(req.getParameter("country"));
            List<CityModel> cityModelList = cityService.getCitiesByCountry(req.getParameter("country"));

            List<Place> cities = new ArrayList(cityMap.values());

            createRootMap(writer, cityModelList, "cityRoot", cities);

            countryStatisticsDao.addToStatistics(req.getParameter("country"));

        } else if (!(req.getParameter("city") == null)) {
            LOGGER.warn("City doesn't exist.");
            Map<String, Place> placeMap = placeSearch.getMapOfPlaces(req.getParameter("city"));
            List<PlaceModel> placeModelList = placeService.getPlaceByCity(req.getParameter("city"));
            List<Place> places = new ArrayList(placeMap.values());

            createRootMap(writer, placeModelList, "placeRoot", places);

            cityStatisticsDao.addToStatistics("city");
        } else if (!(req.getParameter("place") == null)) {

            placeStatisticsDao.addToStatistics("place");
            try {
//                Map<String, Bike> bikeMap = bikeSearch.getMapOfBikesForPlace(req.getParameter("place"));
                List<BikeModel> bikeModelList = bikeService.getAllBikesForPlace(req.getParameter("place"));

                Map<String, Country> countryMap = countrySearch.getMapOfCountries();
                List<Place> places = countryMap.values().stream()
                        .filter(country -> country.getCityList() != null)
                        .flatMap(country -> country.getCityList().stream())
                        .filter(city -> city.getPlaceList() != null)
                        .flatMap(city -> city.getPlaceList().stream())
                        .filter(place -> place.getName() != null && req.getParameter("place").equals(place.getName()))
                        .collect(Collectors.toList());

                createRootMap(writer, bikeModelList, "bikeRoot", places);
                LOGGER.info("Map of bikes has been generated.");
            } catch (Exception e) {
                LOGGER.warn("Exception caught when loading bikes");
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

        } else {


            Map<String, Country> countryMap = countrySearch.getMapOfCountries();

            List<Place> places = countryMap.values().stream()
                    .filter(country -> country.getCityList() != null)
                    .flatMap(country -> country.getCityList().stream())
                    .filter(city -> city.getPlaceList() != null)
                    .flatMap(city -> city.getPlaceList().stream())
                    .collect(Collectors.toList());

            List<Object> countryModelList = countryService.getAllList();

            createRootMap(writer, countryModelList, "countryRoot", places);

        }
    }

    private void createRootMap(PrintWriter writer, Object ListObject, String rootName, List<Place> places) {
        Map<String, Object> mapForFreemarker = new HashMap<>();
        mapForFreemarker.put(rootName, ListObject);
        mapForFreemarker.put("places", places);
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