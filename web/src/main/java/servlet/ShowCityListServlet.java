package servlet;

import com.infoshareacademy.jjdd6.listOfPlaces.CityPrinter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/show-city-list")
public class ShowCityListServlet extends HttpServlet {
    @Inject
    CityPrinter cityPrinter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();
        String templateName = "city-list.ftlh";

//        resp.getWriter().println("<h1>CITY LIST</h1>");
//        resp.getWriter().println();
    }
}