/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

/**
 *
 * @author jao
 */

import Beans.DVDBean;
import java.util.ArrayList;

public interface DVDManagerDAOInterface {
    public boolean addDVD (DVDBean DVD);
    public boolean editDVD (DVDBean DVD);
    public boolean deleteDVD (DVDBean DVD);
    public DVDBean getDVD (int ID);
    public ArrayList<DVDBean> viewAllDVD();
    public boolean restockDVD(int productID, int num);
    public ArrayList<DVDBean> searchDVDbyTitle(String title);
}
