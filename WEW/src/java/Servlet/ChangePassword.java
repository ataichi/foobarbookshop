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
import org.owasp.esapi.errors.AuthenticationException;
import org.owasp.esapi.errors.EncryptionException;

@WebServlet(name = "ChangePassword", urlPatterns = {"/ChangePassword"})
public class ChangePassword extends HttpServlet {

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
            AccountBean account = new AccountBean();

            /* Start of declaration */
            AccountDAOInterface accountdao = new AccountDAOImplementation();

            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();
            ArrayList<LogBean> loglist = (ArrayList<LogBean>) session.getAttribute("loglist");
            /* End of declaration*/

            /* request.getParameter() */
            String currpass = request.getParameter("currpass");
            String pass1 = request.getParameter("pass1");
            String pass2 = request.getParameter("pass2");

            java.util.Date date = new java.util.Date();
            Timestamp time = new Timestamp(date.getTime());
            log.setTime(time);
            log.setActivity("Change Password");
            log.setIp_address(request.getRemoteAddr());
            /* End of request.getParameter() */
            if (session.getAttribute("homeproduct") != null) { // product manager
                account = (AccountBean) session.getAttribute("homeproduct");

                if (account.getAccesscontrol().isEditpassword()) {
                    log.setLog_accountID(account.getAccountID());

                    try {
                        account.changePassword(currpass, pass1, pass2);
                        log.setStatus("successful");
                        logdao.addLog(log);

                        loglist = logdao.getAllLogs();
                        session.setAttribute("loglist", loglist);
                        session.setAttribute("homeproduct", account);
                        response.sendRedirect("productmanagerHOME.jsp");

                    } catch (AuthenticationException ex) {
                        log.setStatus("failed");
                        logdao.addLog(log);
                        loglist = logdao.getAllLogs();
                        session.setAttribute("loglist", loglist);
                        response.sendRedirect("productmanagerChangePassword.jsp");
                        Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (EncryptionException ex) {
                        log.setStatus("failed");
                        logdao.addLog(log);
                        response.sendRedirect("productmanagerChangePassword.jsp");
                        Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (session.getAttribute("homeuser") != null) {
                account = (AccountBean) session.getAttribute("homeuser");

                if (account.getAccesscontrol().isEditpassword()) {
                    log.setLog_accountID(account.getAccountID());

                    try {
                        account.changePassword(currpass, pass1, pass2);
                        log.setStatus("successful");
                        logdao.addLog(log);

                        loglist = logdao.getAllLogs();

                        session.setAttribute("loglist", loglist);
                        session.setAttribute("homecustomer", account);
                        response.sendRedirect("customerHOME.jsp");

                    } catch (AuthenticationException ex) {
                        log.setStatus("failed");
                        logdao.addLog(log);

                        loglist = logdao.getAllLogs();

                        session.setAttribute("loglist", loglist);
                        response.sendRedirect("customerChangePassword.jsp");
                        Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (EncryptionException ex) {
                        log.setStatus("failed");
                        logdao.addLog(log);
                        response.sendRedirect("customerChangePassword.jsp");
                        Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (session.getAttribute("homeaccounting") != null) {
                account = (AccountBean) session.getAttribute("homeaccounting");

                if (account.getAccesscontrol().isEditpassword()) {
                    log.setLog_accountID(account.getAccountID());

                    try {
                        account.changePassword(currpass, pass1, pass2);
                        log.setStatus("successful");
                        logdao.addLog(log);

                        session.setAttribute("homeaccounting", account);
                        response.sendRedirect("accountingmanagerHOME.jsp");

                    } catch (AuthenticationException ex) {
                        log.setStatus("failed");
                        logdao.addLog(log);
                        response.sendRedirect("accountingmanagerChangePassword.jsp");
                        Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (EncryptionException ex) {
                        log.setStatus("failed");
                        logdao.addLog(log);
                        response.sendRedirect("accountingmanagerChangePassword.jsp");
                        Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
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
