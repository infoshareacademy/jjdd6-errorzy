package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CitySearch;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/show-city-list")
public class ShowCityListServlet extends HttpServlet {


    Map<String, Object> model = new HashMap<>();
    String templateName = "city-list.ftlh";


    @Inject
    private CitySearch citySearch;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = 1;
        for (Map.Entry<String, City> entry : citySearch.getMapOfCitiesForCountry().entrySet()) {
            resp.getWriter().println(i + ". " + entry.getKey());
            i++;
        }
    }
}
