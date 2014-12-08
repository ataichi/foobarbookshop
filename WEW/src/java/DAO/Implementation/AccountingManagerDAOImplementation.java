/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.ProductBean;
import Beans.ProductOrderBean;
import Beans.ShoppingCartBean;
import DAO.Interface.AccountingManagerDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountingManagerDAOImplementation implements AccountingManagerDAOInterface {

    public int getSumSalesOfProductByID(int productID) {
        int total = 0;
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "SELECT SUM(quantity) AS sumquantity from productorder where productorder_productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                total = resultSet.getInt("sumquantity");
                return total;
            }

            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountingManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public ProductBean getSalesByYear(int year) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from product where year = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, year);

            ResultSet resultSet = ps.executeQuery();

            ProductBean product = new ProductBean();

            int productID;
            String type, title;
            double price;
            String summary, genre;
            int year1, stocks;

            while (resultSet.next()) {
                productID = resultSet.getInt("productID");
                type = resultSet.getString("type");
                title = resultSet.getString("title");
                price = resultSet.getDouble("price");
                summary = resultSet.getString("summary");
                genre = resultSet.getString("genre");
                year = resultSet.getInt("year");
                stocks = resultSet.getInt("stocks");

                product.setProductID(productID);
                product.setType(type);
                product.setTitle(title);
                product.setPrice(price);
                product.setSummary(summary);
                product.setGenre(genre);
                product.setYear(year);
                product.setNumberStocks(stocks);
            }
            connection.close();

            return product;

        } catch (SQLException ex) {
            Logger.getLogger(AccountingManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<ProductOrderBean> getAllProductOrders() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from productorder";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<ProductOrderBean> list = new ArrayList<ProductOrderBean>();
            ProductOrderBean bean = new ProductOrderBean();

            int productorderID, productorder_shoppingcartID, productorder_productID, quantity;
            double price;

            while (resultSet.next()) {
                productorderID = resultSet.getInt("productorderID");
                productorder_shoppingcartID = resultSet.getInt("productorder_shoppingcartID");
                productorder_productID = resultSet.getInt("productorder_productID");
                quantity = resultSet.getInt("quantity");

                price = resultSet.getDouble("price");

                bean = new ProductOrderBean();

                bean.setProductorderID(productorderID);
                bean.setProductorder_shoppingcartID(productorder_shoppingcartID);
                bean.setProductorder_productID(productorder_productID);
                bean.setQuantity(quantity);

                bean.setPrice(price);

                list.add(bean);
            }

            connection.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AccountingManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<ShoppingCartBean> getAllShoppingCart() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from shoppingcart";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<ShoppingCartBean> list = new ArrayList<ShoppingCartBean>();
            ShoppingCartBean bean = new ShoppingCartBean();

            int shoppingcartID, shoppingcart_customerID;
            Timestamp orderDate;
            double total;

            while (resultSet.next()) {

                shoppingcartID = resultSet.getInt("shoppingcartID");
                shoppingcart_customerID = resultSet.getInt("shoppingcart_customerID");

                orderDate = resultSet.getTimestamp("orderDate");

                total = resultSet.getDouble("total");

                bean = new ShoppingCartBean();

                bean.setShoppingcartID(shoppingcartID);
                bean.setShoppingcart_customerID(shoppingcart_customerID);

                bean.setOrderDate(orderDate);

                list.add(bean);
            }

            connection.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AccountingManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<ProductOrderBean> getAllProductOrderByProductID(int productID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from productorder where productorder_productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<ProductOrderBean> list = new ArrayList<ProductOrderBean>();
            ProductOrderBean bean = new ProductOrderBean();

            int productorderID, productorder_shoppingcartID, productorder_productID, quantity;
            double price;

            while (resultSet.next()) {
                productorderID = resultSet.getInt("productorderID");
                productorder_shoppingcartID = resultSet.getInt("productorder_shoppingcartID");
                productorder_productID = resultSet.getInt("productorder_productID");
                quantity = resultSet.getInt("quantity");

                price = resultSet.getDouble("price");

                bean = new ProductOrderBean();

                bean.setProductorderID(productorderID);
                bean.setProductorder_shoppingcartID(productorder_shoppingcartID);
                bean.setProductorder_productID(productorder_productID);
                bean.setQuantity(quantity);

                bean.setPrice(price);

                list.add(bean);
            }

            connection.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AccountingManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
