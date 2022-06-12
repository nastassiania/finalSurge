package page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Log4j2
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
        log.info("Open registration page");
        driver.get(url);
        return this;
    }

    public RegistrationPage fillInFirstName(String firstNameToEnter) {
        log.info("Enter first name");
        firstName.clear();
        firstName.sendKeys(firstNameToEnter);
        return this;
    }

    public RegistrationPage fillInLastName(String lastNameToEnter) {
        log.info("Enter last name");
        lastName.clear();
        lastName.sendKeys(lastNameToEnter);
        return this;
    }

    public RegistrationPage fillInEmail(String emailToEnter) {
        log.info("Enter email");
        email.clear();
        email.sendKeys(emailToEnter);
        return this;
    }

    public RegistrationPage chooseTimeZone(String timeZoneToChoose) {
        log.info("Choose timezone");
        Select select = new Select(timeZone);
        select.selectByVisibleText(timeZoneToChoose);
        return this;
    }


    public RegistrationPage fillInPassword(String passwordToEnter) {
        log.info("Enter password");
        password.clear();
        password.sendKeys(passwordToEnter);
        return this;
    }

    public RegistrationPage fillInConfirmPassword(String confirmPasswordToEnter) {
         log.info("Enter password for confirmation");
        confirmPassword.clear();
        confirmPassword.sendKeys(confirmPasswordToEnter);
        return this;
    }

    public void clickCreateNewAccountButton() {
        log.info("Click \"Create new account\" button");
        createNewAccountButton.click();
    }

    public String getErrorMessage(){
        log.info("Get text of error message");
        return errorMessage.getText();
    }

}
