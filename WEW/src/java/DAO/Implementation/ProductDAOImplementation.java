/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.ProductBean;
import DAO.Interface.ProductDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAOImplementation implements ProductDAOInterface {

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
            Logger.getLogger(ProductDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<ProductBean> getAllProductsByType(String type) {
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
            Logger.getLogger(ProductDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<ProductBean> getProductsByTitle(String title) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from product where title like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            String temp = "%" + title + "%";
            ps.setString(1, temp);

            ProductBean bean = new ProductBean();
            ArrayList<ProductBean> list = new ArrayList<ProductBean>();
            String type, title1, summary, genre;
            int year, stocks, productID;
            double price;

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                bean = new ProductBean();

                type = resultSet.getString("type");
                title1 = resultSet.getString("title");
                summary = resultSet.getString("summary");
                genre = resultSet.getString("genre");

                year = resultSet.getInt("year");
                stocks = resultSet.getInt("stocks");
                productID = resultSet.getInt("productID");

                price = resultSet.getDouble("price");

                bean.setType(type);
                bean.setTitle(title1);
                bean.setSummary(summary);
                bean.setGenre(genre);

                bean.setYear(year);
                bean.setNumberStocks(stocks);
                bean.setProductID(productID);

                bean.setPrice(price);

                list.add(bean);
            }
            connection.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<ProductBean> getProductsBySummary(String summary) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from product where summary like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            String temp = "%" + summary + "%";
            ps.setString(1, temp);

            ProductBean bean = new ProductBean();
            ArrayList<ProductBean> list = new ArrayList<ProductBean>();
            String type, title, summary1, genre;
            int year, stocks, productID;
            double price;

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                bean = new ProductBean();

                type = resultSet.getString("type");
                title = resultSet.getString("title");
                summary1 = resultSet.getString("summary");
                genre = resultSet.getString("genre");

                year = resultSet.getInt("year");
                stocks = resultSet.getInt("stocks");
                productID = resultSet.getInt("productID");

                price = resultSet.getDouble("price");

                bean.setType(type);
                bean.setTitle(title);
                bean.setSummary(summary1);
                bean.setGenre(genre);

                bean.setYear(year);
                bean.setNumberStocks(stocks);
                bean.setProductID(productID);

                bean.setPrice(price);

                list.add(bean);
            }
            connection.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<ProductBean> getProductsByGenre(String genre) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from product where genre like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            String temp = "%" + genre + "%";
            ps.setString(1, temp);

            ProductBean bean = new ProductBean();
            ArrayList<ProductBean> list = new ArrayList<ProductBean>();
            String type, title, summary, genre1;
            int year, stocks, productID;
            double price;

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                bean = new ProductBean();

                type = resultSet.getString("type");
                title = resultSet.getString("title");
                summary = resultSet.getString("summary");
                genre1 = resultSet.getString("genre");

                year = resultSet.getInt("year");
                stocks = resultSet.getInt("stocks");
                productID = resultSet.getInt("productID");

                price = resultSet.getDouble("price");

                bean.setType(type);
                bean.setTitle(title);
                bean.setSummary(summary);
                bean.setGenre(genre1);

                bean.setYear(year);
                bean.setNumberStocks(stocks);
                bean.setProductID(productID);

                bean.setPrice(price);

                list.add(bean);
            }
            connection.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<ProductBean> getProductsByYear(int year) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from product where year = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, year);

            ProductBean bean = new ProductBean();
            ArrayList<ProductBean> list = new ArrayList<ProductBean>();
            String type, title, summary, genre;
            int year1, stocks, productID;
            double price;

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                bean = new ProductBean();

                type = resultSet.getString("type");
                title = resultSet.getString("title");
                summary = resultSet.getString("summary");
                genre = resultSet.getString("genre");

                year1 = resultSet.getInt("year");
                stocks = resultSet.getInt("stocks");
                productID = resultSet.getInt("productID");

                price = resultSet.getDouble("price");

                bean.setType(type);
                bean.setTitle(title);
                bean.setSummary(summary);
                bean.setGenre(genre);

                bean.setYear(year1);
                bean.setNumberStocks(stocks);
                bean.setProductID(productID);

                bean.setPrice(price);

                list.add(bean);
            }
            connection.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public boolean updateStocks(int productid, int stocks) {
        String query = "UPDATE product SET stocks=? WHERE productID=?";
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, stocks);
            ps.setInt(2, productid);
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<ProductBean> getAllAvailableProducts() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from product where stocks > 0";
            PreparedStatement ps = connection.prepareStatement(query);

            ArrayList<ProductBean> list = new ArrayList<ProductBean>();
            ProductBean bean = new ProductBean();
            String type, title, summary, genre;
            int year, stocks, productID;
            double price;

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                bean = new ProductBean();
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

                list.add(bean);
            }
            connection.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<ProductBean> getAllAvailableProductsByType(String type) {
        try {
            String query = "select * from product where stocks > 0 AND type=?";
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
            Logger.getLogger(ProductDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
