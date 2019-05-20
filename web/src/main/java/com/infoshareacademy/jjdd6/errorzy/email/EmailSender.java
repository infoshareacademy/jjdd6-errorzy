package com.infoshareacademy.jjdd6.errorzy.email;

import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CityStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CountryStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.PlaceStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.statistics.model.CityStatistics;
import com.infoshareacademy.jjdd6.errorzy.statistics.model.CountryStatistics;
import com.infoshareacademy.jjdd6.errorzy.statistics.model.PlaceStatistics;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@Singleton
@Startup
public class EmailSender {
    private static final String EMAIL = "errorzy.jjdd6@gmail.com";
    private static final String EMAIL_TOPIC = "Errorzy report: " + LocalDateTime.now();

    @Inject
    private EmailService emailService;
    @Inject
    private CountryStatisticsDao countryStatisticsDao;
    @Inject
    private CityStatisticsDao cityStatisticsDao;
    @Inject
    private PlaceStatisticsDao placeStatisticsDao;

    @Schedule(hour = "*/3", minute = "0")
    public void sendReportEmail() {
        List<CountryStatistics> countryStatistics = countryStatisticsDao.findAll();
        List<CityStatistics> cityStatistics = cityStatisticsDao.findAll();
        List<PlaceStatistics> placeStatistics = placeStatisticsDao.findAll();

        StringBuilder sb = new StringBuilder();

        String mailContent = sb.append("----------- COUNTRY STATISTIC -----------")
                .append(System.lineSeparator())
                .append(countryStatistics.toString())
                .append("----------- CITY STATISTIC -----------")
                .append(System.lineSeparator())
                .append(cityStatistics.toString())
                .append("----------- PLACE STATISTIC -----------")
                .append(System.lineSeparator())
                .append(placeStatistics.toString())
                .toString();

        emailService.sendMail(EMAIL, EMAIL_TOPIC, mailContent);
    }
}
