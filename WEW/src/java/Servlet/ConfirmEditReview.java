/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.CustomerBean;
import Beans.LogBean;
import Beans.ProductBean;
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
import java.util.ArrayList;
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
@WebServlet(name = "ConfirmEditReview", urlPatterns = {"/ConfirmEditReview"})
public class ConfirmEditReview extends HttpServlet {

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

            //if (homeuser.getAccesscontrol().isEditmessage()) {
            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();
            Timestamp time;
            java.util.Date date = new java.util.Date();
            time = new Timestamp(date.getTime());
            log.setTime(time);

            String review = request.getParameter("review");
            int review_productID = Integer.valueOf(request.getParameter("productid"));
            int reviewID = Integer.valueOf(request.getParameter("reviewid"));

            String activity = "Edit Review for product " + review_productID;
            log.setActivity(activity);
            log.setLog_accountID(homeuser.getAccountID());
            log.setIp_address(request.getRemoteAddr());
            

            CustomerBean customer = new CustomerBean();
            CustomerDAOInterface customerdao = new CustomerDAOImplementation();

            ReviewBean reviewbean = new ReviewBean();

            customer = customerdao.getCustomerByAccountID(homeuser.getAccountID());

            reviewbean.setReview(review);
            reviewbean.setReviewID(reviewID);
            reviewbean.setReview_customerID(customer.getCustomerID());
            reviewbean.setReview_productID(review_productID);

            boolean editreview = false;

            editreview = customerdao.editReview(reviewbean);

            ArrayList<ProductBean> productsbought = new ArrayList<ProductBean>();
            productsbought = customerdao.getProductsBoughtByCustomer(customer.getCustomerID()); // get array list of products bought by customer4
            ArrayList<ReviewBean> reviewlist = new ArrayList<ReviewBean>();
            reviewlist = customerdao.getReviewsByCustomer(customer.getCustomerID());

            if (editreview) {
                // successful mag-edit
                log.setStatus("successful");
                logdao.addLog(log);
                session.setAttribute("productsbought", productsbought);
                session.setAttribute("reviewlist", reviewlist);
                response.sendRedirect("customerviewreviews.jsp");
            } else {
                log.setStatus("failed");
                logdao.addLog(log);
                response.sendRedirect("customereditreview");
            }
            //} else {
            //    out.println("ACCESS DENIED");
            //}
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
