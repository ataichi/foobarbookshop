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
import DAO.Implementation.AudioCDManagerDAOImplementation;
import DAO.Implementation.BookDAOImplementation;
import DAO.Implementation.BookManagerDAOImplementation;
import DAO.Implementation.DVDDAOImplementation;
import DAO.Implementation.DVDManagerDAOImplementation;
import DAO.Implementation.MagazineManagerDAOImplementation;
import DAO.Implementation.ProductManagerDAOImplementation;
import DAO.Interface.AudioCDDAOInterface;
import DAO.Interface.AudioCDManagerDAOInterface;
import DAO.Interface.BookDAOInterface;
import DAO.Interface.BookManagerDAOInterface;
import DAO.Interface.DVDDAOInterface;
import DAO.Interface.DVDManagerDAOInterface;
import DAO.Interface.MagazineManagerDAOInterface;
import DAO.Interface.ProductManagerDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditProductServlet", urlPatterns = {"/EditProductServlet"})
public class EditProductServlet extends HttpServlet {

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
            productManager = pdao.getProductManagerBeanById(homeproduct.getAccountID());

            int productID = Integer.parseInt(request.getParameter("product"));
            ProductBean editproduct = new ProductBean();
            editproduct = pdao.getProductById(productID);

            
            if (editproduct.getType().equals("Audio CD")) {
                AudioCDBean audiocd = new AudioCDBean();
                AudioCDDAOInterface audiodao = new AudioCDDAOImplementation();
                audiocd = audiodao.getAudioCDByProductID(productID);

                session.setAttribute("editaudio", audiocd);

                session.setAttribute("editbook", null);
                session.setAttribute("editdvd", null);
                session.setAttribute("editmagazine", null);
            } else if (editproduct.getType().equals("Books")) {
                BookBean book = new BookBean();
                BookDAOInterface bookdao = new BookDAOImplementation();
                book = bookdao.getBookByProductID(productID);

                session.setAttribute("editbook", book);

                session.setAttribute("editaudio", null);
                session.setAttribute("editdvd", null);
                session.setAttribute("editmagazine", null);
            } else if (editproduct.getType().equals("DVD")) {
                DVDBean dvd = new DVDBean();
                DVDDAOInterface dvddao = new DVDDAOImplementation();
                dvd = dvddao.getDVDByProductID(productID);

                session.setAttribute("editdvd", dvd);

                session.setAttribute("editaudio", null);
                session.setAttribute("editbook", null);
                session.setAttribute("editmagazine", null);
            } else if (editproduct.getType().equals("Magazine")) {
                MagazineBean magazine = new MagazineBean();
                MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
                magazine = magazinedao.getMagazineByProductId(productID);
                out.println(productID);
                out.println(magazine.getIssueNo());
                session.setAttribute("editmagazine", magazine);
                
                session.setAttribute("editaudio", null);
                session.setAttribute("editbook", null);
                session.setAttribute("editdvd", null);
            }
            
            session.setAttribute("editproduct", editproduct);
            response.sendRedirect("editproduct.jsp");

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
