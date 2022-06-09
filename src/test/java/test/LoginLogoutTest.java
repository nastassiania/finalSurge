package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.LoginLogoutPage;
import page.UserProfilePage;
import service.LoginLogoutPageService;

public class LoginLogoutTest extends BaseTest{

    private LoginLogoutPageService loginLogoutPageService;
    private UserProfilePage userProfilePage;
    private LoginLogoutPage loginLogoutPage;

    @BeforeTest
    private void loginLogout() {
        loginLogoutPageService = new LoginLogoutPageService();
        userProfilePage = new UserProfilePage();
        loginLogoutPage = new LoginLogoutPage();
    }

    @Test
    public void logInSuccessfullyTest() {
        userProfilePage = loginLogoutPageService.logInSuccessfully();
        String actualLogInMessage = userProfilePage.getTextOfMessageWhenLoggedIn();
        String expectedLogInMessage = "View, Edit and Add workouts.";
        Assert.assertEquals(actualLogInMessage, expectedLogInMessage, "Actual message doesn't match the expected one!");
    }

    @Test(dependsOnMethods = "logInSuccessfullyTest")
    public void logOutTest() {
        loginLogoutPage = loginLogoutPageService.logOut();
        String actualLogOutMessage = loginLogoutPage.getTextOfMessageAfterSuccessfulLogOut();
        String expectedLogOutMessage = "You have been successfully logged out of the system.";
        Assert.assertEquals(actualLogOutMessage, expectedLogOutMessage, "Actual message doesn't match the expected one!");
    }

    @Test
    public void LogInUnsuccessfullyWithWrongPasswordTest() {
        userProfilePage = loginLogoutPageService.logInUnsuccessfullyWithWrongPassword();
        String actualLogInUnsuccessfullyMessage = loginLogoutPage.getTextOfMessageIfWrongPasswordWhenLogIn();
        String expectedLogInUnsuccessfullyMessage = "Invalid login credentials. Please try again.";
        Assert.assertEquals(actualLogInUnsuccessfullyMessage, expectedLogInUnsuccessfullyMessage, "Actual message doesn't match the expected one!");
    }

}
