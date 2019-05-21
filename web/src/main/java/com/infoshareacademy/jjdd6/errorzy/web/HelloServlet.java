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
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/portal/home")
public class HelloServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(HelloServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private CountryService countryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Hello Servlet has been opened.");
        resp.setContentType("text/html;charset=UTF-8");
        Template template = templateProvider.getTemplate(getServletContext(), "hello.ftlh");

        Writer writer = resp.getWriter();

        List<CountryModel> countryModelList = countryService.getAllList();

        Map<String, Object> model = new HashMap<>();

        model.put("countries", countryModelList);

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            LOG.warn("Template " + e + " not found.");
        }
    }
}