package Beans;

import java.sql.Timestamp;

public class ShoppingCartBean {

    private int shoppingcartID;
    private int shoppingcart_customerID;
    private double total;
    private Timestamp orderDate;

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public int getShoppingcartID() {
        return shoppingcartID;
    }

    public int getShoppingcart_customerID() {
        return shoppingcart_customerID;
    }

    public double getTotal() {
        return total;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public void setShoppingcartID(int shoppingcartID) {
        this.shoppingcartID = shoppingcartID;
    }

    public void setShoppingcart_customerID(int shoppingcart_customerID) {
        this.shoppingcart_customerID = shoppingcart_customerID;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
