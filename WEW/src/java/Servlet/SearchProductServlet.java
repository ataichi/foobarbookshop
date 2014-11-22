/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.AudioCDBean;
import Beans.BookBean;
import Beans.DVDBean;
import Beans.MagazineBean;
import Beans.ProductBean;
import Beans.ProductManagerBean;
import DAO.Implementation.AudioCDManagerDAOImplementation;
import DAO.Implementation.BookManagerDAOImplementation;
import DAO.Implementation.DVDManagerDAOImplementation;
import DAO.Implementation.MagazineManagerDAOImplementation;
import DAO.Implementation.ProductDAOImplementation;
import DAO.Implementation.ProductManagerDAOImplementation;
import DAO.Interface.AudioCDManagerDAOInterface;
import DAO.Interface.BookManagerDAOInterface;
import DAO.Interface.DVDManagerDAOInterface;
import DAO.Interface.MagazineManagerDAOInterface;
import DAO.Interface.ProductDAOInterface;
import DAO.Interface.ProductManagerDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SearchProductServlet", urlPatterns = {"/SearchProductServlet"})
public class SearchProductServlet extends HttpServlet {

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
            AccountBean homeproduct = (AccountBean) session.getAttribute("homeproduct");
            String searchstring = request.getParameter("searchstring");
            ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
            ProductDAOInterface productdao = new ProductDAOImplementation();
            
       
            if (homeproduct.getAccountID() != 0) { // product manager searches for a product
                out.println("here");
                ProductManagerBean productmanager = new ProductManagerBean();
                ProductManagerDAOInterface pdao = new ProductManagerDAOImplementation();
                productmanager = pdao.getProductManagerBeanById(homeproduct.getAccountID());

                if (productmanager.getProdType().equals("Books")) { //book manager
                    BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();
                    ArrayList<BookBean> booklist = new ArrayList<BookBean>();
                    //              booklist = bookdao.getAllBooks();
                    session.setAttribute("booklist", booklist);

                    session.setAttribute("productlist", productlist);

                } else if (productmanager.getProdType().equals("Audio CD")) { // audio cd manager
                    AudioCDManagerDAOInterface cddao = new AudioCDManagerDAOImplementation();
                    ArrayList<AudioCDBean> audiocdlist = new ArrayList<AudioCDBean>();
                    //             audiocdlist = cddao.getAllAudioCD();
                    session.setAttribute("audiocdlist", audiocdlist);

                    productlist = pdao.getProductsByType(productmanager.getProdType());
                    session.setAttribute("productlist", productlist);

                } else if (productmanager.getProdType().equals("DVD")) { //dvd manager
                    DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();
                    ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
                    //            dvdlist = dvddao.viewAllDVD();
                    session.setAttribute("dvdlist", dvdlist);

                    productlist = pdao.getProductsByType(productmanager.getProdType());
                    session.setAttribute("productlist", productlist);

                } else if (productmanager.getProdType().equals("Magazine")) { //magazine manager
                    MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
                    ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();
                    //             magazinelist = magazinedao.getAllMagazine();

                    productlist = pdao.getProductsByType(productmanager.getProdType());
                    session.setAttribute("productlist", productlist);

                }

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
