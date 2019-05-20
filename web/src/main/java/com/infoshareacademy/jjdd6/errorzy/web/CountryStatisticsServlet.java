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
    private CountryStatisticsDao countryStatisticsDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String action = req.getParameter("action");
        LOGGER.info("Requested action: {}", action);
        if (action == null || action.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }

        if (action.equals("findByName")) {
            findByNameCountryStatistics(req, resp);
        } else if (action.equals("findAll")) {
            findAllCountryStatistics(req, resp);
        } else if (action.equals("findMostChecked")) {
            findMostCheckedCountryStatistics(req, resp);
        } else {
            resp.getWriter().write("Unknown action.");
        }
    }

    private void findAllCountryStatistics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<CountryStatistics> countryList = countryStatisticsDao.findAll();
        LOGGER.info("Found {} objects", countryList.size());

        for (CountryStatistics cou : countryList) {
            resp.getWriter().write(cou.toString() + "\n");

        }
    }

    private void findMostCheckedCountryStatistics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final CountryStatistics countryName = countryStatisticsDao.findMostChecked();
        LOGGER.info("Found {} objects", countryName.toString());

        resp.getWriter().write(countryName.toString());
    }

    private void findByNameCountryStatistics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String name = req.getParameter("country");
        final CountryStatistics countryName = countryStatisticsDao.findByName(name);
        LOGGER.info("Found {} objects", countryName.toString());

        resp.getWriter().write(countryName.toString());
    }
}
