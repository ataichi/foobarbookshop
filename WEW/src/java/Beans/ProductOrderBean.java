
package Beans;

public class ProductOrderBean {
    private int productorderID;
    private int productorder_shoppingcartID;
    private int productorder_productID;
    private double price;
    private int quantity;
    private String review;
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductorderID() {
        return productorderID;
    }

    public void setProductorderID(int productorderID) {
        this.productorderID = productorderID;
    }

    public int getProductorder_shoppingcartID() {
        return productorder_shoppingcartID;
    }

    public void setProductorder_shoppingcartID(int productorder_shoppingcartID) {
        this.productorder_shoppingcartID = productorder_shoppingcartID;
    }

    public int getProductorder_productID() {
        return productorder_productID;
    }

    public void setProductorder_productID(int productorder_productID) {
        this.productorder_productID = productorder_productID;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
