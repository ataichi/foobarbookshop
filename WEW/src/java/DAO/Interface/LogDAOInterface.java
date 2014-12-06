/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Interface;

import Beans.LogBean;
import java.sql.Timestamp;
import java.util.ArrayList;

public interface LogDAOInterface {
    
    public boolean addLog(LogBean log);
    public boolean deleteLog(int id);
    
    public ArrayList<LogBean> getAllLogs();
    public ArrayList<LogBean> getAllLogsByAccountID(int accountid);
    public ArrayList<LogBean> getAllLogsByActivity(String activity);
    
    public ArrayList<LogBean> getAllLogsToday();
    public ArrayList<LogBean> getAllLogsByTime(Timestamp from, Timestamp to);
    
    
}
