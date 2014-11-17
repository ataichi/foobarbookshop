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
import DAO.Implementation.AudioCDDAOImplementation;
import DAO.Implementation.BookDAOImplementation;
import DAO.Implementation.DVDDAOImplementation;
import DAO.Implementation.MagazineDAOImplementation;
import DAO.Implementation.ProductDAOImplementation;
import DAO.Implementation.ProductManagerDAOImplementation;
import DAO.Interface.AudioCDDAOInterface;
import DAO.Interface.BookDAOInterface;
import DAO.Interface.DVDDAOInterface;
import DAO.Interface.MagazineDAOInterface;
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
@WebServlet(name = "RemoveProductServlet", urlPatterns = {"/RemoveProductServlet"})
public class RemoveProductServlet extends HttpServlet {

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
            ProductManagerBean productManager = new ProductManagerBean();
            ProductManagerDAOInterface pdao = new ProductManagerDAOImplementation();
            ProductDAOInterface productdao = new ProductDAOImplementation();
            productManager = pdao.getProductManagerBeanById(homeproduct.getAccountID());
            ArrayList<ProductBean> plist = new ArrayList<ProductBean>();

            int productID = Integer.parseInt(request.getParameter("product"));
            ProductBean removeproduct = productdao.getProductById(productID);
            boolean check_removeproduct = false;
            boolean check_removespecificproduct = false;

            String type = removeproduct.getType();
            if (type.equals("Audio CD")) {
                AudioCDBean removeaudio = new AudioCDBean();
                AudioCDDAOInterface audiodao = new AudioCDDAOImplementation();
                removeaudio = audiodao.getAudioCDByProductId(productID);
                ArrayList<AudioCDBean> cdlist = new ArrayList<AudioCDBean>();

                check_removespecificproduct = audiodao.deleteaudioCD(productID);
                if (check_removespecificproduct) {
                    check_removeproduct = productdao.removeProduct(productID);

                    if (check_removeproduct) {
                        out.println("delete cd");
                        plist = productdao.getAllProductsByType(type);
                        cdlist = audiodao.getAllAudioCD();
                        session.setAttribute("audiocdlist", cdlist);
                        session.setAttribute("productlist", plist);
                        response.sendRedirect("productmanagerHOME.jsp");
                    } else {
                        out.println("failed to remove cd");
                        //response.sendRedirect("productmanagerHOME.jsp");
                    }
                }

            } else if (type.equals("Books")) {
                BookBean removebook = new BookBean();
                BookDAOInterface bookdao = new BookDAOImplementation();
                removebook = bookdao.getBookByProductId(productID);
                ArrayList<BookBean> booklist = new ArrayList<BookBean>();

                check_removespecificproduct = bookdao.deleteBook(productID);
                if (check_removespecificproduct) {
                    check_removeproduct = productdao.removeProduct(productID);

                    if (check_removeproduct) {
                        booklist = bookdao.getAllBooks();
                        plist = productdao.getAllProductsByType(type);

                        session.setAttribute("booklist", booklist);
                        session.setAttribute("productlist", plist);
                        
                        out.println("delete book");
                        response.sendRedirect("productmanagerHOME.jsp");
                    } else {
                        out.println("failed to remove book");
                        //response.sendRedirect("productmanagerHOME.jsp");
                    }
                }
            } else if (type.equals("DVD")) {
                DVDBean removedvd = new DVDBean();
                DVDDAOInterface dvddao = new DVDDAOImplementation();
                removedvd = dvddao.getDVDByProductId(productID);
                ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();

                check_removespecificproduct = dvddao.deleteDVD(productID);
                if (check_removespecificproduct) {
                    check_removeproduct = productdao.removeProduct(productID);

                    if (check_removeproduct) {
                        dvdlist = dvddao.getAllDVD();
                        plist = productdao.getAllProductsByType(type);

                        session.setAttribute("dvdlist", dvdlist);
                        session.setAttribute("productlist", plist);
                        out.println("delete dvd");
                        response.sendRedirect("productmanagerHOME.jsp");
                    } else {
                        out.println("failed to remove dvd");
                        //response.sendRedirect("productmanagerHOME.jsp");
                    }
                }

            } else if (type.equals("Magazine")) {
                MagazineBean removemagazine = new MagazineBean();
                MagazineDAOInterface magazinedao = new MagazineDAOImplementation();
                removemagazine = magazinedao.getMagazineByProductId(productID);

                check_removespecificproduct = magazinedao.deleteMagazine(productID);
                if (check_removespecificproduct) {
                    check_removeproduct = productdao.removeProduct(productID);

                    if (check_removeproduct) {
                        out.println("delete magazine");
                        ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();
                        magazinelist = magazinedao.getAllMagazine();
                        plist = productdao.getAllProductsByType(type);

                        session.setAttribute("productlist", plist);
                        session.setAttribute("magazinelist", magazinelist);

                        response.sendRedirect("productmanagerHOME.jsp");
                    } else {
                        out.println("failed to remove cd");
                        //response.sendRedirect("productmanagerHOME.jsp");
                    }
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
