/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

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

public class CreditCardDAOImplementation implements CreditCardDAOInterface {

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
            ps.setString(4, creditCard.getCardexpdate());

            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CreditCardDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editCreditCard(CreditCardBean creditCard) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "update creditcard set cardName = ?, cardNo = ?, cardType = ?, cardExpDate = ? where creditCardID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, creditCard.getCardname());
            ps.setString(2, creditCard.getCardno());
            ps.setString(3, creditCard.getCardtype());
            ps.setString(4, creditCard.getCardexpdate());
            ps.setInt(5, creditCard.getCreditcardID());

            ps.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CreditCardDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CreditCardDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            String cardName1, cardNo, cardType, cardExpDate;
            while (resultSet.next()) {

                creditcardID = resultSet.getInt("creditcardID");
                cardName1 = resultSet.getString("cardName");
                cardNo = resultSet.getString("cardNo");
                cardType = resultSet.getString("cardType");
                cardExpDate = resultSet.getString("cardExpDate");

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
            Logger.getLogger(CreditCardDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            String cardName, cardNo1, cardType, cardExpDate;
            while (resultSet.next()) {

                creditcardID = resultSet.getInt("creditcardID");
                cardName = resultSet.getString("cardName");
                cardNo1 = resultSet.getString("cardNo");
                cardType = resultSet.getString("cardType");
                cardExpDate = resultSet.getString("cardExpDate");

                bean.setCardexpdate(cardExpDate);
                bean.setCardname(cardName);
                bean.setCardno(cardNo);
                bean.setCardtype(cardType);
                bean.setCreditcardID(creditcardID);

            }

            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(CreditCardDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            String cardName, cardNo, cardType1, cardExpDate;
            while (resultSet.next()) {

                creditcardID = resultSet.getInt("creditcardID");
                cardName = resultSet.getString("cardName");
                cardNo = resultSet.getString("cardNo");
                cardType1 = resultSet.getString("cardType");
                cardExpDate = resultSet.getString("cardExpDate");

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getUserCreditCard(int customerID) {
        int creditcardID = 0;

        try {
            String query = "select customercreditcard_creditcardID from customercreditcard where customercreditcard_customerID = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, customerID);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                creditcardID = resultSet.getInt("customercreditcard_creditcardID");
            }

            connection.close();
            return creditcardID;

        } catch (SQLException ex) {
            Logger.getLogger(AudioCDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return creditcardID;
    }

    @Override
    public CreditCardBean getLastCreditCard() {
        try {
            String query = "select * from creditcard order by creditcardID desc limit 1";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet resultSet = ps.executeQuery();

            CreditCardBean bean = new CreditCardBean();
            int creditcardID;
            String cardName, cardNo, cardType, cardExpDate;
            while (resultSet.next()) {

                creditcardID = resultSet.getInt("creditcardID");
                cardName = resultSet.getString("cardName");
                cardNo = resultSet.getString("cardNo");
                cardType = resultSet.getString("cardType");
                cardExpDate = resultSet.getString("cardExpDate");

                bean.setCardexpdate(cardExpDate);
                bean.setCardname(cardName);
                bean.setCardno(cardNo);
                bean.setCardtype(cardType);
                bean.setCreditcardID(creditcardID);

            }

            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(CreditCardDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public CreditCardBean getCreditCardByCreditCardID(int creditcardID) {
        try {
            String query = "select * from creditcard where creditcardID = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, creditcardID);

            ResultSet resultSet = ps.executeQuery();

            CreditCardBean bean = new CreditCardBean();
            int creditcardID1;
            String cardName, cardNo, cardType, cardExpDate;
            while (resultSet.next()) {

                creditcardID1 = resultSet.getInt("creditcardID");
                cardName = resultSet.getString("cardName");
                cardNo = resultSet.getString("cardNo");
                cardType = resultSet.getString("cardType");
                cardExpDate = resultSet.getString("cardExpDate");

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

}
