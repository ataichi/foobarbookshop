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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            String address = request.getRemoteAddr();
            AccountBean homeproduct = (AccountBean) session.getAttribute("homeproduct");

            //if (homeproduct.getAccesscontrol().isDeleteproduct()) {
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
            log.setIp_address(address);

            log.setLog_accountID(homeproduct.getAccountID());
            java.util.Date date = new java.util.Date();
            Timestamp time = new Timestamp(date.getTime());
            log.setTime(time);
            log.setIp_address(request.getRemoteAddr());
            log.setStatus("Successful");
            if (type.equals("Audio CD")) {
                AudioCDBean removeaudio = new AudioCDBean();
                AudioCDManagerDAOInterface audiodao = new AudioCDManagerDAOImplementation();
                removeaudio = audiodao.getAudioCDByProductID(productID);
                ArrayList<AudioCDBean> cdlist = new ArrayList<AudioCDBean>();

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

            } else if (type.equals("Book")) {
                BookBean removebook = new BookBean();
                BookManagerDAOInterface bookmanagerdao = new BookManagerDAOImplementation();
                BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();
                removebook = bookdao.getBookByProductID(productID);
                ArrayList<BookBean> booklist = new ArrayList<BookBean>();

                check_removespecificproduct = bookmanagerdao.deleteBook(removebook.getBookID());
                if (check_removespecificproduct) {
                    check_removeproduct = pdao.removeProduct(productID);

                    if (check_removeproduct) {
                        booklist = bookmanagerdao.getAllBooks();
                        plist = pdao.getProductsByType(type);

                        if (logdao.addLog(log)) {
                            session.setAttribute("booklist", booklist);
                            session.setAttribute("productlist", plist);

                            out.println("delete book");
                            response.sendRedirect("productmanagerHOME.jsp");
                        }
                    } else {
                        out.println("failed to remove book");
                        //response.sendRedirect("productmanagerHOME.jsp");
                    }
                }
            } else if (type.equals("DVD")) {
                DVDBean removedvd = new DVDBean();
                DVDManagerDAOInterface dvdmanagerdao = new DVDManagerDAOImplementation();
                DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();
                removedvd = dvddao.getDVDByProductID(productID);
                ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();

                check_removespecificproduct = dvdmanagerdao.deleteDVD(removedvd.getDvdID());
                if (check_removespecificproduct) {
                    check_removeproduct = pdao.removeProduct(productID);

                    if (check_removeproduct) {
                        //dvdlist = dvddao.deleteDVD();
                        plist = pdao.getProductsByType(type);

                        if (logdao.addLog(log)) {
                            session.setAttribute("dvdlist", dvdlist);
                            session.setAttribute("productlist", plist);
                            out.println("delete dvd");
                            response.sendRedirect("productmanagerHOME.jsp");
                        }
                    } else {
                        out.println("failed to remove dvd");
                        //response.sendRedirect("productmanagerHOME.jsp");
                    }
                }

            } else if (type.equals("Magazine")) {
                MagazineBean removemagazine = new MagazineBean();
                MagazineManagerDAOInterface magazinemanagerdao = new MagazineManagerDAOImplementation();
                MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
                removemagazine = magazinedao.getMagazineByProductID(productID);

                check_removespecificproduct = magazinemanagerdao.deleteMagazine(removemagazine.getMagazineID());
                if (check_removespecificproduct) {
                    check_removeproduct = pdao.removeProduct(productID);

                    if (check_removeproduct) {
                        out.println("delete magazine");
                        ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();
                        magazinelist = magazinemanagerdao.getAllMagazine();
                        plist = pdao.getProductsByType(type);

                        if (logdao.addLog(log)) {
                            session.setAttribute("productlist", plist);
                            session.setAttribute("magazinelist", magazinelist);

                            response.sendRedirect("productmanagerHOME.jsp");
                        }
                    } else {
                        out.println("failed to remove magazine");
                        //response.sendRedirect("productmanagerHOME.jsp");
                    }
                }
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
