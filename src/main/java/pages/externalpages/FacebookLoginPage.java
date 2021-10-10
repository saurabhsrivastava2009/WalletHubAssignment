package pages.externalpages;

import config.basicactions.Element;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.Arrays;
import java.util.List;

/**
 * External facebook login page
 *
 * @author saurabhsrivastava
 */
public class FacebookLoginPage extends BasePage {

    /**
     * local locators
     */
    private By emailBy = By.id("email");
    private By passwordBy = By.id("pass");
    private By loginBy = By.name("login");


    /**
     * Adding loadables for {@link FacebookLoginPage}
     *
     * @return list of loadables
     */
    @Override
    protected List<By> getLoadables() {
        return Arrays.asList(emailBy, passwordBy, loginBy);
    }

    /**
     * Method to navigate to {@link FacebookLoginPage}
     *
     * @return {@link FacebookLoginPage}
     */
    @Override
    public FacebookLoginPage navigateToPage() {
        this.url = "https://en-gb.facebook.com/";
        this.navigateToPage(url);
        waitForLoad(40);
        return this;
    }

    /**
     * Method to login to facebook
     *
     * @param email    - the user's email
     * @param password - the user's password
     * @return - user's {@link FacebookHomePage}
     */
    public FacebookHomePage login(String email, String password) {
        Element.setText(email, Element.waitForElement(emailBy));
        Element.setText(password, Element.waitForElement(passwordBy));
        Element.click(Element.waitForElement(loginBy));
        FacebookHomePage facebookHomePage = new FacebookHomePage();
        facebookHomePage.navigateToPage().waitForLoad(40);
        return facebookHomePage;
    }
}
