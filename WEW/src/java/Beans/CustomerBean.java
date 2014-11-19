
package Beans;

public class CustomerBean {
    protected String shippingAddress;
    protected String billingAddress;
    protected int customer_accountID;
    protected int customerID;
    protected int customer_creditCardID;

    public int getCustomer_creditCardID() {
        return customer_creditCardID;
    }

    public void setCustomer_creditCardID(int customer_creditCardID) {
        this.customer_creditCardID = customer_creditCardID;
    }
    
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    
   
    public int getCustomer_accountID() {
        return customer_accountID;
    }

    public void setCustomer_accountID(int customer_accountID) {
        this.customer_accountID = customer_accountID;
    }
    
    
    
    
}
