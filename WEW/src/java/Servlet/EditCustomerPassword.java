/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Evy
 */
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
            AccountBean account = (AccountBean) session.getAttribute("homeuser");
            AccountBean bean = new AccountBean();

            String currpass, newpass, reenter;
            currpass = account.getPassword();
            newpass = request.getParameter("newpass");
            reenter = request.getParameter("reenter");

            int id = account.getAccountID();
            
            AccountDAOInterface accountdao = new AccountDAOImplementation();
            bean.setAccountID(id);
            
            bean.setPassword(newpass);
            
            boolean edit = accountdao.updateAccountPassword((bean));
           
            if(currpass == request.getParameter("currpass")){
                edit = true;
            }
            else{
                edit=false;
            }

            
            out.println(edit);

            if (edit) {
                session.setAttribute("homeuser", bean);
                response.sendRedirect("customerHOME.jsp");
            } else {
                session.setAttribute("homeuser", bean);
                response.sendRedirect("changepassword.jsp");
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