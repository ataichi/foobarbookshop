/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Giodee
 */
public class ProductManagerBean {

    protected int productmanagerID;
    protected String prodType;
    protected int prodmanager_accountID;

    public String getProdType() {
        return prodType;
    }

    public int getProdmanager_accountID() {
        return prodmanager_accountID;
    }

    public int getProductmanagerID() {
        return productmanagerID;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public void setProdmanager_accountID(int prodmanager_accountID) {
        this.prodmanager_accountID = prodmanager_accountID;
    }

    public void setProductmanagerID(int productmanagerID) {
        this.productmanagerID = productmanagerID;
    }
    

}
