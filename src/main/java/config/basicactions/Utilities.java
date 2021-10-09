package config.basicactions;

import java.util.Random;

/**
 * Class to handle Utilities
 *
 * @author saurabhsrivastava
 */
public class Utilities {

    /**
     * Method to generate random string within the specified limit
     *
     * @param limit - the number upto which you want to generate the string
     * @return - the random string
     */
    public static String generateRandomChar(int limit) {
        Random r = new Random();
        String alphabet = "123xyz";
        for (int i = 0; i < limit; i++) {
            alphabet = alphabet + alphabet.charAt(r.nextInt(alphabet.length()));
        }
        return alphabet;
    }
}
