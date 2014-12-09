/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Security;

import Beans.AccountBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import Process.Hasher;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.errors.AuthenticationException;

public class LoginAuthenticator {

    private boolean isLoggedIn = false;

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public AccountBean login(HttpServletRequest hsr, HttpServletResponse hsr1) throws AuthenticationException {
        AccountBean account = new AccountBean();
        AccountDAOInterface accountdao = new AccountDAOImplementation();

        AccessController accesscontrol = new AccessController();

        String username = hsr.getParameter("loguser");
        String password = hsr.getParameter("logpass");
        String type;

        int ctr_try = Integer.parseInt(hsr.getParameter("ctr_try"));

        String algorithm = "MD5";

        try {

            Hasher hash = new Hasher(algorithm);
            try {
                hash.updateHash(password, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
            }
            password = hash.getHashBASE64();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
        }

        account = accountdao.getUserByUsername(username);
        password = hsr.getParameter("logpass");
        if (accountdao.doesUserExist(username, password) && "Customer".equals(account.getAccountType()) && !account.getLocked()) {
            // Customer
            accesscontrol.createcustomer = false;
            accesscontrol.editcustomer = true;
            accesscontrol.deletecustomer = true;

            accesscontrol.createproductmanager = false;
            accesscontrol.editproductmanager = false;
            accesscontrol.deleteproductmanager = false;

            accesscontrol.createaccountingmanager = false;
            accesscontrol.editaccountingmanager = false;
            accesscontrol.deleteaccountingmanager = false;

            accesscontrol.postmessage = true;
            accesscontrol.editmessage = true;
            accesscontrol.viewmessage = true;
            accesscontrol.deletemessage = true;

            accesscontrol.addproduct = false;
            accesscontrol.editproduct = false;
            accesscontrol.deleteproduct = false;
            accesscontrol.restockproduct = false;

            accesscontrol.viewsales = false;
            accesscontrol.unlockuser = false;
            accesscontrol.viewtransactions = true;
            accesscontrol.viewactivity = false;
            accesscontrol.buyproduct = true;

            accesscontrol.addtoshoppingcart = true;
            accesscontrol.editshoppingcart = true;
            accesscontrol.removeproductfromshoppingcart = true;
            accesscontrol.viewproduct = true;

            accesscontrol.editpassword = true;

            accesscontrol.addadmin = false;
            accesscontrol.editadmin = false;
            accesscontrol.deleteadmin = false;

            account.setAccesscontrol(accesscontrol);

            return account;

        } else if (accountdao.doesUserExist(username, password) && "Admin".equals(account.getAccountType()) && !account.getLocked()) {
            // Admin
            accesscontrol.createcustomer = false;
            accesscontrol.editcustomer = false;
            accesscontrol.deletecustomer = false;

            accesscontrol.createproductmanager = true;
            accesscontrol.editproductmanager = true;
            accesscontrol.deleteproductmanager = true;

            accesscontrol.createaccountingmanager = true;
            accesscontrol.editaccountingmanager = true;
            accesscontrol.deleteaccountingmanager = true;

            accesscontrol.postmessage = false;
            accesscontrol.editmessage = false;
            accesscontrol.viewmessage = false;
            accesscontrol.deletemessage = false;

            accesscontrol.addproduct = false;
            accesscontrol.editproduct = false;
            accesscontrol.deleteproduct = false;
            accesscontrol.restockproduct = false;

            accesscontrol.viewsales = false;
            accesscontrol.unlockuser = true;
            accesscontrol.viewtransactions = false;
            accesscontrol.viewactivity = true;
            accesscontrol.buyproduct = false;

            accesscontrol.addtoshoppingcart = false;
            accesscontrol.editshoppingcart = false;
            accesscontrol.removeproductfromshoppingcart = false;
            accesscontrol.viewproduct = false;

            accesscontrol.editpassword = true;

            accesscontrol.addadmin = false;
            accesscontrol.editadmin = false;
            accesscontrol.deleteadmin = false;

            account.setAccesscontrol(accesscontrol);

            return account;

        } else if (accountdao.doesUserExist(username, password) && "Book Manager".equals(account.getAccountType()) && !account.getLocked()) {
            // Book Manager
            accesscontrol.createcustomer = false;
            accesscontrol.editcustomer = false;
            accesscontrol.deletecustomer = false;

            accesscontrol.createproductmanager = false;
            accesscontrol.editproductmanager = true;
            accesscontrol.deleteproductmanager = true;

            accesscontrol.createaccountingmanager = false;
            accesscontrol.editaccountingmanager = false;
            accesscontrol.deleteaccountingmanager = false;

            accesscontrol.postmessage = false;
            accesscontrol.editmessage = false;
            accesscontrol.viewmessage = true;
            accesscontrol.deletemessage = false;

            accesscontrol.addproduct = true;
            accesscontrol.editproduct = true;
            accesscontrol.deleteproduct = true;
            accesscontrol.restockproduct = true;

            accesscontrol.viewsales = false;
            accesscontrol.unlockuser = false;
            accesscontrol.viewtransactions = false;
            accesscontrol.viewactivity = false;
            accesscontrol.buyproduct = false;

            accesscontrol.addtoshoppingcart = false;
            accesscontrol.editshoppingcart = false;
            accesscontrol.removeproductfromshoppingcart = false;
            accesscontrol.viewproduct = true;

            accesscontrol.editpassword = true;

            accesscontrol.addadmin = false;
            accesscontrol.editadmin = false;
            accesscontrol.deleteadmin = false;

            account.setAccesscontrol(accesscontrol);

            return account;

        } else if (accountdao.doesUserExist(username, password) && "Audio CD Manager".equals(account.getAccountType()) && !account.getLocked()) {
            // Audio CD Manager
            accesscontrol.createcustomer = false;
            accesscontrol.editcustomer = false;
            accesscontrol.deletecustomer = false;

            accesscontrol.createproductmanager = false;
            accesscontrol.editproductmanager = true;
            accesscontrol.deleteproductmanager = true;

            accesscontrol.createaccountingmanager = false;
            accesscontrol.editaccountingmanager = false;
            accesscontrol.deleteaccountingmanager = false;

            accesscontrol.postmessage = false;
            accesscontrol.editmessage = false;
            accesscontrol.viewmessage = true;
            accesscontrol.deletemessage = false;

            accesscontrol.addproduct = true;
            accesscontrol.editproduct = true;
            accesscontrol.deleteproduct = true;
            accesscontrol.restockproduct = true;

            accesscontrol.viewsales = false;
            accesscontrol.unlockuser = false;
            accesscontrol.viewtransactions = false;
            accesscontrol.viewactivity = false;
            accesscontrol.buyproduct = false;

            accesscontrol.addtoshoppingcart = false;
            accesscontrol.editshoppingcart = false;
            accesscontrol.removeproductfromshoppingcart = false;
            accesscontrol.viewproduct = true;

            accesscontrol.editpassword = true;

            accesscontrol.addadmin = false;
            accesscontrol.editadmin = false;
            accesscontrol.deleteadmin = false;

            account.setAccesscontrol(accesscontrol);

            return account;

        } else if (accountdao.doesUserExist(username, password) && "DVD Manager".equals(account.getAccountType()) && !account.getLocked()) {
            // DVD Manager
            accesscontrol.createcustomer = false;
            accesscontrol.editcustomer = false;
            accesscontrol.deletecustomer = false;

            accesscontrol.createproductmanager = false;
            accesscontrol.editproductmanager = true;
            accesscontrol.deleteproductmanager = true;

            accesscontrol.createaccountingmanager = false;
            accesscontrol.editaccountingmanager = false;
            accesscontrol.deleteaccountingmanager = false;

            accesscontrol.postmessage = false;
            accesscontrol.editmessage = false;
            accesscontrol.viewmessage = true;
            accesscontrol.deletemessage = false;

            accesscontrol.addproduct = true;
            accesscontrol.editproduct = true;
            accesscontrol.deleteproduct = true;
            accesscontrol.restockproduct = true;

            accesscontrol.viewsales = false;
            accesscontrol.unlockuser = false;
            accesscontrol.viewtransactions = false;
            accesscontrol.viewactivity = false;
            accesscontrol.buyproduct = false;

            accesscontrol.addtoshoppingcart = false;
            accesscontrol.editshoppingcart = false;
            accesscontrol.removeproductfromshoppingcart = false;
            accesscontrol.viewproduct = true;

            accesscontrol.editpassword = true;

            accesscontrol.addadmin = false;
            accesscontrol.editadmin = false;
            accesscontrol.deleteadmin = false;

            account.setAccesscontrol(accesscontrol);

            return account;

        } else if (accountdao.doesUserExist(username, password) && "Magazine Manager".equals(account.getAccountType()) && !account.getLocked()) {
            // Magazine Manager
            accesscontrol.createcustomer = false;
            accesscontrol.editcustomer = false;
            accesscontrol.deletecustomer = false;

            accesscontrol.createproductmanager = false;
            accesscontrol.editproductmanager = true;
            accesscontrol.deleteproductmanager = true;

            accesscontrol.createaccountingmanager = false;
            accesscontrol.editaccountingmanager = false;
            accesscontrol.deleteaccountingmanager = false;

            accesscontrol.postmessage = false;
            accesscontrol.editmessage = false;
            accesscontrol.viewmessage = true;
            accesscontrol.deletemessage = false;

            accesscontrol.addproduct = true;
            accesscontrol.editproduct = true;
            accesscontrol.deleteproduct = true;
            accesscontrol.restockproduct = true;

            accesscontrol.viewsales = false;
            accesscontrol.unlockuser = false;
            accesscontrol.viewtransactions = false;
            accesscontrol.viewactivity = false;
            accesscontrol.buyproduct = false;

            accesscontrol.addtoshoppingcart = false;
            accesscontrol.editshoppingcart = false;
            accesscontrol.removeproductfromshoppingcart = false;
            accesscontrol.viewproduct = true;

            accesscontrol.editpassword = true;

            accesscontrol.addadmin = false;
            accesscontrol.editadmin = false;
            accesscontrol.deleteadmin = false;

            account.setAccesscontrol(accesscontrol);

            return account;
        } else if (accountdao.doesUserExist(username, password) && "Accounting Manager".equals(account.getAccountType()) && !account.getLocked()) {
            // Accounting Manager
            accesscontrol.createcustomer = false;
            accesscontrol.editcustomer = false;
            accesscontrol.deletecustomer = false;

            accesscontrol.createproductmanager = false;
            accesscontrol.editproductmanager = true;
            accesscontrol.deleteproductmanager = true;

            accesscontrol.createaccountingmanager = false;
            accesscontrol.editaccountingmanager = true;
            accesscontrol.deleteaccountingmanager = true;

            accesscontrol.postmessage = false;
            accesscontrol.editmessage = false;
            accesscontrol.viewmessage = false;
            accesscontrol.deletemessage = false;

            accesscontrol.addproduct = true;
            accesscontrol.editproduct = true;
            accesscontrol.deleteproduct = true;
            accesscontrol.restockproduct = true;

            accesscontrol.viewsales = true;
            accesscontrol.unlockuser = false;
            accesscontrol.viewtransactions = false;
            accesscontrol.viewactivity = false;
            accesscontrol.buyproduct = false;

            accesscontrol.addtoshoppingcart = false;
            accesscontrol.editshoppingcart = false;
            accesscontrol.removeproductfromshoppingcart = false;
            accesscontrol.viewproduct = false;

            accesscontrol.editpassword = true;

            accesscontrol.addadmin = false;
            accesscontrol.editadmin = false;
            accesscontrol.deleteadmin = false;

            account.setAccesscontrol(accesscontrol);

            return account;
        }
        return null;

    }

}
