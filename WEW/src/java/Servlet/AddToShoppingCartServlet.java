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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToShoppingCartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToShoppingCartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            HttpSession session = request.getSession();

            ArrayList<ProductOrderBean> order = (ArrayList<ProductOrderBean>) session.getAttribute("temporder");
            ArrayList<ProductOrderBean> neworder = new ArrayList<ProductOrderBean>();
            ProductOrderBean temporder = new ProductOrderBean();
            AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
            ProductBean productbean = new ProductBean();
            ArrayList<ProductBean> tempproductlist = (ArrayList<ProductBean>) session.getAttribute("tempproductlist");
            ProductDAOInterface productdao = new ProductDAOImplementation();

            int product = Integer.valueOf(request.getParameter("product"));
            productbean = productdao.getProductById(product);

            String action = request.getParameter("action");

            int quantity = Integer.valueOf(request.getParameter("quantity"));
            out.println(product + "\n");
            out.println(quantity);

            temporder.setProductorder_productID(product);
            temporder.setQuantity(quantity);
            temporder.setPrice(productbean.getPrice() * quantity);

            int sum = 0;
            double total = 0;
            boolean check = false;
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getProductorder_productID() == temporder.getProductorder_productID()) {
                    sum = order.get(i).getQuantity() + temporder.getQuantity();
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
            } else { // buy
                ShoppingCartBean cartbean = (ShoppingCartBean) session.getAttribute("shoppingcart");
                CustomerDAOInterface cdao = new CustomerDAOImplementation();
                boolean shopcartcheck = false;
                int i = 0, shoppingcartID;

                out.println(homeuser.getAccountID());

                cartbean.setShoppingcart_customerID(homeuser.getAccountID());

                for (i = 0; i < order.size(); i++) { // update total
                    total += order.get(i).getPrice() * order.get(i).getQuantity();
                }
                cartbean.setTotal(total);
                Timestamp orderTime;
                java.util.Date date = new java.util.Date();
                orderTime = new Timestamp(date.getTime());
                cartbean.setOrderDate(orderTime);

                shopcartcheck = cdao.purchase(cartbean);

                if (shopcartcheck) {
                    shoppingcartID = cdao.getShoppingCartID();

                    cartbean.setShoppingcart_customerID(homeuser.getAccountID());
                    for (i = 0; i < order.size(); i++) {
                        cdao.addProductsToCart(order.get(i), shoppingcartID);
                    }
                    out.println("yehey");
                    //response.sendRedirect("");
                } else {
                    //response.sendRedirect("");
                    out.println("unable to purchase");
                }
                session.setAttribute("temporder", neworder); // new orderbean; reset

            }
            response.sendRedirect("customerHOME.jsp");

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
