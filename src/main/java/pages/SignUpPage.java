package pages;

import config.basicactions.Element;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

/**
 * Page Class to handle login related operations
 *
 * @author saurabhsrivastava
 */
public class SignUpPage extends BasePage {

    /**
     * Page css selectors and local variables
     */
    private By emailBy = By.cssSelector("[name=\"em\"]");
    private By passwordBy = By.cssSelector("[name=\"pw1\"]");
    private By confirmPasswordBy = By.cssSelector("[name=\"pw2\"]");
    private By getCreditScoreBy = By.cssSelector("[aria-labelledby=\"get-my-report\"]");
    private By joinButtonBy = By.cssSelector(".btns .blue");
    private By successDescriptionBy = By.cssSelector(".h1-heading");

    /**
     * Method to add the page loadables
     *
     * @return - the list of page loadables
     */
    @Override
    List<By> getLoadables() {
        return Arrays.asList(emailBy, passwordBy, confirmPasswordBy);
    }

    /**
     * Method to navigate to {@link SignUpPage}
     *
     * @return - {@link SignUpPage} for chaining
     */
    @Override
    public SignUpPage navigateToPage() {
        this.url = "https://wallethub.com/join/light";
        this.navigateToPage(url);
        waitForLoad();
        return this;
    }

    /**
     * Method to sing up using the following values
     *
     * @param email           - your email
     * @param password        - password of your choice
     * @param confirmPassword - same as password
     * @param shouldCheck     - true if you want to check credit score else false
     * @return - {@link SignUpPage} for chaining
     */
    public SignUpPage signUp(String email, String password, boolean shouldCheck) {
        Element.setText(email, Element.waitForElement(emailBy));
        Element.setText(password, Element.waitForElement(passwordBy));
        Element.setText(password, Element.waitForElement(confirmPasswordBy));
        Element.markCheckBox(shouldCheck, Element.waitForElement(getCreditScoreBy), "aria-checked");
        Element.click(Element.waitForElement(joinButtonBy));
        return this;
    }

    /**
     * Method to verify sign up is successful
     *
     * @param description - the success description
     * @return - true if successful else false
     */
    public boolean isJoiningSuccessfulDescriptionPresent(String description) {
        return Element.getText(Element.waitForElement(successDescriptionBy)).equals(description);
    }
}
