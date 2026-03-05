/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import business.User;
import data.FakeDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fred Scott Southeast Community College INFO
 */
public class Public extends HttpServlet {

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
        if (action == null) {
            action = "default";
        }

        switch (action) {
            case "login": {
                //I've given you the start of a login system here
                
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                //Before you get your DB working you can use the usernames and 
                // passwords that are hardcoded in the FakeDB class to test
                String storedCreds = FakeDB.getPasswordForUsername(username);
                if (storedCreds == null || !password.equals(storedCreds)) {
                    request.setAttribute("message", "invalid credentials");
                } else {

                    //Since the fake users only have a username and password
                    // this uses a constructor with only that info
                    // you'll want to update later because you'll likely want
                    // all of the info for the user to store in the session
                    User loggedInUser = new User(username, email, password);
                    request.getSession().setAttribute("loggedInUser", loggedInUser);
                    //this forwards to the private controller with an action value
                    url = "/Private?action=gotoProfile";

                }
                break;
            }
            
            case "goToRegister": {
                url = "/register.jsp";
                break;
            }
            
            case "register": {
                break;
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
