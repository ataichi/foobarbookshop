/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.MagazineBean;
import DAO.Interface.MagazineDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MagazineDAOImplementation implements MagazineDAOInterface {

    @Override
    public MagazineBean getMagazineByProductId(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from magazine where magazine_productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();
            MagazineBean bean = new MagazineBean();
            int magazineID, magazine_productID, volumeNo, issueNo;
            String publisher;
            java.sql.Date datePublished;
            while (resultSet.next()) {
                magazineID = resultSet.getInt("magazineID");
                magazine_productID = resultSet.getInt("magazine_productID");
                volumeNo = resultSet.getInt("volumeNo");
                issueNo = resultSet.getInt("issueNo");
                publisher = resultSet.getString("publisher");
                datePublished = resultSet.getDate("datePublished");

                bean = new MagazineBean();
                
                bean.setMagazine_productID(magazine_productID);
                bean.setMagazineID(magazineID);
                bean.setIssueNo(issueNo);
                bean.setVolumeNo(volumeNo);
                bean.setPublisher(publisher);
                bean.setDatePublished((Date) datePublished);
            }
            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(MagazineManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public boolean deleteMagazine(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "delete from magazine where magazine_productID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public ArrayList<MagazineBean> getAllMagazine() {
         try {
            String query = "select * from magazine";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            Date datePublished;
            int magazineID, volumeNo, issueNo, magazine_productID;
            String publisher;
            ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();
            MagazineBean bean = new MagazineBean();
            while(rs.next()) {
                magazineID = rs.getInt("magazineID");
                volumeNo = rs.getInt("volumeNo");
                issueNo = rs.getInt("issueNo");
                magazine_productID = rs.getInt("magazine_productID");
                publisher = rs.getString("publisher");
                datePublished = rs.getDate("datePublished");
                
                bean = new MagazineBean();
                bean.setDatePublished(datePublished);
                bean.setIssueNo(issueNo);
                bean.setMagazineID(magazineID);
                bean.setMagazine_productID(magazine_productID);
                bean.setPublisher(publisher);
                bean.setVolumeNo(volumeNo);
                
                magazinelist.add(bean);
            }
            connection.close();
            return magazinelist;
            
        } catch (SQLException ex) {
            Logger.getLogger(MagazineManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
