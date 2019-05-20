package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.email.EmailService;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CityStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CountryStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.PlaceStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.model.CityStatistics;
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
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/mail")
public class EmailServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(EmailServlet.class);
    private static final String EMAIL = "krzesniak1@gmil.com";
    private static final String EMAIL_TOPIC = "Errorzy report: " + LocalDateTime.now();

    @Inject
    private EmailService emailService;
    @Inject
    private CountryStatisticsDao countryStatisticsDao;
    @Inject
    private CityStatisticsDao cityStatisticsDao;
    @Inject
    private PlaceStatisticsDao placeStatisticsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String to = req.getParameter("to");
        String topic = req.getParameter("topic");
        String content = req.getParameter("content");

        LOG.info("Mailer servlet has been opened.");

        List<CountryStatistics> countryStatistics = countryStatisticsDao.findAll();
        List<CityStatistics> cityStatistics = cityStatisticsDao.findAll();
        List<PlaceStatistics> placeStatistics = placeStatisticsDao.findAll();

        StringBuilder sb = new StringBuilder();

        String mailContent = sb.append("----------- COUNTRY STATISTIC -----------")
                .append("\\n")
                .append(countryStatistics.toString())
                .append("----------- CITY STATISTIC -----------")
                .append("\\n")
                .append(cityStatistics.toString())
                .append("----------- PLACE STATISTIC -----------")
                .append("\\n")
                .append(placeStatistics.toString())
                .toString();

                emailService.sendMail(EMAIL, EMAIL_TOPIC, mailContent);
    }
}
