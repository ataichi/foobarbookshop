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

/**
 *
 * @author Giodee
 */
public class DVDDAOImplementation implements DVDDAOInterface {

    @Override
    public DVDBean getDVDByProductId(int ID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from dvd where dvd_productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ID);

            DVDBean bean = new DVDBean();
            int dvdID, dvd_productID;
            String director, actor, productCompany;

            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
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
            Logger.getLogger(DVDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean deleteDVD(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "delete from dvd where dvd_productID=?";
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
    public ArrayList<DVDBean> getAllDVD() {
        try {
            String query = "select * from dvd";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);

            int dvdID, dvd_productID;
            String director, productionCompany, mainActors;

            DVDBean bean = new DVDBean();
            ArrayList<DVDBean> mlist = new ArrayList<DVDBean>();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dvdID = rs.getInt("dvdID");
                dvd_productID = rs.getInt("dvd_productID");
                director = rs.getString("director");
                productionCompany = rs.getString("productCompany");
                mainActors = rs.getString("actor");

                bean = new DVDBean();
                bean.setDirector(director);
                bean.setDvdID(dvdID);
                bean.setDvd_productID(dvd_productID);
                bean.setMainActors(mainActors);
                bean.setProductionCompany(productionCompany);

                mlist.add(bean);
            }
            connection.close();
            return mlist;

        } catch (SQLException ex) {
            Logger.getLogger(DVDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
