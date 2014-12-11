
import Beans.LogBean;
import DAO.Implementation.AccountDAOImplementation;
import DAO.Implementation.LogDAOImplementation;
import Security.Authenticator;
import Process.Hasher;
import Servlet.LoginServlet;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Danica
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LogBean log = new LogBean();
        LogDAOImplementation logdao = new LogDAOImplementation();
        Timestamp time;
        java.util.Date date = new java.util.Date();
        time = new Timestamp(date.getTime());
        log.setTime(time);
        log.setIp_address("192.168.1.0");
        log.setActivity("login");
        log.setStatus("successful");
        logdao.addLog(log);
    }

}
