package Servlet;

import Beans.*;
import DAO.Implementation.*;
import DAO.Interface.*;
import Process.Hasher;
import Security.Cookies;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AccountingSignupServlet", urlPatterns = {"/AccountingSignupServlet"})
public class AccountingSignupServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            Cookie userCookie;
            Hashtable cookies = new Cookies().cookieTable(request.getCookies());

            HttpSession session = request.getSession();
            String address = request.getRemoteAddr();
            AccountBean homeadmin = (AccountBean) session.getAttribute("homeadmin");

            //if (homeadmin.getAccesscontrol().isCreateaccountingmanager()) {
            AccountBean account = new AccountBean();
            AccountDAOInterface userdao = new AccountDAOImplementation();
            AdminDAOInterface adao = new AdminDAOImplementation();

            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();
            String firstname = request.getParameter("fname");
            String lastname = request.getParameter("lname");
            String mInitial = request.getParameter("mname");
            String email = request.getParameter("email");
            String username = request.getParameter("uname");
            String pass1 = request.getParameter("pass1");
            String password = pass1;
            if (password.toLowerCase().contains(username.toLowerCase()) || password.toLowerCase().contains(firstname.toLowerCase())
                    || password.toLowerCase().contains(lastname.toLowerCase())) {
                response.sendRedirect("accountingmanagersignupfail.jsp");
            } else {
                boolean locked = false;

                Hasher hash = null;

                try {
                    hash = new Hasher("MD5");
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(AccountingSignupServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                hash.updateHash(pass1, "UTF-8");
                pass1 = hash.getHashBASE64();

                account.setFirstName(AccountDAOImplementation.inputSanitizer(firstname));
                account.setLastName(AccountDAOImplementation.inputSanitizer(lastname));
                account.setMiddleInitial(AccountDAOImplementation.inputSanitizer(mInitial));
                account.setPassword(pass1);
                account.setEmailAdd(email);
                account.setUsername(AccountDAOImplementation.inputSanitizer(username));
                account.setAccountType("Accounting Manager");
                account.setLocked(locked);

                int accountingmanager_accountID;

            java.util.Date date = new java.util.Date();
            Timestamp time = new Timestamp(date.getTime());
            
            log.setIp_address(address);
            log.setLog_accountID(homeadmin.getAccountID()); // temporary
            log.setTime(time);
            log.setActivity("Add new Accounting Manager " + account.getFirstName());

                boolean addUser = userdao.addAccount(account);

                if (addUser) {
                //accountingmanager_accountID = userdao.getUserByUsername(request.getParameter("uname")).getAccountID();
                    //accountingManager.setAccountingManager_accountID(accountingmanager_accountID);
                    if (logdao.addLog(log)) {
                        userCookie = new Cookie("password", pass1);
                        userCookie.setMaxAge(86400);
                        response.addCookie(userCookie);
                        response.sendRedirect("adminHOME.jsp");
                    }
                } else {
                    response.sendRedirect("signup_accountingmanager.jsp");
                }
            //   } else {
                //      out.println("ACCESS DENIED");
                //  }
            /*
                 boolean addAccountingManager = adao.addAccountingManager(accountingManager);
                 if (addUser && addAccountingManager) {
                 response.sendRedirect("adminHOME.jsp");
                 //successful
                 } else {
                 response.sendRedirect("signupfail.jsp");
                 }
                 */
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
