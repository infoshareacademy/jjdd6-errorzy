package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.numberOfPlaces.Statistics;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CityStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CountryStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.PlaceStatisticsDao;
import freemarker.template.Template;
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

@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(StatisticsServlet.class.getName());

    @Inject
    CountryStatisticsDao countryStatisticsDao;

    @Inject
    CityStatisticsDao cityStatisticsDao;

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

        if (action.equals("update")) {
            updateStatiscics(req, resp);
        } else if (action.equals("save")) {
            saveStatiscics(req, resp);
        } else if (action.equals("delete")) {
            deleteStatiscics(req, resp);
        } else if (action.equals("findByName")) {
            findByNameStatiscics(req, resp);
        } else if (action.equals("findMostChecked")) {
            findMostCheckedStatiscics(req, resp);
        } else if (action.equals("addToStatistics")) {
            addToStatisticStatiscics(req, resp);
        } else {
            resp.getWriter().write("Unkown action.");
        }


    }

    private void addToStatisticStatiscics(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void findMostCheckedStatiscics(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void findByNameStatiscics(HttpServletRequest req, HttpServletResponse resp) {
    }


    private void deleteStatiscics(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void saveStatiscics(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void updateStatiscics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String name = new String(req.getParameter("name"));
        LOGGER.info("Updating statistics with name = {}", name);
        //final Statistics existingStatistics =;
    }
}