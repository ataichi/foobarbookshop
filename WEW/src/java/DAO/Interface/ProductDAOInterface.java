/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.ProductBean;
import java.util.ArrayList;

public interface ProductDAOInterface {
    
    public ProductBean getProductById(int id);
    
    public ArrayList<ProductBean> getAllProductsByType(String type);
    public ArrayList<ProductBean> getProductsByTitle(String title);
    public ArrayList<ProductBean> getProductsBySummary(String summary);
    public ArrayList<ProductBean> getProductsByGenre(String genre);
    public ArrayList<ProductBean> getProductsByYear(int year);
    
    
    
    
}
