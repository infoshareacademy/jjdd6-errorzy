package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.dbloader.model.PlaceModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.PlaceService;
import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.PlaceStatisticsDao;
import com.infoshareacademy.jjdd6.geoservice.ClosestStation;
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
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/closestPlace-servlet")
@Transactional
public class ClosestStationServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(ClosestStationServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private ClosestStation closestStation;
    @Inject
    private PlaceService placeService;
    @Inject
    private PlaceStatisticsDao placeStatisticsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("ClosestStations Servlet has been loaded.");
        resp.setContentType("text/html;charset=UTF-8");
        Writer writer = resp.getWriter();
        Template template = templateProvider.getTemplate(getServletContext(), "closest-station-servlet.ftlh");
        Map<String, Object> model = new HashMap<>();

        if ((req.getParameter("lat") != (null) && req.getParameter("lng") != (null))) {
            double lat;
            double lng;

            try {
                lat = Double.parseDouble(req.getParameter("lat"));
                lng = Double.parseDouble(req.getParameter("lng"));
            } catch (NumberFormatException e) {
                resp.getWriter().println("Wrong input! It should be double!");
                LOGGER.info("Wrong input inserted(Should be Double).");
                return;
            }

            String distanceUnit = req.getParameter("unit");

            Place closestPlace = closestStation.findTheClosestPlace(lat, lng);
            PlaceModel placeModel = placeService.getPlaceByName(closestPlace.getName());
            String cityName = placeModel.getCity().getName();

            placeStatisticsDao.addToStatistics(closestPlace.getName());

            double distance = closestStation.getDistanceBetweenTwoGeoPoints(lat, lng, closestPlace);

            if (distanceUnit.equals("meter")) {
                distance = distance * 1000.0;
            }

            model.put("place", placeModel);
            model.put("cityName", cityName);
            model.put("distanceToPlace", distance);
            model.put("distanceUnit", distanceUnit + "s");
            model.put("lateralValue", lat);
            model.put("longitudinalValue", lng);
        }

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            LOGGER.warn("Template not found: " + e);
        }
    }
}