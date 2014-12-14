/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.AudioCDBean;
import Beans.BookBean;
import Beans.CustomerBean;
import Beans.DVDBean;
import Beans.MagazineBean;
import Beans.ProductBean;
import Beans.ProductOrderBean;
import Beans.ReviewBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.AudioCDManagerDAOImplementation;
import DAO.Implementation.BookManagerDAOImplementation;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Implementation.DVDManagerDAOImplementation;
import DAO.Implementation.MagazineManagerDAOImplementation;
import DAO.Implementation.ProductDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.AudioCDManagerDAOInterface;
import DAO.Interface.BookManagerDAOInterface;
import DAO.Interface.CustomerDAOInterface;
import DAO.Interface.DVDManagerDAOInterface;
import DAO.Interface.MagazineManagerDAOInterface;
import DAO.Interface.ProductDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ShoppingCart", urlPatterns = {"/ShoppingCart"})
public class ShoppingCart extends HttpServlet {

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

            /* Start of declarations */
            ProductBean productbean = new ProductBean();
            ProductDAOInterface productdao = new ProductDAOImplementation();

            ArrayList<ProductOrderBean> order = (ArrayList<ProductOrderBean>) session.getAttribute("temporder");
            ArrayList<ProductOrderBean> neworder = new ArrayList<ProductOrderBean>();
            ProductOrderBean temporderbean = new ProductOrderBean();

            ArrayList<ProductBean> tempproductlist = (ArrayList<ProductBean>) session.getAttribute("tempproductlist");

            String action = request.getParameter("action");

            Cookie[] cookies = request.getCookies();
            boolean foundCookie = false;

