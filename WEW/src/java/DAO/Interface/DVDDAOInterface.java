/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.DVDBean;
import java.util.ArrayList;

public interface DVDDAOInterface {
    public DVDBean getDVDByID(int id);
    public DVDBean getDVDByProductID(int productID);
    public ArrayList<DVDBean> getDVDByDirector(String director);
    public ArrayList<DVDBean> getDVDByActor(String actor);
    public ArrayList<DVDBean> getDVDByProducer(String productCompany);
}
