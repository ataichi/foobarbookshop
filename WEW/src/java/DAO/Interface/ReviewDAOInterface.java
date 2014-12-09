/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.BookBean;
import java.sql.Date;
import java.util.ArrayList;
import Beans.ReviewBean;

/**
 *
 * @author Juan Paolo A. Coloma
 */
public interface ReviewDAOInterface {
      
    public boolean deleteReview (int ReviewID);
    public ArrayList<ReviewBean> getAllReviews(int ID);
    
}
