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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MagazineDAOImplementation implements MagazineDAOInterface {

    @Override
    public MagazineBean getMagazineByProductID(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from magazine where magazine_productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            MagazineBean bean = new MagazineBean();
            int magazineID, magazine_productID, volumeNo, issueNo;
            java.sql.Date datePublished;
            String publisher;
            
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next()) {
                magazineID = resultset.getInt("magazineID");
                magazine_productID = resultset.getInt("magazine_productID");
                volumeNo = resultset.getInt("volumeNo");
                issueNo = resultset.getInt("issueNo");
                
                datePublished = resultset.getDate("datePublished");
                
                publisher = resultset.getString("publisher");
                
                bean.setMagazineID(magazineID);
                bean.setMagazine_productID(magazine_productID);
                bean.setVolumeNo(volumeNo);
                bean.setIssueNo(issueNo);
                
                bean.setDatePublished(datePublished);
                
                bean.setPublisher(publisher);
            }
            connection.close();
            return bean;
            
        } catch (SQLException ex) {
            Logger.getLogger(MagazineDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public MagazineBean getMagazineByID(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from magazine where magazineID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            MagazineBean bean = new MagazineBean();
            int magazineID, magazine_productID, volumeNo, issueNo;
            java.sql.Date datePublished;
            String publisher;
            
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next()) {
                magazineID = resultset.getInt("magazineID");
                magazine_productID = resultset.getInt("magazine_productID");
                volumeNo = resultset.getInt("volumeNo");
                issueNo = resultset.getInt("issueNo");
                
                datePublished = resultset.getDate("datePublished");
                
                publisher = resultset.getString("publisher");
                
                bean.setMagazineID(magazineID);
                bean.setMagazine_productID(magazine_productID);
                bean.setVolumeNo(volumeNo);
                bean.setIssueNo(issueNo);
                
                bean.setDatePublished(datePublished);
                
                bean.setPublisher(publisher);
            }
            connection.close();
            return bean;
            
        } catch (SQLException ex) {
            Logger.getLogger(MagazineDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<MagazineBean> getMagazineByPublisher(String publisher) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from magazine where publisher like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+publisher+"%");
            
            MagazineBean bean = new MagazineBean();
            ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();
            int magazineID, magazine_productID, volumeNo, issueNo;
            java.sql.Date datePublished;
            String publisher1;
            
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next()) {
                
                bean = new MagazineBean();
                
                magazineID = resultset.getInt("magazineID");
                magazine_productID = resultset.getInt("magazine_productID");
                volumeNo = resultset.getInt("volumeNo");
                issueNo = resultset.getInt("issueNo");
                
                datePublished = resultset.getDate("datePublished");
                
                publisher1 = resultset.getString("publisher");
                
                bean.setMagazineID(magazineID);
                bean.setMagazine_productID(magazine_productID);
                bean.setVolumeNo(volumeNo);
                bean.setIssueNo(issueNo);
                
                bean.setDatePublished(datePublished);
                
                bean.setPublisher(publisher1);
                
                magazinelist.add(bean);
            }
            connection.close();
            return magazinelist;
            
        } catch (SQLException ex) {
            Logger.getLogger(MagazineDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<MagazineBean> getMagazineByIssueNo(int issueNo) {
         try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from magazine where issueNo = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, issueNo);
            
            ArrayList<MagazineBean> magazinelist= new ArrayList<MagazineBean>();
            MagazineBean bean = new MagazineBean();
            int magazineID, magazine_productID, volumeNo, issueNo1;
            java.sql.Date datePublished;
            String publisher;
            
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next()) {
                bean = new MagazineBean();
                
                magazineID = resultset.getInt("magazineID");
                magazine_productID = resultset.getInt("magazine_productID");
                volumeNo = resultset.getInt("volumeNo");
                issueNo1 = resultset.getInt("issueNo");
                
                datePublished = resultset.getDate("datePublished");
                
                publisher = resultset.getString("publisher");
                
                bean.setMagazineID(magazineID);
                bean.setMagazine_productID(magazine_productID);
                bean.setVolumeNo(volumeNo);
                bean.setIssueNo(issueNo1);
                
                bean.setDatePublished(datePublished);
                
                bean.setPublisher(publisher);
                
                magazinelist.add(bean);
            }
            connection.close();
            return magazinelist;
            
        } catch (SQLException ex) {
            Logger.getLogger(MagazineDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<MagazineBean> getmagazineByVolumeNo(int volumeNo) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from magazine where volumeNo = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, volumeNo);
            
            ArrayList<MagazineBean> magazinelist = new ArrayList<MagazineBean>();
            MagazineBean bean = new MagazineBean();
            int magazineID, magazine_productID, volumeNo1, issueNo;
            java.sql.Date datePublished;
            String publisher;
            
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next()) {
                bean = new MagazineBean();
                
                magazineID = resultset.getInt("magazineID");
                magazine_productID = resultset.getInt("magazine_productID");
                volumeNo1 = resultset.getInt("volumeNo");
                issueNo = resultset.getInt("issueNo");
                
                datePublished = resultset.getDate("datePublished");
                
                publisher = resultset.getString("publisher");
                
                bean.setMagazineID(magazineID);
                bean.setMagazine_productID(magazine_productID);
                bean.setVolumeNo(volumeNo1);
                bean.setIssueNo(issueNo);
                
                bean.setDatePublished(datePublished);
                
                bean.setPublisher(publisher);
                
                magazinelist.add(bean);
            }
            connection.close();
            return magazinelist;
            
        } catch (SQLException ex) {
            Logger.getLogger(MagazineDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
