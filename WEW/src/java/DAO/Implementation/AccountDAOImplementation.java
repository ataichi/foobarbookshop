package DAO.Implementation;

import Beans.AccountBean;
import DAO.Interface.AccountDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDAOImplementation implements AccountDAOInterface {

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public boolean addAccount(AccountBean accountBean) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into account (firstName, lastName, middleInitial, username, password, emailAdd, accounttype, locked) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, accountBean.getFirstName());
            ps.setString(2, accountBean.getLastName());
            ps.setString(3, accountBean.getMiddleInitial());
            ps.setString(4, accountBean.getUsername());
            ps.setString(5, accountBean.getPassword());
            ps.setString(6, accountBean.getEmailAdd());
            ps.setString(7, accountBean.getAccountType());
            ps.setBoolean(8, accountBean.getLocked());
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateAccount(AccountBean accountBean) {

        String query = "UPDATE account SET firstName=?, lastName=?, middleInitial=?, username=?, emailAdd=?, accounttype=?, locked=? WHERE accountID=?";
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, accountBean.getFirstName());
            ps.setString(2, accountBean.getLastName());
            ps.setString(3, accountBean.getMiddleInitial());
            ps.setString(4, accountBean.getUsername());
            ps.setString(5, accountBean.getEmailAdd());
            ps.setString(6, accountBean.getAccountType());
            ps.setBoolean(7, accountBean.getLocked());
            ps.setInt(8, accountBean.getAccountID());
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateAccountPassword(AccountBean accountBean) {

        String query = "UPDATE account SET password=? WHERE accountID=?";
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, accountBean.getPassword());
            ps.setInt(2, accountBean.getAccountID());
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public AccountBean getUserByUsername(String username) {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from account where username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);

            ResultSet resultSet = ps.executeQuery();

            String firstName, lastName, middleInitial, uname, password, emailAdd, type;
            int accountID;
            boolean locked;

            AccountBean bean = new AccountBean();

            while (resultSet.next()) {
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                middleInitial = resultSet.getString("middleInitial");
                uname = resultSet.getString("username");
                password = resultSet.getString("password");
                emailAdd = resultSet.getString("emailAdd");
                type = resultSet.getString("accounttype");
                accountID = resultSet.getInt("accountID");
                locked = resultSet.getBoolean("locked");

                bean.setAccountID(accountID);
                bean.setAccountType(type);
                bean.setEmailAdd(emailAdd);
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setMiddleInitial(middleInitial);
                bean.setPassword(password);
                bean.setUsername(uname);
                bean.setLocked(locked);

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
    public boolean doesUserExist(String username, String password) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "SELECT * FROM account WHERE username = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                return true;
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<AccountBean> getAccountByName(String firstname, String lastname) {
        try {
            String query = "select * from account where firstName=? and lastName=?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, firstname);
            ps.setString(2, lastname);

            String firstName, lastName, middleInitial, uname, password, emailAdd, type;
            int accountID;
            boolean locked;

            AccountBean bean = new AccountBean();
            ArrayList<AccountBean> alist = new ArrayList<AccountBean>();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accountID = rs.getInt("accountID");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                middleInitial = rs.getString("middleInitial");
                uname = rs.getString("username");
                password = rs.getString("password");
                emailAdd = rs.getString("emailAdd");
                type = rs.getString("accounttype");
                locked = rs.getBoolean("locked");

                bean = new AccountBean();

                bean.setAccountID(accountID);
                bean.setAccountType(type);
                bean.setEmailAdd(emailAdd);
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setLocked(locked);
                bean.setMiddleInitial(middleInitial);
                bean.setPassword(password);
                bean.setUsername(uname);

                alist.add(bean);
            }
            connection.close();
            return alist;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<AccountBean> getAccountByFirstName(String firstname) {
        try {
            String query = "select * from account where firstName=?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, firstname);

            String firstName, lastName, middleInitial, uname, password, emailAdd, type;
            int accountID;
            boolean locked;

            AccountBean bean = new AccountBean();
            ArrayList<AccountBean> alist = new ArrayList<AccountBean>();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accountID = rs.getInt("accountID");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                middleInitial = rs.getString("middleInitial");
                uname = rs.getString("username");
                password = rs.getString("password");
                emailAdd = rs.getString("emailAdd");
                type = rs.getString("accounttype");
                locked = rs.getBoolean("locked");

                bean = new AccountBean();

                bean.setAccountID(accountID);
                bean.setAccountType(type);
                bean.setEmailAdd(emailAdd);
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setLocked(locked);
                bean.setMiddleInitial(middleInitial);
                bean.setPassword(password);
                bean.setUsername(uname);

                alist.add(bean);
            }

            connection.close();
            return alist;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<AccountBean> getAccountByLastName(String lastname) {
        try {
            String query = "select * from account where lastName=?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, lastname);

            String firstName, lastName, middleInitial, uname, password, emailAdd, type;
            int accountID;
            boolean locked;

            AccountBean bean = new AccountBean();
            ArrayList<AccountBean> alist = new ArrayList<AccountBean>();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accountID = rs.getInt("accountID");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                middleInitial = rs.getString("middleInitial");
                uname = rs.getString("username");
                password = rs.getString("password");
                emailAdd = rs.getString("emailAdd");
                type = rs.getString("accounttype");
                locked = rs.getBoolean("locked");

                bean = new AccountBean();

                bean.setAccountID(accountID);
                bean.setAccountType(type);
                bean.setEmailAdd(emailAdd);
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setLocked(locked);
                bean.setMiddleInitial(middleInitial);
                bean.setPassword(password);
                bean.setUsername(uname);

                alist.add(bean);
            }

            connection.close();
            return alist;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<AccountBean> getAllAccounts() {
        try {
            String query = "select * from account";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);

            String firstName, lastName, middleInitial, uname, password, emailAdd, type;
            int accountID;
            boolean locked;

            AccountBean bean = new AccountBean();
            ArrayList<AccountBean> alist = new ArrayList<AccountBean>();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accountID = rs.getInt("accountID");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                middleInitial = rs.getString("middleInitial");
                uname = rs.getString("username");
                password = rs.getString("password");
                emailAdd = rs.getString("emailAdd");
                type = rs.getString("accounttype");
                locked = rs.getBoolean("locked");

                bean = new AccountBean();

                bean.setAccountID(accountID);
                bean.setAccountType(type);
                bean.setEmailAdd(emailAdd);
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setLocked(locked);
                bean.setMiddleInitial(middleInitial);
                bean.setPassword(password);
                bean.setUsername(uname);

                alist.add(bean);
            }

            connection.close();
            return alist;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean lockAccount(AccountBean accountBean) {
        try {
            String query = "update account set locked=? where accountID=?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setBoolean(1, true);
            ps.setInt(2, accountBean.getAccountID());
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteAccount(int accountID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "delete from account where accountID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<AccountBean> getAllLockedAccounts() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from account where locked = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setBoolean(1, true);

            ResultSet resultSet = ps.executeQuery();

            String firstName, lastName, middleInitial, uname, password, emailAdd, type;
            int accountID;
            boolean locked;

            ArrayList<AccountBean> alist = new ArrayList<AccountBean>();
            AccountBean bean = new AccountBean();

            while (resultSet.next()) {
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                middleInitial = resultSet.getString("middleInitial");
                uname = resultSet.getString("username");
                password = resultSet.getString("password");
                emailAdd = resultSet.getString("emailAdd");
                type = resultSet.getString("accounttype");
                accountID = resultSet.getInt("accountID");
                locked = resultSet.getBoolean("locked");

                bean = new AccountBean();

                bean.setAccountID(accountID);
                bean.setAccountType(type);
                bean.setEmailAdd(emailAdd);
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setMiddleInitial(middleInitial);
                bean.setPassword(password);
                bean.setUsername(uname);
                bean.setLocked(locked);

                alist.add(bean);
            }
            connection.close();
            return alist;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void insertLog(String ip, String description, boolean success) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps;

            int i = 1;
            if (success) {
                ps = connection.prepareStatement("INSERT INTO success_logs (ip_address, description) VALUES(?,?)");
            } else {
                ps = connection.prepareStatement("INSERT INTO error_logs (ip_address, description) VALUES(?,?)");
            }

            ps.setString(i++, ip);
            ps.setString(i++, description);
            ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    //prevents XSS and SQL Injection
    public static String inputSanitizer(String input) {
        String filtered = input.replaceAll("(?i)<script.*?>.*?</script.*?>", ""); // remove <script>  
        filtered = filtered.replaceAll("(?i)<.*?javascript:.*?>.*?</.*?>", ""); // remove javascript calls
        filtered = filtered.replaceAll("(?i)<.*?\\s+on.*?>.*?</.*?>", ""); //remove onLoad or onClick 
        filtered = filtered.replaceAll("--", ""); //remove comments in SQL

        filtered = filtered.replaceAll("([^A-Za-z0-9@. ]+)", "");
        return filtered;
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        boolean found = false;
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from account where username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);

            ResultSet resultSet = ps.executeQuery();

            String compare;

            while (resultSet.next()) {
                compare = resultSet.getString("username");
                found=true;

            }
            connection.close();
            return found;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return found;

    }

    @Override
    public boolean changePassword(int accountID, String password) {
         try {
            String query = "update account set password=? where accountID=?";
            Connector c = new Connector();
            Connection connection = c.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, password);
            ps.setInt(2, accountID);
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   }

    @Override
    public AccountBean getUserByAccountID(int accountID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from account where accountID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);

            ResultSet resultSet = ps.executeQuery();

            String firstName, lastName, middleInitial, uname, password, emailAdd, type;
            boolean locked;

            AccountBean bean = new AccountBean();

            while (resultSet.next()) {
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                middleInitial = resultSet.getString("middleInitial");
                uname = resultSet.getString("username");
                password = resultSet.getString("password");
                emailAdd = resultSet.getString("emailAdd");
                type = resultSet.getString("accounttype");
                accountID = resultSet.getInt("accountID");
                locked = resultSet.getBoolean("locked");

                bean.setAccountID(accountID);
                bean.setAccountType(type);
                bean.setEmailAdd(emailAdd);
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setMiddleInitial(middleInitial);
                bean.setPassword(password);
                bean.setUsername(uname);
                bean.setLocked(locked);


            }
            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
