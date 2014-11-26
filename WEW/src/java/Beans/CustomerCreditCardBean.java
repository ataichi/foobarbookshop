/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

public class CustomerCreditCardBean {

    protected int customercreditcardID;
    protected int customercreditcard_customerID;
    protected int customercreditcard_creditcardID;

    public int getCustomercreditcardID() {
        return customercreditcardID;
    }

    public int getCustomercreditcard_customerID() {
        return customercreditcard_customerID;
    }

    public int getCustomercreditcard_creditcardID() {
        return customercreditcard_creditcardID;
    }

    public void setCustomercreditcard_customerID(int customercreditcard_customerID) {
        this.customercreditcard_customerID = customercreditcard_customerID;
    }

    public void setCustomercreditcardID(int customercreditcardID) {
        this.customercreditcardID = customercreditcardID;
    }

    public void setCustomercreditcard_creditcardID(int customercreditcard_creditcardID) {
        this.customercreditcard_creditcardID = customercreditcard_creditcardID;
    }

}
