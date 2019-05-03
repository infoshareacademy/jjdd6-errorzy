package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.geoservice.ClosestStation;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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

    @Inject
    TemplateProvider templateProvider;
    @Inject
    ClosestStation closestStation;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        Template template = templateProvider.getTemplate(getServletContext(), "closest-station-servlet.ftlh");
        Map<String, Object> model = new HashMap<>();

        if (!(req.getParameter("lat") == (null) && req.getParameter("lng") == (null))) {
            try {
                Double.parseDouble(req.getParameter("lat"));
                Double.parseDouble(req.getParameter("lng"));
            } catch (NumberFormatException e) {
                resp.getWriter().println("Wrong input! It should be double!");
                return;
            }

            double lat = Double.parseDouble(req.getParameter("lat"));
            double lng = Double.parseDouble(req.getParameter("lng"));
            String distanceUnit = req.getParameter("unit");

            Place closestPlace = closestStation.findTheClosestPlace(lat, lng);
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
            e.printStackTrace();
        }
    }
}