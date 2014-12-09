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

@WebServlet(name = "CustomerSearchProductServlet", urlPatterns = {"/CustomerSearchProductServlet"})
public class CustomerSearchProductServlet extends HttpServlet {

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
            AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");

            if (homeuser.getAccesscontrol().isViewproduct()) {
                String searchstring = request.getParameter("srch-term");
                ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
                ArrayList<ProductBean> searchproductlist = new ArrayList<ProductBean>();
                ArrayList<AudioCDBean> searchaudiocdlist = new ArrayList<AudioCDBean>();
                ArrayList<BookBean> searchbooklist = new ArrayList<BookBean>();
                ArrayList<DVDBean> searchdvdlist = new ArrayList<DVDBean>();
                ArrayList<MagazineBean> searchmagazinelist = new ArrayList<MagazineBean>();
                ProductDAOInterface productdao = new ProductDAOImplementation();
                ProductBean productbean = new ProductBean();

                AudioCDManagerDAOInterface audiocddao = new AudioCDManagerDAOImplementation();
                ArrayList<AudioCDBean> audiolist = new ArrayList<AudioCDBean>();
                AudioCDBean audio = new AudioCDBean();

                BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();
                ArrayList<BookBean> booklist = new ArrayList<BookBean>();
                BookBean book = new BookBean();

                DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();
                ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
                DVDBean dvd = new DVDBean();

                MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
                ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();
                MagazineBean magazine = new MagazineBean();

                out.println("Product:\n");
                out.println("title: ");
                productlist = productdao.getProductsByTitle(searchstring);
                int productID;
                out.println(searchstring);
                for (int i = 0; i < productlist.size(); i++) {
                    out.println("pumasok po ako");
                    out.println(productlist.get(i).getProductID() + ":" + productlist.get(i).getTitle());
                    out.println("\n");
                    productID = productlist.get(i).getProductID();
                    if (productlist.get(i).getType().equals("Audio CD")) {
                        out.println("cd po ako");
                        audio = audiocddao.getAudioCDByProductID(productID);
                        searchaudiocdlist.add(audio);
                    } else if (productlist.get(i).getType().equals("Book")) {
                        book = bookdao.getBookByProductID(productID);
                        searchbooklist.add(book);
                    } else if (productlist.get(i).getType().equals("DVD")) {
                        dvd = dvddao.getDVDByProductID(productID);
                        searchdvdlist.add(dvd);
                    } else if (productlist.get(i).getType().equals("Magazine")) {
                        magazine = magazinedao.getMagazineByProductID(productID);
                        searchmagazinelist.add(magazine);
                    }
                    searchproductlist.add(productlist.get(i));
                }

                out.println("\nSummary: ");
                productlist = productdao.getProductsBySummary(searchstring);
                for (int i = 0; i < productlist.size(); i++) {
                    out.println(productlist.get(i).getTitle() + productlist.get(i).getSummary());
                    productID = productlist.get(i).getProductID();
                    if (productlist.get(i).getType().equals("Audio CD")) {
                        audio = audiocddao.getAudioCDByProductID(productID);
                        searchaudiocdlist.add(audio);
                    } else if (productlist.get(i).getType().equals("Book")) {
                        book = bookdao.getBookByProductID(productID);
                        searchbooklist.add(book);
                    } else if (productlist.get(i).getType().equals("DVD")) {
                        dvd = dvddao.getDVDByProductID(productID);
                        searchdvdlist.add(dvd);
                    } else if (productlist.get(i).getType().equals("Magazine")) {
                        magazine = magazinedao.getMagazineByProductID(productID);
                        searchmagazinelist.add(magazine);
                    }
                    searchproductlist.add(productlist.get(i));
                }

                out.println("Genre: ");
                productlist = productdao.getProductsByGenre(searchstring);
                for (int i = 0; i < productlist.size(); i++) {
                    out.println(productlist.get(i).getTitle() + productlist.get(i).getGenre());
                    productID = productlist.get(i).getProductID();
                    if (productlist.get(i).getType().equals("Audio CD")) {
                        audio = audiocddao.getAudioCDByProductID(productID);
                        searchaudiocdlist.add(audio);
                    } else if (productlist.get(i).getType().equals("Book")) {
                        book = bookdao.getBookByProductID(productID);
                        searchbooklist.add(book);
                    } else if (productlist.get(i).getType().equals("DVD")) {
                        dvd = dvddao.getDVDByProductID(productID);
                        searchdvdlist.add(dvd);
                    } else if (productlist.get(i).getType().equals("Magazine")) {
                        magazine = magazinedao.getMagazineByProductID(productID);
                        searchmagazinelist.add(magazine);
                    }
                    searchproductlist.add(productlist.get(i));
                }

                out.println("\n\nAUDIO CD:");

                audiolist = audiocddao.getAudioCDByArtist(searchstring);
                out.println("\nArtist");
                for (int i = 0; i < audiolist.size(); i++) {
                    productbean = productdao.getProductById(audiolist.get(i).getAudiocd_productID());
                    out.println(productbean.getTitle() + audiolist.get(i).getArtist());
                    productID = productlist.get(i).getProductID();
                    if (productlist.get(i).getType().equals("Audio CD")) {
                        audio = audiocddao.getAudioCDByProductID(productID);
                        searchaudiocdlist.add(audio);
                    } else if (productlist.get(i).getType().equals("Book")) {
                        book = bookdao.getBookByProductID(productID);
                        searchbooklist.add(book);
                    } else if (productlist.get(i).getType().equals("DVD")) {
                        dvd = dvddao.getDVDByProductID(productID);
                        searchdvdlist.add(dvd);
                    } else if (productlist.get(i).getType().equals("Magazine")) {
                        magazine = magazinedao.getMagazineByProductID(productID);
                        searchmagazinelist.add(magazine);
                    }
                    searchaudiocdlist.add(audiolist.get(i));
                }

                audiolist = audiocddao.getAudioCDByRecordCompany(searchstring);
                out.println("\nRecord Company:");
                for (int i = 0; i < audiolist.size(); i++) {
                    productbean = productdao.getProductById(audiolist.get(i).getAudiocd_productID());
                    out.println(productbean.getTitle() + audiolist.get(i).getRecordCompany());
                    productID = productlist.get(i).getProductID();
                    if (productlist.get(i).getType().equals("Audio CD")) {
                        audio = audiocddao.getAudioCDByProductID(productID);
                        searchaudiocdlist.add(audio);
                    } else if (productlist.get(i).getType().equals("Book")) {
                        book = bookdao.getBookByProductID(productID);
                        searchbooklist.add(book);
                    } else if (productlist.get(i).getType().equals("DVD")) {
                        dvd = dvddao.getDVDByProductID(productID);
                        searchdvdlist.add(dvd);
                    } else if (productlist.get(i).getType().equals("Magazine")) {
                        magazine = magazinedao.getMagazineByProductID(productID);
                        searchmagazinelist.add(magazine);
                    }
                    searchaudiocdlist.add(audiolist.get(i));
                }

                out.println("\n\nBOOKS:");

                booklist = bookdao.getBookByAuthor(searchstring);
                out.println("\nAuthor:");
                for (int i = 0; i < booklist.size(); i++) {
                    productbean = productdao.getProductById(booklist.get(i).getBook_productID());
                    out.println(productbean.getTitle() + booklist.get(i).getAuthor());
                    searchbooklist.add(booklist.get(i));
                }

                booklist = bookdao.getBookByPublisher(searchstring);
                out.println("\nPublisher");
                for (int i = 0; i < booklist.size(); i++) {
                    productbean = productdao.getProductById(booklist.get(i).getBook_productID());
                    out.println(productbean.getTitle() + booklist.get(i).getPublisher());
                    searchbooklist.add(booklist.get(i));
                }

                //datePublished
                out.println("\n\nDVD:");

                dvdlist = dvddao.getDVDByActor(searchstring);
                out.println("\nActor");
                for (int i = 0; i < dvdlist.size(); i++) {
                    productbean = productdao.getProductById(dvdlist.get(i).getDvd_productID());
                    out.println(productbean.getTitle() + dvdlist.get(i).getMainActors());
                    searchdvdlist.add(dvdlist.get(i));
                }

                dvdlist = dvddao.getDVDByDirector(searchstring);
                out.println("\nDirector");
                for (int i = 0; i < dvdlist.size(); i++) {
                    productbean = productdao.getProductById(dvdlist.get(i).getDvd_productID());
                    out.println(productbean.getTitle() + dvdlist.get(i).getDirector());
                    searchdvdlist.add(dvdlist.get(i));
                }

                dvdlist = dvddao.getDVDByProducer(searchstring);
                out.println("\nProduction Company:");
                for (int i = 0; i < dvdlist.size(); i++) {
                    productbean = productdao.getProductById(dvdlist.get(i).getDvd_productID());
                    out.println(productbean.getTitle() + dvdlist.get(i).getProductionCompany());
                    searchdvdlist.add(dvdlist.get(i));
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
                    out.println(productbean.getTitle() + magazinelist.get(i).getPublisher());
                    searchmagazinelist.add(magazinelist.get(i));
                }

                session.setAttribute("searchproductlist", searchproductlist);
                session.setAttribute("searchaudiocdlist", searchaudiocdlist);
                session.setAttribute("searchbooklist", searchbooklist);
                session.setAttribute("searchdvdlist", searchdvdlist);
                session.setAttribute("searchmagazinelist", searchmagazinelist);
                out.println(searchproductlist.size());
                response.sendRedirect("customerSearchProduct.jsp");
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
