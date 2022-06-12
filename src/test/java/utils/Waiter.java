package utils;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();

    private static int durationSec = 10;

    public void waitElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
        wait.until(ExpectedConditions.elementToBeClickable(element));}

    public void waitVisibilityOf(WebElement element){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
        wait.until(ExpectedConditions.visibilityOf(element));}

    public void waitVisibilityOfElementLocated(String xPath, String label){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(xPath, label))));}

}
