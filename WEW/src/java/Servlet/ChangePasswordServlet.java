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

@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/ChangePasswordServlet"})
public class ChangePasswordServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePasswordServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePasswordServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            HttpSession session = request.getSession();

            String type = (String) session.getAttribute("type");
            AccountBean account = new AccountBean();
            if (type.equals("Customer")) {
                account = (AccountBean) session.getAttribute("homecustomer");
            } else if (type.equals("Audio CD Manager") || type.equals("Book Manager") || type.equals("DVD Manager") || type.equals("Magazine Manager")) {
                account = (AccountBean) session.getAttribute("homeproduct");
            } else if (type.equals("Accounting Manager")) {
                account = (AccountBean) session.getAttribute("homeaccounting");
            } else if (type.equals("Admin")) {
                account = (AccountBean) session.getAttribute("homeadmin");
            }

            AccountDAOInterface accountdao = new AccountDAOImplementation();

            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();

            String password1 = request.getParameter("password1");

            // hash password here
            String password2 = request.getParameter("password2");
            String password3 = request.getParameter("password3");

            boolean changepassword = accountdao.changePassword(account.getAccountID(), password3);

            if (changepassword) {
                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());
                log.setTime(time);
                log.setActivity("Change password account ID " + account.getAccountID());
                log.setLog_accountID(account.getAccountID());

                if (logdao.addLog(log)) {
                    account.setAccountID(account.getAccountID());
                    account.setAccountType(account.getAccountType());
                    account.setEmailAdd(account.getEmailAdd());
                    account.setFirstName(account.getFirstName());
                    account.setLastName(account.getLastName());
                    account.setLocked(false);
                    account.setMiddleInitial(account.getMiddleInitial());
                    // hashed value of password dapat
                    account.setPassword(password3);
                    account.setUsername(account.getUsername());

                    if (type.equals("Customer")) {
                        session.setAttribute("homecustomer", account);
                        response.sendRedirect("customerHOME.jsp");
                    } else if (type.equals("Audio CD Manager") || type.equals("Book Manager") || type.equals("DVD Manager") || type.equals("Magazine Manager")) {
                        session.setAttribute("homeproduct", account);
                        response.sendRedirect("productmanagerHOME.jsp");
                    } else if (type.equals("Accounting Manager")) {
                        session.setAttribute("homeaccounting", account);
                        response.sendRedirect("accountingmanagerHOME.jsp");
                    } else if (type.equals("Admin")) {
                        session.setAttribute("homeadmin", account);
                        response.sendRedirect("adminHOME.jsp");
                    }
                }
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