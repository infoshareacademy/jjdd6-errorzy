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

@WebServlet("/country_statistics")
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

        if (action.equals("update")) {
            updateCountryStatiscics(req, resp);
        } else if (action.equals("delete")) {
            deleteCountryStatiscics(req, resp);
        } else if (action.equals("findByName")) {
            findByNameCountryStatiscics(req, resp);
        } else if (action.equals("findMostChecked")) {
            findMostCheckedCountryStatiscics(req, resp);
        } else if (action.equals("addToStatistics")) {
            addToStatisticCountryStatiscics(req, resp);
        } else {
            resp.getWriter().write("Unkown action.");
        }


    }


    private void updateCountryStatiscics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String country = new String(req.getParameter("country"));
        LOGGER.info("Updating statistics for = {}", country);
        final CountryStatistics existingCountryStatistics = countryStatisticsDao.findByName(country);
        if (existingCountryStatistics == null) {
            LOGGER.info("This country name = {} has not been searched yet, nothing to be updated");
        } else {
            existingCountryStatistics.setNumberOfVisits(Long.parseLong(req.getParameter("number of visit")));

            countryStatisticsDao.update(existingCountryStatistics);
            LOGGER.info("Statistics for this country name = {} have been updated");
        }
    }


    private void addToStatisticCountryStatiscics(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void findMostCheckedCountryStatiscics(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void findByNameCountryStatiscics(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void deleteCountryStatiscics(HttpServletRequest req, HttpServletResponse resp) {
        final String name = new String(req.getParameter("name"));
        LOGGER.info("Removing statistics for = {}", name);

    }


}