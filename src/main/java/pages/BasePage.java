package pages;

import config.basicactions.Element;
import config.browserdriver.DriverFactory;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Base page to handle common page related functionality
 *
 * @author saurabhsrivastava
 */
public abstract class BasePage extends DriverFactory {

    protected String url = "";

    /**
     * Method to get the page loables
     *
     * @return - the page loadables
     */
    protected abstract List<By> getLoadables();

    /**
     * Method to wait for page to load
     */
    public void waitForLoad() {
        getLoadables().forEach(Element::waitForElement);
    }

    /**
     * Method to wait for page to load with custom timeout
     * @param timeOutInSeconds - the time in seconds
     */
    public void waitForLoad(int timeOutInSeconds){
        getLoadables().forEach(by->Element.waitForElementWithCustomTimeOut(by,timeOutInSeconds));
    }

    abstract protected BasePage navigateToPage();

    /**
     * Method to navigate to a particular URL
     *
     * @param url - the URL to which you want to navigate to
     */
    protected void navigateToPage(String url) {
        DriverFactory.getDriver().get(url);
    }

}
