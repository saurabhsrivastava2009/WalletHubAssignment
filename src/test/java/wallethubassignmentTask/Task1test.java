package wallethubassignmentTask;

import config.browserdriver.DriverFactory;
import config.usersdata.Users;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.externalpages.FacebookHomePage;
import pages.externalpages.FacebookLoginPage;

public class Task1test extends DriverFactory {

    private FacebookLoginPage facebookLoginPage = new FacebookLoginPage();
    private FacebookHomePage facebookHomePage = new FacebookHomePage();

    private Users dummyUser = Users.TEST_DUMMY_USER;
    
    @Test
    public void verifyPostInFB(){
        facebookLoginPage.navigateToPage()
                .login(dummyUser.getCompleteLoginID(), dummyUser.getUserPassword());
        String post = "Hello World! Posting as dummy user!!";
        facebookHomePage.postSomething(post);
        Assert.assertEquals(true,facebookHomePage.verifyThisPost(post),"Post Verified");

    }
}
