package filter;

import business.User;
import controllers.Private;
import data.GroupDB;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;

/**
 * @author schei
 */
public class SecurityFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(Private.class.getName());
    String url = "/login.jsp";
    private FilterConfig filterConfig = null;
    private String[] allowedHosts = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        String hostsString = filterConfig.getInitParameter("allowedHosts");
        if (hostsString != null && !hostsString.trim().equals("")) {
            allowedHosts = hostsString.split("\n");
        }
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        HttpSession session = httpRequest.getSession();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String remoteAddress = httpRequest.getRemoteAddr();
        boolean allowed = false;

        User accessGrantedUser = new User();
        User loggedInUser = null;

        try {
            if (session.getAttribute("loggedInUser") != null) {
                accessGrantedUser = (User) session.getAttribute("loggedInUser");
                loggedInUser = GroupDB.selectUser(accessGrantedUser.getUsername(), true);
                allowed = true;
            }
        } catch (SQLException | NamingException ex) {
            LOG.log(Level.SEVERE, "*** sql select fail", ex);
        }

//        for (String host : allowedHosts) {
//            if (host.trim().equals(remoteAddress)) {
//                allowed = true;
//                break;
//            }
//        }
        if (allowed) {
            chain.doFilter(request, response);
        } else {
            // redirect
            request.setAttribute("messsage", "error logging in");
            filterConfig.getServletContext().getRequestDispatcher(url).forward(request, response);
        }

    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
