package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CityStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CountryStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.PlaceStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.model.CountryStatistics;
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
import java.util.List;
import java.util.Map;

@WebServlet("/country-statistics")
public class CountryStatisticsServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(CountryStatisticsServlet.class.getName());

    @Inject
    private CountryStatisticsDao countryStatisticsDao;
    @Inject
    private CityStatisticsDao cityStatisticsDao;
    @Inject
    private PlaceStatisticsDao placeStatisticsDao;
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Admin dashboard has been loaded.");
        resp.setContentType("text/html;charset=UTF-8");
        Writer writer = resp.getWriter();
        Template template = templateProvider.getTemplate(getServletContext(), "statistics.ftlh");

        Map<String, Object> model = new HashMap<>();

        model.put("countryNumber", countryStatisticsDao.findAll());
        model.put("cityNumber", cityStatisticsDao.findAll());
        model.put("placeNumber", placeStatisticsDao.findAll());

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            LOGGER.warn("Template " + e + " not found.");
        }
    }


    //
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        final String action = req.getParameter("action");
//        LOGGER.info("Requested action: {}", action);
//        if (action == null || action.isEmpty()) {
//            resp.getWriter().write("Empty action parameter.");
//            return;
//        }
//
//        if (req.getParameter("")) {
//            findByNameCountryStatistics(req, resp);
//        } else if (action.equals("findAll")) {
//            findAllCountryStatistics(req, resp);
//        } else if (action.equals("findMostChecked")) {
//            findMostCheckedCountryStatistics(req, resp);
//        } else {
//            resp.getWriter().write("Unknown action.");
//        }
//    }
//
//    private void findAllCountryStatistics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        final List<CountryStatistics> countryList = countryStatisticsDao.findAll();
//        LOGGER.info("Found {} objects", countryList.size());
//        for (CountryStatistics cou : countryList) {
//            resp.getWriter().write(cou.toString() + "\n");
//            resp.sendRedirect("/statistics.ftlh");
//            List<CountryStatistics> countryStatisticsList = countryStatisticsDao.findAll();
//
//
//        }
//    }
//
//    private void findMostCheckedCountryStatistics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        final CountryStatistics countryName = countryStatisticsDao.findMostChecked();
//        LOGGER.info("Found {} objects", countryName.toString());
//        resp.getWriter().write(countryName.toString());
//        resp.sendRedirect("/statistics.ftlh");
//    }
//
//    private void findByNameCountryStatistics(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        final String name = req.getParameter("country");
//        final CountryStatistics countryName = countryStatisticsDao.findByName(name);
//        LOGGER.info("Found {} objects", countryName.toString());
//        resp.getWriter().write(countryName.toString());
//        resp.sendRedirect("/statistics.ftlh");
//    }
}
