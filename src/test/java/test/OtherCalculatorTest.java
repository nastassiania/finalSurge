package test;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import model.UserData;
import org.testng.Assert;
import org.testng.annotations.*;
import page.OtherCalculatorPage;
import page.TopBarPage;
import service.LoginPageService;
import service.OtherCalculatorsPageService;

import static utils.StringConstant.*;

@Log4j2
public class OtherCalculatorTest extends BaseTest{

        private OtherCalculatorPage otherCalculatorPage;
        private LoginPageService loginPageService;
        private OtherCalculatorsPageService otherCalculatorsPageService;
        private TopBarPage topBarPage;

        @BeforeClass
        public void logIn() {
            otherCalculatorPage = new OtherCalculatorPage();
            otherCalculatorsPageService = new OtherCalculatorsPageService();
            topBarPage = new TopBarPage();
            loginPageService = new LoginPageService();
            loginPageService.logIn(UserData.builder().email(email).password(password).build());
        }

        @Test(description = "Verification that CaloriesNeeds Calculator counts properly")
        @Description("Verification that CaloriesNeeds Calculator counts properly")
        public void checkCaloriesNeedsCalculatorTest() {
            otherCalculatorPage = otherCalculatorsPageService.checkCaloricNeeds();
            String actualCaloriesForTestPerson = otherCalculatorPage.getTextOfTodayCaloricNeeds();
            String expectedCaloriesForTestPerson = caloricNeed;
            log.info("Actual caloric need - \n" + actualCaloriesForTestPerson + "\n");
            log.info("Expected caloric need - \n" + expectedCaloriesForTestPerson + "\n");
            Assert.assertTrue(actualCaloriesForTestPerson.contains(expectedCaloriesForTestPerson), "Actual amount of calories doesn't match the expected one!");

        }

    }
