/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Interface;

import Beans.LockReportBean;
import java.util.ArrayList;

public interface LockReportDAOInterface {
    
    public boolean addLockReport();
    public ArrayList<LockReportBean> getLockReportByAccountID(int id);
    public ArrayList<LockReportBean> getLockReportByReason(String reason);
    public ArrayList<LockReportBean> getAllLockReport(); 
    
}
