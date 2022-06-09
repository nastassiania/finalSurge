package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage{

    @FindBy(xpath = "//div[@class='user-info']")
    private WebElement welcoming;

    @FindBy(xpath = "//div[@class='user-info']//strong")
    private WebElement userName;

    @FindBy(xpath = "//ul[@id='breadcrumbs']//span")
    private WebElement messageWhenLoggedIn;

    @FindBy(xpath = "//a[@href ='logout.cshtml'][contains(text(), 'Logout')]")
    private WebElement logOutButton;

    @FindBy(xpath = "//a[@href ='UserProfile.cshtml'][contains(text(), 'Settings')]")
    private WebElement settingsButton;

    public String getTextOfWelcoming(){
        return welcoming.getText() + userName.getText();
    }

    public String getTextOfMessageWhenLoggedIn(){
        return messageWhenLoggedIn.getText();
    }

    public void clickLogOutButton() {
//        log.info("Click \"Login\" button");
        logOutButton.click();
    }
}
