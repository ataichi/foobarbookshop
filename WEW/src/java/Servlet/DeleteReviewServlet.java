/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.AudioCDBean;
import Beans.BookBean;
import Beans.CustomerBean;
import Beans.DVDBean;
import Beans.LogBean;
import Beans.MagazineBean;
import Beans.ProductBean;
import Beans.ReviewBean;
import DAO.Implementation.AudioCDManagerDAOImplementation;
import DAO.Implementation.BookManagerDAOImplementation;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Implementation.DVDManagerDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Implementation.MagazineManagerDAOImplementation;
import DAO.Implementation.ProductManagerDAOImplementation;
import DAO.Implementation.ReviewDAOImplementation;
import DAO.Interface.AudioCDManagerDAOInterface;
import DAO.Interface.BookManagerDAOInterface;
import DAO.Interface.CustomerDAOInterface;
import DAO.Interface.DVDManagerDAOInterface;
import DAO.Interface.LogDAOInterface;
import DAO.Interface.MagazineManagerDAOInterface;
import DAO.Interface.ProductManagerDAOInterface;
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

@WebServlet(name = "DeleteReviewServlet", urlPatterns = {"/DeleteReviewServlet"})
public class DeleteReviewServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            HttpSession session = request.getSession();
            AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");

            //if (homeuser.getAccesscontrol().isDeletemessage()) {
            out.println(request.getParameter("reviewid"));
            String str_reviewid = request.getParameter("reviewid");
            int reviewID = Integer.valueOf(str_reviewid);
            ArrayList<ReviewBean> reviewlist = new ArrayList<ReviewBean>();
            ReviewBean reviewbean = new ReviewBean();

            CustomerBean customer = new CustomerBean();
            CustomerDAOInterface customerdao = new CustomerDAOImplementation();
            customer = customerdao.getCustomerByAccountID(homeuser.getAccountID());
            ReviewDAOInterface reviewdao = new ReviewDAOImplementation();

            boolean checkdelete = false;
            checkdelete = reviewdao.deleteReview(reviewID);

            out.println(reviewID);
            if (checkdelete) {
                // delete successful

                LogBean log = new LogBean();
                LogDAOInterface logdao = new LogDAOImplementation();

                log.setActivity("Remove review " + reviewID);

                log.setLog_accountID(homeuser.getAccountID());
                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());
                log.setTime(time);
                log.setIp_address(request.getRemoteAddr());
                log.setStatus("successful");

                reviewlist = customerdao.getReviewsByCustomer(customer.getCustomerID());

                if (logdao.addLog(log)) {
                    session.setAttribute("reviewlist", reviewlist);
                    response.sendRedirect("customerviewreviews.jsp");
                }
            } else {
                // delete unsucessful
            }
            //} else {
            //    out.println("ACCESS DENIED HEHE");
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
