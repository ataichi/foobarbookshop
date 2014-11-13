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

import Beans.MagazineBean;
import java.util.ArrayList;

public interface MagazineManagerDAOInterface {
    public boolean addMagazine (MagazineBean magazine);
    public boolean editMagazine (MagazineBean magazine);
    public boolean deleteMagazine (MagazineBean magazine);
    
    public MagazineBean getMagazine (int ID);
    public ArrayList<MagazineBean> viewAllMagazine();
    public boolean restockMagazine(int productID, int num);
    public ArrayList<MagazineBean> searchMagazinebyTitle(String title);
}
