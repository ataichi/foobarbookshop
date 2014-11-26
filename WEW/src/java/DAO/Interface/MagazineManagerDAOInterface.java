/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.MagazineBean;
import java.util.ArrayList;

public interface MagazineManagerDAOInterface {
    public boolean addMagazine (MagazineBean magazine);
    public boolean editMagazine (MagazineBean magazine);
    public boolean deleteMagazine (int id);
    
    public MagazineBean getMagazine (int ID);
    public ArrayList<MagazineBean> getAllMagazine();
    public boolean restockMagazine(int productID, int num);
    public ArrayList<MagazineBean> searchMagazinebyTitle(String title);
    public MagazineBean getMagazineByProductID(int id);
    public MagazineBean getMagazineByID(int id);
    public ArrayList<MagazineBean> getMagazineByPublisher(String publisher);
    public ArrayList<MagazineBean> getMagazineByIssueNo(int issueNo);
    public ArrayList<MagazineBean> getmagazineByVolumeNo(int volumeNo);
    
}
