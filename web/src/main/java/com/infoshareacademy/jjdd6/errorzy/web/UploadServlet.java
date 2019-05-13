package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.upload.FileUploadProcessorBean;
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

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(UploadServlet.class.getName());

    @Inject
    private FileUploadProcessorBean fileUploadProcessorBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Upload complete.");

        LOGGER.info("XML File has been uploaded.");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            File file = fileUploadProcessorBean.uploadFile(req.getPart("file"));
        } catch (Exception e) {
            LOGGER.warn("Uploading file failed.");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
