/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.ProductBean;
import Beans.ShoppingCartBean;
import java.util.ArrayList;

/**
 *
 * @author Giodee
 */
public interface ShoppingCartDAOInterface {
 
       public boolean addShoppingCart(ShoppingCartBean shoppingcart);
       public boolean editShoppingCart(ShoppingCartBean shoppingcart);
       public boolean deleteShoppingCart(int shoppincartID);
       
       public ArrayList<ShoppingCartBean> getAllShoppingCart();
       
       public boolean addToCart (ProductBean product);
       public boolean removeFromCart (ProductBean product);
       public ArrayList<ProductBean> viewCart();
       public boolean purchase(int productID);
       public ProductBean viewProduct (int ProductID);
       public ProductBean searchProduct (int ProductID);
}
