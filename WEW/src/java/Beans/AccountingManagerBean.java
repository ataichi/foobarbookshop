/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author jao
 */
public class AccountingManagerBean {

    protected int accountingManagerID;
    protected int accountingManager_accountID;

    public int getAccountingManagerID() {
        return accountingManagerID;
    }

    public int getAccountingManager_accountID() {
        return accountingManager_accountID;
    }

    public void setAccountingManagerID(int accountingManagerID) {
        this.accountingManagerID = accountingManagerID;
    }

    public void setAccountingManager_accountID(int accountingManager_accountID) {
        this.accountingManager_accountID = accountingManager_accountID;
    }

}
