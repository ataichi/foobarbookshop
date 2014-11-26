/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.ProductBean;
import DAO.Interface.ProductManagerDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductManagerDAOImplementation implements ProductManagerDAOInterface {

    @Override
    public boolean addProduct(ProductBean product) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into product (type, title, price, summary, genre, year, stocks) "
                    + "values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, product.getType());
            ps.setString(2, product.getTitle());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getSummary());
            ps.setString(5, product.getGenre());
            ps.setInt(6, product.getYear());
            ps.setInt(7, product.getNumberStocks());
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProductManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ProductBean getLastProduct() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from product "
                    + "order by productID desc "
                    + "limit 1";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ProductBean bean = new ProductBean();
            int productID, year, stocks;
            String type, title, summary, genre;
            double price;
            while (resultSet.next()) {
                productID = resultSet.getInt("productID");
                year = resultSet.getInt("year");
                stocks = resultSet.getInt("stocks");

                type = resultSet.getString("type");
                title = resultSet.getString("title");
                summary = resultSet.getString("summary");
                genre = resultSet.getString("genre");

                price = resultSet.getDouble("price");

                bean.setProductID(productID);
                bean.setYear(year);
                bean.setNumberStocks(stocks);

                bean.setType(type);
                bean.setTitle(title);
                bean.setSummary(summary);
                bean.setGenre(genre);

                bean.setPrice(price);

                return bean;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<ProductBean> getProductsByType(String type) {
        try {
            String query = "select * from product where type=?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, type);

            int productID, year, stocks;
            String prodtype, title, summary, genre;
            double price;
            ProductBean bean = new ProductBean();
            ArrayList<ProductBean> plist = new ArrayList<ProductBean>();

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

                productID = resultSet.getInt("productID");
                year = resultSet.getInt("year");
                stocks = resultSet.getInt("stocks");

                price = resultSet.getDouble("price");

                prodtype = resultSet.getString("type");
                title = resultSet.getString("title");
                summary = resultSet.getString("summary");
                genre = resultSet.getString("genre");

                bean = new ProductBean();

                bean.setProductID(productID);
                bean.setYear(year);
                bean.setNumberStocks(stocks);

                bean.setPrice(price);

                bean.setType(type);
                bean.setTitle(title);
                bean.setSummary(summary);
                bean.setGenre(genre);

                plist.add(bean);
            }
            connection.close();
            return plist;

        } catch (SQLException ex) {
            Logger.getLogger(ProductManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public boolean editProduct(ProductBean product) {
        String query = "UPDATE product SET title=?, price=?, summary=?, genre=?, year=?, stocks=? WHERE productID=?";
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, product.getTitle());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getSummary());
            ps.setString(4, product.getGenre());
            ps.setInt(5, product.getYear());
            ps.setInt(6, product.getNumberStocks());
            ps.setInt(7, product.getProductID());

            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public ProductBean getProductById(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from product where productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ProductBean bean = new ProductBean();
            String type, title, summary, genre;
            int year, stocks, productID;
            double price;

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                type = resultSet.getString("type");
                title = resultSet.getString("title");
                summary = resultSet.getString("summary");
                genre = resultSet.getString("genre");

                year = resultSet.getInt("year");
                stocks = resultSet.getInt("stocks");
                productID = resultSet.getInt("productID");

                price = resultSet.getDouble("price");

                bean.setType(type);
                bean.setTitle(title);
                bean.setSummary(summary);
                bean.setGenre(genre);

                bean.setYear(year);
                bean.setNumberStocks(stocks);
                bean.setProductID(productID);

                bean.setPrice(price);
            }
            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(ProductManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public boolean removeProduct(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "delete from product where productID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean restockProduct(int newstocks, int id) {
        String query = "UPDATE product SET stocks=? WHERE productID=?";
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, newstocks);
            ps.setInt(2, id);

            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}
