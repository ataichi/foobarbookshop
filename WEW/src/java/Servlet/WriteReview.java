/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.CustomerBean;
import Beans.LogBean;
import Beans.ReviewBean;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Interface.CustomerDAOInterface;
import DAO.Interface.LogDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "WriteReview", urlPatterns = {"/WriteReview"})
public class WriteReview extends HttpServlet {

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
            CustomerBean tempcustomer = (CustomerBean) session.getAttribute("tempcustomer");
            ReviewBean reviewbean = new ReviewBean();
            CustomerDAOInterface customerdao = new CustomerDAOImplementation();
            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();

            String review = request.getParameter("review");
            int productid = Integer.valueOf(request.getParameter("productid"));
            int review_customerID = tempcustomer.getCustomerID();

            reviewbean.setReview(review);
            reviewbean.setReview_customerID(review_customerID);
            reviewbean.setReview_productID(productid);

            int accountid = tempcustomer.getCustomer_accountID();
            java.util.Date date = new java.util.Date();
            Timestamp time = new Timestamp(date.getTime());
            String activity = "Customer ID" + tempcustomer.getCustomerID() + " wrote review for product id " + productid;
            // not sure if customerID or accountID dapat :)

            log.setActivity(activity);
            log.setLog_accountID(accountid);
            log.setTime(time);

            if (customerdao.writeReview(reviewbean)) {

                if(logdao.addLog(log))
                response.sendRedirect("customerHOME.jsp");
            }

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
