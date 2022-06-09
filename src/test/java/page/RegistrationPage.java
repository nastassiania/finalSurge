package page;

import model.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegistrationPage extends BasePage{

    @FindBy(xpath = "//input[@id='create_first']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='create_last']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='create_email']")
    private WebElement email;

    @FindBy(xpath = "//select[@id='create_timezone']")
    private WebElement timeZone;

    @FindBy(xpath = "//input[@id='password_meter']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='create_passwordmatch']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createNewAccountButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    private WebElement errorMessage;

    public RegistrationPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public RegistrationPage fillInFirstName(String firstNameToEnter) {
        //log.info("Enter login");
        firstName.clear();
        firstName.sendKeys(firstNameToEnter);
        return this;
    }

    public RegistrationPage fillInLastName(String lastNameToEnter) {
        //log.info("Enter login");
        lastName.clear();
        lastName.sendKeys(lastNameToEnter);
        return this;
    }

    public RegistrationPage fillInEmail(String emailToEnter) {
        //log.info("Enter login");
        email.clear();
        email.sendKeys(Keys.CONTROL + "v");
        return this;
    }

    public RegistrationPage chooseTimeZone(String timeZoneToChoose) {
        //log.info("Enter login");
        UserData userData = new UserData();
        String timeZone1 = userData.getTimeZone();
        timeZone.click();
        driver.findElement(By.xpath(String.format("//select[@id='create_timezone']//option[contains(text(), '%s')]", timeZone1))).click();
        return this;
    }


    public RegistrationPage fillInPassword(String passwordToEnter) {
       // log.info("Enter password");
        password.clear();
        password.sendKeys(passwordToEnter);
        return this;
    }

    public RegistrationPage fillInConfirmPassword(String confirmPasswordToEnter) {
        // log.info("Enter password");
        confirmPassword.clear();
        confirmPassword.sendKeys(confirmPasswordToEnter);
        return this;
    }

    public void clickCreateNewAccountButton() {
//        log.info("Click \"Login\" button");
        createNewAccountButton.click();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

}
