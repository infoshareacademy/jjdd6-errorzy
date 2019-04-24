package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.freemarker.TemplateProvider;
import com.infoshareacademy.jjdd6.errorzy.upload.FileUploadProcessorBean;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    public static final String UPLOAD_TEMPLATE = "upload-servlet.ftlh";
    private static final Logger LOGGER = LogManager.getLogger(UploadServlet.class.getName());

    @Inject
    TemplateProvider templateProvider;

    @Inject
    FileUploadProcessorBean fileUploadProcessorBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        Template template = templateProvider.getTemplate(getServletContext(), UPLOAD_TEMPLATE);
        try {
            template.process(null, writer);
        } catch (TemplateException e) {
            LOGGER.warn("Template not found" + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        File file = fileUploadProcessorBean.uploadFile(req.getPart("file"));
    }
}
