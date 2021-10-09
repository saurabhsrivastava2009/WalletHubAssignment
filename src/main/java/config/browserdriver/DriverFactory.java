package config.browserdriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Class used to set up the web driver
 *
 * @author saurabhsrivastava
 */
public class DriverFactory {

    private static WebDriver driver;

    /**
     * Method to setup up the driver before the execution starts
     */
    @BeforeClass
    public void setDriver() {
        driver = identifyBrowser(System.getProperty("browser")).getDriver();
    }

    /**
     * Method to identify the browser and return the browser specific object
     *
     * @param browser - the browser for which you want the driver
     * @return - the browser object
     */
    private static Browser identifyBrowser(String browser) {
        if (!browser.isEmpty()) {
            try {
                return (Browser) Class.forName("config.browserdriver." + browser + "Browser").newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("Browser not provided");
    }

    /**
     * Method to get the current driver.
     *
     * @return - the current initialised driver
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Method to quit the driver session once the test case is over.
     */
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
