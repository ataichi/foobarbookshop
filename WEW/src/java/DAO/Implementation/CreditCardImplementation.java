/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.AudioCDBean;
import Beans.CreditCardBean;
import DAO.Interface.CreditCardDAOInterface;
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
public class CreditCardImplementation implements CreditCardDAOInterface {

    @Override
    public boolean addCreditCard(CreditCardBean creditCard) {
        try {
            Connector c = new Connector();

            Connection connection = c.getConnection();
            String query = "insert into creditcard (cardName, cardNo, cardType, cardExpDate) values (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, creditCard.getCardname());
            ps.setString(2, creditCard.getCardno());
            ps.setString(3, creditCard.getCardtype());
            ps.setDate(4, creditCard.getCardexpdate());

            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountingManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editCreditCard(CreditCardBean creditCard) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "update creditcard set cardName = ?, cardNo = ?, cardType = ?, cardExptDate = ? where creditCardID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, creditCard.getCardname());
            ps.setString(2, creditCard.getCardno());
            ps.setString(3, creditCard.getCardtype());
            ps.setDate(4, creditCard.getCardexpdate());

            ps.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AudioCDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean deleteCreditCard(int creditCardID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "delete from creditcard where creditcardID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, creditCardID);
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AudioCDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<CreditCardBean> getCreditCardByCardName(String cardName) {
        try {
            String query = "select * from creditcard where cardName = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cardName);

            ResultSet resultSet = ps.executeQuery();

            ArrayList<CreditCardBean> clist = new ArrayList<CreditCardBean>();
            CreditCardBean bean = new CreditCardBean();
            int creditcardID;
            String cardName1, cardNo, cardType;
            Date cardExpDate;
            while (resultSet.next()) {

                creditcardID = resultSet.getInt("creditcardID");
                cardName1 = resultSet.getString("cardName");
                cardNo = resultSet.getString("cardNo");
                cardType = resultSet.getString("cardType");
                cardExpDate = resultSet.getDate("cardExpDate");

                bean.setCardexpdate(cardExpDate);
                bean.setCardname(cardName);
                bean.setCardno(cardNo);
                bean.setCardtype(cardType);
                bean.setCreditcardID(creditcardID);

                clist.add(bean);

            }

            connection.close();
            return clist;

        } catch (SQLException ex) {
            Logger.getLogger(AudioCDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public CreditCardBean getCreditCardByCardNo(String cardNo) {
        try {
            String query = "select * from creditcard where cardNo = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cardNo);

            ResultSet resultSet = ps.executeQuery();

            CreditCardBean bean = new CreditCardBean();
            int creditcardID;
            String cardName, cardNo1, cardType;
            Date cardExpDate;
            while (resultSet.next()) {

                creditcardID = resultSet.getInt("creditcardID");
                cardName = resultSet.getString("cardName");
                cardNo1 = resultSet.getString("cardNo");
                cardType = resultSet.getString("cardType");
                cardExpDate = resultSet.getDate("cardExpDate");

                bean.setCardexpdate(cardExpDate);
                bean.setCardname(cardName);
                bean.setCardno(cardNo);
                bean.setCardtype(cardType);
                bean.setCreditcardID(creditcardID);

            }

            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(AudioCDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ArrayList<CreditCardBean> getCreditCardByCardType(String cardType) {
        try {
            String query = "select * from creditcard where cardType = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cardType);

            ResultSet resultSet = ps.executeQuery();

            ArrayList<CreditCardBean> clist = new ArrayList<CreditCardBean>();
            CreditCardBean bean = new CreditCardBean();
            int creditcardID;
            String cardName, cardNo, cardType1;
            Date cardExpDate;
            while (resultSet.next()) {

                creditcardID = resultSet.getInt("creditcardID");
                cardName = resultSet.getString("cardName");
                cardNo = resultSet.getString("cardNo");
                cardType1 = resultSet.getString("cardType");
                cardExpDate = resultSet.getDate("cardExpDate");

                bean.setCardexpdate(cardExpDate);
                bean.setCardname(cardName);
                bean.setCardno(cardNo);
                bean.setCardtype(cardType);
                bean.setCreditcardID(creditcardID);

                clist.add(bean);

            }

            connection.close();
            return clist;

        } catch (SQLException ex) {
            Logger.getLogger(AudioCDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ArrayList<CreditCardBean> getCreditCardByExpDate(Date from, Date to) {
        try {
            String query = "select * from creditcard where cardExpDate between ? and ? ";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, from);
            ps.setDate(2, to);

            ResultSet resultSet = ps.executeQuery();

            ArrayList<CreditCardBean> clist = new ArrayList<CreditCardBean>();
            CreditCardBean bean = new CreditCardBean();
            int creditcardID;
            String cardName, cardNo, cardType;
            Date cardExpDate;
            while (resultSet.next()) {

                creditcardID = resultSet.getInt("creditcardID");
                cardName = resultSet.getString("cardName");
                cardNo = resultSet.getString("cardNo");
                cardType = resultSet.getString("cardType");
                cardExpDate = resultSet.getDate("cardExpDate");

                bean.setCardexpdate(cardExpDate);
                bean.setCardname(cardName);
                bean.setCardno(cardNo);
                bean.setCardtype(cardType);
                bean.setCreditcardID(creditcardID);

                clist.add(bean);

            }

            connection.close();
            return clist;

        } catch (SQLException ex) {
            Logger.getLogger(AudioCDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ArrayList<CreditCardBean> getUserCreditCard(int customerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
