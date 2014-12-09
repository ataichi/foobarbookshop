/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.BookBean;
import Beans.ReviewBean;
import DAO.Interface.ReviewDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReviewDAOImplementation implements ReviewDAOInterface {

    String query, reviewString;
    int ID, source, product;
    ArrayList<ReviewBean> rlist = new ArrayList<ReviewBean>();
    ReviewBean bean;

    @Override
    public boolean deleteReview(int ReviewID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "delete from review where reviewID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ReviewID);
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BookManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<ReviewBean> getAllReviews() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "select * from review";
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                ID = resultSet.getInt("reviewID");
                reviewString = resultSet.getString("reviewString");
                source = resultSet.getInt("review_CustomerID");
                product = resultSet.getInt("review_ProductID");

                bean = new ReviewBean();

                bean.setReview(reviewString);
                bean.setReviewID(ID);
                bean.setReview_customerID(source);
                bean.setReview_productID(product);

                rlist.add(bean);
            }
            connection.close();
            return rlist;

        } catch (SQLException ex) {
            Logger.getLogger(BookManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ReviewBean getReviewByReviewID(int reviewID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "select * from review where reviewID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, reviewID);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                ID = resultSet.getInt("reviewID");
                reviewString = resultSet.getString("reviewString");
                source = resultSet.getInt("review_CustomerID");
                product = resultSet.getInt("review_ProductID");

                bean = new ReviewBean();

                bean.setReview(reviewString);
                bean.setReviewID(ID);
                bean.setReview_customerID(source);
                bean.setReview_productID(product);
            }
            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(BookManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
