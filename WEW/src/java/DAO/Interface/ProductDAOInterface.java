/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.ProductBean;
import java.util.ArrayList;

/**
 *
 * @author Giodee
 */
public interface ProductDAOInterface {
    
    public ProductBean getProductById(int id);
    public boolean removeProduct(int id);
    public ArrayList<ProductBean> getAllProductsByType(String type);
    
}
