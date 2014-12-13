/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.LockReportBean;
import Beans.LogBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.LockReportDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.LockReportDAOInterface;
import DAO.Interface.LogDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SendReport", urlPatterns = {"/SendReport"})
public class SendReport extends HttpServlet {

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

            LockReportBean lockreport = new LockReportBean();
            LockReportDAOInterface lockreportdao = new LockReportDAOImplementation();

            String email = request.getParameter("email");
            String reason = request.getParameter("reason");

            out.println(email);
            out.println(reason);

            AccountDAOInterface accountdao = new AccountDAOImplementation();
            AccountBean account = accountdao.getUserByEmailAddress(email);

            if (account.getAccountID() == 0) {
                out.println("User does not exist");
            } else {

                lockreport.setDone(0);
                lockreport.setEmailaddress(email);
                lockreport.setLockreport_accountID(account.getAccountID());
                lockreport.setReason(reason);

                LogBean log = new LogBean();
                LogDAOInterface logdao = new LogDAOImplementation();

                Timestamp time;
                java.util.Date date = new java.util.Date();
                time = new Timestamp(date.getTime());
                String activity = account.getAccountID() + " lock";
                // not sure if customerID or accountID dapat :)

                log.setActivity(activity);
                log.setLog_accountID(account.getAccountID());
                log.setTime(time);
                log.setIp_address(request.getRemoteAddr());

                if (lockreportdao.addLockReport(lockreport)) {
                    log.setStatus("successful");
                    logdao.addLog(log);
                    response.sendRedirect("homepage.jsp");
                } else {
                    log.setStatus("failed");
                    logdao.addLog(log);
                    response.sendRedirect("homepage.jsp");
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
