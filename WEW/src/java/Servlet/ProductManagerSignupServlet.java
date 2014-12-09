package Servlet;

import Beans.AccountBean;
import Beans.LogBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.AdminDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.AdminDAOInterface;
import DAO.Interface.LogDAOInterface;
import DBConnection.Hasher;
import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.util.logging.PlatformLogger;

@WebServlet(name = "ProductManagerSignupServlet", urlPatterns = {"/ProductManagerSignupServlet"})
public class ProductManagerSignupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            HttpSession session = request.getSession();
            AccountBean homeadmin = (AccountBean) session.getAttribute("homeadmin");

            //if (homeadmin.getAccesscontrol().isCreateproductmanager()) {
                AccountBean account = new AccountBean();
                AccountDAOInterface userdao = new AccountDAOImplementation();
                AdminDAOInterface admindao = new AdminDAOImplementation();
                LogBean log = new LogBean();
                LogDAOInterface logdao = new LogDAOImplementation();

                String pass1 = request.getParameter("pass1");

                Hasher hash = null;

                try {
                    hash = new Hasher("MD5");
                } catch (NoSuchAlgorithmException ex) {
                    java.util.logging.Logger.getLogger(ProductManagerSignupServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                hash.updateHash(pass1, "UTF-8");
                pass1 = hash.getHashBASE64();

                account.setFirstName(AccountDAOImplementation.inputSanitizer(request.getParameter("fname")));
                account.setLastName(AccountDAOImplementation.inputSanitizer(request.getParameter("lname")));
                account.setMiddleInitial(request.getParameter("mname"));
                account.setPassword(pass1);
                account.setEmailAdd(request.getParameter("email"));
                account.setUsername(AccountDAOImplementation.inputSanitizer(request.getParameter("uname")));
                //account.setAccountType("product manager");
                account.setAccountType(request.getParameter("prodType") + " Manager");
                account.setLocked(false);

                int productmanager_accountID;
                boolean addUser = userdao.addAccount(account);
                if (addUser) {
                    //productmanager_accountID = userdao.getUserByUsername(request.getParameter("uname")).getAccountID();
                    //productManager.setProdmanager_accountID(productmanager_accountID);

                    java.util.Date date = new java.util.Date();
                    Timestamp time = new Timestamp(date.getTime());

                    log.setLog_accountID(homeadmin.getAccountID()); // temporary lang hehe
                    log.setTime(time);
                    log.setActivity("Product Manager Sign Up");
                    if (logdao.addLog(log)) {
                        response.sendRedirect("adminHOME.jsp");
                    }

                } else {
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
