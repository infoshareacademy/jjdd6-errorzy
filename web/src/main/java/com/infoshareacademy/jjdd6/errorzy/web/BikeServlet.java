package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/bike-servlet/*")
public class BikeServlet extends HttpServlet {

    @Inject
    private CountrySearch countrySearch;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String[] servletMapping = req.getHttpServletMapping().getMatchValue().split("/");
//        String action = servletMapping[servletMapping.length - 1];

        PrintWriter writer = resp.getWriter();
        Template template = templateProvider.getTemplate(getServletContext(), "bike-servlet-template.ftlh");

        Map<String, Country> countryMap = countrySearch.getMapOfCountries();
        Map<String, Object> mapWithCountryNames = new HashMap<>();
        mapWithCountryNames.put("root", countryMap);

//        String chosenCountry = req.getP
//        Map<String, City> cityMap = citySearch.getMapOfCitiesForCountry()

        try {
            template.process(mapWithCountryNames, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
