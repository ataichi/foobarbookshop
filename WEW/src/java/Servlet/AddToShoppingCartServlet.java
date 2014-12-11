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

@WebServlet(name = "AddToShoppingCartServlet", urlPatterns = {"/AddToShoppingCartServlet"})
public class AddToShoppingCartServlet extends HttpServlet {

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
            AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");

            //if (homeuser.getAccesscontrol().isAddtoshoppingcart()) {
            ArrayList<ProductOrderBean> order = (ArrayList<ProductOrderBean>) session.getAttribute("temporder");
            ArrayList<ProductOrderBean> neworder = new ArrayList<ProductOrderBean>();
            ProductOrderBean temporder = new ProductOrderBean();
            ProductBean productbean = new ProductBean();
            ArrayList<ProductBean> tempproductlist = (ArrayList<ProductBean>) session.getAttribute("tempproductlist");
            ProductDAOInterface productdao = new ProductDAOImplementation();

            ArrayList<ProductBean> productlist;

            out.println(request.getParameter("product"));
            int product = Integer.valueOf(request.getParameter("product"));
            out.println(product);
            productbean = productdao.getProductById(product);

            String action = request.getParameter("action");

            int quantity = Integer.valueOf(request.getParameter("qty"));
            out.println(product + "\n");
            out.println(quantity);

            temporder.setProductorder_productID(product);
            temporder.setQuantity(quantity);
            temporder.setPrice(productbean.getPrice() * quantity);

            productbean = productdao.getProductById(product);
            //     boolean updateStocks = productdao.updateStocks(product, productbean.getNumberStocks() - quantity);

            int sum = 0;
            double total = 0;
            boolean check = false;
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getProductorder_productID() == temporder.getProductorder_productID()) {
                    sum = quantity;
                    total = sum * temporder.getPrice();

                    order.get(i).setPrice(total);
                    order.get(i).setProductorderID(order.get(i).getProductorderID());
                    order.get(i).setProductorder_productID(temporder.getProductorder_productID());
                    order.get(i).setQuantity(sum);
                    check = true;
                    break;
                }

            }

            if (!check) { // not found
                order.add(temporder);
                out.println(order.size());
                tempproductlist.add(productbean);
            }

            if (action.equals("Add to Cart")) {
                session.setAttribute("temporder", order);
                session.setAttribute("tempproductlist", tempproductlist);
                out.println(order.size());
                out.println("DITO KASI");
                response.sendRedirect("customerHOME.jsp");
            } else { // buy
                response.sendRedirect("customerConfirmBillingInformation.jsp");
            }
            // out.println("ACCESS GRANTED");
            // response.sendRedirect("customerHOME.jsp");
            //} else {
            //    out.println("SORRY PO");
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
