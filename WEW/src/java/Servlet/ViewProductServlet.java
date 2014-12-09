/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.*;
import DAO.Implementation.*;
import DAO.Interface.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ViewProductServlet", urlPatterns = {"/ViewProductServlet"})
public class ViewProductServlet extends HttpServlet {

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
            AccountBean account = (AccountBean) session.getAttribute("homeproduct");

            if (account.getAccesscontrol().isViewproduct()) {
                ProductDAOImplementation pdao = new ProductDAOImplementation();
                AudioCDManagerDAOImplementation audiocddao = new AudioCDManagerDAOImplementation();
                AudioCDBean audiocdbean = new AudioCDBean();
                BookManagerDAOImplementation bookdao = new BookManagerDAOImplementation();
                BookBean bookbean = new BookBean();
                DVDManagerDAOImplementation dvddao = new DVDManagerDAOImplementation();
                DVDBean dvdbean = new DVDBean();
                MagazineManagerDAOImplementation magdao = new MagazineManagerDAOImplementation();
                MagazineBean magbean = new MagazineBean();
                ArrayList<ReviewBean> reviewlist = new ArrayList<ReviewBean>();
                ReviewBean review = new ReviewBean();
                AccountBean accountbean = new AccountBean();

                AccountDAOInterface adao = new AccountDAOImplementation();
                CustomerDAOInterface cdao = new CustomerDAOImplementation();

                ArrayList<CustomerBean> customerlist = new ArrayList<CustomerBean>();
                CustomerBean customer = new CustomerBean();
                ArrayList<AccountBean> accountlist = new ArrayList<AccountBean>();

                int productID = Integer.parseInt(request.getParameter("product"));
                ArrayList<ReviewBean> reviews = cdao.getReviewsByProductID(productID);
                
                for (int i = 0; i < reviews.size(); i++) { // get customers
                    out.println(reviews.get(i).getReview_customerID());
                    customer = cdao.getCustomerById(reviews.get(i).getReview_customerID());
                    customerlist.add(customer);
                    out.println(customer.getCustomer_accountID());
                    account = adao.getUserByAccountID(customer.getCustomer_accountID());
                    accountlist.add(account);
                }
                ProductBean productBean = new ProductBean();
                productBean = pdao.getProductById(productID);
                session.setAttribute("viewproduct", productBean);
                session.setAttribute("accountlist", accountlist);
                session.setAttribute("reviews", reviews);
                session.setAttribute("customerlist", customerlist);

                if (productBean.getType().equals("Audio CD")) {
                    audiocdbean = audiocddao.getAudioCDByProductID(productID);
                    session.setAttribute("viewaudiocd", audiocdbean);
                    response.sendRedirect("viewproduct.jsp");
                } else if (productBean.getType().equals("Book")) {
                    bookbean = bookdao.getBookByProductID(productID);
                    session.setAttribute("viewbook", bookbean);
                    response.sendRedirect("viewproduct.jsp");
                } else if (productBean.getType().equals("DVD")) {
                    dvdbean = dvddao.getDVDByProductID(productID);
                    session.setAttribute("viewdvd", dvdbean);
                    response.sendRedirect("viewproduct.jsp");
                } else if (productBean.getType().equals("Magazine")) {
                    magbean = magdao.getMagazineByProductID(productID);
                    session.setAttribute("viewmagazine", magbean);
                    response.sendRedirect("viewproduct.jsp");
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
