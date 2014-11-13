
package Beans;

public class ProductManagerBean {
    private int productmanagerID;
    private int prodmanager_accountID;
    private String prodType;

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public int getProductmanagerID() {
        return productmanagerID;
    }

    public void setProductmanagerID(int productmanagerID) {
        this.productmanagerID = productmanagerID;
    }

    public int getProdmanager_accountID() {
        return prodmanager_accountID;
    }

    public void setProdmanager_accountID(int prodmanager_accountID) {
        this.prodmanager_accountID = prodmanager_accountID;
    }
    
}
