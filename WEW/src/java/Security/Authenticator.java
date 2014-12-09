/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authenticator {
    
    private boolean isLoggedin = false;

    public boolean isIsLoggedin() {
        return isLoggedin;
    }

    public void setIsLoggedin(boolean isLoggedin) {
        this.isLoggedin = isLoggedin;
    }
    
    public boolean login(HttpServletRequest hsr, HttpServletResponse hsr1) {
        return true;
    }
    
}
