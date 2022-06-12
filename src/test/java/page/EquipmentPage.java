package page;

import elements.DropDown;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

@Log4j2
public class EquipmentPage extends BasePage{

    @FindBy(xpath = "//input[@id='ShoeName']")
    private WebElement equipmentName;

    @FindBy(xpath = "//span[contains(text(), 'Select Brand...')]")
    private WebElement equipmentBrandDropDown;

    @FindBy(xpath = "//select[@id='ShoeBrand']//ancestor::body//ul[@class='select2-results']")
    private WebElement equipmentBrandSelect;

    @FindBy(xpath = "//div[@class='select2-drop select2-with-searchbox select2-drop-active']//input[@class='select2-input select2-focused']")
    private WebElement equipmentBrandInput;

    @FindBy(xpath = "//a[@id='Cancel']")
    private WebElement cancelEquipmentPhotoUpdating;

    @FindBy(xpath = "//input[@id='ShoeModel']")
    private WebElement equipmentModel;

    @FindBy(xpath = "//input[@id='ShoeCost']")
    private WebElement equipmentCost;

    @FindBy(xpath = "//input[@id='ShoeDate']")
    private WebElement equipmentDatePurchased;

    @FindBy(xpath = "//td[@class='day  active']")
    private WebElement today;

    @FindBy(xpath = "//input[@id='StartDist']")
    private WebElement startingDistance;

    @FindBy(xpath = "//select[@id='DistType']")
    private WebElement distanceTypeSelect;

    @FindBy(xpath = "//input[@id='saveButton']")
    private WebElement addEquipmentButton;

    @FindBy(xpath = "//table[@class='table']//tr")
    private List<WebElement> userBikes;

    public EquipmentPage fillInEquipmentName(String equipmentNameToEnter){
        log.info("Enter equipment name");
        equipmentName.clear();
        equipmentName.sendKeys(equipmentNameToEnter);
        return this;
    }

    public EquipmentPage chooseEquipmentBrand(String equipmentToChoose) {
        log.info("Choose equipment brand");
        equipmentBrandDropDown.click();
        new DropDown(equipmentToChoose).chooseEquipmentBrand();
        return this;
    }

    public EquipmentPage fillInEquipmentModel(String equipmentModelToEnter){
        log.info("Enter equipment model");
        equipmentModel.clear();
        equipmentModel.sendKeys(equipmentModelToEnter);
        return this;
    }

    public EquipmentPage fillInEquipmentCost(String equipmentCostToEnter){
        log.info("Enter equipment cost");
        equipmentCost.clear();
        equipmentCost.sendKeys(equipmentCostToEnter);
        return this;
    }

    public EquipmentPage chooseDateOfPurchase(){
        log.info("Enter equipment date of purchase");
        equipmentDatePurchased.click();
        today.click();
        return this;
    }

    public EquipmentPage fillInStartingDistance(String startingDistanceToEnter){
        log.info("Enter starting distance");
        startingDistance.clear();
        startingDistance.sendKeys(startingDistanceToEnter);
        return this;
    }

    public EquipmentPage chooseDistanceType(String distanceTypeToChoose) {
        log.info("Choose distance type");
        distanceTypeSelect.click();
        Select select = new Select(distanceTypeSelect);
        select.selectByVisibleText(distanceTypeToChoose);
        return this;
    }

    public EquipmentPage clickAddEquipmentButton(){
        log.info("Click \"Add equipment\" button");
        addEquipmentButton.click();
        return this;
    }

    public int getAmountOfUserBikes(){
        log.info("Get amount of user's bikes");
        return userBikes.size();
    }




}
