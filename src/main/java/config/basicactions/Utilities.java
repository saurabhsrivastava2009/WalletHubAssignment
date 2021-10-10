package config.basicactions;

import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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

    /**
     * Custom sleep
     * @param timeOutInSeconds - time in seconds
     */
    public static void customSleep(int timeOutInSeconds){
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(new Duration(timeOutInSeconds, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
