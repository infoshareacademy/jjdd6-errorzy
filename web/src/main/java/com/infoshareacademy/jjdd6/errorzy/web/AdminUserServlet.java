package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.dbloader.service.BikeService;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.CityService;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.CountryService;
import com.infoshareacademy.jjdd6.errorzy.dbloader.service.PlaceService;
import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin")
public class AdminUserServlet extends HelloServlet {
    private static final Logger LOGGER = LogManager.getLogger(AdminUserServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private CountryService countryService;
    @Inject
    private CityService cityService;
    @Inject
    private PlaceService placeService;
    @Inject
    private BikeService bikeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Admin dashboard has been loaded.");
        resp.setContentType("text/html;charset=UTF-8");
        Writer writer = resp.getWriter();
        Template template = templateProvider.getTemplate(getServletContext(), "admin-servlet.ftlh");

        Map<String, Object> model = new HashMap<>();

        model.put("countryNumber", countryService.getAllList().size());
        model.put("cityNumber", cityService.getAllList().size());
        model.put("placeNumber", placeService.getAllList().size());
        model.put("bikeNumber", bikeService.getAllList().size());

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            LOGGER.warn("Template " + e + " not found.");
        }
    }
}
