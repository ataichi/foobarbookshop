/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.CustomerBean;
import Beans.ProductBean;
import Beans.ProductOrderBean;
import Beans.ReviewBean;
import Beans.ShoppingCartBean;
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

@WebServlet(name = "ViewCustomerTransactions", urlPatterns = {"/ViewCustomerTransactions"})
public class ViewCustomerTransactions extends HttpServlet {

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

            //if (homeuser.getAccesscontrol().isViewtransactions()) {
            CustomerBean tempcustomer = (CustomerBean) session.getAttribute("tempcustomer");
            CustomerDAOInterface customerdao = new CustomerDAOImplementation();

            ArrayList<ProductOrderBean> productorderlist = new ArrayList<ProductOrderBean>();
            ArrayList<ProductOrderBean> finalproductorderlist = new ArrayList<ProductOrderBean>();
            ProductOrderBean productorder = new ProductOrderBean();
            ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
            ProductBean product = new ProductBean();
            ArrayList<ShoppingCartBean> shoppingcartlist = new ArrayList<ShoppingCartBean>();
            ProductDAOInterface productdao = new ProductDAOImplementation();
        //    ReviewBean review = new ReviewBean();
            ArrayList<ReviewBean> reviewlist = new ArrayList<ReviewBean>();

            out.println("CustomerID:" + tempcustomer.getCustomerID());
            shoppingcartlist = customerdao.getShoppingCartByCustomerID(tempcustomer.getCustomerID());

            out.println(shoppingcartlist.get(0).getShoppingcartID());
            out.println(shoppingcartlist.get(1).getShoppingcartID());

            for (int i = 0; i < shoppingcartlist.size(); i++) {
                productorderlist = customerdao.getProductOrderByShoppingCartID(shoppingcartlist.get(i).getShoppingcartID());
                out.println(shoppingcartlist.get(i).getOrderDate());
                out.println(shoppingcartlist.get(i).getShoppingcartID());
                for (int j = 0; j < productorderlist.size(); j++) {
                    // transfer productorderlist sa finalproductorderlist
                    productorder = productorderlist.get(j);
                    finalproductorderlist.add(productorder);

                    //arraylist of products bought
                    product = productdao.getProductById(productorder.getProductorder_productID());
                    productlist.add(product);

                    /*
                     review = new ReviewBean();
                     review = customerdao.getCustomerReviewForProduct(product.getProductID(), tempcustomer.getCustomerID());
                     if (review != null) {
                     reviewlist.add(review);
                     }
                     */
                }

            }

                // get transactions by customer
                /*
             session.setAttribute("productlist", productlist);
             session.setAttribute("finalproductorderlist", finalproductorderlist);
             session.setAttribute("shoppingcartlist", shoppingcartlist);
             //      session.setAttribute("reviewlist", reviewlist);
             */
            /*
             out.println("Productlist:" + productlist.size());
             out.println("\nFinalProductOrderList" + finalproductorderlist.size());
             out.println("\nShoppingCartList" + shoppingcartlist.size());

             out.println("PRODUCT LIST:\n");
             for (int i = 0; i < productlist.size(); i++) {
             out.println("Title: " + productlist.get(i).getTitle());
             out.println("\n");
             }

             out.println("FINAL PRODUCT ORDER LIST: \n");
             for (int i = 0; i < finalproductorderlist.size(); i++) {
             out.println("Product order ID: " + finalproductorderlist.get(i).getProductorderID());
             out.println("\n");
             }

             out.println("SHOPPING CART LIST: \n");
             for (int i = 0; i < shoppingcartlist.size(); i++) {
             out.println("Order date: " + shoppingcartlist.get(i).getOrderDate());
             out.println("\n");
             }
             */
            response.sendRedirect("customerTransactions.jsp");
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
