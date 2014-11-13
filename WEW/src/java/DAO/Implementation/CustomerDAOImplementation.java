
package DAO.Implementation;

import Beans.CustomerBean;
import Beans.ProductBean;
import DAO.Interface.CustomerDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giodee
 */
public class CustomerDAOImplementation implements CustomerDAOInterface {

    @Override
    public boolean addCustomer(CustomerBean customerBean) {
    try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into customer (apartmentnoBA, streetBA, subdivisionBA, cityBA, postalcodeBA, countryBA,"
                    + " apartmentnoDA, streetDA, subdivisionDA, cityDA, postalcodeDA, countryDA, customer_accountID) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customerBean.getApartmentNoBA());
            ps.setString(2, customerBean.getStreetBA());
            ps.setString(3, customerBean.getSubdivisionBA());
            ps.setString(4, customerBean.getCityBA());
            ps.setInt(5, customerBean.getPostalCodeBA());
            ps.setString(6, customerBean.getCountryBA());
            
            ps.setString(7, customerBean.getApartmentNoBA());
            ps.setString(8, customerBean.getStreetBA());
            ps.setString(9, customerBean.getSubdivisionBA());
            ps.setString(10, customerBean.getCityBA());
            ps.setInt(11, customerBean.getPostalCodeBA());
            ps.setString(12, customerBean.getCountryBA());  
            ps.setInt(13, customerBean.getCustomer_accountID());
            ps.executeUpdate();
            connection.close();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public CustomerBean getCustomerById(int customerID) {
        try {
            String query = "select * from customer where customerID = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, customerID);
            
            ResultSet rs = ps.executeQuery();
            
            CustomerBean bean = new CustomerBean();
            String apartmentNoBA, streetBA, subdivisionBA, cityBA, countryBA;
            String apartmentNoDA, streetDA, subdivisionDA, cityDA, countryDA;
            int customer_accountID, customer_creditCardID, postalCodeBA,  postalCodeDA;
            
            while(rs.next()) {
                apartmentNoBA = rs.getString("apartmentnoBA");
                streetBA = rs.getString("streetBA");
                subdivisionBA = rs.getString("subdivisionBA");
                cityBA = rs.getString("cityBA");
                postalCodeBA = rs.getInt("postalcodeBA");
                countryBA = rs.getString("countryBA");
                apartmentNoDA = rs.getString("apartmentnoDA");
                streetDA = rs.getString("streetDA");
                subdivisionDA = rs.getString("subdivisionDA");
                cityDA = rs.getString("cityDA");
                postalCodeDA = rs.getInt("postalcodeDA");
                countryDA = rs.getString("countryDA");
                customer_accountID = rs.getInt("customerID");
                customer_creditCardID = rs.getInt("customer_creditcardID");
                customerID = rs.getInt("customerID");
                
                bean = new CustomerBean();
                
                bean.setApartmentNoBA(apartmentNoBA);
                bean.setApartmentNoDA(apartmentNoDA);
                bean.setCityBA(cityBA);
                bean.setCityDA(cityDA);
                bean.setCountryBA(countryBA);
                bean.setCountryDA(countryDA);
                bean.setCustomerID(customerID);
                bean.setCustomer_accountID(customer_accountID);
                bean.setCustomer_creditCardID(customer_creditCardID);
                bean.setPostalCodeBA(postalCodeBA);
                bean.setPostalCodeDA(postalCodeDA);
                bean.setStreetBA(streetBA);
                bean.setStreetDA(streetDA);
                bean.setSubdivisionBA(subdivisionBA);
                bean.setSubdivisionDA(subdivisionDA);
                
            }
            
            connection.close();
            return bean;
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<CustomerBean> getAllCustomers() {
        try {
            String query = "select * from customer";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            CustomerBean bean = new CustomerBean();
            ArrayList<CustomerBean> clist = new ArrayList<CustomerBean>();
            String apartmentNoBA, streetBA, subdivisionBA, cityBA, countryBA;
            String apartmentNoDA, streetDA, subdivisionDA, cityDA, countryDA;
            int customerID, customer_accountID, customer_creditCardID, postalCodeBA,  postalCodeDA;
            
            while(rs.next()) {
                apartmentNoBA = rs.getString("apartmentnoBA");
                streetBA = rs.getString("streetBA");
                subdivisionBA = rs.getString("subdivisionBA");
                cityBA = rs.getString("cityBA");
                postalCodeBA = rs.getInt("postalcodeBA");
                countryBA = rs.getString("countryBA");
                apartmentNoDA = rs.getString("apartmentnoDA");
                streetDA = rs.getString("streetDA");
                subdivisionDA = rs.getString("subdivisionDA");
                cityDA = rs.getString("cityDA");
                postalCodeDA = rs.getInt("postalcodeDA");
                countryDA = rs.getString("countryDA");
                customer_accountID = rs.getInt("customerID");
                customer_creditCardID = rs.getInt("customer_creditcardID");
                customerID = rs.getInt("customerID");
                
                bean = new CustomerBean();
                
                bean.setApartmentNoBA(apartmentNoBA);
                bean.setApartmentNoDA(apartmentNoDA);
                bean.setCityBA(cityBA);
                bean.setCityDA(cityDA);
                bean.setCountryBA(countryBA);
                bean.setCountryDA(countryDA);
                bean.setCustomerID(customerID);
                bean.setCustomer_accountID(customer_accountID);
                bean.setCustomer_creditCardID(customer_creditCardID);
                bean.setPostalCodeBA(postalCodeBA);
                bean.setPostalCodeDA(postalCodeDA);
                bean.setStreetBA(streetBA);
                bean.setStreetDA(streetDA);
                bean.setSubdivisionBA(subdivisionBA);
                bean.setSubdivisionDA(subdivisionDA);
                
                clist.add(bean);
                
            }
            
            connection.close();
            return clist;
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean addToCart(ProductBean product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeFromCart(ProductBean product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductBean> viewCart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean purchase(int productID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductBean viewProduct(int ProductID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductBean searchProduct(int ProductID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
