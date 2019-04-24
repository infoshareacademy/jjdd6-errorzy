package servlet;

import bean.FileUploadProcessorBean;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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

    @Inject
    TemplateProvider templateProvider;
    @Inject
    FileUploadProcessorBean fileUploadProcessorBean;
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        Template template = templateProvider.getTemplate(getServletContext(), "upload-servlet.ftlh");
        try {
            template.process(null, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        File file = fileUploadProcessorBean.uploadFile(req.getPart("file"));
    }
}

