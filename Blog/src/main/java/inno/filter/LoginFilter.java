package inno.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey Sadriev aka AESFUI on 01.12.2016.
 */
public class LoginFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                                                        throws IOException, ServletException {
        System.out.println("Зашли в фильтр");
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect("accessdenied.jsp");
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
