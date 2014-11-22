/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.MagazineBean;
import java.util.ArrayList;

public interface MagazineDAOInterface {
    
    public MagazineBean getMagazineByProductID(int id);
    public MagazineBean getMagazineByID(int id);
    public ArrayList<MagazineBean> getMagazineByPublisher(String publisher);
    public ArrayList<MagazineBean> getMagazineByIssueNo(int issueNo);
    public ArrayList<MagazineBean> getmagazineByVolumeNo(int volumeNo);
      
}
