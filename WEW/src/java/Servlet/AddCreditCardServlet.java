/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.CreditCardBean;
import Beans.CustomerBean;
import Beans.CustomerCreditCardBean;
import DAO.Implementation.CreditCardDAOImplementation;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Interface.CreditCardDAOInterface;
import DAO.Interface.CustomerDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddCreditCardServlet", urlPatterns = {"/AddCreditCardServlet"})
public class AddCreditCardServlet extends HttpServlet {

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
            CustomerBean customer = (CustomerBean) session.getAttribute("tempcustomer");
            CreditCardBean creditcard = (CreditCardBean) session.getAttribute("creditcard");
            CustomerDAOInterface customerdao = new CustomerDAOImplementation();

            CustomerCreditCardBean customercreditcardbean = new CustomerCreditCardBean();
            CreditCardDAOInterface creditcarddao = new CreditCardDAOImplementation();
            String cardName, cardNo, cardType, cardExpDate;

            int creditcardid = 0;
            creditcardid = creditcarddao.getUserCreditCard(customer.getCustomerID());

            if (creditcardid == 0) { // add new creditcard
                cardName = request.getParameter("cardName");
                cardNo = request.getParameter("cardNo");
                cardType = request.getParameter("cardType");
                cardExpDate = request.getParameter("cardExpDate");

                creditcard.setCardname(cardName);
                creditcard.setCardno(cardNo);
                creditcard.setCardtype(cardType);
                creditcard.setCardexpdate(cardExpDate);
                boolean addCreditcard = creditcarddao.addCreditCard(creditcard);

                if (addCreditcard) {

                    int last = creditcarddao.getLastCreditCard().getCreditcardID();
                    customercreditcardbean.setCustomercreditcard_customerID(customer.getCustomerID());
                    customercreditcardbean.setCustomercreditcard_creditcardID(last);
                    out.println(customercreditcardbean.getCustomercreditcard_customerID());
                    boolean addCustomercreditcard = customerdao.addCustomerCreditCard(customercreditcardbean);
                    if (addCustomercreditcard) {

                        session.setAttribute("creditcard", creditcard);

                    } else {
                        out.println("NO");
                    }

                }

            } else { // edit existing creditcard
                creditcardid = creditcarddao.getUserCreditCard(customer.getCustomerID());
                creditcard = creditcarddao.getCreditCardByCreditCardID(creditcardid);

                cardName = request.getParameter("cardName");
                cardNo = request.getParameter("cardNo");
                cardType = request.getParameter("cardType");
                cardExpDate = request.getParameter("cardExpDate");

                creditcard.setCardname(cardName);
                creditcard.setCardno(cardNo);
                creditcard.setCardtype(cardType);
                creditcard.setCardexpdate(cardExpDate);
                
                out.println(creditcard.getCreditcardID() + "\n");
                out.println(creditcard.getCardexpdate() + "\n");
                out.println(creditcard.getCardno() + "\n");
                out.println(creditcard.getCardtype() + "\n");
                boolean editCreditcard = creditcarddao.editCreditCard(creditcard);
                if (editCreditcard) {
                    out.println("yesyes");
                    session.setAttribute("creditcard", creditcard);
                    response.sendRedirect("customerHOME.jsp");
                } else {
                    out.println("nope");
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
