package com.infoshareacademy.jjdd6.errorzy.web;
import com.infoshareacademy.jjdd6.errorzy.statistics.Statistics;
import com.infoshareacademy.jjdd6.errorzy.statistics.StatisticsValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/statistisc")
public class StatisticsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String country = req.getParameter("country");
        String city = req.getParameter("city");

        //JEZELI tylko panstwo, to
        if (city == null)
        resp.getWriter().println(Statistics.getStatisticsForCountry(country));
        // Walidator czy to co jest w countr i city czy istnieje w bazie
        boolean cityResult = StatisticsValidator.checkIfCityExists(city);
        boolean countryResult = StatisticsValidator.checkIfCountryExists(country);
        if(!(cityResult && countryResult)) {
            throw new IllegalStateException("Nie ma next bajka tutaj!!!!!!@");
        }
        //czy miasto nalezy do panstwa
        //jesli tak to
    //    resp.getWriter().println(Statistics.statisticsForCities(city));
        ;


     //   resp.getWriter().println(statistics.statisticsForCities(city).size());

    }
}
