package Servlet;

import Beans.AccountBean;
import Beans.CustomerBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.CustomerDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SignupServlet", urlPatterns = {"/SignupServlet"})
public class SignupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            AccountBean account = new AccountBean();
            CustomerBean customer = new CustomerBean();
            AccountDAOInterface userdao = new AccountDAOImplementation();
            CustomerDAOInterface customerdao = new CustomerDAOImplementation();
            boolean checkAccount=false, checkCustomer=false;

            String firstname = request.getParameter("fname");
            String lastname = request.getParameter("lname");
            String mInitial = request.getParameter("mname");
            String email = request.getParameter("email");
            String username = request.getParameter("uname");
            String pass1 = request.getParameter("pass1");

            account.setFirstName(firstname);
            account.setLastName(lastname);
            account.setMiddleInitial(mInitial);
            account.setPassword(pass1);
            account.setEmailAdd(email);
            account.setUsername(username);
            account.setAccountType("customer");
            account.setLocked(false);
            
            checkAccount = userdao.addAccount(account);
            
            String billingAddress = request.getParameter("billingAddress");
            String shippingAddress = request.getParameter("shippingAddress");
            
            int customer_accountID = userdao.getUserByUsername(username).getAccountID();
            
        // setb illing address
            // set delivery address
            
            customer.setCustomer_accountID(customer_accountID);
            
            checkCustomer = customerdao.addCustomer(customer);
            
            if(checkAccount && checkCustomer){
//                  out.println("HI");
                response.sendRedirect("home.html");
            }
            else{
//                    out.println("NO");
               response.sendRedirect("loginfail.jsp");
            }
        } finally {
            out.close();
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
