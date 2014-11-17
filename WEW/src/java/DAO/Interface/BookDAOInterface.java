/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.BookBean;
import java.util.ArrayList;

/**
 *
 * @author Giodee
 */
public interface BookDAOInterface {
    public BookBean getBookByProductId(int id);
    public boolean deleteBook(int id);
    public ArrayList<BookBean> getAllBooks();
    
}
