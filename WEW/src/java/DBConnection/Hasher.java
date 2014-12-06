package DBConnection;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;


public class Hasher {
    private String algorithm;
    private MessageDigest hashGen;
    
    public Hasher(String algorithm) throws NoSuchAlgorithmException {
        hashGen = MessageDigest.getInstance("MD5");
        
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
    
    public void updateHash(String value,String charset) throws UnsupportedEncodingException {
        hashGen.update(value.getBytes(charset));
    }
    
    public String getHashBASE64() {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(hashGen.digest());
    }
    
    public void resetHasher(){
        hashGen.reset();
    }
    
}
