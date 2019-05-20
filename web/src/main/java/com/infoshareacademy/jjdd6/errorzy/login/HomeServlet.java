package com.infoshareacademy.jjdd6.errorzy.login;
import com.auth0.SessionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class HomeServlet extends HttpServlet {
    private static final Logger LOG = LogManager.getLogger(HomeServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        LOG.info("HomeServlet has been started.");
        final String accessToken = (String) SessionUtils.get(req, "accessToken");
        final String idToken = (String) SessionUtils.get(req, "idToken");
        if (accessToken != null) {
            LOG.info("AccessToken = " + accessToken);
            req.setAttribute("userId", accessToken);
        } else if (idToken != null) {
            LOG.info("idToken = " + idToken);
            req.setAttribute("userId", idToken);
        }
        LOG.warn("No token from the user");
        req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, res);

    }
}
