package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;
import freemarker.template.Template;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/countries")
public class CountryServlet extends HttpServlet {

    @Inject
    private CountrySearch countrySearch;
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "countries.ftlh");
        template.dump(resp.getWriter());

        int i = 1;
        for (Map.Entry<String, Country> entry : countrySearch.getMapOfCountries().entrySet()) {
            resp.getWriter().println(i + ". " + entry.getKey());
            i++;
        }
    }
}