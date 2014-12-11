/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.ProductBean;
import Beans.ProductOrderBean;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Implementation.ProductDAOImplementation;
import DAO.Interface.CustomerDAOInterface;
import DAO.Interface.ProductDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditShoppingCartServlet", urlPatterns = {"/EditShoppingCartServlet"})
public class EditShoppingCartServlet extends HttpServlet {

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
            AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");

            //if (homeuser.getAccesscontrol().isEditshoppingcart()) {
            ArrayList<ProductOrderBean> temporder = (ArrayList<ProductOrderBean>) session.getAttribute("temporder");
            ProductOrderBean tempproductorder = new ProductOrderBean();
            ArrayList<ProductBean> tempproduct = (ArrayList<ProductBean>) session.getAttribute("tempproductlist");
            ProductBean productbean = new ProductBean();

            ProductDAOInterface productdao = new ProductDAOImplementation();
            CustomerDAOInterface customerdao = new CustomerDAOImplementation();

            int productid = Integer.valueOf(request.getParameter("productid"));
//            int productorderid = Integer.valueOf(request.getParameter("productorderid"));
            String action = request.getParameter("action");

            out.println(productid);
            //     productbean = productdao.getProductById(productid);
            //   tempproductorder = customerdao.getProductOrderBeanByID(productid);
            //    out.println(tempproductorder.getProductorderID());
            //     session.setAttribute("tempproductorder", productbean);
            //   session.setAttribute("editproduct", productbean);
            out.println(temporder.size());
            out.println(tempproduct.size());
            if (action.equals("Remove")) { // remove product
                out.println("REMOVE");
                for (int i = 0; i < tempproduct.size(); i++) {
                    if (tempproduct.get(i).getProductID() == productid) {
                        temporder.remove(i);
                        tempproduct.remove(i);

                        session.setAttribute("tempproductlist", tempproduct);
                        session.setAttribute("temporder", temporder);
                        response.sendRedirect("customerHOME.jsp");

                    }
                }

            } else {
                int quantity = Integer.valueOf(request.getParameter("qty"));

                for (int i = 0; i < temporder.size(); i++) {

                    if (temporder.get(i).getProductorder_productID() == productid) {
                        temporder.get(i).setQuantity(quantity);
                        temporder.get(i).setPrice(quantity * productbean.getPrice());
                        out.println(temporder.get(i).getPrice());
                        session.setAttribute("temporder", temporder);
                        response.sendRedirect("customerConfirmCart.jsp");

                    }
                }
                out.println(action);
            }
            //           response.sendRedirect("customerEditShoppingCart.jsp");
            //} else {
            //    out.println("ACCESS DENIED");
            //}
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
