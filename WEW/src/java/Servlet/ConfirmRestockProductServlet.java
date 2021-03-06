/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.*;
import DAO.Implementation.*;
import DAO.Interface.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ConfirmRestockProductServlet", urlPatterns = {"/ConfirmRestockProductServlet"})
public class ConfirmRestockProductServlet extends HttpServlet {

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

            if (account.getAccesscontrol().isRestockproduct()) {
                ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
                ProductBean restockproduct = (ProductBean) session.getAttribute("restockproduct");
                ProductManagerDAOInterface productmanagerdao = new ProductManagerDAOImplementation();
                ProductDAOInterface productdao = new ProductDAOImplementation();

                int newstocks = Integer.valueOf(request.getParameter("numberstocks"));

                LogBean log = new LogBean();
                LogDAOInterface logdao = new LogDAOImplementation();
                java.util.Date date = new java.util.Date();
                Timestamp time = new Timestamp(date.getTime());

                log.setIp_address(address);
                log.setLog_accountID(account.getAccountID());
                log.setTime(time);
                log.setActivity("Restock Confirm Restock for Product ID " + restockproduct.getProductID());

                out.println(newstocks);
                boolean checkRestock = productmanagerdao.restockProduct(newstocks, restockproduct.getProductID());

                if (checkRestock) {
                    productlist = productmanagerdao.getProductsByType(restockproduct.getType());
                    log.setStatus("successful");
                    logdao.addLog(log);
                    session.setAttribute("productlist", productlist);
                    response.sendRedirect("productmanagerHOME.jsp");
                } else {
                    //set cookies unable to restock
                    log.setStatus("failed");
                    logdao.addLog(log);
                    response.sendRedirect("restockproduct.jsp");
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
