package config.browserdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Class to set up and return the ChromeDriver
 *
 * @author saurabhsrivastava
 */
public class FirefoxBrowser implements Browser {

    /**
     * Method to setup and return the chrome driver
     *
     * @return - the chrome driver
     */
    @Override
    public WebDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
