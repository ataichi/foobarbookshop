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

@WebServlet(name = "AddProductServlet", urlPatterns = {"/AddProductServlet"})
public class AddProductServlet extends HttpServlet {

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

            if (homeproduct.getAccesscontrol().isAddproduct()) {
                ProductManagerDAOImplementation pdao = new ProductManagerDAOImplementation();
                LogBean log = new LogBean();
                LogDAOInterface logdao = new LogDAOImplementation();

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

                ProductBean product = new ProductBean();
                String type, title, summary, genre;
                double price;
                int year, numberStocks;

                type = prodType;
                title = request.getParameter("productTitle");
                summary = request.getParameter("productSummary");
                genre = request.getParameter("productGenre");
                price = Double.parseDouble(request.getParameter("productPrice"));
                year = Integer.parseInt(request.getParameter("productYear"));
                numberStocks = Integer.parseInt(request.getParameter("productStocks"));

                product.setGenre(genre);
                product.setNumberStocks(numberStocks);
                product.setPrice(price);
                product.setSummary(summary);
                product.setTitle(title);
                product.setType(type);
                product.setYear(year);

                log.setIp_address(address);
                boolean addProduct = false;

                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());

                log.setLog_accountID(homeproduct.getAccountID());
                log.setTime(time);

                if (type.equals("Audio CD")) {// add audio cd
                    log.setActivity("Add Audio CD");

                    AudioCDManagerDAOInterface cdao = new AudioCDManagerDAOImplementation();
                    AudioCDBean cd = new AudioCDBean();
                    String artist = null, recordCompany = null;

                    artist = request.getParameter("cdArtist");
                    recordCompany = request.getParameter("cdRecord");

                    boolean addCD = false;

                    addProduct = pdao.addProduct(product);
                    product = pdao.getLastProduct();

                    cd.setArtist(artist);
                    cd.setRecordCompany(recordCompany);
                    cd.setAudiocd_productID(product.getProductID());

                    addCD = cdao.addAudioCD(cd);

                    if (addProduct && addCD) { // success
                        log.setStatus("successful");
                        logdao.addLog(log);
                        ArrayList<AudioCDBean> cdlist = cdao.getAllAudioCD();
                        ArrayList<ProductBean> plist = pdao.getProductsByType(type);

                        session.setAttribute("audiocdlist", cdlist);
                        session.setAttribute("productlist", plist);
                        response.sendRedirect("productmanagerHOME.jsp");
                    } else { // may error
                        log.setStatus("failed");
                        logdao.addLog(log);
                        response.sendRedirect("addproduct.jsp");
                    }

                } else if (type.equals("Book")) {// add books
                    log.setActivity("Add Book");
                    BookManagerDAOInterface bdao = new BookManagerDAOImplementation();

                    BookBean book = new BookBean();
                    String author, publisher, bookDatePublished;
                    java.util.Date date1;
                    java.sql.Date sqlDate;

                    author = request.getParameter("bookAuthor");
                    publisher = request.getParameter("bookPublisher");
                    DateFormat formatter;
                    bookDatePublished = request.getParameter("bookDatePublished");

                    addProduct = pdao.addProduct(product);
                    product = pdao.getLastProduct();

                    formatter = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        date1 = formatter.parse(bookDatePublished);
                        sqlDate = new java.sql.Date(date1.getTime());
                        book.setDatePublished(sqlDate);
                    } catch (ParseException ex) {
                        Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    boolean addBook = false;
                    book.setAuthor(author);
                    book.setPublisher(publisher);
                    int book_productID = product.getProductID();
                    book.setBook_productID(book_productID);
                    addBook = bdao.addBook(book);

                    if (addProduct && addBook) { //success
                        log.setStatus("successful");
                        logdao.addLog(log);
                        ArrayList<BookBean> booklist = new ArrayList<BookBean>();
                        booklist = bdao.getAllBooks();
                        ArrayList<ProductBean> plist = pdao.getProductsByType(type);

                        session.setAttribute("booklist", booklist);
                        session.setAttribute("productlist", plist);
                        response.sendRedirect("productmanagerHOME.jsp");
                    } else { //error
                        log.setStatus("failed");
                        logdao.addLog(log);
                        out.println("productmanagerHOME.jsp");
                    }

                } else if (type.equals("DVD")) {// add dvd
                    log.setActivity("Add DVD");
                    DVDBean bean = new DVDBean();
                    DVDManagerDAOInterface ddao = new DVDManagerDAOImplementation();

                    addProduct = pdao.addProduct(product);

                    int dvd_productID;
                    String director, actors, productCompany;

                    director = request.getParameter("dvdDirector");
                    actors = request.getParameter("dvdActor");
                    productCompany = request.getParameter("dvdProducer");

                    bean.setDirector(director);
                    bean.setMainActors(actors);
                    bean.setProductionCompany(productCompany);
                    product = pdao.getLastProduct();
                    dvd_productID = product.getProductID();
                    bean.setDvd_productID(dvd_productID);

                    boolean addDvd = ddao.addDVD(bean);

                    if (addProduct && addDvd) {//successfully added product
                        log.setStatus("successful");
                        logdao.addLog(log);
                        ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
                        dvdlist = ddao.viewAllDVD();
                        ArrayList<ProductBean> plist = pdao.getProductsByType(type);

                        session.setAttribute("dvdlist", dvdlist);
                        session.setAttribute("productlist", plist);
                        response.sendRedirect("productmanagerHOME.jsp");
                    } else { //error
                        log.setStatus("failed");
                        logdao.addLog(log);
                        response.sendRedirect("productmanagerHOME.jsp");

                    }

                } else if (type.equals("Magazine")) {// add magazine
                    log.setActivity("Add Magazine");
                    MagazineBean bean = new MagazineBean();
                    MagazineManagerDAOInterface mdao = new MagazineManagerDAOImplementation();

                    addProduct = pdao.addProduct(product);

                    int magazine_productID;
                    String publisher, datePublished;
                    int volumeNo, issueNo;
                    java.util.Date date1;
                    java.sql.Date sqlDate;

                    product = pdao.getLastProduct();
                    magazine_productID = product.getProductID();

                    DateFormat formatter;
                    datePublished = request.getParameter("magazineDate");
                    formatter = new SimpleDateFormat("yyyy-MM-dd");

                    try {
                        date = formatter.parse(datePublished);
                        sqlDate = new java.sql.Date(date.getTime());
                        bean.setDatePublished(sqlDate);
                    } catch (ParseException ex) {
                        Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    publisher = request.getParameter("magazinePublisher");
                    volumeNo = Integer.parseInt(request.getParameter("magazineVolume"));
                    issueNo = Integer.parseInt(request.getParameter("magazineIssue"));

                    bean.setMagazine_productID(magazine_productID);
                    bean.setPublisher(publisher);
                    bean.setVolumeNo(volumeNo);
                    bean.setIssueNo(issueNo);

                    boolean addMagazine = mdao.addMagazine(bean);

                    if (addProduct && addMagazine) {
                        log.setStatus("successful");
                        logdao.addLog(log);
                        ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();
                        ArrayList<ProductBean> plist = pdao.getProductsByType(type);
                        magazinelist = mdao.getAllMagazine();

                        session.setAttribute("magazinelist", magazinelist);
                        session.setAttribute("productlist", plist);
                        response.sendRedirect("productmanagerHOME.jsp");
                    } else {
                        log.setStatus("failed");
                        logdao.addLog(log);
                        response.sendRedirect("addproduct.jsp");
                    }
                } else {
                    log.setActivity("Add Product");
                    log.setStatus("failed");
                    logdao.addLog(log);
                    response.sendRedirect("productmanagerHOME.jsp");
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
