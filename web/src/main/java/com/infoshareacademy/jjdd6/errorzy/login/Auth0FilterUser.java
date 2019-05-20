package com.infoshareacademy.jjdd6.errorzy.login;

import com.auth0.SessionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter class to check if a valid session exists. This will be true if the User Id is present.
 */
@WebFilter(urlPatterns = {"portal/home", "/bike-servlet/*", "/show-city-list", "/closestPlace-servlet", "/country-servlet", "/number-of-places", "/upload", "/country-statistics", "/city-statistics", "/place-statistics", "/mail", "/upload"})
public class Auth0FilterUser implements Filter {
    private static final Logger LOG = LogManager.getLogger(Auth0FilterUser.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Perform filter check on this request - verify the User Id is present.
     *
     * @param request  the received request
     * @param response the response to send
     * @param next     the next filter chain
     **/
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
        LOG.info("Filtering users method in authorisation of users class has been runned.");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String accessToken = (String) SessionUtils.get(req, "accessToken");
        String idToken = (String) SessionUtils.get(req, "idToken");
        if (accessToken == null && idToken == null) {
            res.sendRedirect("/login");
            return;
        }
        next.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}