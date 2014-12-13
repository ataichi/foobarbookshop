package Servlet;

import Beans.AccountBean;
import Beans.LockReportBean;
import Beans.LogBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.LockReportDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.LockReportDAOInterface;
import DAO.Interface.LogDAOInterface;
import Process.Hasher;
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

@WebServlet(name = "AdminLoginServlet", urlPatterns = {"/AdminLoginServlet"})
public class AdminLoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, AuthenticationException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            AccountBean account = new AccountBean();
            AccountDAOInterface accountdao = new AccountDAOImplementation();

            ArrayList<LogBean> loglist = new ArrayList<LogBean>();
            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();

            ArrayList<LockReportBean> lockreportlist = new ArrayList<LockReportBean>();
            ArrayList<AccountBean> lockedAccounts = new ArrayList<AccountBean>();
            LockReportDAOInterface lockreportdao = new LockReportDAOImplementation();

            String username = AccountDAOImplementation.inputSanitizer(request.getParameter("loguser"));
            String password = request.getParameter("logpass");
            String type;
            Hasher hash = null;

            try {
                hash = new Hasher("MD5");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AdminLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AdminLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            Hasher hashGen;

            try {
                salt = Long.toString(random.nextLong());
                hashGen = new Hasher("MD5");
                hashGen.updateHash(address, "UTF-8");
                token = hashGen.getHashBASE64();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AdminLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            LoginAuthenticator loginauthenticator = new LoginAuthenticator();

            account = loginauthenticator.login(request, response);
            if (account != null) {
                loglist = logdao.getAllLogs();
                lockreportlist = lockreportdao.getAllNotDoneLockReport();
                lockedAccounts = accountdao.getAllLockedAccounts();

                type = "Admin";
                log.setActivity("Admin Login");
                log.setLog_accountID(account.getAccountID());

                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());
                log.setTime(time);
                log.setStatus("successful");
                if (logdao.addLog(log)) {
                    session.setAttribute("homeadmin", account);
                    session.setAttribute("type", type);
                    session.setAttribute("loglist", loglist);
                    session.setAttribute("homeadmin", account);
                    session.setAttribute("lockedAccounts", lockedAccounts);
                    session.setAttribute("lockreportlist", lockreportlist);
                    session.setMaxInactiveInterval(600);
                    response.sendRedirect("adminHOME.jsp");
                }
            } else {
                response.sendRedirect("adminLogin.jsp");
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
        try {
            processRequest(request, response);
        } catch (AuthenticationException ex) {
            Logger.getLogger(AdminLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (AuthenticationException ex) {
            Logger.getLogger(AdminLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
