/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.DVDBean;
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

/**
 *
 * @author Giodee
 */
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
            Logger.getLogger(DVDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProductDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

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
            Logger.getLogger(DVDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
