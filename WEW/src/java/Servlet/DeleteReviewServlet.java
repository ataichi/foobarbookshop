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
import Beans.LogBean;
import Beans.MagazineBean;
import Beans.ProductBean;
import DAO.Implementation.AudioCDManagerDAOImplementation;
import DAO.Implementation.BookManagerDAOImplementation;
import DAO.Implementation.DVDManagerDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Implementation.MagazineManagerDAOImplementation;
import DAO.Implementation.ProductManagerDAOImplementation;
import DAO.Interface.AudioCDManagerDAOInterface;
import DAO.Interface.BookManagerDAOInterface;
import DAO.Interface.DVDManagerDAOInterface;
import DAO.Interface.LogDAOInterface;
import DAO.Interface.MagazineManagerDAOInterface;
import DAO.Interface.ProductManagerDAOInterface;
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
 * @author Juan Paolo A. Coloma
 */
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
            AccountBean homeproduct = (AccountBean) session.getAttribute("homeproduct");
            
           //  if(homeproduct.getAccesscontrol().isDeleteproduct()){
            
            ProductManagerDAOInterface pdao = new ProductManagerDAOImplementation();
            ArrayList<ProductBean> plist = new ArrayList<ProductBean>();

            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();

            int productID = Integer.parseInt(request.getParameter("product"));
            ProductBean removeproduct = pdao.getProductById(productID);
            boolean check_removeproduct = false;
            boolean check_removespecificproduct = false;

            String type = removeproduct.getType();
            log.setActivity("Remove " + type + " " + removeproduct.getTitle());
            if (type.equals("Audio CD")) {
                AudioCDBean removeaudio = new AudioCDBean();
                AudioCDManagerDAOInterface audiodao = new AudioCDManagerDAOImplementation();
                removeaudio = audiodao.getAudioCDByProductID(productID);
                ArrayList<AudioCDBean> cdlist = new ArrayList<AudioCDBean>();

                log.setLog_accountID(homeproduct.getAccountID());
                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());
                log.setTime(time);

                check_removespecificproduct = audiodao.deleteAudioCD(removeaudio.getAudiocdID());
                if (check_removespecificproduct) {
                    check_removeproduct = pdao.removeProduct(productID);

                    if (check_removeproduct) {
                        out.println("delete cd");
                        plist = pdao.getProductsByType(type);
                        cdlist = audiodao.getAllAudioCD();

                        if (logdao.addLog(log)) {
                            session.setAttribute("audiocdlist", cdlist);
                            session.setAttribute("productlist", plist);
                            response.sendRedirect("productmanagerHOME.jsp");
                        }
                    } else {
                        out.println(productID);
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
