/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giodee
 */
@WebServlet(name = "ShoppingCart", urlPatterns = {"/ShoppingCart"})
public class ShoppingCart extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            HttpSession session = request.getSession();
            AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");

            String action = request.getParameter("action");
            String qty = request.getParameter("qty");
            String product = request.getParameter("product");

            int int_qty = Integer.valueOf(qty);
            out.println(action);
            out.println(qty);

            Cookie[] cookies = request.getCookies();
            boolean foundCookie = false;

            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie1 = cookies[i];
                if (cookie1.getName().equals(homeuser.getUsername() + "-productid-" + product)) {
                    out.println("QTY = " + cookie1.getValue());
                    int temp = Integer.valueOf(cookie1.getValue());

                    cookie1.setValue(String.valueOf(temp + int_qty));
                    out.println(cookie1.getValue());
                    cookies[i] = cookie1;
                    out.println(cookies[i].getValue());

                    foundCookie = true;
                }
            }

            if (!foundCookie) {
                Cookie cookie1 = new Cookie(homeuser.getUsername() + "-productid-" + product, product);
                cookie1.setMaxAge(24 * 60 * 60);
                response.addCookie(cookie1);
                out.println("ADD COOKIE");

            }

            response.sendRedirect("customerHOME.jsp");

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
