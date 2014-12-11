
import DAO.Implementation.AccountDAOImplementation;
import Security.Authenticator;
import Process.Hasher;
import Servlet.LoginServlet;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
        try {
            AccountDAOImplementation adao = new AccountDAOImplementation();
            String password = "danica!!";
            Hasher hash = null;
            try {
                hash = new Hasher("MD5");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            hash.updateHash(password, "UTF-8");
            password = hash.getHashBASE64();
            System.out.println(password);
            boolean usercheck;
            usercheck = adao.authenticateUser("danica", password);
            System.out.println(usercheck);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
