package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.dbloader.model.BikeModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.BikeService;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.CityService;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.CountryService;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.PlaceService;
import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CityStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CountryStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.PlaceStatisticsDao;
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
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@WebServlet("/bike-servlet/*")
@Transactional
public class BikeServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(BikeServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private CountryService countryService;
    @Inject
    private CityService cityService;
    @Inject
    private PlaceService placeService;
    @Inject
    private BikeService bikeService;

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

        if (req.getParameter("country") != null) {
            List<CityModel> cityModelList = cityService.getCitiesByCountry(req.getParameter("country"));
            List<PlaceModel> places = cityModelList.stream()
                    .map(cm -> cm.getPlaceList())
                    .flatMap(pl -> pl.stream())
                    .collect(toList());

            LOGGER.info("Showing map for " + places.size() + " places (by country)");

            createRootMap(writer, cityModelList, "cityRoot", places);

            countryStatisticsDao.addToStatistics(req.getParameter("country"));

        } else if (req.getParameter("city") != null) {
            List<PlaceModel> placeModelList = placeService.getPlaceByCity(req.getParameter("city"));

            LOGGER.info("Showing map for " + placeModelList.size() + " places (by place)");

            createRootMap(writer, placeModelList, "placeRoot", placeModelList);

            cityStatisticsDao.addToStatistics(req.getParameter("city"));

        } else if (req.getParameter("place") != null) {

            List<BikeModel> bikeModelList = bikeService.getAllBikesForPlace(req.getParameter("place"));
            createRootMap(writer, bikeModelList, "bikeRoot", Arrays.asList(placeService.getPlaceByName(req.getParameter("place"))));

            placeStatisticsDao.addToStatistics(req.getParameter("place"));
            LOGGER.info("Map of bikes has been generated.");
        } else {

            List<CountryModel> countryModelList = countryService.getAllList();

            List<PlaceModel> places = countryModelList.stream()
                    .flatMap(c -> c.getCityList().stream())
                    .flatMap(c -> c.getPlaceList().stream())
                    .collect(toList());

            LOGGER.info("Showing map for " + places.size() + " places (all)");

            createRootMap(writer, countryModelList, "countryRoot", places);
        }
    }

    private void createRootMap(PrintWriter writer, Object ListObject, String rootName, List<PlaceModel> places) {
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