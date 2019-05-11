package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CityStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.model.CityStatistics;
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

@WebServlet("/city-statistics")
public class CityStatisticsServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(CityStatisticsServlet.class.getName());

    @Inject
    CityStatisticsDao cityStatisticsDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String action = req.getParameter("action");
        LOGGER.info("Requested action: {}", action);
        if (action == null || action.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }

        if (action.equals("delete")) {
            deleteCityStatiscics(req, resp);
        } else if (action.equals("findByName")) {
            findByNameCityStatiscics(req, resp);
        } else if (action.equals("findAll")) {
            findAllCityStatistics(req, resp);
        } else if (action.equals("findMostChecked")) {
            findMostCityCountryStatiscics(req, resp);
        } else {
            resp.getWriter().write("Unknown action.");
        }

    }

    private void deleteCityStatiscics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String city = new String(req.getParameter("city"));
        LOGGER.info("Removing statistics for = {}", city);

        cityStatisticsDao.delete(city);

        findAllCityStatistics(req, resp);
    }

    private void findAllCityStatistics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<CityStatistics> cityList = cityStatisticsDao.findAll();
        LOGGER.info("Found {} objects", cityList.size());

        for (CityStatistics cit : cityList) {
            resp.getWriter().write(cit.toString() + "\n");
        }
    }

    private void findMostCityCountryStatiscics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final CityStatistics cityName = cityStatisticsDao.findMostChecked();
        LOGGER.info("Found {} objects", cityName.toString());

        resp.getWriter().write(cityName.toString());
    }

    private void findByNameCityStatiscics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String name = req.getParameter("city");
        final CityStatistics cityName = cityStatisticsDao.findByName(name);
        LOGGER.info("Found {} objects", cityName.toString());

        resp.getWriter().write(cityName.toString());
    }
}

