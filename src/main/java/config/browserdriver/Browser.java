package config.browserdriver;

import org.openqa.selenium.WebDriver;

/**
 * Common interface for all the browsers
 *
 * @author saurabhsrivastava
 */
public interface Browser {
    /**
     * Method to get the driver
     *
     * @return - the web driver
     */
    WebDriver getDriver();
}
