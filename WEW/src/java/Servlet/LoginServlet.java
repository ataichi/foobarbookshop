package Servlet;

import Beans.AccountBean;
import Beans.AudioCDBean;
import Beans.BookBean;
import Beans.CreditCardBean;
import Beans.CustomerBean;
import Beans.DVDBean;
import Beans.MagazineBean;
import Beans.ProductBean;
import Beans.ProductOrderBean;
import Beans.ShoppingCartBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.AudioCDManagerDAOImplementation;
import DAO.Implementation.BookManagerDAOImplementation;
import DAO.Implementation.CreditCardDAOImplementation;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Implementation.DVDManagerDAOImplementation;
import DAO.Implementation.MagazineManagerDAOImplementation;
import DAO.Implementation.ProductManagerDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.AudioCDManagerDAOInterface;
import DAO.Interface.BookManagerDAOInterface;
import DAO.Interface.CreditCardDAOInterface;
import DAO.Interface.CustomerDAOInterface;
import DAO.Interface.DVDManagerDAOInterface;
import DAO.Interface.MagazineManagerDAOInterface;
import DAO.Interface.ProductManagerDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            AccountBean account = new AccountBean();

            String username = request.getParameter("loguser");
            String password = request.getParameter("logpass");

            AccountDAOInterface accountdao = new AccountDAOImplementation();
            account = accountdao.getUserByUsername(username);

            ShoppingCartBean shoppingcart = new ShoppingCartBean();
            ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
            ProductManagerDAOInterface pdao = new ProductManagerDAOImplementation();

            if (accountdao.doesUserExist(username, password) && "Customer".equals(account.getAccountType())) {
                CustomerDAOImplementation customerdao = new CustomerDAOImplementation();
                CreditCardDAOImplementation creditcarddao = new CreditCardDAOImplementation();
                CreditCardBean creditcard = new CreditCardBean();
                ArrayList<ProductOrderBean> temporder = new ArrayList<ProductOrderBean>();
                CustomerBean tempcustomer = customerdao.getCustomerByAccountID(account.getAccountID());
                int creditcardID = creditcarddao.getUserCreditCard(tempcustomer.getCustomerID());
                creditcard = creditcarddao.getCreditCardByCreditCardID(creditcardID);
                out.println(tempcustomer.getCustomerID());
                out.println(creditcardID);
                session.setAttribute("creditcard", creditcard);

                session.setAttribute("tempcustomer", tempcustomer);
                session.setAttribute("shoppingcart", shoppingcart);
                session.setAttribute("homeuser", account);
                session.setAttribute("temporder", temporder);
                response.sendRedirect("customerHOME.jsp");
            } else if (accountdao.doesUserExist(username, password) && "admin".equals(account.getAccountType())) {
                session.setAttribute("homeadmin", account);
                out.println("here");
                response.sendRedirect("adminHOME.jsp");

            } else if (accountdao.doesUserExist(username, password) && "Book Manager".equals(account.getAccountType())) {
                BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();
                ArrayList<BookBean> booklist = new ArrayList<BookBean>();
                booklist = bookdao.getAllBooks();
                session.setAttribute("booklist", booklist);

                productlist = pdao.getProductsByType("Book");
                session.setAttribute("productlist", productlist);
                session.setAttribute("homeproduct", account);
                response.sendRedirect("productmanagerHOME.jsp");
            } else if (accountdao.doesUserExist(username, password) && "Audio CD Manager".equals(account.getAccountType())) {
                AudioCDManagerDAOInterface cddao = new AudioCDManagerDAOImplementation();
                ArrayList<AudioCDBean> audiocdlist = new ArrayList<AudioCDBean>();
                audiocdlist = cddao.getAllAudioCD();
                session.setAttribute("audiocdlist", audiocdlist);

                productlist = pdao.getProductsByType("Audio CD");
                session.setAttribute("productlist", productlist);
                session.setAttribute("homeproduct", account);
                response.sendRedirect("productmanagerHOME.jsp");
            } else if (accountdao.doesUserExist(username, password) && "DVD Manager".equals(account.getAccountType())) {
                DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();
                ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
                dvdlist = dvddao.viewAllDVD();
                session.setAttribute("dvdlist", dvdlist);

                productlist = pdao.getProductsByType("DVD");
                session.setAttribute("productlist", productlist);
                session.setAttribute("homeproduct", account);
                response.sendRedirect("productmanagerHOME.jsp");
            } else if (accountdao.doesUserExist(username, password) && "Magazine Manager".equals(account.getAccountType())) {
                MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
                ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();
                magazinelist = magazinedao.getAllMagazine();

                productlist = pdao.getProductsByType("Magazine");
                session.setAttribute("productlist", productlist);
                session.setAttribute("homeproduct", account);
                response.sendRedirect("productmanagerHOME.jsp");
            } else if (accountdao.doesUserExist(username, password) && "accounting manager".equals(account.getAccountType())) {
                session.setAttribute("homeaccounting", account);
                response.sendRedirect("accountingmanagerHOME.jsp");
            } else {
                out.println(accountdao.doesUserExist(username, password));
                out.println(account.getAccountType());
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
