/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import business.User;
import data.GroupDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fred Scott Southeast Community College INFO
 */
public class Public extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(Public.class.getName());
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/login.jsp";
        String action = request.getParameter("action");
        
        HttpSession session = request.getSession();

        ArrayList errors = new ArrayList();

        if (action == null) {
            action = "default";
        }

        switch (action) {
            case "login": {
                //I've given you the start of a login system here

                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                try {
                    User user = GroupDB.selectUser(username);
                    if (user == null || !password.equals(user.getPassword())) {
                        request.setAttribute("message", "invalid credentials");
                    } else {
                        User loggedInUser = new User(username, email, password);
                        request.setAttribute("loggedInUser", loggedInUser);
                        //this forwards to the private controller with an action value
                        url = "/Private?action=gotoProfile";
                    }
                    
                } catch (NamingException | SQLException ex) {
                    errors.add("Database down. Try again later.");
                    LOG.log(Level.SEVERE, "*** Server down", ex);
                }

                break;
            }

            case "goToRegister": {
                url = "/register.jsp";
                break;
            }

            case "register": {
                try {
                    // Validation for new user here
                    User newUser = new User();
                    
                    LinkedHashMap<Integer, User> Users = GroupDB.selectUsers();
                    
                    String username = request.getParameter("username");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    
                    //validate username
                    
                    if (username.length() < 4 || username.length() > 20)
                    {
                        errors.add("Username must be between 4-20 characters inclusive.");
                    }
                    
                    
                    
                    //Validate email
                    
                    if (email.length() < 5)
                    {
                        errors.add("Email must be more than 5 characters.");
                    }
                    
                    if (email.contains("@") == false)
                    {
                        errors.add("Email must contain @ symbol.");
                    }
                    
                    if (email.indexOf(".") <= email.indexOf("@"))
                    {
                        errors.add("Email must contain a period after the @ symbol.");
                    }
                    
                    //Validate password
                    
                    if (password.length() < 10)
                    {
                        errors.add("Password must be more than 10 characters.");
                    }
                    
                    break;
                } catch (NamingException ex) {
                    Logger.getLogger(Public.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Public.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
