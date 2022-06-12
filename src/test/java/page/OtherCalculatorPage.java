package page;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class OtherCalculatorPage extends BasePage{

    @FindBy(xpath = "//input[@class='span2 inline'][@id='Weight']")
    private WebElement weight;

    @FindBy(xpath = "//input[@name='WeightType'][@id='optionsRadios4']")
    private WebElement weightTypeKilos;

    @FindBy(xpath = "//input[@class='span2 inline'][@id='HeightInchCent']")
    private WebElement height;

    @FindBy(xpath = "//input[@name='HeightType'][@id='optionsRadios4']")
    private WebElement heightTypeCentimeters;

    @FindBy(xpath = "//input[@class='span4 inline'][@id='Age']")
    private WebElement age;

    @FindBy(xpath = "//input[@name='Gender'][@id='optionsRadios5']")
    private WebElement genderMale;

    @FindBy(xpath = "//input[@class='span2 inline'][@id='RunDist']")
    private WebElement todayRunDistance;

    @FindBy(xpath = "//input[@name='DistType'][@id='optionsRadios8']")
    private WebElement distanceTypeKm;

    @FindBy(xpath = "//input[@id='saveButtonSettings']")
    private WebElement calculateCaloricNeedsButton;

    @FindBy(xpath = "//div[@class='span6']//div[@class='w-box w-box-green']//tbody//tr")
    private WebElement todayCaloricNeeds;

    public OtherCalculatorPage fillInWeight(String weightToEnter){
        log.info("Enter weight");
        weight.sendKeys(weightToEnter);
        return this;
    }

    public OtherCalculatorPage chooseWeightTypeKilos(){
        log.info("Choose type of weight - kilos");
        weightTypeKilos.click();
        return this;
    }

    public OtherCalculatorPage fillInHeight(String heightToEnter){
        log.info("Enter height");
        height.sendKeys(heightToEnter);
        return this;
    }

    public OtherCalculatorPage chooseHeightTypeCentimeters(){
        log.info("Choose height type - cm");
        heightTypeCentimeters.click();
        return this;
    }

    public OtherCalculatorPage fillInAge(String ageToEnter){
        log.info("Enter age");
        age.sendKeys(ageToEnter);
        return this;
    }

    public OtherCalculatorPage chooseMaleGender(){
        log.info("Choose gender - male");
        genderMale.click();
        return this;
    }

    public OtherCalculatorPage fillInTodayRunDistance(String todayRunDistanceToEnter){
        log.info("Enter today run distance");
        todayRunDistance.sendKeys(todayRunDistanceToEnter);
        return this;
    }

    public OtherCalculatorPage chooseDistanceTypeKm(){
        log.info("Choose distance type - km");
        distanceTypeKm.click();
        return this;
    }

    public void clickCalculateCaloricNeedsButton(){
        log.info("Click \"Calculate caloric needs\" button");
        calculateCaloricNeedsButton.click();
    }

    public String getTextOfTodayCaloricNeeds(){
        log.info("Get text of \"Today caloric needs\" field");
        return todayCaloricNeeds.getText();
    }

}
