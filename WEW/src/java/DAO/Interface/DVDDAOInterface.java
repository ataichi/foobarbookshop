/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.DVDBean;

/**
 *
 * @author Giodee
 */
public interface DVDDAOInterface {
    public DVDBean getDVDByProductId(int id);
    
}
