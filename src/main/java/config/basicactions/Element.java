package config.basicactions;

import config.browserdriver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Class to manage the web elements and perform some basic actions on page
 *
 * @author saurabhsrivastava
 */
public class Element {

    /**
     * get the web driver initialised as a part of before method
     */
    private static WebDriver webDriver = DriverFactory.getDriver();

    /**
     * Method to wait for the element to load before we perform any operation
     *
     * @param cssSelector - the cssSelector for which you want to wait
     * @return - the web element if available
     */
    public static WebElement waitForElement(By cssSelector) {
        return new WebDriverWait(webDriver, 20).until(ExpectedConditions.visibilityOfElementLocated(cssSelector));
    }

    /**
     * Method to Mark the checkbox
     *
     * @param shouldMark - true if you want to mark else false
     * @param webElement - the checkbox webElement
     * @param attribute  - the attribute to check for
     */
    public static void markCheckBox(boolean shouldMark, WebElement webElement, String attribute) {
        if (shouldMark) {
            click(webElement);
            return;
        }
        if (isCheckBoxMarked(attribute, webElement)) {
            click(webElement);
        }
    }

    /**
     * Method to check checkbox is marked
     *
     * @param attribute  - the attribute for which stores the check uncheck value
     * @param webElement - the checkbox web element
     * @return - true if marked else false
     */
    public static boolean isCheckBoxMarked(String attribute, WebElement webElement) {
        return getAttributeValue(attribute, webElement).equals("true");
    }

    /**
     * Method to get the attribute value
     *
     * @param attribute  - the attribute for which you want the value
     * @param webElement - the web element from which you want the value
     * @return - the attribute value
     */
    private static String getAttributeValue(String attribute, WebElement webElement) {
        return webElement.getAttribute(attribute);
    }

    /**
     * Method to click a web element
     *
     * @param webElement - the web element you want to click
     */
    public static void click(WebElement webElement) {
        webElement.click();
    }

    /**
     * Method to enter a text in a input field
     *
     * @param text       - the text you want to enter
     * @param webElement - the web element of the input
     */
    public static void setText(String text, WebElement webElement) {
        webElement.sendKeys(text);
    }

    /**
     * Method to just hover over the web element
     *
     * @param element - the element on which you want to hover
     */
    public static void hover(WebElement element) {
        new Actions(webDriver).moveToElement(element).build().perform();
    }

    /**
     * Method to get the text from a web element
     *
     * @param element - the element from which you want the text
     * @return - the text
     */
    public static String getText(WebElement element) {
        return element.getText();
    }

    /**
     * Method to get all the web elements, if there are multiple with the same css
     *
     * @param cssSelector - the css for which you want to look for
     * @return - list of all web elements
     */
    public static List<WebElement> getAllElements(By cssSelector) {
        return webDriver.findElements(cssSelector);
    }

    /**
     * Method to click one of the items from the list
     *
     * @param cssSelector - the list css
     * @param text        - the text you want to click
     */
    public static void clickOneOfMany(By cssSelector, String text) {
        click(getAllElements(cssSelector).stream()
                .filter(elementText -> elementText.getText().contains(text)).findFirst().get());
    }

    /**
     * Method to click a dropdown and then select one of the many options
     *
     * @param dropDownElement      - the dropdown css
     * @param dropDownItemsElement - the dropdown list css
     * @param valueToBeSelected    - the value which you want to select from the dropdown
     */
    public static void selectDropdownOption(By dropDownElement, By dropDownItemsElement, String valueToBeSelected) {
        click(waitForElement(dropDownElement));
        clickOneOfMany(dropDownItemsElement, valueToBeSelected);
    }
}
