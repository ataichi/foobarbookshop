package Servlet;

import Beans.*;
import DAO.Implementation.*;
import DAO.Interface.*;
import DBConnection.Hasher;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

            String username = AccountDAOImplementation.inputSanitizer(request.getParameter("loguser"));
            String password = request.getParameter("logpass");

            int ctr_try = Integer.parseInt(request.getParameter("ctr_try")); // start
            System.out.println("CTR_TRY" + ctr_try);
            Hasher hash = null;

            try {
                hash = new Hasher("MD5");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            hash.updateHash(password, "UTF-8");
            //  password = hash.getHashBASE64();

            AccountDAOInterface accountdao = new AccountDAOImplementation();
            account = accountdao.getUserByUsername(username);

            ShoppingCartBean shoppingcart = new ShoppingCartBean();
            ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
            ProductManagerDAOInterface pdao = new ProductManagerDAOImplementation();

            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();

            if (accountdao.doesUserExist(username, password) && "Customer".equals(account.getAccountType()) && !account.getLocked()) {
                CustomerDAOImplementation customerdao = new CustomerDAOImplementation();
                ArrayList<ProductOrderBean> temporder = new ArrayList<ProductOrderBean>();
                CustomerBean tempcustomer = customerdao.getCustomerByAccountID(account.getAccountID());
                out.println(tempcustomer.getCustomerID());

                log.setActivity("Customer Login");
                log.setLog_accountID(account.getAccountID());

                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());
                log.setTime(time);

                if (logdao.addLog(log)) {
                    session.setAttribute("tempcustomer", tempcustomer);
                    session.setAttribute("shoppingcart", shoppingcart);
                    session.setAttribute("homeuser", account);
                    session.setAttribute("temporder", temporder);
                    session.setAttribute("tempproductlist", productlist);
                    response.sendRedirect("customerHOME.jsp");
                }
            } else if (accountdao.doesUserExist(username, password) && "Admin".equals(account.getAccountType()) && !account.getLocked()) {

                ArrayList<LogBean> loglist = new ArrayList<LogBean>();
                loglist = logdao.getAllLogs();
                
                log.setActivity("Admin Login");
                log.setLog_accountID(account.getAccountID());

                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());
                log.setTime(time);
                if (logdao.addLog(log)) {
                    session.setAttribute("loglist", loglist);
                    session.setAttribute("homeadmin", account);
                    out.println(time);

               //     response.sendRedirect("adminHOME.jsp");
                }

            } else if (accountdao.doesUserExist(username, password) && "Book Manager".equals(account.getAccountType()) && !account.getLocked()) {
                BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();
                ArrayList<BookBean> booklist = new ArrayList<BookBean>();
                booklist = bookdao.getAllBooks();
                session.setAttribute("booklist", booklist);

                productlist = pdao.getProductsByType("Book");

                log.setActivity("Book Manager Login");
                log.setLog_accountID(account.getAccountID());

                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());
                log.setTime(time);

                if (logdao.addLog(log)) {
                    session.setAttribute("productlist", productlist);
                    session.setAttribute("homeproduct", account);
                    response.sendRedirect("productmanagerHOME.jsp");
                }
            } else if (accountdao.doesUserExist(username, password) && "Audio CD Manager".equals(account.getAccountType()) && !account.getLocked()) {
                AudioCDManagerDAOInterface cddao = new AudioCDManagerDAOImplementation();
                ArrayList<AudioCDBean> audiocdlist = new ArrayList<AudioCDBean>();
                audiocdlist = cddao.getAllAudioCD();
                session.setAttribute("audiocdlist", audiocdlist);

                log.setActivity("Audio CD Manager Login");
                log.setLog_accountID(account.getAccountID());

                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());
                log.setTime(time);

                if (logdao.addLog(log)) {
                    productlist = pdao.getProductsByType("Audio CD");
                    session.setAttribute("productlist", productlist);
                    session.setAttribute("homeproduct", account);
                    response.sendRedirect("productmanagerHOME.jsp");
                }
            } else if (accountdao.doesUserExist(username, password) && "DVD Manager".equals(account.getAccountType()) && !account.getLocked()) {
                DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();
                ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
                dvdlist = dvddao.viewAllDVD();
                session.setAttribute("dvdlist", dvdlist);

                log.setActivity("DVD Manager Login");
                log.setLog_accountID(account.getAccountID());

                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());
                log.setTime(time);

                if (logdao.addLog(log)) {
                    productlist = pdao.getProductsByType("DVD");
                    session.setAttribute("productlist", productlist);
                    session.setAttribute("homeproduct", account);
                    response.sendRedirect("productmanagerHOME.jsp");
                }
            } else if (accountdao.doesUserExist(username, password) && "Magazine Manager".equals(account.getAccountType()) && !account.getLocked()) {
                MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
                ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();
                magazinelist = magazinedao.getAllMagazine();

                log.setActivity("Customer Login");
                log.setLog_accountID(account.getAccountID());

                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());
                log.setTime(time);

                if (logdao.addLog(log)) {
                    productlist = pdao.getProductsByType("Magazine");
                    session.setAttribute("productlist", productlist);
                    session.setAttribute("homeproduct", account);
                    response.sendRedirect("productmanagerHOME.jsp");
                }
            } else if (accountdao.doesUserExist(username, password) && "Accounting Manager".equals(account.getAccountType()) && !account.getLocked()) {
                log.setActivity("Accounting Manager Login");
                log.setLog_accountID(account.getAccountID());

                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());
                log.setTime(time);

                if (logdao.addLog(log)) {
                    session.setAttribute("homeaccounting", account);
                    response.sendRedirect("accountingmanagerHOME.jsp");
                }
            } else if (account.getLocked()) { //locked na talaga yung account
                response.sendRedirect("contactAdmin.jsp");
            } else { // login fail
                out.println(accountdao.doesUserExist(username, password));
                out.println(account.getAccountType());
                ctr_try++;

                if (ctr_try != 5) {
                    log.setActivity(username + " Login Attempt:" + ctr_try);
                    log.setLog_accountID(account.getAccountID());

                    java.util.Date date = new java.util.Date();
                    Timestamp time = new Timestamp(date.getTime());
                    log.setTime(time);

                    if (logdao.addLog(log)) {
                        session.setAttribute("username", username);
                        session.setAttribute("ctr_try", ctr_try);
                        System.out.println(ctr_try);
                        response.sendRedirect("loginfail.jsp");
                    }
                } else {//lock account
                    ctr_try = 0;

                    out.println(account.getAccountID());
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
                                out.println("YES LOCK KA NA PO");
                            }

                        } else {
                            out.println("DI KO NA-LOCK");
                        }
                    } else { // user does not exist at all

                        out.println("WALA KA NAMAN E");
                    }

                }
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
