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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            String searchstring = AccountDAOImplementation.inputSanitizer(request.getParameter("srch-term"));
            ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
            ArrayList<ProductBean> finalproductlist = new ArrayList<ProductBean>();
            ProductDAOInterface productdao = new ProductDAOImplementation();
            ProductBean productbean = new ProductBean();

            if (homeproduct.getAccountID() != 0) { // product manager searches for a product
                out.println("here");
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

                if (prodType.equals("Book")) { //book manager
                    BookManagerDAOInterface bookmanagerdao = new BookManagerDAOImplementation();
                    BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();
                    ArrayList<BookBean> booklist = new ArrayList<BookBean>();
                    BookBean bookbean = new BookBean();
                    ArrayList<BookBean> finalbooklist = new ArrayList<BookBean>();

                    out.println("Produhjhjct:");
                    out.println("title:");
                    productlist = productdao.getProductsByTitle(searchstring);
                    for (int i = 0; i < productlist.size(); i++) {
                        if (productlist.get(i).getType().equals("Book")) {
                            productbean = productlist.get(i);
                            finalproductlist.add(productbean);
                            bookbean = bookmanagerdao.getBookByProductID(productbean.getProductID());
                            finalbooklist.add(bookbean);
                            out.println(productlist.get(i).getProductID() + ":" + productlist.get(i).getTitle());
                        }
                    }

                    out.println("\nSummary:");
                    productlist = productdao.getProductsBySummary(searchstring);
                    for (int i = 0; i < productlist.size(); i++) {
                        if (productlist.get(i).getType().equals("Book")) {
                            productbean = productlist.get(i);
                            finalproductlist.add(productbean);
                            bookbean = bookmanagerdao.getBookByProductID(productbean.getProductID());
                            finalbooklist.add(bookbean);
                            out.println(productlist.get(i).getTitle() + productlist.get(i).getSummary());
                        }
                    }
                    out.println("Genre:");
                    productlist = productdao.getProductsByGenre(searchstring);

                    for (int i = 0; i < productlist.size(); i++) {
                        if (productlist.get(i).getType().equals("Book")) {
                            productbean = productlist.get(i);
                            finalproductlist.add(productbean);
                            bookbean = bookmanagerdao.getBookByProductID(productbean.getProductID());
                            finalbooklist.add(bookbean);
                            out.println(productlist.get(i).getTitle() + productlist.get(i).getGenre());
                        }
                    }

                    out.println("\n\nBOOKS:");

                    booklist = bookdao.getBookByAuthor(searchstring);
                    out.println("\nAuthor:");
                    for (int i = 0; i < booklist.size(); i++) {
                        productbean = productdao.getProductById(booklist.get(i).getBook_productID());
                        finalproductlist.add(productbean);
                        bookbean = bookmanagerdao.getBookByProductID(productbean.getProductID());
                        finalbooklist.add(bookbean);
                        out.println(productbean.getTitle() + booklist.get(i).getAuthor());
                    }

                    booklist = bookdao.getBookByPublisher(searchstring);
                    out.println("\nPublisher");
                    for (int i = 0; i < booklist.size(); i++) {
                        productbean = productdao.getProductById(booklist.get(i).getBook_productID());
                        finalproductlist.add(productbean);
                        bookbean = bookmanagerdao.getBookByProductID(productbean.getProductID());
                        finalbooklist.add(bookbean);
                        out.println(productbean.getTitle() + booklist.get(i).getPublisher());
                    }

                    //datePublished
                    session.setAttribute("booklist", finalbooklist);
                    session.setAttribute("prodType", prodType);
                    session.setAttribute("searchproductlist", finalproductlist);
                    response.sendRedirect("productmanagerSearchProduct.jsp");

                } else if (prodType.equals("Audio CD")) { // audio cd manager
                    //     AudioCDManagerDAOInterface cddao = new AudioCDManagerDAOImplementation();
                    AudioCDManagerDAOInterface audiocddao = new AudioCDManagerDAOImplementation();
                    ArrayList<AudioCDBean> audiolist = new ArrayList<AudioCDBean>();
                    ArrayList<AudioCDBean> finalaudiolist = new ArrayList<AudioCDBean>();
                    AudioCDBean audiocdbean = new AudioCDBean();

                    out.println("Product:");
                    out.println("title:");
                    productlist = productdao.getProductsByTitle(searchstring);
                    for (int i = 0; i < productlist.size(); i++) {
                        if (productlist.get(i).getType().equals("Audio CD")) {
                            productbean = productlist.get(i);
                            finalproductlist.add(productbean);
                            audiocdbean = audiocddao.getAudioCDByProductID(productbean.getProductID());
                            finalaudiolist.add(audiocdbean);
                            out.println(productlist.get(i).getProductID() + ":" + productlist.get(i).getTitle());
                        }
                    }

                    out.println("\nSummary:");
                    productlist = productdao.getProductsBySummary(searchstring);
                    for (int i = 0; i < productlist.size(); i++) {
                        if (productlist.get(i).getType().equals("Audio CD")) {
                            productbean = productlist.get(i);
                            finalproductlist.add(productbean);
                            audiocdbean = audiocddao.getAudioCDByProductID(productbean.getProductID());
                            finalaudiolist.add(audiocdbean);
                            out.println(productlist.get(i).getTitle() + productlist.get(i).getSummary());
                        }
                    }
                    out.println("Genre:");
                    productlist = productdao.getProductsByGenre(searchstring);

                    for (int i = 0; i < productlist.size(); i++) {
                        if (productlist.get(i).getType().equals("Audio CD")) {
                            productbean = productlist.get(i);
                            finalproductlist.add(productbean);
                            audiocdbean = audiocddao.getAudioCDByProductID(productbean.getProductID());
                            finalaudiolist.add(audiocdbean);
                            out.println(productlist.get(i).getTitle() + productlist.get(i).getGenre());
                        }
                    }

                    out.println("\n\nAUDIO CD:");

                    audiolist = audiocddao.getAudioCDByArtist(searchstring);
                    out.println("\nArtist");
                    for (int i = 0; i < audiolist.size(); i++) {
                        productbean = productdao.getProductById(audiolist.get(i).getAudiocd_productID());
                        finalproductlist.add(productbean);
                        audiocdbean = audiocddao.getAudioCDByProductID(productbean.getProductID());
                        finalaudiolist.add(audiocdbean);
                        out.println(productbean.getTitle() + audiolist.get(i).getArtist());
                    }

                    audiolist = audiocddao.getAudioCDByRecordCompany(searchstring);
                    out.println("\nRecord Company:");
                    for (int i = 0; i < audiolist.size(); i++) {
                        productbean = productdao.getProductById(audiolist.get(i).getAudiocd_productID());

                        finalproductlist.add(productbean);

                        audiocdbean = audiocddao.getAudioCDByProductID(productbean.getProductID());
                        finalaudiolist.add(audiocdbean);
                        out.println(productbean.getTitle() + audiolist.get(i).getRecordCompany());
                    }

                    session.setAttribute("audiolist", finalaudiolist);
                    session.setAttribute("prodType", prodType);
                    session.setAttribute("searchproductlist", finalproductlist);
                    response.sendRedirect("productmanagerSearchProduct.jsp");
                } else if (prodType.equals("DVD")) { //dvd manager
                    DVDManagerDAOInterface dvdmanagerdao = new DVDManagerDAOImplementation();
                    DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();
                    ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
                    ArrayList<DVDBean> finaldvdlist = new ArrayList<DVDBean>();
                    DVDBean dvdbean = new DVDBean();

                    out.println("Product:");
                    out.println("title:");
                    productlist = productdao.getProductsByTitle(searchstring);
                    for (int i = 0; i < productlist.size(); i++) {
                        if (productlist.get(i).getType().equals("DVD")) {
                            productbean = productlist.get(i);
                            finalproductlist.add(productbean);
                            dvdbean = dvdmanagerdao.getDVDByProductID(productbean.getProductID());
                            finaldvdlist.add(dvdbean);
                            out.println(productlist.get(i).getProductID() + ":" + productlist.get(i).getTitle());
                        }
                    }

                    out.println("\nSummary:");
                    productlist = productdao.getProductsBySummary(searchstring);
                    for (int i = 0; i < productlist.size(); i++) {
                        if (productlist.get(i).getType().equals("DVD")) {
                            productbean = productlist.get(i);
                            finalproductlist.add(productbean);
                            dvdbean = dvdmanagerdao.getDVDByProductID(productbean.getProductID());
                            finaldvdlist.add(dvdbean);
                            out.println(productlist.get(i).getTitle() + productlist.get(i).getSummary());
                        }
                    }
                    out.println("Genre:");
                    productlist = productdao.getProductsByGenre(searchstring);

                    for (int i = 0; i < productlist.size(); i++) {
                        if (productlist.get(i).getType().equals("DVD")) {
                            productbean = productlist.get(i);
                            finalproductlist.add(productbean);
                            dvdbean = dvdmanagerdao.getDVDByProductID(productbean.getProductID());
                            finaldvdlist.add(dvdbean);
                            out.println(productlist.get(i).getTitle() + productlist.get(i).getGenre());
                        }
                    }

                    out.println("\n\nDVD:");

                    dvdlist = dvddao.getDVDByActor(searchstring);
                    out.println("\nActor");
                    for (int i = 0; i < dvdlist.size(); i++) {
                        productbean = productdao.getProductById(dvdlist.get(i).getDvd_productID());
                        if (productbean != null) {
                            finalproductlist.add(productbean);
                            dvdbean = dvdmanagerdao.getDVDByProductID(productbean.getProductID());
                            finaldvdlist.add(dvdbean);
                        }
                        out.println(productbean.getTitle() + dvdlist.get(i).getMainActors());
                    }

                    dvdlist = dvddao.getDVDByDirector(searchstring);
                    out.println("\nDirector");
                    for (int i = 0; i < dvdlist.size(); i++) {
                        productbean = productdao.getProductById(dvdlist.get(i).getDvd_productID());
                        if (productbean != null) {
                            finalproductlist.add(productbean);
                            dvdbean = dvdmanagerdao.getDVDByProductID(productbean.getProductID());
                            finaldvdlist.add(dvdbean);
                        }
                        out.println(productbean.getTitle() + dvdlist.get(i).getDirector());
                    }

                    dvdlist = dvddao.getDVDByProducer(searchstring);
                    out.println("\nProduction Company:");
                    for (int i = 0; i < dvdlist.size(); i++) {
                        productbean = productdao.getProductById(dvdlist.get(i).getDvd_productID());
                        if (productbean != null) {
                            finalproductlist.add(productbean);
                            dvdbean = dvdmanagerdao.getDVDByProductID(productbean.getProductID());
                            finaldvdlist.add(dvdbean);
                        }
                        out.println(productbean.getTitle() + dvdlist.get(i).getProductionCompany());
                    }

                    session.setAttribute("prodType", prodType);
                    session.setAttribute("dvdlist", finaldvdlist);
                    session.setAttribute("searchproductlist", finalproductlist);
                    response.sendRedirect("productmanagerSearchProduct.jsp");
                } else if (prodType.equals("Magazine")) { //magazine manager
                    MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
                    ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();
                    ArrayList<MagazineBean> finalmagazinelist = new ArrayList<MagazineBean>();
                    MagazineBean magazinebean = new MagazineBean();

                    out.println("Product:");
                    out.println("title:");
                    productlist = productdao.getProductsByTitle(searchstring);
                    for (int i = 0; i < productlist.size(); i++) {
                        if (productlist.get(i).getType().equals("Magazine")) {
                            productbean = productlist.get(i);
                            finalproductlist.add(productbean);
                            magazinebean = magazinedao.getMagazineByProductID(productbean.getProductID());
                            finalmagazinelist.add(magazinebean);
                            out.println(productlist.get(i).getProductID() + ":" + productlist.get(i).getTitle());
                        }
                    }

                    out.println("\nSummary:");
                    productlist = productdao.getProductsBySummary(searchstring);
                    for (int i = 0; i < productlist.size(); i++) {
                        if (productlist.get(i).getType().equals("Magazine")) {
                            productbean = productlist.get(i);
                            finalproductlist.add(productbean);
                            magazinebean = magazinedao.getMagazineByProductID(productbean.getProductID());
                            finalmagazinelist.add(magazinebean);
                            out.println(productlist.get(i).getTitle() + productlist.get(i).getSummary());
                        }
                    }
                    out.println("Genre:");
                    productlist = productdao.getProductsByGenre(searchstring);

                    for (int i = 0; i < productlist.size(); i++) {
                        if (productlist.get(i).getType().equals("Magazine")) {
                            productbean = productlist.get(i);
                            finalproductlist.add(productbean);
                            magazinebean = magazinedao.getMagazineByProductID(productbean.getProductID());
                            finalmagazinelist.add(magazinebean);
                            out.println(productlist.get(i).getTitle() + productlist.get(i).getGenre());
                        }
                    }

                    out.println("\n\nMagazine");

                    out.println("\nIssue No:");
                    /*
                     - convert stringsearch to integer
                     magazinelist=magazinedao.getMagazineByIssueNo(stringsearch);
                     for(int i=0;i<magazinelist.size();i++){
                     productbean=productdao.getProductById(magazinelist.get(i).getMagazine_productID());
                     out.println(productbean.getTitle()+magazinelist.get(i).getIssueNo());
                     }
                     */

                    out.println("\nVolume No:");
                    /*
                     -convert stringsearch to integer
                     magazinelist = magazinedao.getMagazineByIssueNo(stringsearch);
                     for(int i=0;i<magazinelist.size();i++){
                     productbean = productdao.getProductById(magazinelist.get(i).getMagazine_productID());
                     out.println(productbean.getTitle()+magazinelist.get(i).getVolumeNo());
                     }
                     */

                    out.println("\nPublisher");
                    magazinelist = magazinedao.getMagazineByPublisher(searchstring);
                    for (int i = 0; i < magazinelist.size(); i++) {
                        productbean = productdao.getProductById(magazinelist.get(i).getMagazine_productID());
                        if (productbean != null) {
                            finalproductlist.add(productbean);
                            magazinebean = magazinedao.getMagazineByProductID(productbean.getProductID());
                            finalmagazinelist.add(magazinebean);
                        }
                        out.println(productbean.getTitle() + magazinelist.get(i).getPublisher());
                    }

                    //productlist = pdao.getProductsByType(prodType);
                    session.setAttribute("prodType", prodType);
                    session.setAttribute("magazinelist", finalmagazinelist);
                    session.setAttribute("searchproductlist", productlist);
                    response.sendRedirect("productmanagerSearchProduct.jsp");
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
