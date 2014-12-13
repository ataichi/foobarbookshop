import Beans.AccountBean;
import Beans.CustomerBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.CustomerDAOImplementation;
import DAO.Interface.AccountDAOInterface;
import DAO.Interface.CustomerDAOInterface;

public class NewMain1 {

    public static void main(String[] args) {
        AccountDAOInterface adao = new AccountDAOImplementation();
        AccountBean bean = new AccountBean();
        bean.setFirstName("Jurdan");
        bean.setLastName("Tsua");
        bean.setMiddleInitial("L");
        bean.setUsername("JJ");
        bean.setPassword("Jordan1!");
        bean.setEmailAdd("j@gmail.com");
        bean.setAccountType("Admin");
        bean.setFailedLoginCount(0);
        bean.setLocked(false);
        adao.addAccount(bean);
        CustomerDAOInterface cdao = new CustomerDAOImplementation();
        CustomerBean cbean = new CustomerBean();
        cbean.setBA("WAHAHAHAHAH KAHIT SAAN");
        cbean.setDA("SA HINDI KAHIT SAAN");
        int customer_accountID = adao.getUserByUsername(bean.getUsername()).getAccountID();
        cbean.setCustomer_accountID(customer_accountID);
        cdao.addCustomer(cbean);
        // TODO code application logic here
    }

}
