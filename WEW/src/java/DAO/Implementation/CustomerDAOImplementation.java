package DAO.Implementation;

import Beans.AudioCDBean;
import Beans.CustomerBean;
import Beans.CustomerCreditCardBean;
import Beans.ProductBean;
import Beans.ProductOrderBean;
import Beans.ReviewBean;
import Beans.ShoppingCartBean;
import DAO.Interface.CustomerDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            int customerID1, customer_accountID;
            String streetBA, subdivisionBA, cityBA, countryBA;
            int apartmentnoBA, postalcodeBA;

            String streetDA, subdivisionDA, cityDA, countryDA;
            int apartmentnoDA, postalcodeDA;

            while (rs.next()) {
                streetBA = rs.getString("streetBA");
                subdivisionBA = rs.getString("subdivisionBA");
                cityBA = rs.getString("cityBA");
                countryBA = rs.getString("countryBA");
                apartmentnoBA = rs.getInt("apartmentnoBA");
                postalcodeBA = rs.getInt("postalcodeBA");

                streetDA = rs.getString("streetDA");
                subdivisionDA = rs.getString("subdivsionDA");
                cityDA = rs.getString("cityDA");
                countryDA = rs.getString("countryDA");
                apartmentnoDA = rs.getInt("apartmentnoDA");
                postalcodeDA = rs.getInt("postalcodeDA");

                customer_accountID = rs.getInt("customerID");
                customerID1 = rs.getInt("customerID");

                bean = new CustomerBean();

                bean.setApartmentNoBA(streetBA);
                bean.setCityBA(cityBA);
                bean.setCountryBA(countryBA);
                bean.setPostalCodeBA(postalcodeBA);
                bean.setStreetBA(streetBA);
                bean.setSubdivisionBA(subdivisionBA);

                bean.setCityDA(cityDA);
                bean.setCountryDA(countryDA);
                bean.setPostalCodeDA(postalcodeDA);
                bean.setStreetDA(streetDA);
                bean.setSubdivisionDA(subdivisionDA);

                bean.setCustomer_accountID(customer_accountID);
                bean.setCustomerID(customerID1);

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

            int customerID, customer_accountID;
            String streetBA, subdivisionBA, cityBA, countryBA;
            int apartmentnoBA, postalcodeBA;

            String streetDA, subdivisionDA, cityDA, countryDA;
            int apartmentnoDA, postalcodeDA;

            while (rs.next()) {
                streetBA = rs.getString("streetBA");
                subdivisionBA = rs.getString("subdivisionBA");
                cityBA = rs.getString("cityBA");
                countryBA = rs.getString("countryBA");
                apartmentnoBA = rs.getInt("apartmentnoBA");
                postalcodeBA = rs.getInt("postalcodeBA");

                streetDA = rs.getString("streetDA");
                subdivisionDA = rs.getString("subdivsionDA");
                cityDA = rs.getString("cityDA");
                countryDA = rs.getString("countryDA");
                apartmentnoDA = rs.getInt("apartmentnoDA");
                postalcodeDA = rs.getInt("postalcodeDA");

                customer_accountID = rs.getInt("customerID");
                customerID = rs.getInt("customerID");

                bean = new CustomerBean();

                bean.setApartmentNoBA(streetBA);
                bean.setCityBA(cityBA);
                bean.setCountryBA(countryBA);
                bean.setPostalCodeBA(postalcodeBA);
                bean.setStreetBA(streetBA);
                bean.setSubdivisionBA(subdivisionBA);

                bean.setCityDA(cityDA);
                bean.setCountryDA(countryDA);
                bean.setPostalCodeDA(postalcodeDA);
                bean.setStreetDA(streetDA);
                bean.setSubdivisionDA(subdivisionDA);

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
    public boolean purchase(ShoppingCartBean shopbean) {
        try {
            boolean check;
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into shoppingcart (shoppingcart_customerID,total,orderDate) value(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, shopbean.getShoppingcart_customerID());
            ps.setDouble(2, shopbean.getTotal());
            ps.setTimestamp(3, shopbean.getOrderDate());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ProductBean viewProduct(int ProductID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductBean searchProduct(int ProductID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerBean getCustomerByAccountID(int id) {
        try {
            String query = "select * from customer where customer_accountID = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            CustomerBean bean = new CustomerBean();
            int customerID1, customer_accountID;
            String streetBA, subdivisionBA, cityBA, countryBA, apartmentnoBA;
            int postalcodeBA;

            String streetDA, subdivisionDA, cityDA, countryDA, apartmentnoDA;
            int postalcodeDA;

            while (rs.next()) {
                streetBA = rs.getString("streetBA");
                subdivisionBA = rs.getString("subdivisionBA");
                cityBA = rs.getString("cityBA");
                countryBA = rs.getString("countryBA");
                apartmentnoBA = rs.getString("apartmentnoBA");
                postalcodeBA = rs.getInt("postalcodeBA");

                streetDA = rs.getString("streetDA");
                subdivisionDA = rs.getString("subdivisionDA");
                cityDA = rs.getString("cityDA");
                countryDA = rs.getString("countryDA");
                apartmentnoDA = rs.getString("apartmentnoDA");
                postalcodeDA = rs.getInt("postalcodeDA");

                customer_accountID = rs.getInt("customerID");
                customerID1 = rs.getInt("customerID");

                bean = new CustomerBean();

                bean.setApartmentNoBA(streetBA);
                bean.setCityBA(cityBA);
                bean.setCountryBA(countryBA);
                bean.setPostalCodeBA(postalcodeBA);
                bean.setStreetBA(streetBA);
                bean.setSubdivisionBA(subdivisionBA);
                bean.setApartmentNoBA(apartmentnoBA);

                bean.setCityDA(cityDA);
                bean.setCountryDA(countryDA);
                bean.setPostalCodeDA(postalcodeDA);
                bean.setStreetDA(streetDA);
                bean.setSubdivisionDA(subdivisionDA);
                bean.setApartmentNoDA(apartmentnoDA);

                bean.setCustomer_accountID(customer_accountID);
                bean.setCustomerID(customerID1);

            }

            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean editAddress(CustomerBean bean) {
        try {
            String query = "update customer set apartmentnoBA=?, streetBA=?, subdivisionBA=?, cityBA=?, postalcodeBA=?, countryBA=?,"
                    + " apartmentnoDA=?, streetDA=?, subdivisionDA=?, cityDA=?, postalcodeDA=?, countryDA=? where customerID=?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, bean.getApartmentNoBA());
            ps.setString(2, bean.getStreetBA());
            ps.setString(3, bean.getSubdivisionBA());
            ps.setString(4, bean.getCityBA());
            ps.setInt(5, bean.getPostalCodeBA());
            ps.setString(6, bean.getCountryBA());
            ps.setString(7, bean.getApartmentNoDA());
            ps.setString(8, bean.getStreetDA());
            ps.setString(9, bean.getSubdivisionDA());
            ps.setString(10, bean.getCityDA());
            ps.setInt(11, bean.getPostalCodeDA());
            ps.setString(12, bean.getCountryDA());
            ps.setInt(13, bean.getCustomerID());
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean addCustomerCreditCard(CustomerCreditCardBean customercreditcard) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into customercreditcard (customercreditcard_customerID, customercreditcard_creditcardID)"
                    + "values(?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, customercreditcard.getCustomercreditcard_customerID());
            ps.setInt(2, customercreditcard.getCustomercreditcard_creditcardID());
            ps.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean removeCustomerCreditCard(int customercreditcard_customerID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "delete from customercreditcard where customercreditcardid_customerID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, customercreditcard_customerID);

            ps.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean removeCustomerCreditCardByCreditCardID(int creditcardID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "delete from customercreditcard where customercreditcardid_creditcardID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, creditcardID);

            ps.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public CustomerCreditCardBean getCustomerCreditCardByCustomerID(int customerID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from customercreditcard where customercreditcardid_customerID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, customerID);

            ResultSet resultset = ps.executeQuery();
            CustomerCreditCardBean customercreditcardbean = new CustomerCreditCardBean();
            int customercreditcardID, customercreditcard_customerID, customercreditcard_creditcardID;
            while (resultset.next()) {
                customercreditcardID = resultset.getInt("customercreditcardID");
                customercreditcard_customerID = resultset.getInt("customercreditcard_customerID");
                customercreditcard_creditcardID = resultset.getInt("customercreditcard_creditcardID");

                customercreditcardbean.setCustomercreditcardID(customercreditcardID);
                customercreditcardbean.setCustomercreditcard_creditcardID(customercreditcard_creditcardID);
                customercreditcardbean.setCustomercreditcard_customerID(customercreditcard_customerID);

            }
            connection.close();

            return customercreditcardbean;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean addProductsToCart(ProductOrderBean orderbean, int shoppingcardID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into productorder (productorder_shoppingcartID, productorder_productID, price, quantity) "
                    + "values (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, shoppingcardID);
            ps.setInt(2, orderbean.getProductorder_productID());
            ps.setDouble(3, orderbean.getPrice());
            ps.setInt(4, orderbean.getQuantity());
            //     ps.setString(5, orderbean.getReview());
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public int getShoppingCartID() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select shoppingcartID from shoppingcart order by shoppingcartID DESC";
            PreparedStatement ps = connection.prepareStatement(query);

            int shoppingcartID;

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                shoppingcartID = resultSet.getInt("shoppingcartID");
                return shoppingcartID;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public boolean writeReview(ReviewBean review) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into review (review_customerID, review_productID, reviewString) values(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, review.getReview_customerID());
            ps.setInt(2, review.getReview_productID());
            ps.setString(3, review.getReview());

            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ProductOrderBean getProductOrderBeanByID(int id) {

        try {
            String query = "select * from productorder where productorderID = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            ProductOrderBean bean = new ProductOrderBean();
            int productorderID, productorder_shoppingcartID, productorder_productID, quantity;
            double price;

            while (rs.next()) {

                productorderID = rs.getInt("productorderID");
                productorder_shoppingcartID = rs.getInt("product_shoppingcartID");
                productorder_productID = rs.getInt("product_productID");
                quantity = rs.getInt("quantity");

                price = rs.getDouble("price");

                bean.setProductorderID(productorderID);
                bean.setProductorder_shoppingcartID(productorder_shoppingcartID);
                bean.setProductorder_productID(productorder_productID);
                bean.setQuantity(quantity);

                bean.setPrice(price);
            }

            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean editReview(ReviewBean review) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "update review set reviewString = ? where review_customerID = ? AND review_productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, review.getReview());
            ps.setInt(2, review.getReview_customerID());
            ps.setInt(3, review.getReview_productID());

            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ReviewBean getCustomerReviewForProduct(int productID, int customerID) {
   try {
            String query = "select * from review where review_productID = ? and review_customerID = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            ps.setInt(2, customerID);

            ResultSet rs = ps.executeQuery();

            ReviewBean bean = new ReviewBean();
            int reviewID, review_productID, review_customerID;
            String reviewString;

            while (rs.next()) {
                
                reviewID = rs.getInt("reviewID");
                review_productID = rs.getInt("review_productID");
                review_customerID = rs.getInt("review_customeID");
                
                reviewString = rs.getString("reviewString");
              
                bean.setReviewID(reviewID);
                bean.setReview_customerID(review_customerID);
                bean.setReview_productID(review_productID);
                        
                bean.setReview(reviewString);

            }

            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
