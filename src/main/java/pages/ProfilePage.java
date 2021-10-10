package pages;

import config.basicactions.Element;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

/**
 * Page class for {@link ProfilePage}
 *
 * @author saurabhsrivastava
 */
public class ProfilePage extends BasePage {

    /**
     * Page level css selectors and local variables
     */
    private By reviewDetailsBy = By.cssSelector(".pr-rec-item-first-row .pr-rec-texts-container");

    private String profileID = "";

    /**
     * Constructor to initialise the profile ID
     *
     * @param profileID - the profile ID of the logged in User
     */
    public ProfilePage(String profileID) {
        this.profileID = profileID;
    }

    /**
     * Method to add the page loadables
     *
     * @return - the list of page loadables
     */
    @Override
    protected List<By> getLoadables() {
        return Arrays.asList(reviewDetailsBy);
    }

    /**
     * Method to navigate to {@link ProfilePage}
     *
     * @return - {@link ProfilePage} for chaining
     */
    @Override
    public ProfilePage navigateToPage() {
        this.url = "https://wallethub.com/profile/" + profileID;
        this.navigateToPage(url);
        waitForLoad();
        return this;
    }

    /**
     * Method to click one of your reviews based on product
     *
     * @param product - the product name for which you want to view the review
     * @return - {@link TestInsurancePage}
     */
    public TestInsurancePage clickMyReview(String product) {
        Element.clickOneOfMany(reviewDetailsBy, product);
        return new TestInsurancePage();
    }
}
