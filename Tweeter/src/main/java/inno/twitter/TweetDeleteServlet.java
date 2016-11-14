package inno.twitter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Long.parseLong;

/**
 * Created by Andrey Sadriev aka AESFUI on 12.11.2016.
 */
@WebServlet(urlPatterns = "/twitter/delete")
public class TweetDeleteServlet extends TweeterServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        service.delete(Long.parseLong(id));
        resp.sendRedirect("/twitter");
    }
}
