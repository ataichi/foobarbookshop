/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.ProductOrderBean;
import java.util.ArrayList;

/**
 *
 * @author Giodee
 */
public interface ProductOrderDAOInterface {
    public boolean addProductOrder(ProductOrderBean productorder);
    public boolean editProductOrder(ProductOrderBean productorder);
    public boolean deleteProductOrder(int productorderID);
    
    public ProductOrderBean getProductOrderById(int productorderID);
    
    public ArrayList<ProductOrderBean> getProductOrderByDate(java.sql.Date from, java.sql.Date to);
    public ArrayList<ProductOrderBean> getProductOrderByCustomerId(int customerID);
    public ArrayList<ProductOrderBean> getAllProductOrder();
    
}
