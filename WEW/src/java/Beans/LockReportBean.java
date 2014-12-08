/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

public class LockReportBean {
    protected int lockreportID;
    protected int lockreport_accountID;
    protected String reason;

    public int getLockreportID() {
        return lockreportID;
    }

    public int getLockreport_accountID() {
        return lockreport_accountID;
    }

    public String getReason() {
        return reason;
    }

    public void setLockreportID(int lockreportID) {
        this.lockreportID = lockreportID;
    }

    public void setLockreport_accountID(int lockreport_accountID) {
        this.lockreport_accountID = lockreport_accountID;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
}
