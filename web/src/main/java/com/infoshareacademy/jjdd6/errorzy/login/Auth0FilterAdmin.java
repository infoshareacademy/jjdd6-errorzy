package com.infoshareacademy.jjdd6.errorzy.login;

import com.auth0.SessionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin", "/db-load", "/statistics", "/mail"})
public class Auth0FilterAdmin implements Filter {

    private static final Logger LOG = LogManager.getLogger(Auth0FilterAdmin.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Boolean isUserAdmin = Boolean.valueOf(filterConfig.getInitParameter("IsUserAdmin"));
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
        LOG.info("Filter method in authorisation of admins class has been runned");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String accessToken = (String) SessionUtils.get(req, "accessToken");
        String idToken = (String) SessionUtils.get(req, "idToken");
        if (accessToken == null && idToken == null) {
            res.sendRedirect("/login");
            return;
        }


        HttpSession session = req.getSession();
        Object isAdminObj = session.getAttribute("isAdmin");

        if (isAdminObj != null && ((Boolean) isAdminObj).booleanValue()) {
            next.doFilter(request, response);
            return;
        }

        res.sendRedirect("/errorsi/err401.html");
    }

    @Override
    public void destroy() {
    }
}

