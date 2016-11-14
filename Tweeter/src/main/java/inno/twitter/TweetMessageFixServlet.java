package inno.twitter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey Sadriev aka AESFUI on 14.11.2016.
 */
@WebServlet(urlPatterns = "/twitter/fix")
public class TweetMessageFixServlet extends TweeterServlet{
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String messageFix = req.getParameter("messagefix");
        Long id = Long.parseLong(req.getParameter("id"));
        service.fixMessage(id, messageFix);
        resp.sendRedirect("/twitter");
    }
}
