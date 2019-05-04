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
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/country-servlet")
public class CountryServlet extends HttpServlet {

    @Inject
    private CountrySearch countrySearch;
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        Template template = templateProvider.getTemplate(getServletContext(), "country-servlet.ftlh");

        Map<String, Country> countryMap = countrySearch.getMapOfCountries();
        Map<String, Object> model = new HashMap<>();

        model.put("modelData", countryMap);

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}