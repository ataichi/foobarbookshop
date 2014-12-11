
import Process.Hasher;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Security.Authenticator;
import java.io.UnsupportedEncodingException;
import static java.lang.System.out;
import org.owasp.esapi.errors.EncryptionException;

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
            Authenticator authenticator = new Authenticator();
            String pass1 = "melodymelody";
            String pass2 = "melodymelody";
            try {
                pass1 = (String) authenticator.hashPassword(pass1, pass2);
            } catch (EncryptionException ex) {
                Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            out.println(pass1);
            
            String old="danica!!";
            
            Hasher oldhash = new Hasher("MD5");
            try {
                oldhash.updateHash(old, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
            }
            old = oldhash.getHashBASE64();
            
            out.println(old);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
