/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.BookBean;
import java.sql.Date;
import java.util.ArrayList;

public interface BookManagerDAOInterface {
    
    public boolean addBook (BookBean book);
    public boolean editBook (BookBean book);
    public boolean deleteBook (int bookID);
     
    public ArrayList<BookBean> getAllBooks();
    public boolean restockBook(int productID, int num);
}
