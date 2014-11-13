package DAO.Implementation;

import Beans.AccountBean;
import Beans.AccountingManagerBean;
import Beans.AdminBean;
import Beans.ProductBean;
import Beans.ProductManagerBean;
import DAO.Interface.AdminDAOInterface;
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
 * @author Danica
 */
public class AdminDAOImplementation implements AdminDAOInterface {

    ProductManagerBean prodmngrbean = new ProductManagerBean();
    ProductBean prodbean = new ProductBean();
    int productmanagerID, prodmanager_accountID;
    String prodType;
    int productID;
    String title, type, summary, genre;
    double price;
    int year;
    String query;


    @Override
    public boolean addAdmin(AdminBean admin) {
        try {
            Connector c = new Connector();

            Connection connection = c.getConnection();
            String query = "insert into admin (admin_accountID) values (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, admin.getAdmin_accountID());

            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountingManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public AdminBean getAdminById(int adminID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from admin where adminID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, adminID);

            ResultSet resultSet = ps.executeQuery();

            int id, admin_accountID;

            AdminBean bean = new AdminBean();

            while (resultSet.next()) {
                id = resultSet.getInt("adminID");
                admin_accountID = resultSet.getInt("admin_accountID");

                bean.setAdminID(id);
                bean.setAdmin_accountID(admin_accountID);

                System.out.println("hssere");

            }
            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<AdminBean> getAdminByFullName(String firstname, String lastname) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select adminID, admin_accountID from admin, account "
                    + "where account.firstName = ? and account.lastName = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, firstname);
            ps.setString(2, lastname);

            ResultSet resultSet = ps.executeQuery();

            int id, admin_accountID;

            ArrayList<AdminBean> alist = new ArrayList<AdminBean>();
            AdminBean bean = new AdminBean();

            while (resultSet.next()) {
                id = resultSet.getInt("adminID");
                admin_accountID = resultSet.getInt("admin_accountID");

                bean.setAdminID(id);
                bean.setAdmin_accountID(admin_accountID);

                alist.add(bean);
                System.out.println("hssere");

            }
            connection.close();
            return alist;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public boolean unlockAccount(int AccountID) {
        String query = "UPDATE account SET locked=? WHERE accountID=?";
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setBoolean(1, false);
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOImplementation.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ProductManagerBean getProductManager(int ID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            query = "select * from productmanager where productmanagerID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ID);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                productmanagerID = resultSet.getInt("productmanagerID");
                prodmanager_accountID = resultSet.getInt("prodmanager_accountID");
                prodType = resultSet.getString("prodType");

                prodmngrbean = new ProductManagerBean();

                prodmngrbean.setProdType(prodType);
                prodmngrbean.setProdmanager_accountID(prodmanager_accountID);
                prodmngrbean.setProductmanagerID(productmanagerID);
            }
            connection.close();
            return prodmngrbean;

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOImplementation.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean addProductManager(ProductManagerBean productManager) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into productmanager (prodmanager_accountID, prodType) values (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productManager.getProdmanager_accountID());
            ps.setString(2, productManager.getProdType());
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOImplementation.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void viewActivityLog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<AccountBean> searchUserByFirstName(String firstname) {
        try {
            String temp = "%" + firstname + "%";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "SELECT * from account where firstName like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, temp);
            ResultSet resultSet = ps.executeQuery();
            ArrayList<AccountBean> list = new ArrayList<AccountBean>();
            AccountBean bean = new AccountBean();

            while (resultSet.next()) {
                bean = new AccountBean();
                bean.setAccountID(resultSet.getInt("accountID"));
                bean.setAccountType(resultSet.getString("accounttype"));
                bean.setFirstName(resultSet.getString("firstName"));
                bean.setLastName(resultSet.getString("lastName"));
                bean.setMiddleInitial(resultSet.getString("middleInitial"));
                bean.setUsername(resultSet.getString("username"));
                bean.setPassword(resultSet.getString("password"));
                bean.setEmailAdd(resultSet.getString("emailAdd"));
                list.add(bean);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOImplementation.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public AccountingManagerBean getAccountingManager(int ID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from accountingmanager where accountingmanagerID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ID);

            ResultSet resultSet = ps.executeQuery();

            int accountingManagerID, accountingManager_accountID;

            AccountingManagerBean bean = new AccountingManagerBean();

            while (resultSet.next()) {
                accountingManagerID = resultSet.getInt("accountingmanagerID");
                accountingManager_accountID = resultSet.getInt("accounting_accountID");

                bean.setAccountingManagerID(accountingManagerID);
                bean.setAccountingManager_accountID(accountingManager_accountID);

                System.out.println("hssere");

            }
            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public boolean addAccountingManager(AccountingManagerBean accountingManager) {
        try {
            Connector c = new Connector();

            Connection connection = c.getConnection();
            String query = "insert into accountingmanager (accounting_accountID) values (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountingManager.getAccountingManager_accountID());
            
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountingManagerDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
