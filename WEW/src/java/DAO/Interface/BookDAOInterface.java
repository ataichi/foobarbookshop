/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.BookBean;
import java.sql.Date;
import java.util.ArrayList;

public interface BookDAOInterface {

    public BookBean getBookByID(int bookID);
    public ArrayList<BookBean> getBookByAuthor(String author);
    public ArrayList<BookBean> getBookByPublisher(String publisher);
    public ArrayList<BookBean> getBookByDate(Date from, Date to);
    public BookBean getBookByProductID(int id);
}
