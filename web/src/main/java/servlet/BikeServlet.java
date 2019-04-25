package servlet;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;
import freemarker.TemplateProvider;
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

@WebServlet("/bike-servlet")
public class BikeServlet extends HttpServlet {

    @Inject
    private CountrySearch countrySearch;

    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        Template template = templateProvider.getTemplate(getServletContext(), "bike-servlet-template.ftlh");

        Map<String, Country> countryMap = countrySearch.getMapOfCountries();
        Map<String, Object> mapWithCountryNames = new HashMap<>();
        mapWithCountryNames.put("root", countryMap);



        try {
            template.process(mapWithCountryNames, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
