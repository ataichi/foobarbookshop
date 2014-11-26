package DAO.Interface;

import Beans.AccountBean;
import Beans.AdminBean;
import Beans.ProductBean;
import java.util.ArrayList;

public interface AdminDAOInterface {
    public boolean addAdmin(AdminBean admin);
    public AdminBean getAdminById(int adminID);
    public ArrayList<AdminBean> getAdminByFullName(String firstname, String lastname);
    
    public boolean unlockAccount (int AccountID);
    public void viewActivityLog(); //Log bean :(
    public ArrayList<AccountBean> searchUserByFirstName(String firstname);
    
}
