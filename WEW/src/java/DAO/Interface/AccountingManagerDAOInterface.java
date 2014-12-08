/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.ProductBean;
import Beans.ProductOrderBean;
import Beans.ShoppingCartBean;
import java.sql.Date;
import java.util.ArrayList;

public interface AccountingManagerDAOInterface {

    public int getSumSalesOfProductByID(int productID);

    public ProductBean getSalesByYear(int year);
    
    public ArrayList<ProductOrderBean> getAllProductOrders();
    public ArrayList<ShoppingCartBean> getAllShoppingCart();
    public ArrayList<ProductOrderBean> getAllProductOrderByProductID(int productID);
    /*public viewSales ();
     public viewSalesByProductType ();
     public viewSalesByYear ();
     public viewSalesByMonth ();
     public viewSalesByWeek ();
     public viewSalesByDaw ();**/
}
