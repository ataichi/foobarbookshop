package Servlet;

import Beans.*;
import DAO.Implementation.*;
import DAO.Interface.*;
import DBConnection.Hasher;
import Process.Randomizer;
import Security.LoginAuthenticator;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.owasp.esapi.errors.AuthenticationException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            AccountBean account = new AccountBean();
            AccountDAOInterface accountdao = new AccountDAOImplementation();

            ArrayList<ProductOrderBean> temporder = new ArrayList<ProductOrderBean>();

            ShoppingCartBean shoppingcart = new ShoppingCartBean();

            ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
            ArrayList<ProductBean> productaudiolist = new ArrayList<ProductBean>();
            ArrayList<ProductBean> productbooklist = new ArrayList<ProductBean>();
            ArrayList<ProductBean> productdvdlist = new ArrayList<ProductBean>();
            ArrayList<ProductBean> productmagazinelist = new ArrayList<ProductBean>();

            ProductManagerDAOInterface pdao = new ProductManagerDAOImplementation();
            ProductDAOInterface productdao = new ProductDAOImplementation();

            ArrayList<LogBean> loglist = new ArrayList<LogBean>();
            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();

            ArrayList<LockReportBean> lockreportlist = new ArrayList<LockReportBean>();
            ArrayList<AccountBean> lockedAccounts = new ArrayList<AccountBean>();
            LockReportDAOInterface lockreportdao = new LockReportDAOImplementation();

            AudioCDManagerDAOInterface cddao = new AudioCDManagerDAOImplementation();
            ArrayList<AudioCDBean> audiocdlist = new ArrayList<AudioCDBean>();

            BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();
            ArrayList<BookBean> booklist = new ArrayList<BookBean>();

            DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();
            ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();

            MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
            ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();

            AccountingManagerDAOInterface accountingmanagerdao = new AccountingManagerDAOImplementation();
            ArrayList<ProductOrderBean> productorderlist = new ArrayList<ProductOrderBean>();
            ArrayList<ShoppingCartBean> shoppingcartlist = new ArrayList<ShoppingCartBean>();

            String username = AccountDAOImplementation.inputSanitizer(request.getParameter("loguser"));
            String password = request.getParameter("logpass");
            String type;

            int ctr_try = Integer.parseInt(request.getParameter("ctr_try")); // start
            System.out.println("CTR_TRY" + ctr_try);
            Hasher hash = null;

            try {
                hash = new Hasher("MD5");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            hash.updateHash(password, "UTF-8");
            password = hash.getHashBASE64();

            String salt = null;
            String token = null;
            String address = request.getRemoteAddr();

            Random random = new Random();
            SecureRandom randomGen;

            try {
                randomGen = SecureRandom.getInstance("SHA1PRNG");
                randomGen.setSeed(12);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            Hasher hashGen;

            try {
                salt = Long.toString(random.nextLong());
                hashGen = new Hasher("MD5");
                hashGen.updateHash(address, "UTF-8");
                token = hashGen.getHashBASE64();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            LoginAuthenticator loginauthenticator = new LoginAuthenticator();

            try {
                account = loginauthenticator.login(request, response);
                if (account != null) {
                    if (account.getLocked()) {
                        response.sendRedirect("contactAdmin.jsp");
                    } else {
                        if (account.getAccountType().equals("Customer")) {
                            CustomerDAOImplementation customerdao = new CustomerDAOImplementation();
                            CustomerBean tempcustomer = customerdao.getCustomerByAccountID(account.getAccountID());

                            productaudiolist = productdao.getAllProductsByType("Audio CD");
                            productbooklist = productdao.getAllProductsByType("Book");
                            productdvdlist = productdao.getAllProductsByType("DVD");
                            productmagazinelist = productdao.getAllProductsByType("Magazine");

//                    System.out.println(tempcustomer.getCustomerID());
                            type = "Customer";
                            log.setActivity("Customer Login");
                            log.setLog_accountID(account.getAccountID());

                            Timestamp time;
                            java.util.Date date = new java.util.Date();
                            time = new Timestamp(date.getTime());
                            log.setTime(time);
                            log.setIp_address(address);
                            log.setSalt(salt);
                            log.setToken(token);

                            if (logdao.addLog(log)) {
                                session.setAttribute("type", type);
                                session.setAttribute("tempcustomer", tempcustomer);
                                session.setAttribute("shoppingcart", shoppingcart);
                                session.setAttribute("homeuser", account);
                                session.setAttribute("temporder", temporder);

                                session.setAttribute("tempproductlist", productlist);
                                session.setAttribute("productaudiolist", productaudiolist);
                                session.setAttribute("productbooklist", productbooklist);
                                session.setAttribute("productdvdlist", productdvdlist);
                                session.setAttribute("productmagazinelist", productmagazinelist);

                                System.out.println("TRY TRY TRY");
                                session.setMaxInactiveInterval(-1);
                                out.println("DITO 123PO");
                                response.sendRedirect("customerHOME.jsp");
                            }
                        } else if (account.getAccountType().equals("Admin")) {
                            loglist = logdao.getAllLogs();
                            lockreportlist = lockreportdao.getAllNotDoneLockReport();
                            lockedAccounts = accountdao.getAllLockedAccounts();

                            type = "Admin";
                            log.setActivity("Admin Login");
                            log.setLog_accountID(account.getAccountID());

                            java.util.Date date = new java.util.Date();
                            Timestamp time = new Timestamp(date.getTime());
                            log.setTime(time);
                            if (logdao.addLog(log)) {
                                session.setAttribute("homeadmin", account);
                                session.setAttribute("type", type);
                                session.setAttribute("loglist", loglist);
                                session.setAttribute("homeadmin", account);
                                session.setAttribute("lockedAccounts", lockedAccounts);
                                session.setAttribute("lockreportlist", lockreportlist);
                                System.out.println(time);
                                session.setMaxInactiveInterval(600);
                                out.println("DITO ASDPO");

                                response.sendRedirect("adminHOME.jsp");
                            }

                        } else if (account.getAccountType().equals("Audio CD Manager")) {
                            audiocdlist = cddao.getAllAudioCD();
                            productlist = pdao.getProductsByType("Audio CD");

                            type = "Audio CD Manager";

                            log.setActivity("Audio CD Manager Login");
                            log.setLog_accountID(account.getAccountID());

                            java.util.Date date = new java.util.Date();
                            Timestamp time = new Timestamp(date.getTime());
                            log.setTime(time);

                            if (logdao.addLog(log)) {
                                session.setAttribute("audiocdlist", audiocdlist);
                                session.setAttribute("type", type);
                                session.setAttribute("productlist", productlist);
                                session.setAttribute("homeproduct", account);
                                session.setMaxInactiveInterval(600);
                                out.println("DIASDASDASDATO PO");

                                response.sendRedirect("productmanagerHOME.jsp");
                            }

                        } else if (account.getAccountType().equals("Book Manager")) {
                            booklist = bookdao.getAllBooks();
                            productlist = pdao.getProductsByType("Book");
                            type = "Book Manager";

                            log.setActivity("Book Manager Login");
                            log.setLog_accountID(account.getAccountID());

                            java.util.Date date = new java.util.Date();
                            Timestamp time = new Timestamp(date.getTime());
                            log.setTime(time);

                            if (logdao.addLog(log)) {
                                session.setAttribute("booklist", booklist);
                                session.setAttribute("type", type);
                                session.setAttribute("productlist", productlist);
                                session.setAttribute("homeproduct", account);
                                session.setMaxInactiveInterval(600);
                                out.println("DITO123123 PO");

                                response.sendRedirect("productmanagerHOME.jsp");
                            }

                        } else if (account.getAccountType().equals("DVD Manager")) {
                            dvdlist = dvddao.viewAllDVD();
                            type = "DVD Manager";
                            productlist = pdao.getProductsByType("DVD");

                            log.setActivity("DVD Manager Login");
                            log.setLog_accountID(account.getAccountID());

                            java.util.Date date = new java.util.Date();
                            Timestamp time = new Timestamp(date.getTime());
                            log.setTime(time);

                            if (logdao.addLog(log)) {
                                session.setAttribute("dvdlist", dvdlist);

                                session.setAttribute("type", type);
                                session.setAttribute("productlist", productlist);
                                session.setAttribute("homeproduct", account);
                                session.setMaxInactiveInterval(600);
                                out.println("DITO 123123131412PO");

                                response.sendRedirect("productmanagerHOME.jsp");
                            }

                        } else if (account.getAccountType().equals("Magazine Manager")) {

                            magazinelist = magazinedao.getAllMagazine();
                            productlist = pdao.getProductsByType("Magazine");

                            log.setActivity("Magazine Manager Login");
                            log.setLog_accountID(account.getAccountID());

                            java.util.Date date = new java.util.Date();
                            Timestamp time = new Timestamp(date.getTime());
                            log.setTime(time);

                            type = "Magazine Manager";

                            if (logdao.addLog(log)) {
                                session.setAttribute("type", type);
                                session.setAttribute("magazinelist", magazinelist);

                                session.setAttribute("productlist", productlist);
                                session.setAttribute("homeproduct", account);
                                session.setMaxInactiveInterval(600);
                                out.println("AYOKO PO");

                                response.sendRedirect("productmanagerHOME.jsp");
                            }

                        } else if (account.getAccountType().equals("Accounting Manager")) {
                            log.setActivity("Accounting Manager Login");
                            log.setLog_accountID(account.getAccountID());

                            type = "Accounting Manager";
                            java.util.Date date = new java.util.Date();
                            Timestamp time = new Timestamp(date.getTime());
                            log.setTime(time);

                            productorderlist = accountingmanagerdao.getAllProductOrders();
                            shoppingcartlist = accountingmanagerdao.getAllShoppingCart();

                            productaudiolist = pdao.getProductsByType("Audio CD");
                            productbooklist = pdao.getProductsByType("Book");
                            productdvdlist = pdao.getProductsByType("DVD");
                            productmagazinelist = pdao.getProductsByType("Magazine");

                            if (logdao.addLog(log)) {
                                session.setAttribute("audiolist", productaudiolist);
                                session.setAttribute("booklist", productbooklist);
                                session.setAttribute("dvdlist", productdvdlist);
                                session.setAttribute("magazinelist", productmagazinelist);

                                session.setAttribute("productorderlist", productorderlist);
                                session.setAttribute("shoppingcartlist", shoppingcartlist);

                                session.setAttribute("type", type);
                                session.setAttribute("homeaccounting", account);

                                session.setMaxInactiveInterval(600);
                                out.println("DITO123156SADHASJK PO");
                                out.println(productaudiolist.size());
                                out.println(productbooklist.size());
                                out.println(productdvdlist.size());
                                out.println(productmagazinelist.size());
                                out.println(productorderlist.size());
                                out.println(shoppingcartlist.size());
                                out.println(account.getAccountType());
                               response.sendRedirect("accountingmanagerHOME.jsp");
                            }

                        }
                    }
                } else if (accountdao.isUsernameAvailable(username)) {
                    account = accountdao.getUserByUsername(username);
                    if (account.getLocked()) {
                        response.sendRedirect("contactAdmin.jsp");
                    } else {
                        ctr_try++;
                        if (ctr_try <= 5) {

                            session.setAttribute("ctr_try", ctr_try);
                            session.setAttribute("username", username);
                            response.sendRedirect("loginfail.jsp");
                        } else {
                            // lock account
                            account = accountdao.getUserByUsername(username);
                            if (account.getAccountID() != 0) { // user exists -> lock account
                                boolean lock = accountdao.lockAccount(account);
                                if (lock) {
                                    ctr_try = 0; // reset counter
                                    log.setActivity("Lock Account " + username);
                                    log.setLog_accountID(account.getAccountID());

                                    java.util.Date date = new java.util.Date();
                                    Timestamp time = new Timestamp(date.getTime());
                                    log.setTime(time);
                                    if (logdao.addLog(log)) {
                                        response.sendRedirect("contactAdmin.jsp");
                                    }

                                } else {
                                    System.out.println("DI KO NA-LOCK");
                                }
                            } else { // user does not exist at all

                                System.out.println("WALA KA NAMAN E");
                            }

                            response.sendRedirect("contactAdmin.jsp");
                        }
                    }
                } else {
                    ctr_try++;
                    if (ctr_try <= 5) {

                        session.setAttribute("ctr_try", ctr_try);
                        session.setAttribute("username", username);
                        response.sendRedirect("loginfail.jsp");
                    } else {
                        // lock account
                        account = accountdao.getUserByUsername(username);
                        if (account.getAccountID() != 0) { // user exists -> lock account
                            boolean lock = accountdao.lockAccount(account);
                            if (lock) {
                                ctr_try = 0; // reset counter
                                log.setActivity("Lock Account " + username);
                                log.setLog_accountID(account.getAccountID());

                                java.util.Date date = new java.util.Date();
                                Timestamp time = new Timestamp(date.getTime());
                                log.setTime(time);
                                if (logdao.addLog(log)) {
                                    response.sendRedirect("contactAdmin.jsp");
                                }

                            } else {
                                System.out.println("DI KO NA-LOCK");
                            }
                        } else { // user does not exist at all

                            System.out.println("WALA KA NAMAN E");
                        }

                        response.sendRedirect("contactAdmin.jsp");
                    }
                }
            } catch (AuthenticationException ex) {
                System.out.println("Sorry :(");
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
