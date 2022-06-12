package test;

import lombok.extern.log4j.Log4j2;
import model.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.LoginPage;
import service.LoginPageService;

import static utils.StringConstant.*;

@Log4j2
public class LoginUnsuccessfullyTest extends BaseTest{

    private LoginPageService loginPageService;
    private LoginPage loginLogoutPage;

    @BeforeTest
    public void loginLogout() {
        loginPageService = new LoginPageService();
        loginLogoutPage = new LoginPage();
    }

    @Test(description = "Login with incorrect password")
    public void LogInWithWrongPasswordTest() {
        UserData credentials = UserData.builder()
                .email(email)
                .password(wrongPassword)
                .build();
        loginPageService.logIn(credentials);
        String actualLogInUnsuccessfullyMessage = loginLogoutPage.getTextOfErrorMessage();
        String expectedLogInUnsuccessfullyMessage = "Invalid login credentials. Please try again.";
        log.info("Actual message - \n" + actualLogInUnsuccessfullyMessage + "\n");
        log.info("Expected message - \n" + expectedLogInUnsuccessfullyMessage + "\n");
        Assert.assertEquals(actualLogInUnsuccessfullyMessage, expectedLogInUnsuccessfullyMessage, "Actual message doesn't match the expected one!");
    }

}
