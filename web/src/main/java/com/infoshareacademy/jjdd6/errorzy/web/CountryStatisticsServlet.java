package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CountryStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.model.CountryStatistics;
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

@WebServlet("/country-statistics")
public class CountryStatisticsServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(CountryStatisticsServlet.class.getName());

    @Inject
    CountryStatisticsDao countryStatisticsDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String action = req.getParameter("action");
        LOGGER.info("Requested action: {}", action);
        if (action == null || action.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }


        if (action.equals("delete")) {
            deleteCountryStatiscics(req, resp);
        } else if (action.equals("findByName")) {
            findByNameCountryStatiscics(req, resp);
        } else if (action.equals("findAll")) {
            findAllCountryStatistics(req, resp);
        } else if (action.equals("findMostChecked")) {
            findMostCheckedCountryStatiscics(req, resp);
        } else {
            resp.getWriter().write("Unknown action.");
        }


    }


    private void deleteCountryStatiscics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String country = new String(req.getParameter("country"));
        LOGGER.info("Removing statistics for = {}", country);

        countryStatisticsDao.delete(country);

        findAllCountryStatistics(req, resp);
    }

    private void findAllCountryStatistics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<CountryStatistics> result = countryStatisticsDao.findAll();
        LOGGER.info("Found {} objects", result.size());
        for (CountryStatistics cou : result) {
            resp.getWriter().write(cou.toString() + "\n");
        }

    }

    private void findMostCheckedCountryStatiscics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long numberOfVisits = req.getParameter(Long.parseLong(req.getParameter("number of visit"));

        final List<CountryStatistics> result = countryStatisticsDao.findMostChecked();

        LOGGER.info("Found {} objects", result.size());

        for (CountryStatistics cou : result) {
            resp.getWriter().write(cou.toString() + "\n");

        }
    }

    private void findByNameCountryStatiscics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String country = new String(req.getParameter("country"));

        LOGGER.info("Found {} objects", country);

        for (CountryStatistics cou : country) {
            resp.getWriter().write(cou + "\n");
        }

    }


}
