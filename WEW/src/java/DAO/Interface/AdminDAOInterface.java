package DAO.Interface;

import Beans.AccountBean;
import Beans.AdminBean;
import Beans.ProductManagerBean;
import Beans.AccountingManagerBean;
import Beans.ProductBean;
import java.util.ArrayList;

public interface AdminDAOInterface {
    public boolean addAdmin(AdminBean admin);
    public AdminBean getAdminById(int adminID);
    public ArrayList<AdminBean> getAdminByFullName(String firstname, String lastname);
    
    //Create Product Manager
    public ProductManagerBean getProductManager (int ID);
    public boolean addProductManager(ProductManagerBean productManager);
    
    //Create Accounting Manager
    public AccountingManagerBean getAccountingManager(int ID);
    public boolean addAccountingManager(AccountingManagerBean bean);

    public boolean unlockAccount (int AccountID);
    public void viewActivityLog(); //Log bean :(
//    public void viewActivityProductManager (ProductManagerBean manager);
//    public void viewActivityAccountingManager (AccountingManagerBean manager);
    public ArrayList<AccountBean> searchUserByFirstName(String firstname);
    
}
