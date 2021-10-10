package pages.externalpages;

import config.basicactions.Element;
import config.basicactions.Utilities;
import config.browserdriver.DriverFactory;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.Arrays;
import java.util.List;

/**
 * External {@link FacebookHomePage}
 *
 * @author saurabhsrivastava
 */
public class FacebookHomePage extends BasePage {

    /**
     * Local css selectors
     */
    private By postSomethingHomeBy = By.cssSelector(".oajrlxb2 .m9osqain span.a8c37x1j");
    private By postSomethingInsideDialogBy = By.cssSelector("[data-editor=\"7a9fs\"]");
    private By postBy = By.cssSelector("[aria-label=\"Post\"]");
    private By postedPostBy = By.cssSelector(".kvgmc6g5.cxmmr5t8.oygrvhab.hcukyx3x.c1et5uql");

    /**
     * Method to navigate to {@link FacebookHomePage}
     *
     * @return {@link FacebookHomePage}
     */
    @Override
    protected List<By> getLoadables() {
        return Arrays.asList(postSomethingHomeBy);
    }

    /**
     * Navigate to home
     *
     * @return {@link FacebookHomePage}
     */
    @Override
    protected FacebookHomePage navigateToPage() {
        Utilities.customSleep(40);
        if (DriverFactory.getDriver().getCurrentUrl().contains("welcome")) {
            this.url = "https://www.facebook.com/";
            this.navigateToPage(url);
        }
        waitForLoad(40);
        return this;
    }

    /**
     * Method to post on {@link FacebookHomePage}
     *
     * @param something - the text you want to post
     * @return - {@link FacebookHomePage}
     */
    public FacebookHomePage postSomething(String something) {
        Element.click(Element.waitForElementWithCustomTimeOut(postSomethingHomeBy,30));
        Element.setText(something, Element.waitForElementWithCustomTimeOut(postSomethingInsideDialogBy,30));
        Element.click(Element.waitForElement(postBy));
        return this;
    }

    /**
     * Method to verify something is posted
     *
     * @param post - the post you want to verify
     * @return - true if found else false
     */
    public boolean verifyThisPost(String post) {
        return Element.getAllElements(postedPostBy).stream()
                .filter(webElement -> webElement.getText().contains(post)).findFirst()
                .get().getText().contains(post);
    }
}
