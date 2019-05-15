package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.errorzy.model.CityModel;
import com.infoshareacademy.jjdd6.errorzy.service.CityService;
import com.infoshareacademy.jjdd6.errorzy.statistics.dao.CityStatisticsDao;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CitySearch;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/show-city-list")
public class CityListServlet extends HttpServlet {
    private static final Logger LOG = LogManager.getLogger(CityListServlet.class);

    @Inject
    private CityService cityService;
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("CityList servlet loaded.");
        resp.setContentType("text/html;charset=UTF-8");
        Writer writer = resp.getWriter();
        Template template = templateProvider.getTemplate(getServletContext(), "city-list-servlet.ftlh");

        List<CityModel> listOfCity = cityService.getAllList();
        Map<String, List<CityModel>> model = new HashMap();

        model.put("rootCity", listOfCity);

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            LOG.error("Template " + e +" not found.");
        }
    }
}