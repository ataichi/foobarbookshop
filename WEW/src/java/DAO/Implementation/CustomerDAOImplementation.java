package DAO.Implementation;

import Beans.AudioCDBean;
import Beans.CustomerBean;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAOImplementation implements CustomerDAOInterface {

    @Override
    public boolean addCustomer(CustomerBean customerBean) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into customer (BA, DA, customer_accountID) "
                    + "values(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customerBean.getApartmentNoBA());
            ps.setString(2, customerBean.getApartmentNoDA());
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
            int customerID1, customer_accountID;
            String BA, DA;

            while (rs.next()) {
                BA = rs.getString("BA");
                DA = rs.getString("DA");
                
                customer_accountID = rs.getInt("customer_accountID");
                customerID1 = rs.getInt("customerID");

                bean = new CustomerBean();

                System.out.println("A");
                bean.setApartmentNoBA(BA);

                System.out.println("B");
                bean.setApartmentNoBA(DA);

                bean.setCustomer_accountID(customer_accountID);
                System.out.println("A123ADSA");

                bean.setCustomerID(customerID1);
                System.out.println("AINAL");
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
            String BA, DA;

            while (rs.next()) {
                BA = rs.getString("BA");
                DA = rs.getString("DA");
                
                customer_accountID = rs.getInt("customer_accountID");
                customerID = rs.getInt("customerID");

                bean = new CustomerBean();

                bean.setApartmentNoBA(BA);
                bean.setApartmentNoDA(DA);
               
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

            System.out.println("CUSTOMER ID"+shopbean.getShoppingcart_customerID());

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
            String BA, DA;

            while (rs.next()) {
                BA = rs.getString("BA");
                DA = rs.getString("DA");
               
                customer_accountID = rs.getInt("customer_accountID");
                customerID1 = rs.getInt("customerID");

                bean = new CustomerBean();

                bean.setApartmentNoBA(BA);
                bean.setApartmentNoDA(DA);
               
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
            String query = "update customer set BA=?, DA=? where customerID=?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, bean.getApartmentNoBA());
            ps.setString(2, bean.getApartmentNoDA());
            ps.setInt(3, bean.getCustomerID());
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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

                bean = new ReviewBean();

                reviewID = rs.getInt("reviewID");
                review_productID = rs.getInt("review_productID");
                review_customerID = rs.getInt("review_customerID");

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

    @Override
    public ArrayList<ShoppingCartBean> getShoppingCartByCustomerID(int customerID) {
        try {
            String query = "select * from shoppingcart where shoppingcart_customerID = ? ";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, customerID);

            ResultSet rs = ps.executeQuery();

            ArrayList<ShoppingCartBean> list = new ArrayList<ShoppingCartBean>();
            ShoppingCartBean bean = new ShoppingCartBean();

            int shoppingcartID, shoppingcart_customerID;
            Timestamp orderdate;
            double total;

            while (rs.next()) {

                bean = new ShoppingCartBean();

                shoppingcartID = rs.getInt("shoppingcartID");
                shoppingcart_customerID = rs.getInt("shoppingcart_customerID");

                orderdate = rs.getTimestamp("orderdate");

                total = rs.getDouble("total");

                bean.setShoppingcartID(shoppingcartID);
                bean.setShoppingcart_customerID(shoppingcart_customerID);

                bean.setOrderDate(orderdate);

                bean.setTotal(total);

                list.add(bean);

                System.out.println("Shopping cart id:" + bean.getShoppingcartID());

            }

            connection.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<ProductOrderBean> getProductOrderByShoppingCartID(int shoppingcartID) {
        try {
            String query = "select * from productorder where productorder_shoppingcartID = ? ";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, shoppingcartID);

            ResultSet rs = ps.executeQuery();

            ArrayList<ProductOrderBean> list = new ArrayList<ProductOrderBean>();
            ProductOrderBean bean = new ProductOrderBean();

            int productorder_shoppingcartID, productorder_productID, quantity;
            double price;

            while (rs.next()) {

                bean = new ProductOrderBean();

                productorder_shoppingcartID = rs.getInt("productorder_shoppingcartID");
                productorder_productID = rs.getInt("productorder_productID");
                quantity = rs.getInt("quantity");

                price = rs.getDouble("price");

                bean.setProductorder_shoppingcartID(productorder_shoppingcartID);
                bean.setProductorder_productID(productorder_productID);
                bean.setQuantity(quantity);

                bean.setPrice(price);

                list.add(bean);

            }

            connection.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<ReviewBean> getReviewsByProductID(int productid) {

        try {
            String query = "select * from review where review_productID = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productid);

            ResultSet rs = ps.executeQuery();

            ArrayList<ReviewBean> list = new ArrayList<ReviewBean>();
            ReviewBean bean = new ReviewBean();
            int reviewID, review_productID, review_customerID;
            String reviewString;

            while (rs.next()) {

                bean = new ReviewBean();

                reviewID = rs.getInt("reviewID");
                review_productID = rs.getInt("review_productID");
                review_customerID = rs.getInt("review_customerID");

                reviewString = rs.getString("reviewString");

                bean.setReviewID(reviewID);
                bean.setReview_customerID(review_customerID);
                bean.setReview_productID(review_productID);

                bean.setReview(reviewString);

                list.add(bean);

            }

            connection.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<ReviewBean> getReviewsByCustomer(int customerID) {
        try {
            String query = "select * from review where review_customerID = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, customerID);

            ResultSet rs = ps.executeQuery();

            ArrayList<ReviewBean> list = new ArrayList<ReviewBean>();
            ReviewBean bean = new ReviewBean();
            int reviewID, review_productID, review_customerID;
            String reviewString;

            while (rs.next()) {

                bean = new ReviewBean();

                reviewID = rs.getInt("reviewID");
                review_productID = rs.getInt("review_productID");
                review_customerID = rs.getInt("review_customerID");

                reviewString = rs.getString("reviewString");

                bean.setReviewID(reviewID);
                bean.setReview_customerID(review_customerID);
                bean.setReview_productID(review_productID);

                bean.setReview(reviewString);

                list.add(bean);

            }

            connection.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
