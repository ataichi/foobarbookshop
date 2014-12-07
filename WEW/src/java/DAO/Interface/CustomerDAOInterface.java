/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.AudioCDBean;
import Beans.CustomerBean;
import Beans.CustomerCreditCardBean;
import Beans.ProductBean;
import Beans.ProductOrderBean;
import Beans.ReviewBean;
import Beans.ShoppingCartBean;
import java.util.ArrayList;

public interface CustomerDAOInterface {

    public boolean addCustomer(CustomerBean customerBean);

    //public boolean removeCustomer(int customerID);
    public CustomerBean getCustomerById(int customerID);
    public CustomerBean getCustomerByAccountID(int id);
    public ArrayList<CustomerBean> getAllCustomers();
    public boolean editAddress(CustomerBean bean);
    
    //public boolean addToCart(ProductBean product);
    
    //public boolean removeFromCart(ProductBean product);
    //public ArrayList<ProductBean> viewCart();
    public boolean purchase(ShoppingCartBean shopbean);
    public boolean addProductsToCart(ProductOrderBean orderbean, int shoppingcardID);
    public int getShoppingCartID();
    
    public boolean writeReview(ReviewBean review);
    public boolean editReview(ReviewBean review);
    public ReviewBean getCustomerReviewForProduct(int productid, int customerID);
    
    public ProductOrderBean getProductOrderBeanByID(int id);
    
    public ProductBean viewProduct(int ProductID);
    public ProductBean searchProduct(int ProductID);
    
    public boolean addCustomerCreditCard(CustomerCreditCardBean customercreditcard);
    public boolean removeCustomerCreditCard(int customercreditcardid);
    public boolean removeCustomerCreditCardByCreditCardID(int creditcardID);
    public CustomerCreditCardBean getCustomerCreditCardByCustomerID(int customerID);
}
