/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author 851649
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //initialize session    
        HttpSession session = request.getSession();

        //retrieve user input for username and password
        String username = request.getParameter("username_input");
        String password = request.getParameter("password_input");

        //verify the above paramaters using the AccountService Class
        AccountService serviceMethods = new AccountService();
        User verification = serviceMethods.login(username, password);
        
        //log user in
        if (verification.getUsername() != null) {
            session.setAttribute("username_login", username);
            response.sendRedirect("home");
        }//display error message if verification fails
        else {
            request.setAttribute("username_input", username);
            request.setAttribute("password_input", password);
            request.setAttribute("message", "Username or Password are incorrect, please try again.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }
}
