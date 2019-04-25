package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.Place;
import com.infoshareacademy.jjdd6.errorzy.statistics.Statistics;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/statistisc")
public class StatisticsServlet extends HttpServlet {

    @Inject
    private Statistics statistics;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String country = req.getParameter("country");
        int i = 0;
//        for (List<Place> country : statistics.statisticsForCountry(country)) {
//            resp.getWriter().println(i + ". " + country.size());
            resp.getWriter().println(statistics.statisticsForCountry(country).size());
//            i++;

//        }
        for (List<Place> city : statistics.statisticsForCities()) {
            resp.getWriter().println(i + ". " + city.size());
        }
    }
}
//zrobić formularz i użyć do post