package com.infoshareacademy.jjdd6.errorzy.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/contact")
public class ContactFormServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(ContactFormServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameterMap().keySet());
        String name = req.getParameter("name");

//        message.setname(name);
//        email.send(message);

        super.doPost(req, resp);
    }
}
