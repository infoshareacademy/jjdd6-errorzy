package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.PlaceStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.model.CountryStatistics;
import com.infoshareacademy.jjdd6.errorzy.statistics.model.PlaceStatistics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/place-statistics")
public class PlaceStatisticsServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(PlaceStatisticsServlet.class.getName());

    @Inject
    PlaceStatisticsDao placeStatisticsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String action = req.getParameter("action");
        LOGGER.info("Requested action: {}", action);
        if (action == null || action.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }

        if (action.equals("delete")) {
            deletePlaceStatiscics(req, resp);
        } else if (action.equals("findByName")) {
            findByNamePlaceStatiscics(req, resp);
        } else if (action.equals("findAll")) {
            findAllPlaceStatistics(req, resp);
        } else if (action.equals("findMostChecked")) {
            findMostPlaceCountryStatiscics(req, resp);
        } else {
            resp.getWriter().write("Unknown action.");
        }

    }
    private void deletePlaceStatiscics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String place = new String(req.getParameter("place"));
        LOGGER.info("Removing statistics for = {}", place);

        placeStatisticsDao.delete(place);

        findAllPlaceStatistics(req, resp);
    }
    private void findAllPlaceStatistics(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        final List<PlaceStatistics> result = placeStatisticsDao.findAll();
        LOGGER.info("Found {} objects", result.size());
        for (PlaceStatistics p : result) {
            resp.getWriter().write(p.toString() + "\n");

        }
    }

    private void findMostPlaceCountryStatiscics(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void findByNamePlaceStatiscics(HttpServletRequest req, HttpServletResponse resp) {
    }



}
