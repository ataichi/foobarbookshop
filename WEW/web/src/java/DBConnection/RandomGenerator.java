package DBConnection;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomGenerator {

    protected SecureRandom randomGen;
    Random random = new Random();

    public RandomGenerator() throws NoSuchAlgorithmException {
        randomGen = SecureRandom.getInstance("SHA1PRNG");
        randomGen.setSeed(1234);
    }
    
    public long getRandomLong() {
        return random.nextLong();
    }
}
