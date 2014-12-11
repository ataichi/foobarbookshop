package Beans;

public class CustomerBean {

    protected String DA;
    protected String BA;
    protected int customer_accountID;
    protected int customerID;

    public String getBA() {
        return BA;
    }

    public String getDA() {
        return DA;
    }

    public void setBA(String BA) {
        this.BA = BA;
    }

    public void setDA(String DA) {
        this.DA = DA;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCustomer_accountID() {
        return customer_accountID;
    }

    public void setCustomer_accountID(int customer_accountID) {
        this.customer_accountID = customer_accountID;
    }

}
