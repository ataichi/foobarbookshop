package Servlet;

import Beans.*;
import DAO.Implementation.AccountingManagerDAOImplementation;
import DAO.Implementation.AudioCDManagerDAOImplementation;
import DAO.Implementation.BookManagerDAOImplementation;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Implementation.DVDManagerDAOImplementation;
import DAO.Implementation.MagazineManagerDAOImplementation;
import DAO.Implementation.ProductDAOImplementation;
import DAO.Implementation.ProductManagerDAOImplementation;
import DAO.Interface.AccountingManagerDAOInterface;
import DAO.Interface.AudioCDManagerDAOInterface;
import DAO.Interface.BookManagerDAOInterface;
import DAO.Interface.DVDManagerDAOInterface;
import DAO.Interface.MagazineManagerDAOInterface;
import Process.Hasher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Security.Authenticator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.owasp.esapi.errors.AuthenticationException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            AccountBean account = null;
            String address = null;
            String salt = null;
            String token = null;

            Authenticator authenticator = new Authenticator();

            session.setAttribute("errorMessage", "");

            try {
                account = (AccountBean) authenticator.login(request, response);
            } catch (AuthenticationException ex) {
                out.println("here sad");
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (!account.getLoggedIn()) { //meron pero wrong password

                if (account.getFailedLoginCount() <= 5) {
                    account.incrementFailedLoginCount();
                    response.sendRedirect("login.jsp");
                } else {
                    account.lock();
                    //set cookies: Your account has been locked
                    session.setAttribute("errorMessage", "Your account has been locked.");
                    response.sendRedirect("contactAdmin.jsp");
                }

            } else if (account != null && account.getLoggedIn()) {
                request.getSession().invalidate();
                session = request.getSession(true);

                //salt, token, ip address
                address = request.getRemoteAddr();

                Random random = new Random();
                SecureRandom randomGen;

                try {
                    randomGen = SecureRandom.getInstance("MD5");
                    randomGen.setSeed(12);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                Hasher hashGen;

                salt = Long.toString(random.nextLong());
                try {
                    hashGen = new Hasher("MD5");
                    hashGen.updateHash(address, "UTF-8");
                    token = hashGen.getHashBASE64();
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                //DAO Implementation
                ProductDAOImplementation productdao = new ProductDAOImplementation();
                ProductManagerDAOImplementation pdao = new ProductManagerDAOImplementation();
                AccountingManagerDAOInterface accountingmanagerdao = new AccountingManagerDAOImplementation();
                ArrayList<ProductOrderBean> productorderlist = new ArrayList<ProductOrderBean>();
                ArrayList<ShoppingCartBean> shoppingcartlist = new ArrayList<ShoppingCartBean>();

                AudioCDManagerDAOInterface cddao = new AudioCDManagerDAOImplementation();
                ArrayList<AudioCDBean> audiocdlist = new ArrayList<AudioCDBean>();

                BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();
                ArrayList<BookBean> booklist = new ArrayList<BookBean>();

                DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();
                ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();

                MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
                ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();

                ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
                ArrayList<ProductBean> productaudiolist = new ArrayList<ProductBean>();
                ArrayList<ProductBean> productbooklist = new ArrayList<ProductBean>();
                ArrayList<ProductBean> productdvdlist = new ArrayList<ProductBean>();
                ArrayList<ProductBean> productmagazinelist = new ArrayList<ProductBean>();

                if (account.isLocked()) {
                    //out.println("locked");
                    session.setAttribute("errorMessage", "Your account has been locked.");
                    response.sendRedirect("contactAdmin.jsp");
                } else {
                    if (account.getAccountType().equals("Customer")) {
                        CustomerDAOImplementation customerdao = new CustomerDAOImplementation();
                        CustomerBean tempcustomer = customerdao.getCustomerByAccountID(account.getAccountID());

                        productaudiolist = productdao.getAllAvailableProductsByType("Audio CD");
                        productbooklist = productdao.getAllAvailableProductsByType("Book");
                        productdvdlist = productdao.getAllAvailableProductsByType("DVD");
                        productmagazinelist = productdao.getAllAvailableProductsByType("Magazine");

                        ShoppingCartBean shoppingcart = new ShoppingCartBean();
                        ArrayList<ProductOrderBean> temporder = new ArrayList<ProductOrderBean>();

                        ArrayList<ProductBean> productsbought = new ArrayList<ProductBean>();
                        productsbought = customerdao.getProductsBoughtByCustomer(tempcustomer.getCustomerID()); // get array list of products bought by customer4

                        ArrayList<ReviewBean> reviewlist = new ArrayList<ReviewBean>();
                        reviewlist = customerdao.getReviewsByCustomer(tempcustomer.getCustomerID());

                        session.setAttribute("type", "Customer");
                        session.setAttribute("tempcustomer", tempcustomer);
                        session.setAttribute("shoppingcart", shoppingcart);
                        session.setAttribute("homeuser", account);
                        session.setAttribute("temporder", temporder);

                        session.setAttribute("tempproductlist", productlist);
                        session.setAttribute("productaudiolist", productaudiolist);
                        session.setAttribute("productbooklist", productbooklist);
                        session.setAttribute("productdvdlist", productdvdlist);
                        session.setAttribute("productmagazinelist", productmagazinelist);

                        session.setAttribute("productsbought", productsbought);
                        session.setAttribute("reviewlist", reviewlist);
                        session.setMaxInactiveInterval(-1);

                        response.sendRedirect("customerHOME.jsp");
                    } else if (account.getAccountType().equals("Audio CD Manager")) {
                        audiocdlist = cddao.getAllAudioCD();
                        productlist = pdao.getProductsByType("Audio CD");

                        session.setAttribute("audiocdlist", audiocdlist);
                        session.setAttribute("type", "Audio CD Manager");
                        session.setAttribute("productlist", productlist);
                        session.setAttribute("homeproduct", account);
                        session.setMaxInactiveInterval(600);

                        response.sendRedirect("productmanagerHOME.jsp");

                    } else if (account.getAccountType().equals("Book Manager")) {
                        booklist = bookdao.getAllBooks();
                        productlist = pdao.getProductsByType("Book");

                        session.setAttribute("booklist", booklist);
                        session.setAttribute("type", "Book Manager");
                        session.setAttribute("productlist", productlist);
                        session.setAttribute("homeproduct", account);
                        session.setMaxInactiveInterval(600);

                        response.sendRedirect("productmanagerHOME.jsp");

                    } else if (account.getAccountType().equals("DVD Manager")) {
                        dvdlist = dvddao.viewAllDVD();
                        productlist = pdao.getProductsByType("DVD");

                        session.setAttribute("dvdlist", dvdlist);
                        session.setAttribute("type", "DVD Manager");
                        session.setAttribute("productlist", productlist);
                        session.setAttribute("homeproduct", account);
                        session.setMaxInactiveInterval(600);

                        response.sendRedirect("productmanagerHOME.jsp");
                    } else if (account.getAccountType().equals("Magazine Manager")) {
                        magazinelist = magazinedao.getAllMagazine();
                        productlist = pdao.getProductsByType("Magazine");

                        session.setAttribute("type", "Magazine Manager");
                        session.setAttribute("magazinelist", magazinelist);

                        session.setAttribute("productlist", productlist);
                        session.setAttribute("homeproduct", account);
                        session.setMaxInactiveInterval(600);

                        response.sendRedirect("productmanagerHOME.jsp");

                    } else if (account.getAccountType().equals("Accounting Manager")) {
                        productorderlist = accountingmanagerdao.getAllProductOrders();
                        shoppingcartlist = accountingmanagerdao.getAllShoppingCart();

                        productaudiolist = pdao.getProductsByType("Audio CD");
                        productbooklist = pdao.getProductsByType("Book");
                        productdvdlist = pdao.getProductsByType("DVD");
                        productmagazinelist = pdao.getProductsByType("Magazine");

                        session.setAttribute("audiolist", productaudiolist);
                        session.setAttribute("booklist", productbooklist);
                        session.setAttribute("dvdlist", productdvdlist);
                        session.setAttribute("magazinelist", productmagazinelist);

                        session.setAttribute("productorderlist", productorderlist);
                        session.setAttribute("shoppingcartlist", shoppingcartlist);

                        session.setAttribute("type", "Accounting Manager");
                        session.setAttribute("homeaccounting", account);

                        session.setMaxInactiveInterval(600);
                        response.sendRedirect("accountingmanagerHOME.jsp");
                    }
                }

            } else { //didn't match records
                //set cookies: The username and password you entered did not match our records.
                session.setAttribute("errorMessage", "The username and password you entered did not match our records.");
                response.sendRedirect("login.jsp");
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
