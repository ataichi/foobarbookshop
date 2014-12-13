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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FinalEditProductServlet", urlPatterns = {"/FinalEditProductServlet"})
public class FinalEditProductServlet extends HttpServlet {

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

            //if (homeproduct.getAccesscontrol().isEditproduct()) {
            ProductBean editproduct = (ProductBean) session.getAttribute("editproduct");
            ProductManagerDAOInterface productdao = new ProductManagerDAOImplementation();
            out.println(editproduct.getProductID());
            ArrayList<ProductBean> productlist = (ArrayList<ProductBean>) session.getAttribute("productlist");

            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();

            String type, title, summary, genre;
            double price;
            int year, numberStocks;

            type = editproduct.getType();
            title = AccountDAOImplementation.inputSanitizer(request.getParameter("productTitle"));
            summary = AccountDAOImplementation.inputSanitizer(request.getParameter("productSummary"));
            genre = AccountDAOImplementation.inputSanitizer(request.getParameter("productGenre"));
            price = Double.parseDouble(request.getParameter("productPrice"));
            year = Integer.parseInt(AccountDAOImplementation.inputSanitizer(request.getParameter("productYear")));
            numberStocks = Integer.parseInt(AccountDAOImplementation.inputSanitizer(request.getParameter("productStocks")));

            editproduct.setTitle(title);
            editproduct.setSummary(summary);
            editproduct.setGenre(genre);
            editproduct.setPrice(price);
            editproduct.setYear(year);
            editproduct.setNumberStocks(numberStocks);
            editproduct.setProductID(editproduct.getProductID());

            log.setLog_accountID(homeproduct.getAccountID());
            java.util.Date date1 = new java.util.Date();
            Timestamp time = new Timestamp(date1.getTime());
            log.setTime(time);
            log.setIp_address(address);
            log.setActivity("Edit " + editproduct.getTitle() + " Type: " + editproduct.getType());

            if (type.equals("Audio CD")) {

                AudioCDBean audiocd = new AudioCDBean();
                AudioCDManagerDAOInterface audiodao = new AudioCDManagerDAOImplementation();
                AudioCDManagerDAOInterface audiomanagerdao = new AudioCDManagerDAOImplementation();
                audiocd = audiodao.getAudioCDByProductID(editproduct.getProductID());

                String cdArtist = request.getParameter("cdArtist");
                String cdRecord = request.getParameter("cdRecord");

                audiocd.setArtist(cdArtist);
                audiocd.setRecordCompany(cdRecord);

                boolean editProduct = productdao.editProduct(editproduct);
                boolean editCD = audiomanagerdao.editAudioCD(audiocd);

                if (editProduct && editCD) {
                    productlist = productdao.getProductsByType(type);
                    log.setStatus("Successful");
                    logdao.addLog(log);

                    session.setAttribute("productlist", productlist);
                    response.sendRedirect("productmanagerHOME.jsp");
                } else {
                    log.setStatus("failed");
                    logdao.addLog(log);
                    response.sendRedirect("editproduct.jsp");
                }
            } else if (type.equals("Book")) {
                BookBean book = new BookBean();

                BookManagerDAOInterface bookmanagerdao = new BookManagerDAOImplementation();
                BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();
                book = bookdao.getBookByProductID(editproduct.getProductID());

                String author, publisher, bookDatePublished;
                java.util.Date date;
                java.sql.Date sqlDate;

                author = request.getParameter("bookAuthor");
                publisher = request.getParameter("bookPublisher");
                DateFormat formatter;
                bookDatePublished = request.getParameter("bookDatePublished");

                book.setAuthor(author);
                book.setPublisher(publisher);

                formatter = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = formatter.parse(bookDatePublished);
                    sqlDate = new java.sql.Date(date.getTime());
                    out.println(formatter.format(sqlDate));

                    book.setDatePublished(sqlDate);
                    book.setAuthor(author);
                    book.setBookID(book.getBookID());
                    book.setBook_productID(book.getBook_productID());
                    book.setPublisher(publisher);
                } catch (ParseException ex) {
                    Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                boolean editProduct = productdao.editProduct(editproduct);
                boolean editBook = bookmanagerdao.editBook(book);

                if (editProduct && editBook) {
                    log.setStatus("successful");
                    logdao.addLog(log);
                    productlist = productdao.getProductsByType(type);
                    session.setAttribute("productlist", productlist);
                    response.sendRedirect("productmanagerHOME.jsp");
                } else {
                    log.setStatus("failed");
                    logdao.addLog(log);
                    response.sendRedirect("editproduct.jsp");
                }

            } else if (type.equals("DVD")) {

                DVDBean dvd = new DVDBean();
                DVDManagerDAOInterface dvdmanagerdao = new DVDManagerDAOImplementation();
                DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();
                dvd = dvddao.getDVDByProductID(editproduct.getProductID());

                String director, actor, productCompany;

                director = request.getParameter("dvdDirector");
                actor = request.getParameter("dvdActor");
                productCompany = request.getParameter("dvdProducer");

                dvd.setDirector(director);
                dvd.setDvdID(dvd.getDvdID());
                dvd.setDvd_productID(dvd.getDvd_productID());
                dvd.setMainActors(actor);
                dvd.setProductionCompany(productCompany);

                boolean editProduct = productdao.editProduct(editproduct);
                boolean editDVD = dvdmanagerdao.editDVD(dvd);

                if (editProduct && editDVD) {
                    log.setStatus("successful");
                    logdao.addLog(log);
                    productlist = productdao.getProductsByType(type);
                    session.setAttribute("productlist", productlist);
                    response.sendRedirect("productmanagerHOME.jsp");
                } else {
                    log.setStatus("failed");
                    logdao.addLog(log);
                    response.sendRedirect("editproduct.jsp");
                }

            } else if (type.equals("Magazine")) {

                MagazineBean magazine = new MagazineBean();
                MagazineManagerDAOInterface magazinemanagerdao = new MagazineManagerDAOImplementation();
                MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
                magazine = magazinedao.getMagazineByProductID(editproduct.getProductID());

                int volumeNo, issueNo;
                String publisher, datePublished;
                java.util.Date date;
                java.sql.Date sqlDate;

                volumeNo = Integer.valueOf(request.getParameter("magazineVolume"));
                issueNo = Integer.valueOf(request.getParameter("magazineIssue"));
                datePublished = request.getParameter("magazineDate");
                publisher = request.getParameter("magazinePublisher");

                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = formatter.parse(datePublished);
                    sqlDate = new java.sql.Date(date.getTime());
                    out.println(formatter.format(sqlDate));

                    magazine.setVolumeNo(volumeNo);
                    magazine.setIssueNo(issueNo);
                    magazine.setMagazineID(magazine.getMagazineID());
                    magazine.setMagazine_productID(magazine.getMagazine_productID());
                    magazine.setPublisher(publisher);
                    magazine.setDatePublished(sqlDate);

                } catch (ParseException ex) {
                    Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                boolean editProduct = productdao.editProduct(editproduct);
                boolean editMagazine = magazinemanagerdao.editMagazine(magazine);

                if (editProduct && editMagazine) {
                    log.setStatus("successful");
                    logdao.addLog(log);
                    productlist = productdao.getProductsByType(type);

                    session.setAttribute("productlist", productlist);
                    response.sendRedirect("productmanagerHOME.jsp");
                } else {
                    log.setStatus("failed");
                    logdao.addLog(log);
                    response.sendRedirect("editproduct.jsp");
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
