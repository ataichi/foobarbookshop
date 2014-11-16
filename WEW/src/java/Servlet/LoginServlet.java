package Servlet;

import Beans.AccountBean;
import Beans.AudioCDBean;
import Beans.BookBean;
import Beans.DVDBean;
import Beans.MagazineBean;
import Beans.ProductBean;
import Beans.ProductManagerBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.AudioCDManagerDAOImplementation;
import DAO.Implementation.BookManagerDAOImplementation;
import DAO.Implementation.DVDManagerDAOImplementation;
import DAO.Implementation.MagazineManagerDAOImplementation;
import DAO.Implementation.ProductManagerDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.AudioCDManagerDAOInterface;
import DAO.Interface.BookManagerDAOInterface;
import DAO.Interface.DVDManagerDAOInterface;
import DAO.Interface.MagazineManagerDAOInterface;
import DAO.Interface.ProductManagerDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            AccountBean account = new AccountBean();
            String username = request.getParameter("loguser");
            String password = request.getParameter("logpass");

            AccountDAOInterface accountdao = new AccountDAOImplementation();
            account = accountdao.getUserByUsername(username);

            if (accountdao.doesUserExist(username, password) && "customer".equals(account.getAccountType())) {
                session.setAttribute("homeuser", account);
                response.sendRedirect("customerHOME.jsp");
            } else if (accountdao.doesUserExist(username, password) && "admin".equals(account.getAccountType())) {
                session.setAttribute("homeadmin", account);
                response.sendRedirect("adminHOME.jsp");
            } else if (accountdao.doesUserExist(username, password) && "product manager".equals(account.getAccountType())) {
                ProductManagerBean productmanager = new ProductManagerBean();
                ProductManagerDAOInterface pdao = new ProductManagerDAOImplementation();
                productmanager = pdao.getProductManagerBeanById(account.getAccountID());
                ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
                
                if (productmanager.getProdType().equals("Books")) { //book manager
                    BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();
                    ArrayList<BookBean> booklist = new ArrayList<BookBean>();
                    booklist = bookdao.viewAllBook();
                    session.setAttribute("booklist", booklist);
                    
                    productlist = pdao.getProductsByType(productmanager.getProdType());
                    session.setAttribute("productlist", productlist);
                }else if(productmanager.getProdType().equals("Audio CD")){ // audio cd manager
                    AudioCDManagerDAOInterface cddao = new AudioCDManagerDAOImplementation();
                    ArrayList<AudioCDBean> audiocdlist = new ArrayList<AudioCDBean>();
                    audiocdlist = cddao.getAllAudioCD();
                    session.setAttribute("audiocdlist", audiocdlist);
                    
                    productlist=pdao.getProductsByType(productmanager.getProdType());
                    session.setAttribute("productlist",productlist);
                }else if(productmanager.getProdType().equals("DVD")){ //dvd manager
                    DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();
                    ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
                    dvdlist = dvddao.viewAllDVD();
                    session.setAttribute("dvdlist", dvdlist);
                    
                    productlist = pdao.getProductsByType(productmanager.getProdType());
                    session.setAttribute("productlist", productlist);
                }else if(productmanager.getProdType().equals("Magazine")){ //magazine manager
                    MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
                    ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();
                    magazinelist = magazinedao.viewAllMagazine();
                    
                    productlist = pdao.getProductsByType(productmanager.getProdType());
                    session.setAttribute("productlist", productlist);
                }
                
                session.setAttribute("homeproduct", account);
       //         out.println("HERE");
                response.sendRedirect("productmanagerHOME.jsp");
            } else if (accountdao.doesUserExist(username, password) && "accounting manager".equals(account.getAccountType())) {
                session.setAttribute("homeaccounting", account);
                response.sendRedirect("accountingmanagerHOME.jsp");
            } else {
                out.println(accountdao.doesUserExist(username, password));
                out.println(account.getAccountType());
                response.sendRedirect("loginfail.jsp");
            }

        } finally {
            out.close();
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
