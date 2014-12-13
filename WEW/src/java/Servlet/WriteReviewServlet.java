/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.CustomerBean;
import Beans.LogBean;
import Beans.ReviewBean;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Implementation.ReviewDAOImplementation;
import DAO.Interface.CustomerDAOInterface;
import DAO.Interface.LogDAOInterface;
import DAO.Interface.ReviewDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giodee
 */
@WebServlet(name = "WriteReviewServlet", urlPatterns = {"/WriteReviewServlet"})
public class WriteReviewServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WriteReviewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WriteReviewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            HttpSession session = request.getSession();

            AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");

            CustomerBean customer = (CustomerBean) session.getAttribute("tempcustomer");
            CustomerDAOInterface customerdao = new CustomerDAOImplementation();

            ReviewBean reviewbean = new ReviewBean();
            ReviewDAOInterface reviewdao = new ReviewDAOImplementation();

            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();
            String review = request.getParameter("review");
            int id = Integer.valueOf(request.getParameter("id"));
            int review_customerID = customer.getCustomerID();
            out.println(id);

            reviewbean.setReview(review);
            reviewbean.setReview_customerID(review_customerID);
            reviewbean.setReview_productID(id);

            if (customerdao.writeReview(reviewbean)) {
                int accountid = customer.getCustomer_accountID();
                Timestamp time;
                java.util.Date date = new java.util.Date();
                time = new Timestamp(date.getTime());
                String activity = "Customer ID" + customer.getCustomerID() + " wrote review for product id " + id;
                // not sure if customerID or accountID dapat :)

                log.setActivity(activity);
                log.setLog_accountID(accountid);
                log.setTime(time);
                log.setIp_address(request.getRemoteAddr());
                log.setStatus("Successful");
                
                if(logdao.addLog(log)){
                    response.sendRedirect("customerHOME.jsp");
                }

            } else {
       //         out.println("Review not added");
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