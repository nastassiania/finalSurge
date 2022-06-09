package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLogoutPage extends BasePage{

    @FindBy(xpath = "//input[@id='login_name']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='login_password']")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class ='alert alert-success']//strong")
    private WebElement messageAfterSuccessfulLogOut;

    @FindBy(xpath = "//div[@class ='alert alert-error']//strong")
    private WebElement messageIfWrongPasswordWhenLogIn;

    public LoginLogoutPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public LoginLogoutPage fillInEmail(String emailToEnter) {
        // log.info("Enter password");
        email.clear();
        email.sendKeys(emailToEnter);
        return this;
    }

    public LoginLogoutPage fillInPassword(String passwordToEnter) {
        // log.info("Enter password");
        password.clear();
        password.sendKeys(passwordToEnter);
        return this;
    }

    public void clickLoginButton() {
//        log.info("Click \"Login\" button");
        loginButton.click();
    }

    public String getTextOfMessageAfterSuccessfulLogOut(){
        return messageAfterSuccessfulLogOut.getText();
    }
    public String getTextOfMessageIfWrongPasswordWhenLogIn(){
        return messageIfWrongPasswordWhenLogIn.getText();
    }


}
