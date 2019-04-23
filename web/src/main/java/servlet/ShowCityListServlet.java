package servlet;

import com.infoshareacademy.jjdd6.errorzy.City;
import com.infoshareacademy.jjdd6.menu.CitiesPrinterRunner;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/show-city-list")
public class ShowCityListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("ERRORZY RULES!");
    }

    @Inject
    CitiesPrinterRunner citiesPrinterRunner;

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<City> result = computerDao.findAll();
        LOG.info("Found {} objects", result.size());
        for (Computer p : result) {
            resp.getWriter().write(p.toString() + "\n");
        }
    }
}