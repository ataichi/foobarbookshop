package Servlet;

import Beans.AccountBean;
import Beans.ProductManagerBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.AdminDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.AdminDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ProductManagerSignupServlet", urlPatterns = {"/ProductManagerSignupServlet"})
public class ProductManagerSignupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            HttpSession session = request.getSession();
            AccountBean account = new AccountBean();
            ProductManagerBean productManager = new ProductManagerBean();
            AccountDAOInterface userdao = new AccountDAOImplementation();
            AdminDAOInterface admindao = new AdminDAOImplementation();

            account.setFirstName(request.getParameter("fname"));
            account.setLastName(request.getParameter("lname"));
            account.setMiddleInitial(request.getParameter("mname"));
            account.setPassword(request.getParameter("pass1"));
            account.setEmailAdd(request.getParameter("email1"));
            account.setUsername(request.getParameter("uname"));
            account.setAccountType("product manager");
            account.setLocked(false);

            int productmanager_accountID;
            boolean addUser = userdao.addAccount(account);
            if (addUser) {
                productmanager_accountID = userdao.getUserByUsername(request.getParameter("uname")).getAccountID();
                productManager.setProdmanager_accountID(productmanager_accountID);

            }

            productManager.setProdType(request.getParameter("prodType"));

            boolean addProductmanager = admindao.addProductManager(productManager);

      //      out.println(userdao.addAccount(account));
            //      out.println(admindao.addProductManager(productManager));
            if (addUser && addProductmanager) {
                response.sendRedirect("adminHOME.jsp");
            } else {
                response.sendRedirect("signupfail.jsp");
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
