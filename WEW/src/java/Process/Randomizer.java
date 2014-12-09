/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.owasp.esapi.errors.EncryptionException;

public class Randomizer implements org.owasp.esapi.Randomizer {

    private SecureRandom randomGenerator;
    private Random random;

    public Randomizer() {
        try { //generate random number
            randomGenerator = SecureRandom.getInstance("SHA1PRNG");
            randomGenerator.setSeed(13);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Randomizer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getRandomString(int i, char[] chars) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    @Override
    public int getRandomInteger(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getRandomLong() {
        return random.nextLong();
    }

    @Override
    public String getRandomFilename(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getRandomReal(float f, float f1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRandomGUID() throws EncryptionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public byte[] getRandomBytes(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
