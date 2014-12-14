/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Security;

import Beans.AccountBean;
import Beans.LogBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import Process.Hasher;
import java.io.UnsupportedEncodingException;
import static java.lang.System.out;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.User;
import org.owasp.esapi.errors.AuthenticationException;
import org.owasp.esapi.errors.EncryptionException;

public class Authenticator implements org.owasp.esapi.Authenticator {

    @Override
    public void clearCurrent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountBean login() throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountBean login(HttpServletRequest hsr, HttpServletResponse hsr1) throws AuthenticationException {
        try {
            boolean usercheck = false;
            String username = null;
            String password = null;
            AccountBean bean = null;

            username = hsr.getParameter("loguser");
            password = hsr.getParameter("logpass");

            AccountDAOImplementation adao = new AccountDAOImplementation();
            usercheck = adao.authenticateUser(username, password);

            Hasher hash = new Hasher("MD5");
            try {
                hash.updateHash(password, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
            }
    //        password = hash.getHashBASE64();

            Cookie[] cookies = hsr.getCookies();
            boolean foundCookie = false;

            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie1 = cookies[i];
                if (cookie1.getName().equals(username)) {
                    out.println(cookie1.getName() + " " + cookie1.getValue());
                    foundCookie = true;
                }
            }

            usercheck = adao.authenticateUser(username, password);

            //create log for login
            LogBean log = new LogBean();
            LogDAOImplementation logdao = new LogDAOImplementation();

            Timestamp time;
            java.util.Date date = new java.util.Date();
            time = new Timestamp(date.getTime());
            log.setTime(time);
            log.setIp_address(hsr.getRemoteAddr());
            log.setActivity("login");

            AccountBean account = new AccountBean();
            AccountDAOImplementation accountdao = new AccountDAOImplementation();
            AccessController accesscontrol = new AccessController();
            if (usercheck) {
                log.setLog_accountID(account.getAccountID());
                log.setStatus("successful");
                account = adao.getUserByUsername(username);
                account.setLoggedIn(true);
                account.setFailedLoginCount(0);
                adao.setFailedLoginCountToZero(account.getAccountID());
                logdao.addLog(log);

                if (!foundCookie) {
                    Cookie cookie1 = new Cookie(username, account.getAccountType());
                    cookie1.setMaxAge(24 * 60 * 60);
                    hsr1.addCookie(cookie1);
                    out.println("NO COOKIES FOUND");
                }

                if ("Customer".equals(account.getAccountType())) {
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
                } else if ("Admin".equals(account.getAccountType())) {
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
                    accesscontrol.editadmin = true;
                    accesscontrol.deleteadmin = false;

                    account.setAccesscontrol(accesscontrol);

                    return account;
                } else if ("Book Manager".equals(account.getAccountType())) {
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
                } else if ("Audio CD Manager".equals(account.getAccountType())) {
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
                } else if ("DVD Manager".equals(account.getAccountType())) {
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
                } else if ("Magazine Manager".equals(account.getAccountType())) {
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
                } else if ("Accounting Manager".equals(account.getAccountType())) {
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

            } else {
                log.setStatus("failed");
                account = adao.getUserByUsername(username);
                account.setLoggedIn(false);
                if (account != null) {
                    log.setLog_accountID(account.getAccountID());
                    logdao.addLog(log);

                    if (!foundCookie) {
                        Cookie cookie1 = new Cookie(username, account.getAccountType());
                        cookie1.setMaxAge(24 * 60 * 60);
                        hsr1.addCookie(cookie1);
                        out.println("NO COOKIES FOUND");
                    }
                    return account;
                } else {
                    log.setStatus("failed");
                    log.setLog_accountID(0);
                    logdao.addLog(log);
                    return null;
                }
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean verifyPassword(User user, String string
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User createUser(String string, String string1, String string2) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generateStrongPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generateStrongPassword(User user, String string
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changePassword(User user, String string, String string1, String string2) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountBean getUser(long l
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountBean getUser(String string
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set getUserNames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountBean getCurrentUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCurrentUser(User user
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String hashPassword(String string, String string1) throws EncryptionException {
        String password = null;

        if (string.equals(string1)) {
            try {
                Hasher hash = new Hasher("MD5");
                try {
                    hash.updateHash(string, "UTF-8");

                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Authenticator.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                password = hash.getHashBASE64();
                return password;

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Authenticator.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return password;
    }

    @Override
    public void removeUser(String string) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void verifyAccountNameStrength(String string) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void verifyPasswordStrength(String string, String string1, User user) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(String string
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
