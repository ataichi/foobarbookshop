package Servlet;

import Beans.AccountBean;
import Beans.LogBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.AdminDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.AdminDAOInterface;
import DAO.Interface.LogDAOInterface;
import Process.Hasher;
import Security.Authenticator;
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
import org.owasp.esapi.errors.EncryptionException;

@WebServlet(name = "ProductManagerSignupServlet", urlPatterns = {"/ProductManagerSignupServlet"})
public class ProductManagerSignupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Cookie userCookie;
            Hashtable cookies = new Cookies().cookieTable(request.getCookies());

            HttpSession session = request.getSession();
            String address = request.getRemoteAddr();
            AccountBean homeadmin = (AccountBean) session.getAttribute("homeadmin");

            //if (homeadmin.getAccesscontrol().isCreateproductmanager()) {
            AccountBean account = new AccountBean();
            AccountDAOInterface userdao = new AccountDAOImplementation();
            AdminDAOInterface admindao = new AdminDAOImplementation();
            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();

            String pass1 = request.getParameter("pass1");
            String pass2 = request.getParameter("pass2");
            String password = pass1;
            String username = AccountDAOImplementation.inputSanitizer(request.getParameter("uname"));
            String firstname = AccountDAOImplementation.inputSanitizer(request.getParameter("fname"));
            String lastname = AccountDAOImplementation.inputSanitizer(request.getParameter("lname"));

            Authenticator authenticator = new Authenticator();

            if (password.toLowerCase().contains(username.toLowerCase())
                    || password.toLowerCase().contains(firstname.toLowerCase())
                    || password.toLowerCase().contains(lastname.toLowerCase())) {

                response.sendRedirect("signup_productmanager.jsp");
            } else {

                try {
                    pass1 = (String) authenticator.hashPassword(pass1, pass2);
                } catch (EncryptionException ex) {
                    Logger.getLogger(ProductManagerSignupServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                account.setFirstName(firstname);
                account.setLastName(lastname);
                account.setMiddleInitial(request.getParameter("mname"));
                account.setPassword(pass1);
                account.setEmailAdd(request.getParameter("email"));
                account.setUsername(username);
                //account.setAccountType("product manager");
                account.setAccountType(request.getParameter("prodType") + " Manager");
                account.setLocked(false);
                account.setFailedLoginCount(0);

                boolean addUser = userdao.addAccount(account);

                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());

                log.setIp_address(address);
                log.setLog_accountID(homeadmin.getAccountID()); // temporary lang hehe
                log.setTime(time);
                log.setActivity("Product Manager Sign Up");
                log.setIp_address(request.getRemoteAddr());

                out.println(addUser);
                if (addUser) {
                    //productmanager_accountID = userdao.getUserByUsername(request.getParameter("uname")).getAccountID();
                    //productManager.setProdmanager_accountID(productmanager_accountID);

                    log.setStatus("successful");
                    logdao.addLog(log);
                    userCookie = new Cookie("name", request.getParameter("uname"));
                    userCookie.setMaxAge(86400);
                    response.addCookie(userCookie);
                    response.sendRedirect("adminHOME.jsp");
                } else {
                    log.setStatus("failed");
                    logdao.addLog(log);
                    response.sendRedirect("signup_productmanager.jsp");
                }

                //productManager.setProdType(request.getParameter("prodType"));
            /*

                 boolean addProductmanager = admindao.addProductManager(productManager);

                 if (addUser && addProductmanager) {
                 response.sendRedirect("adminHOME.jsp");
                 } else {
                 response.sendRedirect("signupfail.jsp");
                 }
                 */
                // } else {
                //     out.println("ACCESS DENIED");
                // }
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
