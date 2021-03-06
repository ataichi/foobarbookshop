/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.DVDBean;
import DAO.Interface.DVDManagerDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DVDManagerDAOImplementation implements DVDManagerDAOInterface {

    DVDBean bean = new DVDBean();
    int dvdID, dvd_productID;
    String director, actor, productCompany;
    String query;

    @Override
    public boolean addDVD(DVDBean DVD) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "insert into dvd (dvd_productID, director, actor, productCompany) values (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, DVD.getDvd_productID());
            ps.setString(2, DVD.getDirector());
            ps.setString(3, DVD.getMainActors());
            ps.setString(4, DVD.getProductionCompany());

            ps.executeUpdate();

            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DVDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editDVD(DVDBean DVD) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "update dvd set director = ?, actor = ?, productCompany = ? where dvd_productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, DVD.getDirector());
            ps.setString(2, DVD.getMainActors());
            ps.setString(3, DVD.getProductionCompany());
            ps.setInt(4, DVD.getDvd_productID());
            ps.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DVDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteDVD(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "delete from dvd where dvdID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DVDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<DVDBean> viewAllDVD() {
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

    @Override
    public boolean restockDVD(int dvdID, int num) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "update dvd set numberStocks = ? where dvdID = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, num);
            ps.setInt(2, dvdID);

            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DVDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public DVDBean getDVDByID(int id) {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from dvd where dvdID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

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
    public ArrayList<DVDBean> getDVDByDirector(String director) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from dvd where director like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            String temp = "%" + director + "%";
            ps.setString(1, temp);

            DVDBean bean = new DVDBean();
            ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
            int dvdID, dvd_productID;
            String director1, actor, productCompany;

            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
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
            Logger.getLogger(DVDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            String temp = "%" + actor + "%";
            ps.setString(1, temp);

            DVDBean bean = new DVDBean();
            ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
            int dvdID, dvd_productID;
            String director, actor1, productCompany;

            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
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
            Logger.getLogger(DVDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            String temp = "%" + productCompany + "%";
            ps.setString(1, temp);

            DVDBean bean = new DVDBean();
            ArrayList<DVDBean> dvdlist = new ArrayList<DVDBean>();
            int dvdID, dvd_productID;
            String director, actor, productCompany1;

            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
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
            Logger.getLogger(DVDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
