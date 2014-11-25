
package Beans;


import java.sql.Timestamp;

public class ShoppingCartBean {
    private int shoppingcartID;
    private int shoppingcart_customerID;
    private int shoppingcart_creditcardID;
    private double total;
    private Timestamp orderDate;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getShoppingcartID() {
        return shoppingcartID;
    }

    public void setShoppingcartID(int shoppingcartID) {
        this.shoppingcartID = shoppingcartID;
    }

    public int getShoppingcart_customerID() {
        return shoppingcart_customerID;
    }

    public void setShoppingcart_customerID(int shoppingcart_customerID) {
        this.shoppingcart_customerID = shoppingcart_customerID;
    }

    public int getShoppingcart_creditcardID() {
        return shoppingcart_creditcardID;
    }

    public void setShoppingcart_creditcardID(int shoppingcart_creditcardID) {
        this.shoppingcart_creditcardID = shoppingcart_creditcardID;
    }
}
