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
import DAO.Implementation.AudioCDDAOImplementation;
import DAO.Implementation.BookDAOImplementation;
import DAO.Implementation.DVDDAOImplementation;
import DAO.Implementation.MagazineDAOImplementation;
import DAO.Implementation.ProductDAOImplementation;
import DAO.Interface.AudioCDDAOInterface;
import DAO.Interface.BookDAOInterface;
import DAO.Interface.DVDDAOInterface;
import DAO.Interface.MagazineDAOInterface;
import DAO.Interface.ProductDAOInterface;
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
            String searchstring = request.getParameter("searchstring");
            ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
            ProductDAOInterface productdao = new ProductDAOImplementation();
            ProductBean productbean = new ProductBean();
            
            AudioCDDAOInterface audiocddao = new AudioCDDAOImplementation();
            ArrayList<AudioCDBean> audiolist = new ArrayList<AudioCDBean>();
            AudioCDBean audio = new AudioCDBean();
            
            BookDAOInterface bookdao = new BookDAOImplementation();
            ArrayList<BookBean> booklist = new ArrayList<BookBean>();
            BookBean book = new BookBean();
            
            DVDDAOInterface dvddao = new DVDDAOImplementation();
            ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
            DVDBean dvd = new DVDBean();
            
            MagazineDAOInterface magazinedao = new MagazineDAOImplementation();
            ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();
            MagazineBean magazine = new MagazineBean();
            
            out.println("Product:");
            out.println("title:");
            productlist = productdao.getProductsByTitle(searchstring);
            for (int i = 0; i < productlist.size(); i++) {
                out.println(productlist.get(i).getProductID() +":" +productlist.get(i).getTitle());
            }

            out.println("\nSummary:");
            productlist = productdao.getProductsBySummary(searchstring);
            for (int i = 0; i < productlist.size(); i++) {
                out.println(productlist.get(i).getTitle() + productlist.get(i).getSummary());
            }
            out.println("Genre:");
            productlist = productdao.getProductsByGenre(searchstring);

            for (int i = 0; i < productlist.size(); i++) {
                out.println(productlist.get(i).getTitle() + productlist.get(i).getGenre());
            }

            out.println("\n\nAUDIO CD:");

            audiolist = audiocddao.getAudioCDByArtist(searchstring);
            out.println("\nArtist");
            for (int i = 0; i < audiolist.size(); i++) {
                productbean = productdao.getProductById(audiolist.get(i).getAudiocd_productID());
                out.println(productbean.getTitle() + audiolist.get(i).getArtist());
            }

            audiolist = audiocddao.getAudioCDByRecordCompany(searchstring);
            out.println("\nRecord Company:");
            for (int i = 0; i < audiolist.size(); i++) {
                productbean = productdao.getProductById(audiolist.get(i).getAudiocd_productID());
                out.println(productbean.getTitle() + audiolist.get(i).getRecordCompany());
            }

            out.println("\n\nBOOKS:");
            
            booklist = bookdao.getBookByAuthor(searchstring);
            out.println("\nAuthor:");
            for(int i =0;i<booklist.size();i++){
                productbean = productdao.getProductById(booklist.get(i).getBook_productID());
                out.println(productbean.getTitle()+booklist.get(i).getAuthor());
            }
            
            booklist=bookdao.getBookByPublisher(searchstring);
            out.println("\nPublisher");
            for(int i=0;i<booklist.size();i++){
                productbean = productdao.getProductById(booklist.get(i).getBook_productID());
                out.println(productbean.getTitle()+booklist.get(i).getPublisher());
            }
            
            //datePublished
            
            
            out.println("\n\nDVD:");
            
            dvdlist = dvddao.getDVDByActor(searchstring);
            out.println("\nActor");
            for(int i=0;i<dvdlist.size();i++){
                productbean = productdao.getProductById(dvdlist.get(i).getDvd_productID());
                out.println(productbean.getTitle() + dvdlist.get(i).getMainActors());
            }
            
            dvdlist=dvddao.getDVDByDirector(searchstring);
            out.println("\nDirector");
            for(int i=0;i<dvdlist.size();i++){
                productbean = productdao.getProductById(dvdlist.get(i).getDvd_productID());
                out.println(productbean.getTitle() + dvdlist.get(i).getDirector());
            }
            
            dvdlist = dvddao.getDVDByProducer(searchstring);
            out.println("\nProduction Company:");
            for(int i=0;i<dvdlist.size();i++){
                productbean = productdao.getProductById(dvdlist.get(i).getDvd_productID());
                out.println(productbean.getTitle()+dvdlist.get(i).getProductionCompany());
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
            for(int i=0;i<magazinelist.size();i++){
                productbean = productdao.getProductById(magazinelist.get(i).getMagazine_productID());
                out.println(productbean.getTitle()+magazinelist.get(i).getPublisher());
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
