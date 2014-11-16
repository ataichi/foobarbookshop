/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.BookBean;

/**
 *
 * @author Giodee
 */
public interface BookDAOInterface {
    public BookBean getBookByProductId(int id);
    
}
