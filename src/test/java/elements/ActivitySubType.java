package elements;

import driver.DriverSingleton;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class ActivitySubType {

    private static final String ACTIVITY_SUB_TYPE_XPATH = "//li[@class='subtypeselector']//a[contains(text(),'%s')]";

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();
    private final String label;

    public ActivitySubType(String label) {
        this.label = label;
    }

    public void chooseActivitySubType() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(ACTIVITY_SUB_TYPE_XPATH, label))));
        driver.findElement(By.xpath(String.format(ACTIVITY_SUB_TYPE_XPATH, label))).click();
    }

}
