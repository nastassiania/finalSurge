package test;

import model.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.RegistrationPage;
import page.UserProfilePage;
import service.RegistrationPageService;

import java.time.Duration;

public class RegistrationTest extends BaseTest{

    private RegistrationPageService registrationService= new RegistrationPageService();
    private UserData userData = new UserData();

@BeforeMethod
public void getTemporaryEmailForRegistrationTest(){
    driver.get("https://temprmail.com/");
    waiter("//input[@class='w-full block border border-gray-100 shadow-sm text-2xl md:text-3xl text-center rounded px-3 py-3 mb-3']");
    driver.findElement(By.xpath("//button[@title='Copy email address']")).click();
}
    @Test(priority = 0)
    public void registerNewUserSuccessfullyTest(){
        UserProfilePage userProfilePage = registrationService.registerSuccessfully();
        String actualWelcomingMessage = userProfilePage.getTextOfWelcoming();
        String expectedWelcomingMessage = "Welcome, " + userData.getFirstName();
        Assert.assertTrue(actualWelcomingMessage.contains(expectedWelcomingMessage), "Actual welcoming message doesn't match the expected one!");
    }

    @Test(priority = 1)
    public void registerNewUserWithWrongConfirmPasswordTest(){
        RegistrationPage registrationPage = registrationService.registerWithWrongConfirmPassword();
        String actualErrorMessage = registrationPage.getErrorMessage();
        String expectedErrorMessage = "Error: The passwords you entered did not match.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Actual error message doesn't match the expected one!");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.manage().deleteAllCookies();
    }

    private WebDriverWait waiter(String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        return wait;
    }

//    private Boolean elementIsShown(String element) {
//            try {
//                driver.findElement(By.xpath(element)).isEnabled();
//                return true;
//            } catch (NoSuchElementException Ex) {
//                return false;
//            }
//    }

}
