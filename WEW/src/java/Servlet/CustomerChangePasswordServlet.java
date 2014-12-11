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
import Process.Hasher;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
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

@WebServlet(name = "CustomerChangePasswordServlet", urlPatterns = {"/CustomerChangePasswordServlet"})
public class CustomerChangePasswordServlet extends HttpServlet {

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
            //String type = (String) session.getAttribute("type");
            AccountBean account = (AccountBean) session.getAttribute("homeuser");
            /*
             if (account.getAccountType().equals("Customer")) {
             account = (AccountBean) session.getAttribute("homecustomer");
             } else if (account.getAccountType().equals("Audio CD Manager") || account.getAccountType().equals("Book Manager") || account.getAccountType().equals("DVD Manager") || account.getAccountType().equals("Magazine Manager")) {
             account = (AccountBean) session.getAttribute("homeproduct");
             } else if (account.getAccountType().equals("Accounting Manager")) {
             account = (AccountBean) session.getAttribute("homeaccounting");
             } else if (account.getAccountType().equals("Admin")) {
             account = (AccountBean) session.getAttribute("homeadmin");
             }
             */

            //if (account.getAccesscontrol().isEditpassword()) {
            AccountDAOInterface accountdao = new AccountDAOImplementation();

            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();

            String currpass = request.getParameter("currpass");
            String pass1 = request.getParameter("pass1");
            String pass2 = request.getParameter("pass2");

            java.util.Date date = new java.util.Date();
            Timestamp time = new Timestamp(date.getTime());
            log.setTime(time);
            log.setActivity("Change password");
            log.setLog_accountID(account.getAccountID());
            log.setIp_address(request.getRemoteAddr());

            try {
                account.changePassword(currpass, pass1, pass2);
                log.setStatus("successful");
                logdao.addLog(log);

                session.setAttribute("homecustomer", account);
                response.sendRedirect("customerHOME.jsp");

            } catch (AuthenticationException ex) {
                log.setStatus("failed");
                logdao.addLog(log);
                Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EncryptionException ex) {
                log.setStatus("failed");
                logdao.addLog(log);
                Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
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
