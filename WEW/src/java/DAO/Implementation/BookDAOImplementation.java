/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.BookBean;
import DAO.Interface.BookDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giodee
 */
public class BookDAOImplementation implements BookDAOInterface {

    @Override
    public BookBean getBookByProductId(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from book where book_productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();
            BookBean bean = new BookBean();
            int bookID, book_productID;
            String publisher, author;
            Date datePublished;

            while (resultSet.next()) {
                bookID = resultSet.getInt("bookID");
                book_productID = resultSet.getInt("book_productID");
                publisher = resultSet.getString("publisher");
                author = resultSet.getString("author");
                datePublished = resultSet.getDate("datePublished");

                bean.setAuthor(author);
                bean.setBookID(bookID);
                bean.setBook_productID(book_productID);
                bean.setDatePublished(datePublished);
                bean.setPublisher(publisher);
            }
            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(BookManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean deleteBook(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "delete from book where book_productID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

}
