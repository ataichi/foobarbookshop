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
            String query = "insert into customer (shippingAddress, billingAddress, customer_accountID) "
                    + "values(?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customerBean.getShippingAddress());
            ps.setString(2, customerBean.getBillingAddress());
            ps.setInt(3, customerBean.getCustomer_accountID());

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
            String billingAddress, shippingAddress;
            int customer_accountID;

            while (rs.next()) {
                billingAddress = rs.getString("billingAddress");
                shippingAddress = rs.getString("shippingAddress");

                customer_accountID = rs.getInt("customerID");
                customerID = rs.getInt("customerID");

                bean = new CustomerBean();

                bean.setBillingAddress(billingAddress);
                bean.setShippingAddress(shippingAddress);

                bean.setCustomer_accountID(customer_accountID);
                bean.setCustomerID(customerID);

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
            String shippingAddress, billingAddress;
            int customerID, customer_accountID;
            
            while (rs.next()) {
                shippingAddress = rs.getString("shippingAddress");
                billingAddress = rs.getString("billingAddress");

                customer_accountID = rs.getInt("customerID");
                customerID = rs.getInt("customerID");

                bean = new CustomerBean();

                bean.setBillingAddress(billingAddress);
                bean.setShippingAddress(shippingAddress);

                bean.setCustomer_accountID(customer_accountID);
                bean.setCustomerID(customerID);
                
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
