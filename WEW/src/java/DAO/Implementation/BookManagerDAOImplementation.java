/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.BookBean;
import DAO.Interface.BookManagerDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookManagerDAOImplementation implements BookManagerDAOInterface {

    BookBean bean = new BookBean();
    ArrayList<BookBean> blist = new ArrayList<BookBean>();
    int bookID, book_productID;
    String author, publisher;
    Date datePublished;
    String query;

    @Override
    public boolean addBook(BookBean book) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "insert into book (author, publisher, datePublished, book_productID) values (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, book.getAuthor());
            ps.setString(2, book.getPublisher());
            ps.setDate(3, book.getDatePublished());
            ps.setInt(4, book.getBook_productID());
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(BookManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editBook(BookBean book) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "update book set author = ?, publisher = ?, datePublished = ? where book_productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, book.getAuthor());
            ps.setString(2, book.getPublisher());
            ps.setDate(3, book.getDatePublished());
            ps.setInt(4, book.getBook_productID());
            ps.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BookManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteBook(int bookID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "delete from book where bookID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bookID);
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BookManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean restockBook(int productID, int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BookBean> getAllBooks() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "select * from book";
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                bookID = resultSet.getInt("bookID");
                book_productID = resultSet.getInt("book_productID");
                publisher = resultSet.getString("publisher");
                author = resultSet.getString("author");
                datePublished = resultSet.getDate("datePublished");

                bean = new BookBean();

                bean.setAuthor(author);
                bean.setBookID(bookID);
                bean.setBook_productID(book_productID);
                bean.setDatePublished(datePublished);
                bean.setPublisher(publisher);

                blist.add(bean);
            }
            connection.close();
            return blist;

        } catch (SQLException ex) {
            Logger.getLogger(BookManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public BookBean getBookByID(int bookID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from book where bookID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bookID);

            ResultSet resultSet = ps.executeQuery();
            int bookID1, book_productID;
            String publisher, author;
            java.sql.Date datePublished;
            BookBean bean = new BookBean();
            while (resultSet.next()) {
                bookID1 = resultSet.getInt("bookID");
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
    public ArrayList<BookBean> getBookByAuthor(String author) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from book where author = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+author+"%");

            ResultSet resultSet = ps.executeQuery();
            int bookID, book_productID;
            String publisher, author1;
            java.sql.Date datePublished;
            ArrayList<BookBean> booklist = new ArrayList<BookBean>();
            BookBean bean = new BookBean();
            while (resultSet.next()) {
                bookID = resultSet.getInt("bookID");
                book_productID = resultSet.getInt("book_productID");
                publisher = resultSet.getString("publisher");
                author1 = resultSet.getString("author");
                datePublished = resultSet.getDate("datePublished");

                bean = new BookBean();

                bean.setAuthor(author);
                bean.setBookID(bookID);
                bean.setBook_productID(book_productID);
                bean.setDatePublished(datePublished);
                bean.setPublisher(publisher);

                booklist.add(bean);
            }
            connection.close();
            return booklist;

        } catch (SQLException ex) {
            Logger.getLogger(BookManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }

    @Override
    public ArrayList<BookBean> getBookByPublisher(String publisher) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from book where publisher = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+publisher+"%");

            ResultSet resultSet = ps.executeQuery();
            int bookID, book_productID;
            String publisher1, author;
            java.sql.Date datePublished;
            
            ArrayList<BookBean> booklist = new ArrayList<BookBean>();
            BookBean bean = new BookBean();
            
            while (resultSet.next()) {
                bookID = resultSet.getInt("bookID");
                book_productID = resultSet.getInt("book_productID");
                publisher1 = resultSet.getString("publisher");
                author = resultSet.getString("author");
                datePublished = resultSet.getDate("datePublished");

                bean = new BookBean();

                bean.setAuthor(author);
                bean.setBookID(bookID);
                bean.setBook_productID(book_productID);
                bean.setDatePublished(datePublished);
                bean.setPublisher(publisher1);

                booklist.add(bean);
            }
            connection.close();
            return booklist;

        } catch (SQLException ex) {
            Logger.getLogger(BookManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<BookBean> getBookByDate(Date from, Date to) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from book where datePublished > ? and datePublished < ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, from);
            ps.setDate(2, to);

            ResultSet resultSet = ps.executeQuery();
            int bookID, book_productID;
            String publisher, author;
            java.sql.Date datePublished;
            ArrayList<BookBean> booklist = new ArrayList<BookBean>();
            BookBean bean = new BookBean();
            while (resultSet.next()) {
                bookID = resultSet.getInt("bookID");
                book_productID = resultSet.getInt("book_productID");
                publisher = resultSet.getString("publisher");
                author = resultSet.getString("author");
                datePublished = resultSet.getDate("datePublished");

                bean = new BookBean();

                bean.setAuthor(author);
                bean.setBookID(bookID);
                bean.setBook_productID(book_productID);
                bean.setDatePublished(datePublished);
                bean.setPublisher(publisher);

                booklist.add(bean);
            }
            connection.close();
            return booklist;

        } catch (SQLException ex) {
            Logger.getLogger(BookManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public BookBean getBookByProductID(int id) {
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

}
