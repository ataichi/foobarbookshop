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
            int magazineID, magazine_accountID, volumeNo, issueNo;
            String publisher;
            java.sql.Date datePublished;
            while (resultSet.next()) {
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
    public boolean deleteMagazine(int id) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "delete from magazine where magazine_productID=?";
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
