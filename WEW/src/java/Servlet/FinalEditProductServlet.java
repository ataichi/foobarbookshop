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
import DAO.Implementation.AudioCDManagerDAOImplementation;
import DAO.Implementation.BookManagerDAOImplementation;
import DAO.Implementation.DVDManagerDAOImplementation;
import DAO.Implementation.MagazineManagerDAOImplementation;
import DAO.Implementation.ProductManagerDAOImplementation;
import DAO.Interface.AudioCDManagerDAOInterface;
import DAO.Interface.BookManagerDAOInterface;
import DAO.Interface.DVDManagerDAOInterface;
import DAO.Interface.MagazineManagerDAOInterface;
import DAO.Interface.ProductManagerDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
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
            AccountBean homeproduct = (AccountBean) session.getAttribute("homeproduct");
            ProductBean editproduct = (ProductBean) session.getAttribute("editproduct");
            ProductManagerDAOInterface productdao = new ProductManagerDAOImplementation();
            out.println(editproduct.getProductID());
            ArrayList<ProductBean> productlist = (ArrayList<ProductBean>) session.getAttribute("productlist");

            String type, title, summary, genre;
            double price;
            int year, numberStocks;

            type = editproduct.getType();
            title = request.getParameter("productTitle");
            summary = request.getParameter("productSummary");
            genre = request.getParameter("productGenre");
            price = Double.parseDouble(request.getParameter("productPrice"));
            year = Integer.parseInt(request.getParameter("productYear"));
            numberStocks = Integer.parseInt(request.getParameter("productStocks"));

            editproduct.setTitle(title);
            editproduct.setSummary(summary);
            editproduct.setGenre(genre);
            editproduct.setPrice(price);
            editproduct.setYear(year);
            editproduct.setNumberStocks(numberStocks);
            editproduct.setProductID(editproduct.getProductID());

            if (type.equals("Audio CD")) {

                AudioCDBean audiocd = new AudioCDBean();
                AudioCDManagerDAOInterface audiodao = new AudioCDManagerDAOImplementation();
                audiocd = audiodao.getAudioCDByProductId(editproduct.getProductID());

                String cdArtist = request.getParameter("cdArtist");
                String cdRecord = request.getParameter("cdRecord");

                audiocd.setArtist(cdArtist);
                audiocd.setRecordCompany(cdRecord);

                boolean editProduct = productdao.editProduct(editproduct);
                boolean editCD = audiodao.editAudioCD(audiocd);

                out.println(editProduct);
                out.println(editCD);

                if (editProduct && editCD) {
                    productlist = productdao.getProductsByType(type);
                    session.setAttribute("productlist", productlist);
                    response.sendRedirect("productmanagerHOME.jsp");
                } else {
                    out.println("fail");
                }
            } else if (type.equals("Books")) {
                BookBean book = new BookBean();

                BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();
                book = bookdao.getBookByProductId(editproduct.getProductID());

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
                    book.setDatePublished(sqlDate);
                    out.println(formatter.format(sqlDate));
                } catch (ParseException ex) {
                    Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                boolean editProduct = productdao.editProduct(editproduct);
                boolean editBook = bookdao.editBook(book);

                out.println(editProduct);
                out.println(editBook);

                if (editProduct && editBook) {
                    productlist = productdao.getProductsByType(type);
                    session.setAttribute("productlist", productlist);
                    response.sendRedirect("productmanagerHOME.jsp");
                } else {
                    out.println("fail");
                }

            } else if (type.equals("DVD")) {

                DVDBean dvd = new DVDBean();
                DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();
                dvd = dvddao.getDVDByProductId(editproduct.getProductID());

                String director, actor, productCompany;

                director = request.getParameter("dvdDirector");
                actor = request.getParameter("dvdActor");
                productCompany = request.getParameter("dvdProducer");

                boolean editProduct = productdao.editProduct(editproduct);
                boolean editDVD = dvddao.editDVD(dvd);

                out.println(editProduct);
                out.println(editDVD);

                if (editProduct && editDVD) {
                    productlist = productdao.getProductsByType(type);
                    session.setAttribute("productlist", productlist);
                    response.sendRedirect("productmanagerHOME.jsp");
                } else {
                    out.println("fail");
                }

            } else if (type.equals("Magazine")) {

                MagazineBean magazine = new MagazineBean();
                MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
                magazine = magazinedao.getMagazineByProductId(editproduct.getProductID());

                int volumeNo, issueNo;
                String publisher, datePublished;
                java.util.Date date;
                java.sql.Date sqlDate;

                volumeNo = Integer.valueOf(request.getParameter("magazineVolume"));
                issueNo = Integer.valueOf(request.getParameter("magazineIssue"));
                datePublished = request.getParameter("magazineDate");

                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = formatter.parse(datePublished);
                    sqlDate = new java.sql.Date(date.getTime());
                    magazine.setDatePublished(sqlDate);
                    out.println(formatter.format(sqlDate));
                } catch (ParseException ex) {
                    Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                boolean editProduct = productdao.editProduct(editproduct);
                boolean editMagazine = magazinedao.editMagazine(magazine);

                out.println(editProduct);
                out.println(editMagazine);

                if (editProduct && editMagazine) {
                    productlist = productdao.getProductsByType(type);
                    session.setAttribute("productlist", productlist);
                    response.sendRedirect("productmanagerHOME.jsp");
                } else {
                    out.println("fail");
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
