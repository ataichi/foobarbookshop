/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.CustomerBean;
import Beans.LogBean;
import Beans.ProductOrderBean;
import Beans.ShoppingCartBean;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Interface.CustomerDAOInterface;
import DAO.Interface.LogDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ShoppingServlet", urlPatterns = {"/ShoppingServlet"})
public class ShoppingServlet extends HttpServlet {

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

            ArrayList<ProductOrderBean> orderlist = (ArrayList<ProductOrderBean>) session.getAttribute("temporder");
            ArrayList<ProductOrderBean> order = new ArrayList<ProductOrderBean>();
            ShoppingCartBean cartbean = (ShoppingCartBean) session.getAttribute("shoppingcart");
            AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
            CustomerBean customer = new CustomerBean();

            CustomerDAOInterface cdao = new CustomerDAOImplementation();
            double total = 0;

            boolean shopcartcheck = false;
            int i = 0, shoppingcartID;
            shoppingcartID = cdao.getShoppingCartID(); // returns last shoppingcartID

            customer = cdao.getCustomerByAccountID(homeuser.getAccountID());
            out.println(homeuser.getAccountID());

            // cartbean.setShoppingcartID(shoppingcartID);
            for (i = 0; i < orderlist.size(); i++) { // update total

                total += orderlist.get(i).getPrice() * orderlist.get(i).getQuantity();
            }

            Timestamp orderTime;
            java.util.Date date = new java.util.Date();
            orderTime = new Timestamp(date.getTime());

            LogBean log = new LogBean();
            LogDAOInterface logdao = new LogDAOImplementation();

            cartbean.setOrderDate(orderTime);
            cartbean.setShoppingcart_customerID(customer.getCustomerID());
            cartbean.setTotal(total);
         
            out.println(customer.getCustomerID());
            shopcartcheck = cdao.purchase(cartbean);
            if (shopcartcheck) {
                cartbean.setShoppingcart_customerID(homeuser.getAccountID());
                for (i = 0; i < orderlist.size(); i++) {
                    out.println("here here :( ");
                    cdao.addProductsToCart(orderlist.get(i), shoppingcartID + 1);
                }

                log.setActivity("Purchase Shopping Cart ID " + shoppingcartID + 1);
                log.setLog_accountID(homeuser.getAccountID());
                log.setTime(orderTime);

                if (logdao.addLog(log)) {
                    session.setAttribute("temporder", order);
                    out.println("yehey");
                    response.sendRedirect("customerHOME.jsp");
                }
            } else {
                //response.sendRedirect("");
                out.println("unable to purchase");
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
