package pages;

import config.basicactions.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

/**
 * Page class for {@link TestInsurancePage}
 *
 * @author saurabhsrivastava
 */
public class TestInsurancePage extends BasePage {

    /**
     * Page css selectors and local variables
     */
    private By menuItemsBy = By.cssSelector(".left-content > .nav-link > .nav-txt");
    private By starBy = By.cssSelector(".review-action .rvs-svg .rating-box-wrapper > .rvs-star-svg");
    private By reviewCategoryBy = By.cssSelector(".wrev-drp .dropdown.second .dropdown-placeholder");
    private By reviewCategoryOptionsBy = By.cssSelector("div.dropdown.second.opened .dropdown-list >  [role=\"option\"]");
    private By writeReviewBoxBy = By.cssSelector("[placeholder=\"Write your review...\"]");
    private By sumbitReviewBy = By.cssSelector(".sbn-action.semi-bold-font");
    private By reviewsListBy = By.cssSelector("[itemprop=\"review\"]");

    /**
     * Method to add the page loadables
     *
     * @return - the list of page loadables
     */
    @Override
    List<By> getLoadables() {
        return Arrays.asList(menuItemsBy);
    }

    /**
     * Method to navigate to {@link TestInsurancePage}
     *
     * @return - {@link TestInsurancePage} for chaining
     */
    @Override
    public TestInsurancePage navigateToPage() {
        this.url = "https://wallethub.com/profile/test_insurance_company/";
        this.navigateToPage(url);
        waitForLoad();
        return this;
    }

    /**
     * Method to select the tabs present in the {@link TestInsurancePage}
     *
     * @param menuText - Could be any one of {@link MenuTabOptions}
     * @return - {@link TestInsurancePage} for chaining
     */
    public TestInsurancePage clickThisMenu(String menuText) {
        Element.clickOneOfMany(menuItemsBy, menuText);
        return this;
    }

    /**
     * Method to give ratings in form of stars
     *
     * @param rating - the number of stars you want to give
     * @return - {@link TestInsurancePage} for chaining
     */
    public TestInsurancePage giveTheseManyStars(int rating) {
        for (WebElement element : Element.getAllElements(starBy)) {
            Element.hover(element);
            rating = rating - 1;
            if (rating == 0) {
                Element.click(element);
                break;
            }
        }
        return this;
    }

    /**
     * Method to select the product for review
     *
     * @param category - the product category
     * @return - {@link TestInsurancePage} for chaining
     */
    public TestInsurancePage selectProduct(String category) {
        Element.selectDropdownOption(reviewCategoryBy, reviewCategoryOptionsBy, category);
        return this;
    }

    /**
     * Method to write the review and submit
     *
     * @param review - the review you want to enter
     */
    public void writeAndSubmitReview(String review) {
        Element.setText(review, Element.waitForElement(writeReviewBoxBy));
        Element.click(Element.waitForElement(sumbitReviewBy));
        waitForLoad();
    }

    /**
     * Method get the review posted in the {@link TestInsurancePage}
     *
     * @param userID - the user whose review you want to look for
     * @return - the review
     */
    public String getMyReview(String userID) {
        return Element.getAllElements(reviewsListBy).stream().filter(webElement -> webElement.getText().contains(userID)).findFirst().get().getText();
    }

    /**
     * Enum to define the menu options
     */
    public enum MenuTabOptions {
        OVERVIEW("Overview"),
        REVIEWS("Reviews"),
        QNA("Q&A"),
        CONTACT("Contact");

        String menuOptions;

        MenuTabOptions(String menuOptions) {
            this.menuOptions = menuOptions;
        }

        /**
         * Method to get the menu
         *
         * @return - the menu tab which you have selected
         */
        public String getMenuTabOptions() {
            return menuOptions;
        }
    }
}
