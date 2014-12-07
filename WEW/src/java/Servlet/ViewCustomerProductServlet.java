/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AudioCDBean;
import Beans.BookBean;
import Beans.DVDBean;
import Beans.MagazineBean;
import Beans.ProductBean;
import DAO.Implementation.AudioCDManagerDAOImplementation;
import DAO.Implementation.BookManagerDAOImplementation;
import DAO.Implementation.DVDManagerDAOImplementation;
import DAO.Implementation.MagazineManagerDAOImplementation;
import DAO.Implementation.ProductDAOImplementation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Danica
 */
@WebServlet(name = "ViewCustomerProductServlet", urlPatterns = {"/ViewCustomerProductServlet"})
public class ViewCustomerProductServlet extends HttpServlet {

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
            
            int productID = Integer.parseInt(request.getParameter("productid"));
            
            out.println(request.getParameter("productid"));
            out.println(productID);
            out.println("wala");
            
            ProductDAOImplementation pdao = new ProductDAOImplementation();
            AudioCDManagerDAOImplementation audiocddao = new AudioCDManagerDAOImplementation();
            AudioCDBean audiocdbean = new AudioCDBean();
            BookManagerDAOImplementation bookdao = new BookManagerDAOImplementation();
            BookBean bookbean = new BookBean();
            DVDManagerDAOImplementation dvddao = new DVDManagerDAOImplementation();
            DVDBean dvdbean = new DVDBean();
            MagazineManagerDAOImplementation magdao = new MagazineManagerDAOImplementation();
            MagazineBean magbean = new MagazineBean();  
            
            ProductBean productBean = new ProductBean();
            productBean = pdao.getProductById(productID);
            session.setAttribute("viewcustomerproduct", productBean);
            
            if(productBean.getType().equals("Audio CD")) {
                audiocdbean = audiocddao.getAudioCDByProductID(productID);
                session.setAttribute("viewcustomeraudiocd", audiocdbean);
                response.sendRedirect("viewcustomerproduct.jsp");
            }
            else if(productBean.getType().equals("Book")) {
                bookbean = bookdao.getBookByProductID(productID);
                session.setAttribute("viewcustomerbook", bookbean);
                response.sendRedirect("viewcustomerproduct.jsp");
            }
            else if(productBean.getType().equals("DVD")) {
                dvdbean = dvddao.getDVDByProductID(productID);
                session.setAttribute("viewcustomerdvd", dvdbean);
                response.sendRedirect("viewcustomerproduct.jsp");
            }
            else if(productBean.getType().equals("Magazine")) {
                magbean = magdao.getMagazineByProductID(productID);
                session.setAttribute("viewcustomermagazine", magbean);
                response.sendRedirect("viewcustomerproduct.jsp");
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
