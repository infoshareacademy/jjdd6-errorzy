package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.email.EmailService;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CityStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CountryStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.model.CityStatistics;
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
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/mail")
public class EmailTestServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(EmailTestServlet.class);

    @Inject
    private EmailService emailService;
    @Inject
    private CountryStatisticsDao countryStatisticsDao;
    @Inject
    private CityStatisticsDao cityStatisticsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String to = req.getParameter("to");
        String topic = req.getParameter("topic");
        String content = req.getParameter("content");

        LOG.info("Mailer servlet has been opened.");

        List<CountryStatistics> countryStatistics = countryStatisticsDao.findAll();
        List<CityStatistics> cityStatistics = cityStatisticsDao.findAll();

        //so far - parameters in the URL
        // localhost:8080/mail?to=addres@mail.ua&topic=MailTopic&content=Test%20message%20here

        String mailContent = "--------------- COUNTRY STATISTIC --------------- " + countryStatistics.toString();


                emailService.sendMail("krzesniak1@gmail.com", "Errorzy report: " + LocalDateTime.now(), mailContent);
    }
}
