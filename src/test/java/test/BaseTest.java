package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterTest
    public void stopBrowser() {
        DriverSingleton.closeDriver();

    }

}
