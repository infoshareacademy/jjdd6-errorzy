package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.dbloader.model.CountryModel;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.CountryService;
import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
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
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/country-servlet")
@Transactional
public class CountryServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(CountryServlet.class.getName());

    @Inject
    private CountryService countryService;
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Country servlet has been loaded.");
        resp.setContentType("text/html;charset=UTF-8");
        Writer writer = resp.getWriter();
        Template template = templateProvider.getTemplate(getServletContext(), "country-servlet.ftlh");

        List<CountryModel> countryModelList = countryService.getAllList();

        Map<String, Object> model = new HashMap<>();

        model.put("modelData", countryModelList);

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            LOGGER.warn("Template " + e + " not found.");
        }
    }
}