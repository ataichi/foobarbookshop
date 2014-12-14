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

@WebServlet(name = "EditCustomerPassword", urlPatterns = {"/EditCustomerPassword"})
public class EditCustomerPassword extends HttpServlet {

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
            HttpSession session = request.getSession();
            String address = request.getRemoteAddr();
            AccountBean account = (AccountBean) session.getAttribute("homeuser");

            if(account.getAccesscontrol().isEditpassword()){
            AccountBean bean = new AccountBean();

            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();
            String currpass, newpass, reenter;
            currpass = account.getPassword();
            newpass = request.getParameter("pass1");
            reenter = request.getParameter("pass2");

            java.util.Date date = new java.util.Date();
            Timestamp time = new Timestamp(date.getTime());

            log.setIp_address(address);
            log.setLog_accountID(account.getAccountID());
            log.setTime(time);
            log.setActivity("Change Password for Account ID " + account.getAccountID());
            int id = account.getAccountID();

            AccountDAOInterface accountdao = new AccountDAOImplementation();
            bean.setAccountID(id);

            bean.setPassword(newpass);

            boolean edit = accountdao.updateAccountPassword((bean));

            if (currpass.equals(request.getParameter("currpass"))) {
                edit = true;
            } else {
                edit = false;
            }

            out.println(edit);

            if (edit) {
                log.setStatus("successful");
                if (logdao.addLog(log)) {
                    session.setAttribute("homeuser", bean);
                    response.sendRedirect("customerHOME.jsp");
                }
            } else {
                session.setAttribute("homeuser", bean);
                response.sendRedirect("changepassword.jsp");
            }
            }else{
                out.println("ACCESS DENIED");
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
