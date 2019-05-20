package com.infoshareacademy.jjdd6.errorzy.login;

import com.auth0.AuthenticationController;

import javax.servlet.ServletConfig;
import java.io.UnsupportedEncodingException;

public abstract class AuthenticationControllerProvider {

    public static AuthenticationController getInstance(ServletConfig config) throws UnsupportedEncodingException {
        String domain = config.getServletContext().getInitParameter("com.auth0.domain");
        String clientId = config.getServletContext().getInitParameter("com.auth0.clientId");
        String clientSecret = config.getServletContext().getInitParameter("com.auth0.clientSecret");

        return AuthenticationController.newBuilder(domain, clientId, clientSecret)
                .build();
    }
    public static String getDomain(ServletConfig config) {
        return config.getServletContext().getInitParameter("com.auth0.domain");
    }

    public static String getClientId(ServletConfig config) {
        return config.getServletContext().getInitParameter("com.auth0.clientId");
    }

    public static String getClientSecret(ServletConfig config) {
        return config.getServletContext().getInitParameter("com.auth0.clientSecret");
    }
}