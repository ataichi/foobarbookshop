package Servlet;

import Beans.*;
import DAO.Implementation.*;
import DAO.Interface.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
            HttpSession session = request.getSession();
            AccountBean account = new AccountBean();
            AccountDAOInterface userdao = new AccountDAOImplementation();
            AdminDAOInterface adao = new AdminDAOImplementation();
            AccountBean homeadmin = (AccountBean) session.getAttribute("homeadmin");

            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();
            String firstname = request.getParameter("fname");
            String lastname = request.getParameter("lname");
            String mInitial = request.getParameter("mname");
            String email = request.getParameter("email");
            String username = request.getParameter("uname");
            String pass1 = request.getParameter("pass1");
            boolean locked = false;

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

            log.setLog_accountID(homeadmin.getAccountID()); // temporary
            log.setTime(time);
            log.setActivity("Add new Accounting Manager " + account.getFirstName());

            boolean addUser = userdao.addAccount(account);

            if (addUser) {
                //accountingmanager_accountID = userdao.getUserByUsername(request.getParameter("uname")).getAccountID();
                //accountingManager.setAccountingManager_accountID(accountingmanager_accountID);
                if (logdao.addLog(log)) {
                    response.sendRedirect("adminHOME.jsp");
                }
            } else {
                response.sendRedirect("signup_accountingmanager.jsp");
            }
            /*
             boolean addAccountingManager = adao.addAccountingManager(accountingManager);
             if (addUser && addAccountingManager) {
             response.sendRedirect("adminHOME.jsp");
             //successful
             } else {
             response.sendRedirect("signupfail.jsp");
             }
             */
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
