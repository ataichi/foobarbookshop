/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.ProductBean;

/**
 *
 * @author Giodee
 */
public interface ProductDAOInterface {
    
    public ProductBean getProductById(int id);
    public boolean removeProduct(int id);
    
}
