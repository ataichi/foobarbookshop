package DAO.Implementation;

import Beans.AudioCDBean;
import Beans.CustomerBean;
import Beans.ProductBean;
import DAO.Interface.CustomerDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAOImplementation implements CustomerDAOInterface {

    @Override
    public boolean addCustomer(CustomerBean customerBean) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into customer (apartmentnoBA, streetBA, subdivisionBA, cityBA, postalcodeBA, countryBA,"
                    + " apartmentnoDA, streetDA, subdivisionDA, cityDA, postalcodeDA, countryDA, customer_accountID) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customerBean.getApartmentNoBA());
            ps.setString(2, customerBean.getStreetBA());
            ps.setString(3, customerBean.getSubdivisionBA());
            ps.setString(4, customerBean.getCityBA());
            ps.setInt(5, customerBean.getPostalCodeBA());
            ps.setString(6, customerBean.getCountryBA());

            ps.setString(7, customerBean.getApartmentNoBA());
            ps.setString(8, customerBean.getStreetBA());
            ps.setString(9, customerBean.getSubdivisionBA());
            ps.setString(10, customerBean.getCityBA());
            ps.setInt(11, customerBean.getPostalCodeBA());
            ps.setString(12, customerBean.getCountryBA());
            ps.setInt(13, customerBean.getCustomer_accountID());
            ps.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public CustomerBean getCustomerById(int customerID) {
        try {
            String query = "select * from customer where customerID = ?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, customerID);

            ResultSet rs = ps.executeQuery();

            CustomerBean bean = new CustomerBean();
            int customerID1, customer_accountID;
            String streetBA, subdivisionBA, cityBA, countryBA;
            int apartmentnoBA, postalcodeBA;

            String streetDA, subdivisionDA, cityDA, countryDA;
            int apartmentnoDA, postalcodeDA;

            while (rs.next()) {
                streetBA = rs.getString("streetBA");
                subdivisionBA = rs.getString("subdivisionBA");
                cityBA = rs.getString("cityBA");
                countryBA = rs.getString("countryBA");
                apartmentnoBA = rs.getInt("apartmentnoBA");
                postalcodeBA = rs.getInt("postalcodeBA");

                streetDA = rs.getString("streetDA");
                subdivisionDA = rs.getString("subdivsionDA");
                cityDA = rs.getString("cityDA");
                countryDA = rs.getString("countryDA");
                apartmentnoDA = rs.getInt("apartmentnoDA");
                postalcodeDA = rs.getInt("postalcodeDA");

                customer_accountID = rs.getInt("customerID");
                customerID1 = rs.getInt("customerID");

                bean = new CustomerBean();

                bean.setApartmentNoBA(streetBA);
                bean.setCityBA(cityBA);
                bean.setCountryBA(countryBA);
                bean.setPostalCodeBA(postalcodeBA);
                bean.setStreetBA(streetBA);
                bean.setSubdivisionBA(subdivisionBA);

                bean.setCityDA(cityDA);
                bean.setCountryDA(countryDA);
                bean.setPostalCodeDA(postalcodeDA);
                bean.setStreetDA(streetDA);
                bean.setSubdivisionDA(subdivisionDA);

                bean.setCustomer_accountID(customer_accountID);
                bean.setCustomerID(customerID1);

            }

            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<CustomerBean> getAllCustomers() {
        try {
            String query = "select * from customer";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            CustomerBean bean = new CustomerBean();
            ArrayList<CustomerBean> clist = new ArrayList<CustomerBean>();

            int customerID, customer_accountID;
            String streetBA, subdivisionBA, cityBA, countryBA;
            int apartmentnoBA, postalcodeBA;

            String streetDA, subdivisionDA, cityDA, countryDA;
            int apartmentnoDA, postalcodeDA;

            while (rs.next()) {
                streetBA = rs.getString("streetBA");
                subdivisionBA = rs.getString("subdivisionBA");
                cityBA = rs.getString("cityBA");
                countryBA = rs.getString("countryBA");
                apartmentnoBA = rs.getInt("apartmentnoBA");
                postalcodeBA = rs.getInt("postalcodeBA");

                streetDA = rs.getString("streetDA");
                subdivisionDA = rs.getString("subdivsionDA");
                cityDA = rs.getString("cityDA");
                countryDA = rs.getString("countryDA");
                apartmentnoDA = rs.getInt("apartmentnoDA");
                postalcodeDA = rs.getInt("postalcodeDA");

                customer_accountID = rs.getInt("customerID");
                customerID = rs.getInt("customerID");

                bean = new CustomerBean();

                bean.setApartmentNoBA(streetBA);
                bean.setCityBA(cityBA);
                bean.setCountryBA(countryBA);
                bean.setPostalCodeBA(postalcodeBA);
                bean.setStreetBA(streetBA);
                bean.setSubdivisionBA(subdivisionBA);

                bean.setCityDA(cityDA);
                bean.setCountryDA(countryDA);
                bean.setPostalCodeDA(postalcodeDA);
                bean.setStreetDA(streetDA);
                bean.setSubdivisionDA(subdivisionDA);

                bean.setCustomer_accountID(customer_accountID);
                bean.setCustomerID(customerID);

                clist.add(bean);

            }

            connection.close();
            return clist;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean addToCart(ProductBean product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeFromCart(ProductBean product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductBean> viewCart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean purchase(int productID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductBean viewProduct(int ProductID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductBean searchProduct(int ProductID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AudioCDManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CustomerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
