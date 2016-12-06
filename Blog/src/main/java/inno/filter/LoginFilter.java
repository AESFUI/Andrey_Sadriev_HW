package inno.filter;

import inno.model.Users;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Andrey Sadriev aka AESFUI on 01.12.2016.
 */
public class LoginFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                                                            throws IOException, ServletException {
        System.out.println("Зашли в фильтр");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();

        Users users = (Users) session.getAttribute("User");

        //String loginPage="/posts/login.jsp";
        //boolean onLogin = (httpRequest.getRequestURI().equals("/" + loginPage))? true : false;

        //if (users == null && !onLogin) {
        if (users != null) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect("/posts/login");
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
