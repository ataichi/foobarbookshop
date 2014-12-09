/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class Hasher {

    protected String algorithm;

    protected MessageDigest hashGenerator;

    public Hasher(String algorithm) throws NoSuchAlgorithmException {
        hashGenerator = MessageDigest.getInstance(algorithm);
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public void resetHasher() {
        hashGenerator.reset();
    }

    public void updateHash(String value, String charset) throws UnsupportedEncodingException {
        hashGenerator.update(value.getBytes(charset));
    }

    public String getHashBASE64() {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(hashGenerator.digest());
    }
}
