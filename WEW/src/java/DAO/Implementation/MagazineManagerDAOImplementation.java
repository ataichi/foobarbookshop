/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.MagazineBean;
import DAO.Interface.MagazineManagerDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danica
 */
public class MagazineManagerDAOImplementation implements MagazineManagerDAOInterface{
    MagazineBean bean = new MagazineBean();
    int magazineID, magazine_accountID, volumeNo, issueNo, magazine_productID;
    String publisher;
    java.util.Date datePublished = new java.util.Date();
    String query;
    ArrayList<MagazineBean> mlist = new ArrayList<MagazineBean>();
    
    @Override
    public MagazineBean getMagazine(int ID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "select * from magazine where magazineID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ID);
            
            ResultSet resultSet = ps.executeQuery();
            
            while(resultSet.next()) {
                magazineID = resultSet.getInt("magazineID");
                magazine_accountID = resultSet.getInt("magazine_accountID");
                volumeNo = resultSet.getInt("volumeNo");
                issueNo = resultSet.getInt("issueNo");
                publisher = resultSet.getString("publisher");
                datePublished = resultSet.getDate("datePublished");
                
                bean = new MagazineBean();
                
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
    public boolean addMagazine(MagazineBean magazine) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "insert into magazine (magazine_productID, volumeNo, issueNo, publisher, datePublished) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, magazine.getMagazine_productID());
            ps.setInt(2, magazine.getVolumeNo());
            ps.setInt(3, magazine.getIssueNo());
            ps.setString(4, magazine.getPublisher());
            ps.setDate(5, magazine.getDatePublished());
            ps.executeUpdate();
            connection.close();
            return true;
        
        
        } catch (SQLException ex) {
            Logger.getLogger(MagazineManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editMagazine(MagazineBean magazine) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "update magazine set volumeNo = ?, issueNo = ?, publisher = ? datePublished = ? where magazine_productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, magazine.getVolumeNo());
            ps.setInt(2, magazine.getIssueNo());
            ps.setString(3, magazine.getPublisher());
            ps.setDate(4, magazine.getDatePublished());
            ps.setInt(5, magazine.getMagazine_productID());
            ps.executeUpdate();
            
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MagazineManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
    }

    @Override
    public boolean deleteMagazine(int id) {
        
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "delete from magazine where magazineID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MagazineManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
                
                mlist.add(bean);
            }
            connection.close();
            return mlist;
            
        } catch (SQLException ex) {
            Logger.getLogger(MagazineManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean restockMagazine(int productID, int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MagazineBean> searchMagazinebyTitle(String title) {
        try {
            String query = "select * from magazine where title = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, title);
            
            ResultSet rs = ps.executeQuery();
            Date datePublished;
            
            while(rs.next()) {
                
                bean = new MagazineBean();
                magazineID = rs.getInt("magazineID");
                volumeNo = rs.getInt("volumeNo");
                issueNo = rs.getInt("issueNo");
                magazine_productID = rs.getInt("magazine_productID");
                publisher = rs.getString("publisher");
                datePublished = rs.getDate("datePublished");
                
                bean.setDatePublished(datePublished);
                bean.setIssueNo(issueNo);
                bean.setMagazineID(magazineID);
                bean.setMagazine_productID(magazine_productID);
                bean.setPublisher(publisher);
                bean.setVolumeNo(volumeNo);
                
                mlist.add(bean);
            }
            
            connection.close();
            return mlist;
            
        } catch (SQLException ex) {
            Logger.getLogger(MagazineManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

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
            Logger.getLogger(MagazineManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MagazineManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MagazineManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MagazineManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MagazineManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
