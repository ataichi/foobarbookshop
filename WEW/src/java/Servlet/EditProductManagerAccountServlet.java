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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditProductManagerAccountServlet", urlPatterns = {"/EditProductManagerAccountServlet"})
public class EditProductManagerAccountServlet extends HttpServlet {

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
            String address = request.getRemoteAddr();
            AccountBean account = (AccountBean) session.getAttribute("homeproduct");

            //if (account.getAccesscontrol().isEditproductmanager()) {

                LogBean log = new LogBean();
                LogDAOInterface logdao = new LogDAOImplementation();

                AccountBean bean = new AccountBean();

                log.setIp_address(address);
                log.setActivity("Edit Product Manager Account ID: " + account.getAccountID());
                log.setLog_accountID(account.getAccountID());
                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());
                log.setTime(time);

                String firstName, lastName, middleInitial, username, emailAdd;

                if (request.getParameter("fname").isEmpty()) {
                    firstName = account.getFirstName();
                } else {
                    firstName = request.getParameter("fname");
                }

                if (request.getParameter("lname").isEmpty()) {
                    lastName = account.getLastName();
                } else {
                    lastName = request.getParameter("lname");
                }

                if (request.getParameter("mname").isEmpty()) {
                    middleInitial = account.getMiddleInitial();
                } else {
                    middleInitial = request.getParameter("mname");
                }

                if (request.getParameter("uname").isEmpty()) {
                    username = account.getUsername();
                } else {
                    username = request.getParameter("uname");
                }

                if (request.getParameter("email").isEmpty()) {
                    emailAdd = account.getEmailAdd();
                } else {
                    emailAdd = request.getParameter("email");
                }
                boolean locked = false;
                String password = account.getPassword();
                int id = account.getAccountID();
                AccountDAOInterface accountdao = new AccountDAOImplementation();
                bean.setAccountID(id);
                bean.setFirstName(AccountDAOImplementation.inputSanitizer(firstName));
                bean.setLastName(AccountDAOImplementation.inputSanitizer(lastName));
                bean.setMiddleInitial(middleInitial);
                bean.setUsername(AccountDAOImplementation.inputSanitizer(username));
                bean.setEmailAdd(emailAdd);
                bean.setLocked(locked);
                bean.setPassword(password);
                bean.setAccountType(account.getAccountType());

                boolean edit = accountdao.updateAccount(bean);
                if (edit) {
                    if (logdao.addLog(log)) { // edit account successfully -> log
                        session.setAttribute("homeproduct", bean);
                        response.sendRedirect("productmanagerHOME.jsp");
                    }
                } else {
                    session.setAttribute("homeproduct", bean);
                    response.sendRedirect("productmanagerAccount.jsp");
                }

            //} else {
            //    out.println("ACCESS DENIED");
            //}
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
