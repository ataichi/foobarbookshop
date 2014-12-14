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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditAdminAccountServlet extends HttpServlet {

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
            AccountBean account = (AccountBean) session.getAttribute("homeadmin");

            if (account.getAccesscontrol().isEditadmin()) {
                LogBean log = new LogBean();
                LogDAOInterface logdao = new LogDAOImplementation();

                AccountBean bean = new AccountBean();
                String firstName, lastName, middleInitial, username, emailAdd;

                if (request.getParameter("editfirst").isEmpty()) {
                    firstName = account.getFirstName();
                } else {
                    firstName = request.getParameter("editfirst");
                }

                if (request.getParameter("editlast").isEmpty()) {
                    lastName = account.getLastName();
                } else {
                    lastName = request.getParameter("editlast");
                }

                if (request.getParameter("editmiddle").isEmpty()) {
                    middleInitial = account.getMiddleInitial();
                } else {
                    middleInitial = request.getParameter("editmiddle");
                }

                if (request.getParameter("edituser").isEmpty()) {
                    username = account.getUsername();
                } else {
                    username = request.getParameter("edituser");
                }

                if (request.getParameter("editemail").isEmpty()) {
                    emailAdd = account.getEmailAdd();
                } else {
                    emailAdd = request.getParameter("editemail");
                }
                boolean locked = false;
                String password = account.getPassword();
                int id = account.getAccountID();
                AccountDAOInterface accountdao = new AccountDAOImplementation();
                bean.setAccountID(id);
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setMiddleInitial(middleInitial);
                bean.setUsername(username);
                bean.setEmailAdd(emailAdd);
                bean.setLocked(locked);
                bean.setPassword(password);
                bean.setAccountType("Admin");

                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());

                log.setIp_address(address);
                log.setLog_accountID(account.getAccountID());
                log.setTime(time);
                log.setActivity("Edit Admin Account ID " + account.getAccountID());

                boolean edit = accountdao.updateAccount(bean);
                if (edit) {
                    log.setStatus("successful");
                    if (logdao.addLog(log)) {
                        session.setAttribute("homeadmin", bean);
                        response.sendRedirect("adminHOME.jsp");
                    }
                } else {
                    session.setAttribute("homeadmin", bean);
                    response.sendRedirect("adminAccount.jsp");
                }
            } else {
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
