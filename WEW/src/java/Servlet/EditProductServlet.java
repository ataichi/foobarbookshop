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
import java.sql.Timestamp;
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

            //if (homeproduct.getAccesscontrol().isEditproduct()) {
            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();

            Timestamp time;
            java.util.Date date = new java.util.Date();
            time = new Timestamp(date.getTime());

            // not sure if customerID or accountID dapat :)
            ProductManagerDAOInterface pdao = new ProductManagerDAOImplementation();

            String prodType = null;
            if (homeproduct.getAccountType().equals("Audio CD Manager")) {
                prodType = "Audio CD";
            } else if (homeproduct.getAccountType().equals("Book Manager")) {
                prodType = "Book";
            } else if (homeproduct.getAccountType().equals("DVD Manager")) {
                prodType = "DVD";
            } else if (homeproduct.getAccountType().equals("Magazine Manager")) {
                prodType = "Magazine";
            }

            int productID = Integer.parseInt(request.getParameter("product"));
            ProductBean editproduct = new ProductBean();
            editproduct = pdao.getProductById(productID);

            String activity = "Edit " + editproduct.getType() + " " + "product ID " + productID;
            log.setActivity(activity);
            log.setLog_accountID(homeproduct.getAccountID());
            log.setTime(time);
            log.setIp_address(request.getRemoteAddr());
            if (editproduct.getType().equals("Audio CD")) {
                log.setStatus("successful");
                AudioCDBean audiocd = new AudioCDBean();
                AudioCDManagerDAOInterface audiodao = new AudioCDManagerDAOImplementation();
                audiocd = audiodao.getAudioCDByProductID(productID);

                session.setAttribute("editaudio", audiocd);

                session.setAttribute("editbook", null);
                session.setAttribute("editdvd", null);
                session.setAttribute("editmagazine", null);
                session.setAttribute("editproduct", editproduct);
                response.sendRedirect("editproduct.jsp");
            } else if (editproduct.getType().equals("Book")) {
                log.setStatus("successful");
                BookBean book = new BookBean();
                BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();
                book = bookdao.getBookByProductID(productID);

                session.setAttribute("editbook", book);

                session.setAttribute("editaudio", null);
                session.setAttribute("editdvd", null);
                session.setAttribute("editmagazine", null);
                session.setAttribute("editproduct", editproduct);
                response.sendRedirect("editproduct.jsp");
            } else if (editproduct.getType().equals("DVD")) {
                log.setStatus("successful");
                DVDBean dvd = new DVDBean();
                DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();
                dvd = dvddao.getDVDByProductID(productID);

                session.setAttribute("editdvd", dvd);

                session.setAttribute("editaudio", null);
                session.setAttribute("editbook", null);
                session.setAttribute("editmagazine", null);
                session.setAttribute("editproduct", editproduct);
                response.sendRedirect("editproduct.jsp");
            } else if (editproduct.getType().equals("Magazine")) {
                log.setStatus("successful");
                MagazineBean magazine = new MagazineBean();
                MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
                magazine = magazinedao.getMagazineByProductID(productID);
                out.println(productID);
                out.println(magazine.getDatePublished());
                session.setAttribute("editmagazine", magazine);

                session.setAttribute("editaudio", null);
                session.setAttribute("editbook", null);
                session.setAttribute("editdvd", null);
                session.setAttribute("editproduct", editproduct);
                response.sendRedirect("editproduct.jsp");
            } else {
                //set cookies
                log.setStatus("failed");
                response.sendRedirect("productmanagerHOME.jsp");
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
