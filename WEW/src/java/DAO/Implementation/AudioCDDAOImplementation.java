/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.AudioCDBean;
import DAO.Interface.AudioCDDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AudioCDDAOImplementation implements AudioCDDAOInterface {

    @Override
    public AudioCDBean getAudioCDByID(int id) {
        try {
            String query = "select * from audiocd where audiocdID = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            AudioCDBean bean = new AudioCDBean();
            int audiocdID, audiocd_productID;
            String artist, recordCompany;
            while (rs.next()) {

                audiocdID = rs.getInt("audiocdID");
                artist = rs.getString("artist");
                recordCompany = rs.getString("recordCompany");
                audiocd_productID = rs.getInt("audio_productID");

                bean.setArtist(artist);
                bean.setAudiocdID(audiocdID);
                bean.setAudiocd_productID(audiocd_productID);
                bean.setRecordCompany(recordCompany);

            }

            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(AudioCDDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public AudioCDBean getAudioCDByProductID(int productID) {
        try {
            String query = "select * from audiocd where audiocd_productID = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productID);

            ResultSet rs = ps.executeQuery();
            int audiocdID, audiocd_productID;
            String artist, recordCompany;
            AudioCDBean bean = new AudioCDBean();
            while (rs.next()) {
                audiocdID = rs.getInt("audiocdID");
                artist = rs.getString("artist");
                recordCompany = rs.getString("recordCompany");
                audiocd_productID = rs.getInt("audiocd_productID");

                bean.setArtist(artist);
                bean.setAudiocdID(audiocdID);
                bean.setAudiocd_productID(audiocd_productID);
                bean.setRecordCompany(recordCompany);

            }

            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(AudioCDDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public ArrayList<AudioCDBean> getAudioCDByArtist(String artist) {
        try {
            String query = "select * from audiocd where artist = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + artist + "%");

            ResultSet rs = ps.executeQuery();
            AudioCDBean bean = new AudioCDBean();
            ArrayList<AudioCDBean> audiocdlist = new ArrayList<AudioCDBean>();
            int audiocdID, audiocd_productID;
            String artist1, recordCompany;

            while (rs.next()) {

                bean = new AudioCDBean();

                audiocdID = rs.getInt("audiocdID");
                artist1 = rs.getString("artist");
                recordCompany = rs.getString("recordCompany");
                audiocd_productID = rs.getInt("audio_productID");

                bean.setArtist(artist1);
                bean.setAudiocdID(audiocdID);
                bean.setAudiocd_productID(audiocd_productID);
                bean.setRecordCompany(recordCompany);

                audiocdlist.add(bean);
            }

            connection.close();
            return audiocdlist;

        } catch (SQLException ex) {
            Logger.getLogger(AudioCDDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ArrayList<AudioCDBean> getAudioCDByRecordCompany(String recordCompany) {
        try {
            String query = "select * from audiocd where artist = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + recordCompany + "%");

            ResultSet rs = ps.executeQuery();
            AudioCDBean bean = new AudioCDBean();
            ArrayList<AudioCDBean> audiocdlist = new ArrayList<AudioCDBean>();
            int audiocdID, audiocd_productID;
            String artist, recordCompany1;

            while (rs.next()) {

                bean = new AudioCDBean();

                audiocdID = rs.getInt("audiocdID");
                artist = rs.getString("artist");
                recordCompany1 = rs.getString("recordCompany");
                audiocd_productID = rs.getInt("audio_productID");

                bean.setArtist(artist);
                bean.setAudiocdID(audiocdID);
                bean.setAudiocd_productID(audiocd_productID);
                bean.setRecordCompany(recordCompany1);

                audiocdlist.add(bean);
            }

            connection.close();
            return audiocdlist;

        } catch (SQLException ex) {
            Logger.getLogger(AudioCDDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
