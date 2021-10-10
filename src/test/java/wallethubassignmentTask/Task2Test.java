package wallethubassignmentTask;

import config.basicactions.Utilities;
import config.browserdriver.DriverFactory;
import config.usersdata.Users;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SignUpPage;
import pages.TestInsurancePage;

public class Task2Test extends DriverFactory {

    private SignUpPage signUpPage = new SignUpPage();
    private TestInsurancePage testInsurancePage = new TestInsurancePage();
    private LoginPage loginPage = new LoginPage();
    private Users dummyUser = Users.TEST_DUMMY_USER;

    /**
     * Test to create a user
     *//*
    @Test
    public void testJoinedSuccess() {
        boolean isJoined = signUpPage.navigateToPage()
                .signUp(dummyUser.getCompleteLoginID(), dummyUser.getUserPassword(), false)
                .isJoiningSuccessfulDescriptionPresent("Thank you for registering with WalletHub!");
        Assert.assertEquals(true, isJoined, "Joined Successfully");
    }*/

    /**
     * Test to verify review is posted or not on {@link TestInsurancePage}
     */
    @Test
    public void testTestInsurancePageReviewPosted() {
        loginPage.navigateToPage();
        loginPage.login(dummyUser.getCompleteLoginID(), dummyUser.getUserPassword(), dummyUser.getUserProfileID());
        testInsurancePage.navigateToPage()
                .clickThisMenu(TestInsurancePage.MenuTabOptions.REVIEWS.getMenuTabOptions())
                .giveTheseManyStars(4)
                .selectProduct("Health Insurance");
        String review = Utilities.generateRandomChar(200);
        testInsurancePage.writeAndSubmitReview(review);
        String postedReview = testInsurancePage.getMyReview(dummyUser.getUsername());
        ProfilePage profilePage = new ProfilePage(dummyUser.getUserProfileID());
        profilePage.navigateToPage();
        profilePage.clickMyReview("Test Insurance Company");
        Assert.assertEquals(true, postedReview.contains(review), "My Review is present");
    }
}
