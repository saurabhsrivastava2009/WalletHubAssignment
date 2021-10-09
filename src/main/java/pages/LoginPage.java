package pages;

import config.basicactions.Element;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

/**
 * Page class for Login Page
 *
 * @author saurabhsrivastava
 */
public class LoginPage extends BasePage {

    /**
     * Page level css selectors
     */
    private By emailIDBy = By.cssSelector("[name=\"em\"]");
    private By passwordBy = By.cssSelector("[name=\"pw\"]");
    private By loginBy = By.cssSelector(".btn.blue");

    /**
     * Method to add the page loadables
     *
     * @return - the list of page loadables
     */
    @Override
    List<By> getLoadables() {
        return Arrays.asList(emailIDBy, passwordBy, loginBy);
    }

    /**
     * Method to navigate to {@link LoginPage}
     *
     * @return - {@link LoginPage} for chaining
     */
    @Override
    public LoginPage navigateToPage() {
        this.url = "https://wallethub.com/join/login";
        this.navigateToPage(url);
        waitForLoad();
        return this;
    }

    /**
     * Method to login to the Wallet hub
     *
     * @param email     - your email
     * @param password  - your password
     * @param profileID - your profile ID
     * @return - {@link ProfilePage}
     */
    public ProfilePage login(String email, String password, String profileID) {
        Element.setText(email, Element.waitForElement(emailIDBy));
        Element.setText(password, Element.waitForElement(passwordBy));
        Element.click(Element.waitForElement(loginBy));
        ProfilePage profilePage = new ProfilePage(profileID);
        profilePage.waitForLoad();
        return profilePage;
    }
}
