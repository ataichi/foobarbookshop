/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Beans.LogBean;
import DAO.Interface.LogDAOInterface;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogDAOImplementation implements LogDAOInterface {

    @Override
    public boolean addLog(LogBean log) {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into logs (log_accountID, activity, time) values (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, log.getLog_accountID());
            ps.setString(2, log.getActivity());
            ps.setTimestamp(3, log.getTime());

            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(LogDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteLog(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LogBean> getAllLogs() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from logs order by time desc";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery(query);

            ArrayList<LogBean> list = new ArrayList<LogBean>();
            LogBean bean = new LogBean();

            int logID, log_accountID;
            String activity;
            Timestamp time;
            while (resultSet.next()) {

                bean = new LogBean();

                logID = resultSet.getInt("logsID");
                log_accountID = resultSet.getInt("log_accountID");
                activity = resultSet.getString("activity");
                time = resultSet.getTimestamp("time");

                bean.setLogID(logID);
                bean.setLog_accountID(log_accountID);

                bean.setActivity(activity);

                bean.setTime(time);

                list.add(bean);

            }
            connection.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(LogDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<LogBean> getAllLogsByAccountID(int accountid) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from logs where log_accountID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accountid);
            ResultSet resultSet = ps.executeQuery(query);

            ArrayList<LogBean> list = new ArrayList<LogBean>();
            LogBean bean = new LogBean();

            int logID, log_accountID;
            String activity;
            Timestamp time;
            while (resultSet.next()) {

                bean = new LogBean();

                logID = resultSet.getInt("logsID");
                log_accountID = resultSet.getInt("log_accountID");
                activity = resultSet.getString("activity");
                time = resultSet.getTimestamp("time");

                bean.setLogID(logID);
                bean.setLog_accountID(log_accountID);

                bean.setActivity(activity);

                bean.setTime(time);

                list.add(bean);

            }
            connection.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(LogDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<LogBean> getAllLogsByActivity(String activity) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from logs where activity like = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            String temp = "%" + activity + "%";
            ps.setString(1, temp);
            ResultSet resultSet = ps.executeQuery(query);

            ArrayList<LogBean> list = new ArrayList<LogBean>();
            LogBean bean = new LogBean();

            int logID, log_accountID;
            String activity1;
            Timestamp time;
            while (resultSet.next()) {

                bean = new LogBean();

                logID = resultSet.getInt("logsID");
                log_accountID = resultSet.getInt("log_accountID");
                activity1 = resultSet.getString("activity");
                time = resultSet.getTimestamp("time");

                bean.setLogID(logID);
                bean.setLog_accountID(log_accountID);

                bean.setActivity(activity1);

                bean.setTime(time);

                list.add(bean);

            }
            connection.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(LogDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<LogBean> getAllLogsToday() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LogBean> getAllLogsByTime(Timestamp from, Timestamp to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
