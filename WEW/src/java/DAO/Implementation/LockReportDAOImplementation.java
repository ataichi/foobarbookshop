/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.LockReportBean;
import DAO.Interface.LockReportDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LockReportDAOImplementation implements LockReportDAOInterface {
    
    @Override
    public boolean addLockReport(LockReportBean lockreport) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into lockreport (lockreport_accountID, reason, done, emailaddress) values (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, lockreport.getLockreport_accountID());
            ps.setString(2, lockreport.getReason());
            ps.setInt(3, lockreport.getDone());
            ps.setString(4, lockreport.getEmailaddress());
            
            ps.executeUpdate();
            connection.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(LockReportDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public ArrayList<LockReportBean> getLockReportByAccountID(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from lockreport where lockreport_accountID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            
            ArrayList<LockReportBean> list = new ArrayList<LockReportBean>();
            LockReportBean bean = new LockReportBean();
            
            int lockreportID, lockreport_accountID, done;
            String reason, emailaddress;
            while (resultSet.next()) {
                
                bean = new LockReportBean();
                
                lockreportID = resultSet.getInt("lockreportID");
                lockreport_accountID = resultSet.getInt("lockreport_accountID");
                
                done = resultSet.getInt("done");
                
                reason = resultSet.getString("reason");
                emailaddress = resultSet.getString("emailaddress");
                
                bean.setDone(done);
                bean.setEmailaddress(emailaddress);
                bean.setLockreportID(lockreportID);
                bean.setLockreport_accountID(lockreport_accountID);
                bean.setReason(reason);
                
                list.add(bean);
                
            }
            connection.close();
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(LockReportDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public ArrayList<LockReportBean> getLockReportByReason(String reason) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from lockreport where reason like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, reason);
            ResultSet resultSet = ps.executeQuery();
            
            ArrayList<LockReportBean> list = new ArrayList<LockReportBean>();
            LockReportBean bean = new LockReportBean();
            
            int lockreportID, lockreport_accountID, done;
            String lockreason, emailaddress;
            while (resultSet.next()) {
                
                bean = new LockReportBean();
                
                lockreportID = resultSet.getInt("lockreportID");
                lockreport_accountID = resultSet.getInt("lockreport_accountID");
                
                done = resultSet.getInt("done");
                
                lockreason = resultSet.getString("reason");
                emailaddress = resultSet.getString("emailaddress");
                
                bean.setLockreportID(lockreportID);
                bean.setLockreport_accountID(lockreport_accountID);
                
                bean.setDone(done);
                
                bean.setReason(reason);
                bean.setEmailaddress(emailaddress);
                
                list.add(bean);
                
            }
            connection.close();
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(LockReportDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public ArrayList<LockReportBean> getAllLockReport() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from lockreport";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ResultSet resultSet = ps.executeQuery();
            
            ArrayList<LockReportBean> list = new ArrayList<LockReportBean>();
            LockReportBean bean = new LockReportBean();
            
            int lockreportID, lockreport_accountID, done;
            String reason, emailaddress;
            while (resultSet.next()) {
                
                bean = new LockReportBean();
                
                lockreportID = resultSet.getInt("lockreportID");
                lockreport_accountID = resultSet.getInt("lockreport_accountID");
                
                done = resultSet.getInt("done");
                
                reason = resultSet.getString("reason");
                emailaddress = resultSet.getString("emailaddress");
                
                bean.setLockreportID(lockreportID);
                bean.setLockreport_accountID(lockreport_accountID);
                
                bean.setDone(done);
                
                bean.setReason(reason);
                bean.setEmailaddress(emailaddress);
                
                list.add(bean);
                list.add(bean);
                
            }
            connection.close();
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(LockReportDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public boolean editLockReport(LockReportBean lockreport) {
        String query = "UPDATE lockreport SET done=? WHERE lockreportID=?";
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, lockreport.getDone());
            ps.setInt(2, lockreport.getLockreportID());
            
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    @Override
    public ArrayList<LockReportBean> getAllDoneLockReport() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from lockreport where done = 1";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, 1);
            ResultSet resultSet = ps.executeQuery();
            
            ArrayList<LockReportBean> list = new ArrayList<LockReportBean>();
            LockReportBean bean = new LockReportBean();
            
            int lockreportID, lockreport_accountID, done;
            String reason, emailaddress;
            while (resultSet.next()) {
                
                bean = new LockReportBean();
                
                lockreportID = resultSet.getInt("lockreportID");
                lockreport_accountID = resultSet.getInt("lockreport_accountID");
                
                done = resultSet.getInt("done");
                
                reason = resultSet.getString("reason");
                emailaddress = resultSet.getString("emailaddress");
                
                bean.setLockreportID(lockreportID);
                bean.setLockreport_accountID(lockreport_accountID);
                
                bean.setDone(done);
                
                bean.setReason(reason);
                bean.setEmailaddress(emailaddress);
                
                list.add(bean);
                
                list.add(bean);
                
            }
            connection.close();
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(LockReportDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public ArrayList<LockReportBean> getAllNotDoneLockReport() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from lockreport where done = 0";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            
            ArrayList<LockReportBean> list = new ArrayList<LockReportBean>();
            LockReportBean bean = new LockReportBean();
            
            int lockreportID, lockreport_accountID, done;
            String reason, emailaddress;
            while (resultSet.next()) {
                
                bean = new LockReportBean();
                
                lockreportID = resultSet.getInt("lockreportID");
                lockreport_accountID = resultSet.getInt("lockreport_accountID");
                
                done = resultSet.getInt("done");
                
                reason = resultSet.getString("reason");
                emailaddress = resultSet.getString("emailaddress");
                
                bean.setLockreportID(lockreportID);
                bean.setLockreport_accountID(lockreport_accountID);
                
                bean.setDone(done);
                
                bean.setReason(reason);
                bean.setEmailaddress(emailaddress);
                
                list.add(bean);
                list.add(bean);
                
            }
            connection.close();
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(LockReportDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public LockReportBean getLockReportByID(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from lockreport where lockreportID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            System.out.println("lockreportID: " + id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            System.out.println("UMABOT PA KO DITO");
            LockReportBean bean = new LockReportBean();
            
            int lockreportID, lockreport_accountID, done;
            String reason, email;
            while (resultSet.next()) {
                
                bean = new LockReportBean();
                
                lockreportID = resultSet.getInt("lockreportID");
                lockreport_accountID = resultSet.getInt("lockreport_accountID");
                
                done = resultSet.getInt("done");
                
                reason = resultSet.getString("reason");
                email = resultSet.getString("emailaddress");
                 System.out.println("UMABOT PA KO DITO");
                bean.setDone(done);
                bean.setEmailaddress(email);
                bean.setLockreportID(lockreportID);
                bean.setLockreport_accountID(lockreport_accountID);
                bean.setReason(reason);
            }
            connection.close();
            return bean;
            
        } catch (SQLException ex) {
            Logger.getLogger(LockReportDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
