package servlet;

import com.infoshareacademy.jjdd6.errorzy.Country;
import com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller.CountrySearch;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/country-servlet")
public class GetCountryServlet extends HttpServlet {

    @Inject
    private CountrySearch countrySearch;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = 1;
        for (Map.Entry<String, Country> entry : countrySearch.getMapOfCountries().entrySet()) {
            resp.getWriter().println(i + ". " + entry.getKey());
            i++;
        }
    }
}