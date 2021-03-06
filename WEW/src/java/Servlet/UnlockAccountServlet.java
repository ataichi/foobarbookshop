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
import DAO.Implementation.AdminDAOImplementation;
import DAO.Implementation.LockReportDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.LockReportDAOInterface;
import DAO.Interface.LogDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UnlockAccountServlet", urlPatterns = {"/UnlockAccountServlet"})
public class UnlockAccountServlet extends HttpServlet {

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

            AccountBean homeadmin = (AccountBean) session.getAttribute("homeadmin");
            if (homeadmin.getAccesscontrol().isUnlockuser()) {
                int accountID = Integer.parseInt(request.getParameter("accountid"));

                AccountDAOInterface accountdao = new AccountDAOImplementation();
                AdminDAOImplementation admindao = new AdminDAOImplementation();

                LogBean log = new LogBean();
                LogDAOInterface logdao = new LogDAOImplementation();

                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());

                LockReportBean lockreport = new LockReportBean();
                LockReportDAOInterface lockreportdao = new LockReportDAOImplementation();
                ArrayList<LockReportBean> lockreportlist = (ArrayList<LockReportBean>) session.getAttribute("lockreportlist");
                ArrayList<AccountBean> lockedAccounts = (ArrayList<AccountBean>) session.getAttribute("lockedAccounts");
                int lockreportid = Integer.valueOf(request.getParameter("lockreportid"));

                lockreport = lockreportdao.getLockReportByID(lockreportid);

                lockreport.setDone(1);
                lockreport.setEmailaddress(lockreport.getEmailaddress());
                lockreport.setLockreportID(lockreportid);
                lockreport.setLockreport_accountID(lockreport.getLockreport_accountID());
                lockreport.setReason(lockreport.getReason());

                log.setLog_accountID(homeadmin.getAccountID());
                log.setTime(time);
                log.setActivity("Unlock account " + accountID);
                log.setIp_address(request.getRemoteAddr());

                if (admindao.unlockAccount(accountID) && lockreportdao.editLockReport(lockreport)) {
                    log.setStatus("Successful");
                    logdao.addLog(log);
                    ArrayList<LogBean> loglist = logdao.getAllLogs();
                    
                    lockreportlist = lockreportdao.getAllNotDoneLockReport();
                    lockedAccounts = accountdao.getAllLockedAccounts();
                    accountdao.setFailedLoginCountToZero(accountID);

                    session.setAttribute("loglist", loglist);
                    session.setAttribute("lockedreportlist", lockreportlist);
                    session.setAttribute("lockedAccounts", lockedAccounts);
                    response.sendRedirect("unlock_account.jsp");
                } else {
                    log.setStatus("failed");
                    logdao.addLog(log);
                    ArrayList<LogBean> loglist = logdao.getAllLogs();
                    
                    session.setAttribute("loglist", loglist);
                    response.sendRedirect("unlock_account.jsp");
                }
            } else {
          //      out.println("ACCESS DENIED");
                out.println(homeadmin.getAccesscontrol().isUnlockuser());
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
