/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import Beans.AccountBean;
import Beans.LockReportBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.LockReportDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.LockReportDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
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
            
            if(account.getAccountID() == 0){
                out.println("User does not exist");
            }else{
                out.println(account.getAccountID());
                out.println("HERE!! :)");
                
                lockreport.setDone(0);
                lockreport.setEmailaddress(email);
                lockreport.setLockreport_accountID(account.getAccountID());
                lockreport.setReason(reason);
                
                if(lockreportdao.addLockReport(lockreport)){
                    out.println("successful");
                    response.sendRedirect("homepage.jsp");
                }else{
                    out.println("wag ka iiyak");
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
