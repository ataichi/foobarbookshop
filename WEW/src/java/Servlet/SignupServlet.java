package Servlet;

import Beans.AccountBean;
import Beans.CustomerBean;
import Beans.LogBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.CustomerDAOInterface;
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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SignupServlet", urlPatterns = {"/SignupServlet"})
public class SignupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            AccountBean account = new AccountBean();
            CustomerBean customer = new CustomerBean();
            AccountDAOInterface userdao = new AccountDAOImplementation();
            CustomerDAOInterface customerdao = new CustomerDAOImplementation();
            boolean checkAccount = false, checkCustomer = false;

            String firstname = request.getParameter("fname");
            String lastname = request.getParameter("lname");
            String mInitial = request.getParameter("mname");
            String email = request.getParameter("email");
            String username = request.getParameter("uname");
            String pass1 = request.getParameter("pass1");
            String password = pass1;

            if (password.toLowerCase().contains(username.toLowerCase())
                    || password.toLowerCase().contains(firstname.toLowerCase())
                    || password.toLowerCase().contains(lastname.toLowerCase())) {
                out.println("huy bawal yan");
                response.sendRedirect("signup.jsp");

            } else {

                Hasher hash = null;

                try {
                    hash = new Hasher("MD5");
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                hash.updateHash(pass1, "UTF-8");
                pass1 = hash.getHashBASE64();

                boolean check = userdao.isUsernameAvailable(username);
                if (check) { // meron nang username
                    //        out.println("MERON NA");
                    response.sendRedirect("signup.jsp");
                } else {
                    account.setFirstName(firstname);
                    account.setLastName(lastname);
                    account.setMiddleInitial(mInitial);
                    account.setPassword(pass1);
                    account.setEmailAdd(email);
                    account.setUsername(username);
                    account.setAccountType("Customer");
                    account.setLocked(false);
                    account.setFailedLoginCount(0);
                    checkAccount = userdao.addAccount(account);
                    String BA = request.getParameter("BA");
                    String DA = request.getParameter("DA");

                    int customer_accountID = userdao.getUserByUsername(username).getAccountID();

                    customer.setBA(AccountDAOImplementation.inputSanitizer(BA));
                    customer.setDA(AccountDAOImplementation.inputSanitizer(DA));

                    customer.setCustomer_accountID(customer_accountID);

                    checkCustomer = customerdao.addCustomer(customer);
                    LogBean log = new LogBean();
                    LogDAOInterface logdao = new LogDAOImplementation();

                    java.util.Date date = new java.util.Date();
                    Timestamp time = new Timestamp(date.getTime());
                    log.setTime(time);
                    log.setIp_address(request.getRemoteAddr());
                    log.setActivity(username + " Customer SignUps");
                    if (checkAccount && checkCustomer && (!userdao.isUsernameAvailable(username) == false)) {

                        // SET COOKIES
                        
                        Cookie[] cookies = request.getCookies();
                        boolean foundCookie = false;

                        for (int i = 0; i < cookies.length; i++) {
                            Cookie cookie1 = cookies[i];
                            if (cookie1.getName().equals(username)) {
                                out.println(cookie1.getValue());
                                foundCookie = true;
                            }
                        }

                        if (!foundCookie) {
                            Cookie cookie1 = new Cookie("customer", username);
                            cookie1.setMaxAge(24 * 60 * 60);
                            response.addCookie(cookie1);
                        }
                        
                        log.setLog_accountID(customer_accountID);
                        log.setStatus("Successful");
                        session.setAttribute("username", username);
                        logdao.addLog(log);
                        response.sendRedirect("login.jsp");
                    } else {
                        log.setStatus("failed");
                        log.setLog_accountID(0);
                        logdao.addLog(log);
                        AccountDAOImplementation.insertLog(request.getRemoteAddr(), "Customer " + username + " registration failed.", false);
                        response.sendRedirect("signup.jsp");

                        //       SET COOKIES
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
