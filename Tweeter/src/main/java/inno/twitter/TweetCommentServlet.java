package inno.twitter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.StreamHandler;

/**
 * Created by Andrey Sadriev aka AESFUI on 14.11.2016.
 */
@WebServlet(urlPatterns = "/twitter/comment")
public class TweetCommentServlet extends TweeterServlet{
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String comment = req.getParameter("comment");
        Long id = Long.parseLong(req.getParameter("id"));
        if (comment != null) {
            service.addComment(id, comment);
        }
        resp.sendRedirect("/twitter");
    }
}
