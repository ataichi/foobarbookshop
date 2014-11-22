/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.DVDBean;
import java.util.ArrayList;

public interface DVDManagerDAOInterface {
    public boolean addDVD (DVDBean DVD);
    public boolean editDVD (DVDBean DVD);
    public boolean deleteDVD (int id);
    public ArrayList<DVDBean> viewAllDVD();
    public boolean restockDVD(int productID, int num);

}
