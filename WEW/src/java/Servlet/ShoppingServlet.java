/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.CustomerBean;
import Beans.LogBean;
import Beans.ProductBean;
import Beans.ProductOrderBean;
import Beans.ShoppingCartBean;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import DAO.Implementation.ProductDAOImplementation;
import DAO.Interface.CustomerDAOInterface;
import DAO.Interface.LogDAOInterface;
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
            AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");

            if (homeuser.getAccesscontrol().isBuyproduct()) {
                ArrayList<ProductOrderBean> orderlist = (ArrayList<ProductOrderBean>) session.getAttribute("temporder");
                ArrayList<ProductBean> productsbought = (ArrayList<ProductBean>) session.getAttribute("productsbought");

                ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
                ArrayList<ProductBean> productaudiolist = (ArrayList<ProductBean>) session.getAttribute("productaudiolist");
                ArrayList<ProductBean> productbooklist = (ArrayList<ProductBean>) session.getAttribute("productbooklist");
                ArrayList<ProductBean> productdvdlist = (ArrayList<ProductBean>) session.getAttribute("productdvdlist");
                ArrayList<ProductBean> productmagazinelist = (ArrayList<ProductBean>) session.getAttribute("productmagazinelist");

                ShoppingCartBean cartbean = (ShoppingCartBean) session.getAttribute("shoppingcart");
                CustomerBean customer = new CustomerBean();
                CustomerDAOInterface cdao = new CustomerDAOImplementation();

                ProductBean productbean = new ProductBean();
                ProductDAOInterface productdao = new ProductDAOImplementation();

                double total = 0;

                boolean shopcartcheck = false;
                int i = 0, shoppingcartID;
                shoppingcartID = cdao.getShoppingCartID(); // returns last shoppingcartID
                String action = request.getParameter("action");

                /* Reset all
                 *  
                 */
                ArrayList<ProductOrderBean> neworderlist = new ArrayList<ProductOrderBean>();
                ArrayList<ProductBean> newproductlist = new ArrayList<ProductBean>();
                ShoppingCartBean newshoppingcart = new ShoppingCartBean();

                customer = cdao.getCustomerByAccountID(homeuser.getAccountID());

                // cartbean.setShoppingcart_customerID(homeuser.getAccountID());
                for (i = 0; i < orderlist.size(); i++) { // update total
                    total += orderlist.get(i).getPrice() * orderlist.get(i).getQuantity();
                }
                Timestamp orderTime;
                java.util.Date date = new java.util.Date();
                orderTime = new Timestamp(date.getTime());
                cartbean.setOrderDate(orderTime);
                cartbean.setShoppingcart_customerID(customer.getCustomerID());
                cartbean.setTotal(total);

                shopcartcheck = cdao.purchase(cartbean); // add to shopping cart table

                LogBean log = new LogBean();
                LogDAOImplementation logdao = new LogDAOImplementation();
                Timestamp time = new Timestamp(date.getTime());

                log.setLog_accountID(homeuser.getAccountID());
                log.setTime(time);
                log.setIp_address(request.getRemoteAddr());
                log.setActivity("Purchase Product");

                if (shopcartcheck) {
                    log.setStatus("successful");
                    logdao.addLog(log);
                    shoppingcartID = cdao.getShoppingCartID();

                    for (i = 0; i < orderlist.size(); i++) {
                        productbean = productdao.getProductById(orderlist.get(i).getProductorder_productID());
                        cdao.addProductsToCart(orderlist.get(i), shoppingcartID); // add to productorderbean
                        productdao.updateStocks(productbean.getProductID(), productbean.getNumberStocks() - orderlist.get(i).getQuantity());
                        productlist.add(productbean);
                        productsbought.add(productbean);
                    }
                    session.setAttribute("temporder", neworderlist);
                    session.setAttribute("productlist", orderlist);

                    session.setAttribute("productsbought", productsbought); // updated list of products bought
                    session.setAttribute("shoppingcart", newshoppingcart); // reset
                    response.sendRedirect("writeReview.jsp");
                } else {
                    log.setStatus("failed");
                    logdao.addLog(log);
                    response.sendRedirect("customerConfirmBillingInformation.jsp");

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
