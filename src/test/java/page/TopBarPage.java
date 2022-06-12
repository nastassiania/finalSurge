package page;

import elements.DropDown;
import elements.TopBar;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static utils.StringConstant.*;

@Log4j2
public class TopBarPage extends BasePage{

    @FindBy(xpath = "//div[@class='user-info']")
    private WebElement welcoming;

    @FindBy(xpath = "//div[@class='user-info']//strong")
    private WebElement userName;

    @FindBy(xpath = "//i[@class='icsw16-day-calendar']")
    private WebElement calendarLogoButton;

    @FindBy(xpath = "//i[@class='icsw16-home']")
    private WebElement dashboardLogoButton;

    @FindBy(xpath = "//i[@class='icsw16-calculator']")
    private WebElement otherCalculatorsLogoButton;

    @FindBy(xpath = "//a[@href='UserProfile.cshtml'][contains(.,'Settings')]")
    private WebElement settingsButton;

    @FindBy(xpath = "//select[@class='selectnav']")
    private WebElement navigationPanelSelect;

    @FindBy(xpath = "//a[@href ='logout.cshtml'][contains(text(), 'Logout')]")
    private WebElement logOutButton;

    public String getTextOfWelcoming(){
        log.info("Get text of welcome message");
        return welcoming.getText() + userName.getText();
    }

    public void chooseNeededOptionInUpperBar(String topMenuOption, String dropdowmTopMenuOption){
        log.info("Choose \"" + topMenuOption + "\" and \"" + dropdowmTopMenuOption + "\" on the navigation panel");
        new TopBar(topMenuOption).chooseTopMenuOption();
        new DropDown(dropdowmTopMenuOption).chooseTopMenuOption();
    }

    public void clickCalendarLogoButton(){
        log.info("Click \"Calendar\" logo button");
        calendarLogoButton.click();
    }

    public void clickDashboardLogoButton(){
        log.info("Click \"Dashboard\" logo button");
        dashboardLogoButton.click();
    }

    public void openOtherCalculatorsLogoButton(){
        log.info("Click \"Other Calculators\" logo button");
        otherCalculatorsLogoButton.click();
        driver.switchTo().frame(otherCalciFrame);
    }

    public void clickSettingsButton(){
        log.info("Click \"Settings\"");
        settingsButton.click();
    }

    public void clickLogOutButton() {
        log.info("Click \"Logout\"");
        logOutButton.click();
    }

}