            /* End of declarations */
            if (action.equals("Add to Cart")) { // add product to shopping cart

                /* Start  request.getParameter() */
                String qty = request.getParameter("qty");
                String product = request.getParameter("product");

                int int_qty = Integer.valueOf(qty);
                int int_product = Integer.valueOf(product);

                /* End  request.getParameter() */
                productbean = productdao.getProductById(int_product);

                temporderbean.setProductorder_productID(int_product);
                temporderbean.setQuantity(int_qty);
                temporderbean.setPrice(productbean.getPrice() * int_qty);

                int sum = 0;
                double total = 0;
                boolean check = false;

                for (int i = 0; i < order.size(); i++) {
                    for (int j = 0; j < tempproductlist.size(); j++) {
                        if (order.get(i).getProductorder_productID() == temporderbean.getProductorder_productID()
                                && tempproductlist.get(j).getProductID() == temporderbean.getProductorder_productID()) {
                            sum = int_qty;
                            total = sum * temporderbean.getPrice();

                            order.get(i).setPrice(total);
                            order.get(i).setProductorderID(order.get(i).getProductorderID());
                            order.get(i).setProductorder_productID(temporderbean.getProductorder_productID());
                            order.get(i).setQuantity(sum);

                            check = true;
                            break;
                        }
                    }
                }

                if (!check) {
                    /* Item not found */
                    order.add(temporderbean);
                    tempproductlist.add(productbean);
                }

                session.setAttribute("temporder", order);
                session.setAttribute("tempproductlist", tempproductlist);

                response.sendRedirect("customerHOME.jsp");
                /*
                 for (int i = 0; i < cookies.length; i++) {
                 Cookie cookie1 = cookies[i];
                 if (cookie1.getName().equals(homeuser.getUsername() + "-productid-" + product)) {
                 out.println("QTY = " + cookie1.getValue());
                 int temp = Integer.valueOf(cookie1.getValue());

                 cookie1.setValue(String.valueOf(temp + int_qty));
                 out.println(cookie1.getValue());
                 cookies[i] = cookie1;
                 out.println(cookies[i].getValue());

                 foundCookie = true;
                 }
                 }

                 if (!foundCookie) {
                 Cookie cookie1 = new Cookie(homeuser.getUsername() + "-productid-" + product, product);
                 cookie1.setMaxAge(24 * 60 * 60);
                 response.addCookie(cookie1);
                 out.println("ADD COOKIE");
                 }
                 */
            } else if (action.equals("Buy")) {
                response.sendRedirect("customerConfirmBillingInformation.jsp");
            } else if (action.equals("Save")) {
                out.println(action);

            } else if (action.equals("Remove")) {

                /* Start  request.getParameter() */
                String qty = request.getParameter("qty");
                String product = request.getParameter("product");

                int int_qty = Integer.valueOf(qty);
                int int_product = Integer.valueOf(product);

                /* End  request.getParameter() */
                productbean = productdao.getProductById(int_product);

                for (int i = 0; i < tempproductlist.size(); i++) {
                    if (tempproductlist.get(i).getProductID() == int_product) {

                        for (int j = 0; j < order.size(); j++) {
                            if (order.get(j).getProductorder_productID() == tempproductlist.get(i).getProductID()) {
                                order.remove(j);
                                tempproductlist.remove(i);
                            }

                            session.setAttribute("tempproductlist", tempproductlist);
                            session.setAttribute("temporder", order);
                            response.sendRedirect("customerHOME.jsp");
                        }

                    }

                }
            } else if (action.equals("View Details")) {

                /* Start  request.getParameter() */
                String qty = request.getParameter("qty");
                String product = request.getParameter("product");

                int int_qty = Integer.valueOf(qty);
                int int_product = Integer.valueOf(product);

                /* End  request.getParameter() */
                productbean = productdao.getProductById(int_product);

                ArrayList<ReviewBean> reviews = new ArrayList<ReviewBean>();
                CustomerBean customerbean = new CustomerBean();
                CustomerDAOInterface customerdao = new CustomerDAOImplementation();

                ArrayList<CustomerBean> customerlist = new ArrayList<CustomerBean>();
                ArrayList<AccountBean> accountlist = new ArrayList<AccountBean>();
                AccountBean accountbean = new AccountBean();
                AccountDAOInterface accountdao = new AccountDAOImplementation();

                reviews = customerdao.getReviewsByProductID(int_product);

                for (int i = 0; i < reviews.size(); i++) {
                    customerbean = customerdao.getCustomerById(reviews.get(i).getReview_customerID());
                    customerlist.add(customerbean);

                    accountbean = accountdao.getUserByAccountID(customerbean.getCustomer_accountID());
                    accountlist.add(accountbean);
                }

                session.setAttribute("viewproduct", productbean);
                session.setAttribute("accountlist", accountlist);
                session.setAttribute("reviews", reviews);
                session.setAttribute("customerlist", customerlist);
                session.setAttribute("prodType", productbean.getType());

                if (productbean.getType().equals("Audio CD")) {
                    // view audio cd
                    AudioCDBean audiocdbean = new AudioCDBean();
                    AudioCDManagerDAOInterface audiocddao = new AudioCDManagerDAOImplementation();

                    audiocdbean = audiocddao.getAudioCDByProductID(productbean.getProductID());

                    session.setAttribute("viewaudiocd", audiocdbean);
                    response.sendRedirect("viewcustomerproduct.jsp");

                } else if (productbean.getType().equals("Book")) {
                    // view Book   
                    BookBean bookbean = new BookBean();
                    BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();

                    bookbean = bookdao.getBookByProductID(productbean.getProductID());

                    session.setAttribute("viewbook", bookbean);
                    response.sendRedirect("viewcustomerproduct.jsp");

                } else if (productbean.getType().equals("DVD")) {
                    // view dvd
                    DVDBean dvdbean = new DVDBean();
                    DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();

                    dvdbean = dvddao.getDVDByProductID(productbean.getProductID());

                    session.setAttribute("viewdvd", dvdbean);
                    response.sendRedirect("viewcustomerproduct.jsp");

                } else if (productbean.getType().equals("Magazine")) {
                    // view magazine
                    MagazineBean magazinebean = new MagazineBean();
                    MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();

                    magazinebean = magazinedao.getMagazineByProductID(productbean.getProductID());

                    session.setAttribute("viewmagazine", magazinebean);
                    response.sendRedirect("viewcustomerproduct.jsp");
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
