/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.DVDBean;
import DAO.Interface.DVDDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DVDDAOImplementation implements DVDDAOInterface{

   @Override
    public DVDBean getDVDByID(int ID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from dvd where dvdID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ID);
            
            DVDBean bean = new DVDBean();
            int dvdID, dvd_productID;
            String director, actor, productCompany;
            
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next()) {
                dvdID = resultset.getInt("dvdID");
                dvd_productID = resultset.getInt("dvd_productID");
                director = resultset.getString("director");
                actor = resultset.getString("actor");
                productCompany = resultset.getString("productCompany");
            
                bean.setDvdID(dvdID);
                bean.setDirector(director);
                bean.setProductionCompany(productCompany);
                bean.setDvd_productID(dvd_productID);
                bean.setMainActors(actor);
            }
            connection.close();
            return bean;
            
        } catch (SQLException ex) {
            Logger.getLogger(DVDDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public DVDBean getDVDByProductID(int productID) {
         try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from dvd where dvd_productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            
            DVDBean bean = new DVDBean();
            int dvdID, dvd_productID;
            String director, actor, productCompany;
            
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next()) {
                dvdID = resultset.getInt("dvdID");
                dvd_productID = resultset.getInt("dvd_productID");
                director = resultset.getString("director");
                actor = resultset.getString("actor");
                productCompany = resultset.getString("productCompany");
            
                bean.setDvdID(dvdID);
                bean.setDirector(director);
                bean.setProductionCompany(productCompany);
                bean.setDvd_productID(dvd_productID);
                bean.setMainActors(actor);
            }
            connection.close();
            return bean;
            
        } catch (SQLException ex) {
            Logger.getLogger(DVDDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<DVDBean> getDVDByDirector(String director) {
         try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from dvd where director like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+director+"%");
            
            DVDBean bean = new DVDBean();
            ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
            int dvdID, dvd_productID;
            String director1, actor, productCompany;
            
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next()) {
                bean = new DVDBean();
                
                dvdID = resultset.getInt("dvdID");
                dvd_productID = resultset.getInt("dvd_productID");
                director1 = resultset.getString("director");
                actor = resultset.getString("actor");
                productCompany = resultset.getString("productCompany");
            
                bean.setDvdID(dvdID);
                bean.setDirector(director1);
                bean.setProductionCompany(productCompany);
                bean.setDvd_productID(dvd_productID);
                bean.setMainActors(actor);
                
                dvdlist.add(bean);
            }
            connection.close();
            return dvdlist;
            
        } catch (SQLException ex) {
            Logger.getLogger(DVDDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<DVDBean> getDVDByActor(String actor) {
           try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from dvd where actor like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+actor+"%");
            
            DVDBean bean = new DVDBean();
            ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
            int dvdID, dvd_productID;
            String director, actor1, productCompany;
            
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next()) {
                bean = new DVDBean();
                
                dvdID = resultset.getInt("dvdID");
                dvd_productID = resultset.getInt("dvd_productID");
                director = resultset.getString("director");
                actor1 = resultset.getString("actor");
                productCompany = resultset.getString("productCompany");
            
                bean.setDvdID(dvdID);
                bean.setDirector(director);
                bean.setProductionCompany(productCompany);
                bean.setDvd_productID(dvd_productID);
                bean.setMainActors(actor1);
                
                dvdlist.add(bean);
            }
            connection.close();
            return dvdlist;
            
        } catch (SQLException ex) {
            Logger.getLogger(DVDDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<DVDBean> getDVDByProducer(String productCompany) {
          try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from dvd where productCompany like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+productCompany+"%");
            
            DVDBean bean = new DVDBean();
            ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
            int dvdID, dvd_productID;
            String director, actor, productCompany1;
            
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next()) {
                bean = new DVDBean();
                
                dvdID = resultset.getInt("dvdID");
                dvd_productID = resultset.getInt("dvd_productID");
                director = resultset.getString("director");
                actor = resultset.getString("actor");
                productCompany1 = resultset.getString("productCompany");
            
                bean.setDvdID(dvdID);
                bean.setDirector(director);
                bean.setProductionCompany(productCompany1);
                bean.setDvd_productID(dvd_productID);
                bean.setMainActors(actor);
                
                dvdlist.add(bean);
            }
            connection.close();
            return dvdlist;
            
        } catch (SQLException ex) {
            Logger.getLogger(DVDDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
