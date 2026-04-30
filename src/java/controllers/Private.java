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
public class Private extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(Private.class.getName());

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

        try {
            String url = "/profile.jsp";
            String action = request.getParameter("action");

            HttpSession session = request.getSession();

            ArrayList errors = new ArrayList();

            User accessGrantedUser = new User();
            User loggedInUser = null;

            if (session.getAttribute("loggedInUser") != null) {
                accessGrantedUser = (User) session.getAttribute("loggedInUser");
                loggedInUser = GroupDB.selectUser(accessGrantedUser.getUsername(), true);
            }

            //if the user isn't logged in, direct them to the Public controller
            switch (action) {
                case "goToProfile": {
                    url = "/profile.jsp";
                    break;
                }
                case "goToAllUsers": {
                    url = "/allusers.jsp";
                    LinkedHashMap<Integer, User> users = new LinkedHashMap<Integer, User>();

                    try {
                        users = GroupDB.selectUsers();
                        request.setAttribute("users", users);
                    } catch (NamingException | SQLException ex) {
                        errors.add("No users found.");
                        LOG.log(Level.SEVERE, "*** sql select fail", ex);
                    }

                    break;
                }
                case "goToEdit": {
                    url = "/edit.jsp";
                    break;
                }
                case "edit": {
                    url = "/profile.jsp";
                    String newEmail = request.getParameter("newEmail");
                    String newPassword = request.getParameter("newPassword");

                    // Validate edited user
                    errors.addAll(GroupDB.validateEmail(newEmail));
                    errors.addAll(GroupDB.validatePassword(newPassword));

                    if (errors.isEmpty()) {
                        request.setAttribute("rows", GroupDB.update(loggedInUser, newEmail, newPassword));
                    } else {
                        url = "/edit.jsp";
                    }

                    break;
                }
            }

            session.setAttribute("loggedInUser", loggedInUser);
            request.setAttribute("errors", errors);

            getServletContext().getRequestDispatcher(url).forward(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Private.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Private.class.getName()).log(Level.SEVERE, null, ex);
        }
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
