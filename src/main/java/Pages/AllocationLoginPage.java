package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class AllocationLoginPage extends BasePage {

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public AllocationLoginPage(WebDriver driver, WebDriverWait wait) throws IOException {
        super(driver, wait);

    }
    //page locators
     By ClickOnLogin = By.xpath("//button[@type='button']");
     By ClickOnId = By.xpath("(//input[@type='button'])[2]");
     By EnterMailId = By.xpath("//input[@type='email']");
     By SubmitButton = By.xpath("//input[@type='submit']");
     By StatusOfPod = By.xpath("//span[@data-status='ALLOCATION_READY']");
     By StatusOfPodAfterNominate = By.xpath("//span[contains(text(),'IN PROGRESS')]");
     By ClickOnTab = By.xpath("//span[contains(text(),'POD-456')]");
     By ClickOnNominate = By.xpath("//*[@class='ant-tag' and contains(text(),'Java')]");
     By AddingHaSher = By.xpath("(//span[@class='anticon anticon-user-add'])[2]");
     By ClickOnConfirmNomination = By.xpath("//Span[contains(text(),'Confirm Nominations')]");
     By ClickOnConfirm = By.xpath("//span[contains(text(),'Yes, Confirm')]");
     By ClickOnAllocation = By.xpath("//span[contains(text(),'Allocations')]");
     By ClickOnFilter = By.xpath("//span[@class='ant-badge']");
     By ApplyButton = By.xpath("//span[contains(text(),'Apply')]");
     By Skill = By.xpath("//*[@class='ant-select-selection-item-content']");
     By WebPageSkill = By.xpath("(//*[@class='ant-tag' and contains(text(),'Java')])[2]");
     By ClickOnUpcomingPods = By.xpath("//div[@id='rc-tabs-0-tab-upcomingPods']");
     By StatusOfUpcomingpod = By.xpath("//span[contains(text(),'UPCOMING')]");





    //page Actions
    public void doLogin()  {

        doClick(ClickOnLogin);
        doClick(ClickOnId);
        doSendKeys(EnterMailId, "bochandana@deloitte.com");
        doClick(SubmitButton);

    }

    public String getStatusOfPod() {

        return  doGetText(StatusOfPod);

    }
    public String NominateHaSher() {

        doClick(ClickOnTab);
        doClick(ClickOnNominate);
        doClick(ClickOnAllocation);
        doClick(ClickOnConfirm);
        return doGetText(StatusOfPodAfterNominate);

        /*Alert alt = driver.switchTo().alert();
        alt.accept();*/

    }
    public String FilterOptionSkill() throws InterruptedException {
        doClick(ClickOnTab);
        doClick(ClickOnNominate);
        //WaitCondition(ClickOnFilter,30);
        //driver.navigate().refresh();
        Thread.sleep(4000);
        doClick(ClickOnFilter);
        isdisplayed(Skill);

        return doGetText(Skill);


    }
    public String WebPageSkill() throws InterruptedException {
        //WaitCondition(ApplyButton,20);
        Thread.sleep(2000);
        doClick(ApplyButton);
        return doGetText(WebPageSkill);
    }
    public void AddingHaSher()  {
       doClick(ClickOnTab);
       doClick(ClickOnNominate);
       doClick(AddingHaSher);
       doClick(ClickOnConfirmNomination);


    }

    public String ClickOnUpcomingPod(){
        doClick(ClickOnUpcomingPods);
        return doGetText(StatusOfUpcomingpod);
    }


    }

