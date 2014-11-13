
package Beans;

import java.sql.Date;

public class ShoppingCartBean {
    protected int cartID;
    protected CustomerBean customer;
    protected double total;
    protected Date orderDate;

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public CustomerBean getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBean customer) {
        this.customer = customer;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
