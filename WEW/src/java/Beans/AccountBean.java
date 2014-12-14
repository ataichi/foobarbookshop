package Beans;

import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.AdminDAOImplementation;
import Process.Hasher;
import Security.Authenticator;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.owasp.esapi.errors.AuthenticationException;
import org.owasp.esapi.errors.AuthenticationHostException;
import org.owasp.esapi.errors.EncryptionException;
import Security.AccessController;

public class AccountBean implements org.owasp.esapi.User {

    private int accountID;
    private String accountType;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String username;
    private String password;
    private String emailAdd;
    private int failedLoginCount;
    private boolean locked;

    private boolean loggedIn;

    private HttpSession userSession;
    private AccessController accesscontrol;

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean getLoggedIn() {
        return isLoggedIn();
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean getLocked() {
        return isLocked();
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public HttpSession getUserSession() {
        return userSession;
    }

    public void setUserSession(HttpSession userSession) {
        this.userSession = userSession;
    }

    public void setFailedLoginCount(int count) {
        this.failedLoginCount = count;
    }

    @Override
    public Locale getLocale() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLocale(Locale locale) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRole(String string) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRoles(Set<String> set) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changePassword(String old, String new1, String new2) throws AuthenticationException, EncryptionException {
        try {
            AccountDAOImplementation adao = new AccountDAOImplementation();

            Hasher oldhash = new Hasher("MD5");
            try {
                oldhash.updateHash(old, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
            }
            old = oldhash.getHashBASE64();
            
            Hasher new1hash = new Hasher("MD5");
            try {
                new1hash.updateHash(new1, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
            }
            new1 = new1hash.getHashBASE64();
            
            Hasher new2hash = new Hasher("MD5");
            try {
                new2hash.updateHash(new2, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
            }
            new2 = new2hash.getHashBASE64();
            
            if(old.equals(this.getPassword()) && new1.equals(new2)) {
                adao.changePassword(this.getAccountID(), new1);
            }
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void disable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getAccountId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAccountName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCSRFToken() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getExpirationTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getFailedLoginCount() {
        return failedLoginCount;
    }

    @Override
    public String getLastHostAddress() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getLastFailedLoginTime() throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getLastLoginTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getLastPasswordChangeTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> getRoles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getScreenName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSession(HttpSession hs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeSession(HttpSession hs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set getSessions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void incrementFailedLoginCount() {
        AccountDAOImplementation adao = new AccountDAOImplementation();
        adao.incrementFailedLogin(this);
    }

    @Override
    public boolean isAnonymous() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInRole(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    @Override
    public boolean isSessionAbsoluteTimeout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isSessionTimeout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lock() {
        AccountDAOImplementation adao = new AccountDAOImplementation();
        adao.lockAccount(this);
    }

    @Override
    public void loginWithPassword(String string) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeRole(String string) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String resetCSRFToken() throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAccountName(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setExpirationTime(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRoles(Set<String> set) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setScreenName(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unlock() {
        AdminDAOImplementation admindao = new AdminDAOImplementation();
        admindao.unlockAccount(this.getAccountID());
    }

    @Override
    public boolean verifyPassword(String string) throws EncryptionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLastFailedLoginTime(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLastHostAddress(String string) throws AuthenticationHostException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLastLoginTime(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLastPasswordChangeTime(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap getEventMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AccessController getAccesscontrol() {
        return accesscontrol;
    }

    public void setAccesscontrol(AccessController accesscontrol) {
        this.accesscontrol = accesscontrol;
    }

}
