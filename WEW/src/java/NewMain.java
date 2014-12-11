
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
        try {
            String old = "ruth!!";
            String new1 = "danica!!!";
            String new2 = "danica!!!";
            
            Hasher oldhash = new Hasher("MD5");
            try {
                oldhash.updateHash(old, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
            }
            old = oldhash.getHashBASE64();
            
            Hasher new1hash = new Hasher("MD5");
            try {
                new1hash.updateHash(new1, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
            }
            new1 = new1hash.getHashBASE64();
            
            Hasher new2hash = new Hasher("MD5");
            try {
                new2hash.updateHash(new2, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
            }
            new2 = new2hash.getHashBASE64();
            
            System.out.println(old);
            System.out.println(new1);
            System.out.println(new2);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
