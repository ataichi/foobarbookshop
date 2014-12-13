/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.LogBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.LogDAOInterface;
import Security.Authenticator;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.owasp.esapi.errors.EncryptionException;

@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

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
            AccountBean homeadmin = (AccountBean) session.getAttribute("homeadmin");

            String action = request.getParameter("action");

            if (action.equals("Add Accounting Manager")) {
                /* Start of variable declaration */

                AccountBean account = new AccountBean();
                AccountDAOInterface accountdao = new AccountDAOImplementation();

                LogBean log = new LogBean();
                LogDAOInterface logdao = new LogDAOImplementation();

                ArrayList<LogBean> loglist = (ArrayList<LogBean>) session.getAttribute("loglist");

                /* End of variable declaration */
                /* Request.getParameter() */
                String firstname = request.getParameter("fname");
                String lastname = request.getParameter("lname");
                String mInitial = request.getParameter("mname");
                String email = request.getParameter("email");
                String username = request.getParameter("uname");
                String pass1 = request.getParameter("pass1");
                String pass2 = request.getParameter("pass2");
                String password = pass1;

                String address = request.getRemoteAddr();

                /* End of request.getParamater() */
                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());

                log.setIp_address(address);
                log.setLog_accountID(homeadmin.getAccountID()); // temporary
                log.setTime(time);
                log.setActivity("Accounting Manager Sign Up");

                if (password.toLowerCase().contains(username.toLowerCase()) || password.toLowerCase().contains(firstname.toLowerCase())
                        || password.toLowerCase().contains(lastname.toLowerCase())) {

                    //set cookies
                    log.setStatus("failed");
                    logdao.addLog(log);
                    loglist.add(log);
                    loglist = logdao.getAllLogs();
                    session.setAttribute("loglist", loglist);
                    response.sendRedirect("signup_accountingmanager.jsp");
                } else {

                    Authenticator authenticator = new Authenticator();

                    try {
                        pass1 = (String) authenticator.hashPassword(pass1, pass2);
                    } catch (EncryptionException ex) {
                        Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    account.setFirstName(AccountDAOImplementation.inputSanitizer(firstname));
                    account.setLastName(AccountDAOImplementation.inputSanitizer(lastname));
                    account.setMiddleInitial(AccountDAOImplementation.inputSanitizer(mInitial));
                    account.setPassword(pass1);
                    account.setEmailAdd(email);
                    account.setUsername(username);
                    account.setAccountType("Accounting Manager");
                    account.setLocked(false);

                    boolean addUser = accountdao.addAccount(account);

                    if (addUser) {
                        log.setStatus("successful");
                        logdao.addLog(log);
                        loglist.add(log);
                        loglist = logdao.getAllLogs();
                        session.setAttribute("loglist", loglist);
                        response.sendRedirect("adminHOME.jsp");
                    } else {
                        log.setStatus("failed");
                        logdao.addLog(log);
                        loglist.add(log);
                        loglist = logdao.getAllLogs();
                        session.setAttribute("loglist", loglist);
                        response.sendRedirect("signup_accountingmanager.jsp");
                    }

                }
            } else if (action.equals("Add Product Manager")) {

                /* Start of variable declaration */
                AccountBean account = new AccountBean();
                AccountDAOInterface accountdao = new AccountDAOImplementation();

                Authenticator authenticator = new Authenticator();

                LogBean log = new LogBean();
                LogDAOInterface logdao = new LogDAOImplementation();

                ArrayList<LogBean> loglist = (ArrayList<LogBean>) session.getAttribute("loglist");
                /* End of variale declaration */
                /* Request.getParameter() */
                String pass1 = request.getParameter("pass1");
                String pass2 = request.getParameter("pass2");
                String password = pass1;
                String username = AccountDAOImplementation.inputSanitizer(request.getParameter("uname"));
                String firstname = AccountDAOImplementation.inputSanitizer(request.getParameter("fname"));
                String lastname = AccountDAOImplementation.inputSanitizer(request.getParameter("lname"));
                String middlename = AccountDAOImplementation.inputSanitizer(request.getParameter("mname"));

                String address = request.getRemoteAddr();

                /* End of Request.getParameter() */
                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());

                log.setIp_address(address);
                log.setLog_accountID(homeadmin.getAccountID()); // temporary lang hehe
                log.setTime(time);
                log.setActivity("Product Manager Sign Up");

                if (password.toLowerCase().contains(username.toLowerCase())
                        || password.toLowerCase().contains(firstname.toLowerCase())
                        || password.toLowerCase().contains(lastname.toLowerCase())) {

                    //set cookies
                    log.setStatus("failed");
                    logdao.addLog(log);
                    loglist.add(log);
                    loglist = logdao.getAllLogs();
                    session.setAttribute("loglist", loglist);
                    response.sendRedirect("signup_productmanager.jsp");
                } else {
                    try {
                        pass1 = (String) authenticator.hashPassword(pass1, pass2);
                    } catch (EncryptionException ex) {
                        Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    account.setFirstName(firstname);
                    account.setLastName(lastname);
                    account.setMiddleInitial(middlename);
                    account.setPassword(pass1);
                    account.setEmailAdd(request.getParameter("email"));
                    account.setUsername(username);
                    account.setAccountType(request.getParameter("prodType") + " Manager");
                    account.setLocked(false);
                    account.setFailedLoginCount(0);

                    boolean addUser = accountdao.addAccount(account);
                    if (addUser) {
                        log.setStatus("successful");
                        logdao.addLog(log);
                        loglist.add(log);
                        loglist = logdao.getAllLogs();
                        session.setAttribute("loglist", loglist);
                        response.sendRedirect("adminHOME.jsp");
                    } else {
                        log.setStatus("failed");
                        logdao.addLog(log);
                        loglist.add(log);
                        loglist = logdao.getAllLogs();
                        session.setAttribute("loglist", loglist);
                        response.sendRedirect("signup_productmanager.jsp");
                    }

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
