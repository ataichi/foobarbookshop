/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Interface;

import Beans.AudioCDBean;
import Beans.CustomerBean;
import Beans.ProductBean;
import java.util.ArrayList;

public interface CustomerDAOInterface {
       public boolean addCustomer(CustomerBean customerBean);
       //public boolean removeCustomer(int customerID);
       public CustomerBean getCustomerById(int customerID);
       public ArrayList<CustomerBean> getAllCustomers();
       
       public boolean addToCart (ProductBean product);
       public boolean removeFromCart (ProductBean product);
       public ArrayList<ProductBean> viewCart();
       public boolean purchase(int productID);
       public ProductBean viewProduct (int ProductID);
       public ProductBean searchProduct (int ProductID);
       
       public AudioCDBean getAudioCDByID(int id);
       public AudioCDBean getAudioCDByProductID(int productID);
       public ArrayList<AudioCDBean> getAudioCDByArtist(String artist);
       public ArrayList<AudioCDBean> getAudioCDByRecordCompany(String recordCompany);
       
       
       
 
}
