package filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author schei
 */
public class SecurityFilter implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig)
    {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException
    {
        
    }

}
