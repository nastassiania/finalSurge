package test;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import model.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.RegistrationPage;
import page.TopBarPage;
import service.RegistrationPageService;
import service.UserProfilePageService;
import utils.MailGenerator;

import static utils.StringConstant.*;

@Log4j2
public class RegistrationTest extends BaseTest {

    private RegistrationPageService registrationService;
    private RegistrationPage registrationPage;
    private TopBarPage topBarPage;
    private UserProfilePageService userProfilePageService;
    private MailGenerator mailGenerator;
    private String tempEmail;

    @BeforeClass
    private void doBeforeClass() {
        registrationService = new RegistrationPageService();
        registrationPage = new RegistrationPage();
        topBarPage = new TopBarPage();
        userProfilePageService = new UserProfilePageService();
        mailGenerator = new MailGenerator();
    }

    @BeforeMethod
    private void getTemporaryEmailForRegistrationTest() {
        tempEmail = mailGenerator.getTemporaryEmail();
    }

    @Test(description = "Successful registration of a new user")
    @Description("Successful registration of a new user")
    public void registerNewUserSuccessfullyTest() {
        UserData user = UserData.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(tempEmail)
                .timeZone(timeZone)
                .password(password)
                .confirmPassword(password)
                .build();
        registrationService.register(user);
        String actualWelcomingMessage = topBarPage.getTextOfWelcoming();
        String expectedWelcomingMessage = "Welcome, " + user.getFirstName();
        userProfilePageService.deleteAccount();
        log.info("Actual message - \n" + actualWelcomingMessage + "\n");
        log.info("Expected message - \n" + expectedWelcomingMessage + "\n");
        Assert.assertTrue(actualWelcomingMessage.contains(expectedWelcomingMessage), "Actual welcoming message doesn't match the expected one!");
    }

    @Test(description = "Unsuccessful registration of a new user if user inputs incorrect confirmation password")
    @Description("Unsuccessful registration of a new user if user inputs incorrect confirmation password")
    public void registerNewUserWithWrongConfirmPasswordTest() {
        UserData user = UserData.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(tempEmail)
                .timeZone(timeZone)
                .password(password)
                .confirmPassword(wrongPassword)
                .build();
        registrationService.register(user);
        String actualErrorMessage = registrationPage.getErrorMessage();
        String expectedErrorMessage = "Error: The passwords you entered did not match.";
        log.info("Actual message - \n" + actualErrorMessage + "\n");
        log.info("Expected message - \n" + expectedErrorMessage + "\n");
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Actual error message doesn't match the expected one!");
    }

}
