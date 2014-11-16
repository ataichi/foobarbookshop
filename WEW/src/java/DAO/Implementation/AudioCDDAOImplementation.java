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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giodee
 */
public class AudioCDDAOImplementation implements AudioCDDAOInterface {

    @Override
    public boolean addAudioCD(AudioCDBean audioCD) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into audiocd (artist, recordCompany, audiocd_productID) values (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, audioCD.getArtist());
            ps.setString(2, audioCD.getRecordCompany());
            ps.setInt(3, audioCD.getAudiocd_productID());
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AudioCDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public AudioCDBean getAudioCDByProductId(int ID) {
        try {
            String query = "select * from audiocd where audiocd_productID = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ID);

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
            Logger.getLogger(AudioCDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean deleteaudioCD(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "delete from audiocd where audiocd_productID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}
