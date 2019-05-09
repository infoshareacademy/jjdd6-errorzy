package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
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
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/closestPlace-servlet")
public class ClosestStationServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(ClosestStationServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private ClosestStation closestStation;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Writer writer = resp.getWriter();
        Template template = templateProvider.getTemplate(getServletContext(), "neareststation.ftlh");
        Map<String, Object> model = new HashMap<>();

        if (!(req.getParameter("lat") == (null) && req.getParameter("lng") == (null))) {
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
            //
            double distance = closestStation.getDistanceBetweenTwoGeoPoints(lat, lng, closestPlace);

            if (distanceUnit.equals("meter")) {
                distance *= 1000.0;
            }

            model.put("place", closestPlace);
            model.put("distanceToPlace", distance);
            model.put("distanceUnit", distanceUnit + "s");
        }

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            LOGGER.warn("Template not found: " + e);
        }
    }
}
