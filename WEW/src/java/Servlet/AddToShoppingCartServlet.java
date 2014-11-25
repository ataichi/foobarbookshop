/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.ProductBean;
import Beans.ProductOrderBean;
import Beans.ShoppingCartBean;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Implementation.ProductDAOImplementation;
import DAO.Interface.CustomerDAOInterface;
import DAO.Interface.ProductDAOInterface;
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

/**
 *
 * @author Giodee
 */
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

            order.add(temporder);

            out.println(order.size());
            if (action.equals("Add to Cart")) {
                session.setAttribute("temporder", order);
            } else { // buy
                ShoppingCartBean cartbean = (ShoppingCartBean) session.getAttribute("shoppingcart");
                CustomerDAOInterface cdao = new CustomerDAOImplementation();
                boolean shopcartcheck = false;
                int i = 0, shoppingcartID;

                out.println(homeuser.getAccountID());

                cartbean.setShoppingcart_customerID(homeuser.getAccountID());

                cartbean.setShoppingcart_creditcardID(1);
                double total = 0;

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
                session.setAttribute("temporder", neworder); // new orderbean

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
