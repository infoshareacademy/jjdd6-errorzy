package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CityStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CountryStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.PlaceStatisticsDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
