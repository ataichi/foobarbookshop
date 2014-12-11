/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.CustomerBean;
import Beans.LogBean;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Interface.LogDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditBillingInfoServlet", urlPatterns = {"/EditBillingInfoServlet"})
public class EditBillingInfoServlet extends HttpServlet {

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
            AccountBean oldbean = (AccountBean) session.getAttribute("homeuser");

            CustomerDAOImplementation cdao = new CustomerDAOImplementation();
            CustomerBean cbean = (CustomerBean) session.getAttribute("tempcustomer");

            cbean = cdao.getCustomerByAccountID(oldbean.getAccountID());

            String BA = request.getParameter("BA");
            String DA = request.getParameter("DA");

            cbean.setCustomer_accountID(oldbean.getAccountID());

            cbean.setBA(BA);
            cbean.setDA(DA);

            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();
            java.util.Date date = new java.util.Date();
            Timestamp time = new Timestamp(date.getTime());

            log.setIp_address(address);
            log.setLog_accountID(oldbean.getAccountID());
            log.setTime(time);
            log.setActivity("Edit Billing Information of Account ID " + oldbean.getAccountID());
            out.println(cbean.getCustomerID());
            boolean check;
            if (cbean.getCustomerID() == 0) {
                check = cdao.addCustomer(cbean);
                if (check) {
                    if (logdao.addLog(log)) {
                        session.setAttribute("tempcustomer", cbean);
                        response.sendRedirect("customerHOME.jsp");
                        out.println("yes");
                    }
                } else {
                    session.setAttribute("tempcustomer", cbean);
                    response.sendRedirect("customerAccount.jsp");
                    out.println("np");
                }
            } else {
                check = cdao.editAddress(cbean);
                if (check) {
                    if (logdao.addLog(log)) {
                        session.setAttribute("tempcustomer", cbean);
                        response.sendRedirect("customerHOME.jsp");
                        out.println("yehey");
                    }
                } else {
                    session.setAttribute("tempcustomer", cbean);
                    response.sendRedirect("customerAccount.jsp");
                    out.println("bye");
                }
            }

        } catch (Exception e) {
            out.println("error");
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
