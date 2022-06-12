package test;

import lombok.extern.log4j.Log4j2;
import model.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.EquipmentPage;
import page.TopBarPage;
import service.EquipmentPageService;
import service.LoginPageService;

import static utils.StringConstant.*;

@Log4j2
public class EquipmentBikesTest extends BaseTest{

    private EquipmentPageService equipmentPageService;
    private LoginPageService loginPageService;
    private TopBarPage topBarPage;
    private EquipmentPage equipmentPage;

    @BeforeClass
    public void doBeforeClass() {
        equipmentPageService = new EquipmentPageService();
        topBarPage = new TopBarPage();
        equipmentPage = new EquipmentPage();
        loginPageService = new LoginPageService();
        loginPageService.logIn(UserData.builder().email(email).password(password).build());
    }

    @Test(description = "New Bike addition to equipment")
    public void addBikeTest() {
        topBarPage.chooseNeededOptionInUpperBar(gearAndRoutes, bikes);
        int amountOfUserBikesBeforeTest = getAmountOfUserBikes();
        equipmentPageService.addNewEquipment();
        int amountOfUserBikesAfterTest = getAmountOfUserBikes();
        log.info("Amount of user's bikes before test - \n" + amountOfUserBikesBeforeTest + "\n");
        log.info("Amount of user's bikes after test - \n" + amountOfUserBikesAfterTest + "\n");
        Assert.assertTrue(amountOfUserBikesAfterTest==amountOfUserBikesBeforeTest+1, "New equipment was not added!");
    }

    @AfterTest
    public void doAfterTest(){
        topBarPage.clickLogOutButton();
    }


    private int getAmountOfUserBikes() {
        try {
            return equipmentPage.getAmountOfUserBikes();
        } catch (NullPointerException Ex) {
            return 0;
        }
    }

}
