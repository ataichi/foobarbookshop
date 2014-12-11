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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditCustomerAccountServlet", urlPatterns = {"/EditCustomerAccountServlet"})

public class EditCustomerAccountServlet extends HttpServlet {

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
            AccountBean account = (AccountBean) session.getAttribute("homeuser");

            if (account.getAccesscontrol().isEditcustomer()) {
                LogBean log = new LogBean();
                LogDAOInterface logdao = new LogDAOImplementation();

                AccountBean bean = new AccountBean();

                String firstName, lastName, middleInitial, username, emailAdd;

                firstName = request.getParameter("fname");

                lastName = request.getParameter("lname");

                middleInitial = request.getParameter("mname");

                username = request.getParameter("uname");

                emailAdd = request.getParameter("email");

                boolean locked = false;
                int id = account.getAccountID();

                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());
                log.setIp_address(address);
                log.setTime(time);
                log.setLog_accountID(account.getAccountID());
                log.setActivity("Edit Customer Account " + account.getUsername());

                AccountDAOInterface accountdao = new AccountDAOImplementation();
                bean.setAccountID(id);
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setMiddleInitial(middleInitial);
                bean.setUsername(username);
                bean.setEmailAdd(emailAdd);
                bean.setLocked(locked);
                bean.setAccountType("Customer");

                boolean edit = accountdao.updateAccount(bean);
                out.println(edit);

                if (edit) {
                    if (logdao.addLog(log)) {
                        session.setAttribute("homeuser", bean);
                        response.sendRedirect("customerHOME.jsp");
                    }
                } else {
                    session.setAttribute("homeuser", bean);
                    response.sendRedirect("customerAccount.jsp");
                }
            } else {
                out.println("ACCESS DENIED");
            }

        } catch (Exception e) {

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
