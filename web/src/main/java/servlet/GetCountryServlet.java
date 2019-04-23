package servlet;

import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.XmlUnmarshaller;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/country-servlet")
public class GetCountryServlet extends HttpServlet {

    @EJB
    private XmlUnmarshaller unmarshaller;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        unmarshaller.getMarkersList();
        resp.getWriter().println("ERRORZY RULES!");
    }
}