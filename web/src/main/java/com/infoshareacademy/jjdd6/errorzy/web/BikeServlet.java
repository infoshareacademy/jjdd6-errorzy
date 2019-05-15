package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.errorzy.model.BikeModel;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.service.BikeService;
import com.infoshareacademy.jjdd6.errorzy.service.CityService;
import com.infoshareacademy.jjdd6.errorzy.service.CountryService;
import com.infoshareacademy.jjdd6.errorzy.service.PlaceService;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/bike-servlet/*")
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
            createRootMap(writer, cityModelList, "cityRoot");

            countryStatisticsDao.addToStatistics(req.getParameter("country"));

        } else if (req.getParameter("city") != null) {
            List<PlaceModel> placeModelList = placeService.getPlaceByCity(req.getParameter("city"));
            createRootMap(writer, placeModelList, "placeRoot");

            cityStatisticsDao.addToStatistics("city");

        } else if (req.getParameter("place") != null) {

            List<BikeModel> bikeModelList = bikeService.getAllBikesForPlace(req.getParameter("place"));
            createRootMap(writer, bikeModelList, "bikeRoot");

            placeStatisticsDao.addToStatistics("place");
            LOGGER.info("Map of bikes has been generated.");
        } else {

            List<Object> countryModelList = countryService.getAllList();
            createRootMap(writer, countryModelList, "countryRoot");
        }
    }

    private void createRootMap(PrintWriter writer, Object ListObject, String rootName) {
        Map<String, Object> mapForFreemarker = new HashMap<>();
        mapForFreemarker.put(rootName, ListObject);
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