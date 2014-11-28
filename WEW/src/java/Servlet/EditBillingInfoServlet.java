/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.AccountBean;
import Beans.CustomerBean;
import DAO.Implementation.CustomerDAOImplementation;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditBillingInfoServlet", urlPatterns = {"/EditBillingInfoServlet"})
public class EditBillingInfoServlet extends HttpServlet {

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

            CustomerDAOImplementation cdao = new CustomerDAOImplementation();
            CustomerBean cbean = (CustomerBean) session.getAttribute("tempcustomer");
            AccountBean oldbean = (AccountBean) session.getAttribute("homeuser");

            cbean = cdao.getCustomerByAccountID(oldbean.getAccountID());

            String apartmentnoBA, streetBA, subBA, cityBA, countryBA;
            int postalcodeBA;
            String apartmentnoDA, streetDA, subDA, cityDA, countryDA;
            int postalcodeDA;

            apartmentnoBA = request.getParameter("apartmentnoBA");
            streetBA = request.getParameter("streetBA");
            subBA = request.getParameter("subdivisionBA");
            cityBA = request.getParameter("cityBA");
            countryBA = request.getParameter("countryBA");
            postalcodeBA = Integer.parseInt(request.getParameter("postalcodeBA"));

            apartmentnoDA = request.getParameter("apartmentnoDA");
            streetDA = request.getParameter("streetDA");
            subDA = request.getParameter("subdivisionDA");
            cityDA = request.getParameter("cityDA");
            countryDA = request.getParameter("countryDA");
            postalcodeDA = Integer.parseInt(request.getParameter("postalcodeDA"));

            cbean.setCustomer_accountID(oldbean.getAccountID());

            cbean.setApartmentNoBA(apartmentnoBA);
            cbean.setApartmentNoDA(apartmentnoDA);
            cbean.setCityBA(cityBA);
            cbean.setCityDA(cityDA);
            cbean.setCountryBA(countryBA);
            cbean.setCountryDA(countryDA);
            cbean.setPostalCodeBA(postalcodeBA);
            cbean.setPostalCodeDA(postalcodeDA);
            cbean.setStreetBA(streetBA);
            cbean.setStreetDA(streetDA);
            cbean.setSubdivisionBA(subBA);
            cbean.setSubdivisionDA(subDA);

            out.println(cbean.getCustomerID());
            boolean check;
            if (cbean.getCustomerID() == 0) {
                check = cdao.addCustomer(cbean);
                if (check) {
                    session.setAttribute("tempcustomer", cbean);
                    response.sendRedirect("customerHOME.jsp");
                    out.println("yes");
                } else {
                    session.setAttribute("tempcustomer", cbean);
                    response.sendRedirect("customerAccount.jsp");
                    out.println("np");
                }
            } else {
                check = cdao.editAddress(cbean);
                if (check) {
                    session.setAttribute("tempcustomer", cbean);
                    response.sendRedirect("customerHOME.jsp");
                    out.println("yehey");
                } else {
                    session.setAttribute("tempcustomer", cbean);
                    response.sendRedirect("customerAccount.jsp");
                    out.println("bye");
                }
            }

        } catch (Exception e) {
            out.println("error");
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
