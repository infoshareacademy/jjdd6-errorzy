package com.infoshareacademy.jjdd6.errorzy.web;

import com.infoshareacademy.jjdd6.errorzy.email.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mail")
public class EmailTestServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(EmailTestServlet.class);

    @Inject
    private EmailService emailService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String to = req.getParameter("to");
        String topic = req.getParameter("topic");
        String content = req.getParameter("content");

        LOG.info("Mailer servlet has been opened.");

        //so far - parameters in the URL
        // localhost:8080/mail?to=addres@mail.ua&topic=MailTopic&content=Test%20message%20here

        emailService.sendMail(to, topic, content);
    }
}
