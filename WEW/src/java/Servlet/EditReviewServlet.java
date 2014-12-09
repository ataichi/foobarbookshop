/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.LogBean;
import Beans.ProductBean;
import Beans.ReviewBean;
import DAO.Implementation.LogDAOImplementation;
import DAO.Implementation.ProductDAOImplementation;
import DAO.Implementation.ReviewDAOImplementation;
import DAO.Interface.LogDAOInterface;
import DAO.Interface.ProductDAOInterface;
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

@WebServlet(name = "EditReviewServlet", urlPatterns = {"/EditReviewServlet"})
public class EditReviewServlet extends HttpServlet {

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
            out.println("<title>Servlet EditReviewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditReviewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            HttpSession session = request.getSession();
            AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");

            if (homeuser.getAccesscontrol().isEditmessage()) {
                LogBean log = new LogBean();
                LogDAOInterface logdao = new LogDAOImplementation();
                Timestamp time;
                java.util.Date date = new java.util.Date();
                time = new Timestamp(date.getTime());
                // not sure if customerID or accountID dapat :)

                log.setLog_accountID(homeuser.getAccountID());
                log.setTime(time);

                int reviewID = Integer.valueOf(request.getParameter("reviewid"));
                String activity = "Edit review ID " + reviewID;
                log.setActivity(activity);

                ReviewBean reviewbean = new ReviewBean();
                ReviewDAOInterface reviewdao = new ReviewDAOImplementation();
                ProductDAOInterface productdao = new ProductDAOImplementation();
                ProductBean productbean = new ProductBean();

                reviewbean = reviewdao.getReviewByReviewID(reviewID);
                productbean = productdao.getProductById(reviewbean.getReview_productID());

                if (logdao.addLog(log)) {
                    session.setAttribute("reviewbean", reviewbean);

                    session.setAttribute("productbean", productbean);
                    out.println(reviewbean.getReview_productID());
                    out.println(productbean.getTitle());
                    //     response.sendRedirect("customereditreview.jsp");
                    out.println("YEHEY PWEDE");
                } else {
                    out.println("UNABLE TO EDIT");
                }
            } else {
                out.println("ACCESS DENIED");
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
