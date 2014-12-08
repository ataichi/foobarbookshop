/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.ProductBean;
import Beans.ProductOrderBean;
import DAO.Interface.AccountingManagerDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public ProductBean getSalesByYear(Date date) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select SUM(total) AS totalorders from shoppingcart where Year(orderDate) = ?"
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, date);

            ResultSet resultSet = ps.executeQuery();

            //ProductBean product = new ProductBean();

            /*int productID;
            String type, title;
            double price;
            String summary, genre;
            int year, stocks;
            
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
            }*/
             while (resultSet.next()) {
                total = resultSet.getInt("totalorders");
                return total;
            }
            connection.close();

            //return product;

        } catch (SQLException ex) {
            Logger.getLogger(AccountingManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

}
