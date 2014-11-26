/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.ProductBean;
import java.util.ArrayList;

public interface ProductManagerDAOInterface {

    public boolean addProduct(ProductBean product);

    public boolean editProduct(ProductBean product);

    public ProductBean getLastProduct();

    public ArrayList<ProductBean> getProductsByType(String type);

    public ProductBean getProductById(int id);

    public boolean removeProduct(int id);
    
    public boolean restockProduct(int newstocks, int id);

}
