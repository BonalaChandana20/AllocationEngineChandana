package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page {

    public BasePage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
    }
    //Common Methods
    public void doClick(By locator){
        driver.findElement(locator).click();
    }
    public void doSendKeys(By locator,String text) {
        driver.findElement(locator).sendKeys(text);
    }
    public String doGetText(By locator) {
       return driver.findElement(locator).getText();
    }
    public void WaitCondition(By ele,long WaitTimeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver,WaitTimeInSeconds);
        WebElement elements = null;
        elements = wait.until(ExpectedConditions.elementToBeClickable(ele));

    }
    public void MouseOver(By locator) {
        Actions a =new Actions(driver);
        a.moveToElement((WebElement) locator);
    }
    public void doClear(By locator){
        driver.findElement(locator).clear();
    }
    public void isdisplayed(By locator){
        driver.findElement(locator).isDisplayed();
    }
}
