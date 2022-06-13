package Tests;

import Pages.Page;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Connection;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public Page page;
    Logger log= Logger.getLogger("BaseTest");

   // public ExtentReports extent;
   // public ExtentTest extentTest;





    @BeforeMethod
    public void SetUp() throws IOException {

       // PropertyConfigurator.configure("Log4j.properties");
       /* extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);*/

        System.setProperty("webdriver.chrome.driver", "C://selenium jars and drivers//driver//Chromedriver//chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,20);
        driver.manage().window().maximize();
        log.info("opening url");
        driver.get("https://dna-staging.hashedin.com/allocation/allocate");
        //creating the object of Page class
        page = new Page(driver,wait);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



    }

        @AfterMethod
    public void tearDown(){
       // extent.flush()
           log.info("browser Closed");

        driver.quit();
    }
   /* public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String Destination = System.getProperty("user.dir")+"/FailedTestScreenshots/"+screenshotName + dateName +".png";
        File finalDestination = new File(Destination);
        FileUtils.copyFile(source,finalDestination);
        return Destination;
    }

    @AfterMethod
    public void getReport(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE){
            extentTest.log(LogStatus.FAIL,"Testcase Failed"+result.getName());
            extentTest.log(LogStatus.FAIL,"Testcase Failed"+result.getThrowable());
            String ScreenshotPath = BaseTest.getScreenshot(driver,result.getName());
            extentTest.log(LogStatus.FAIL,extentTest.addScreencast(ScreenshotPath));
        }
        else if(result.getStatus()==ITestResult.SKIP){
            extentTest.log(LogStatus.SKIP,"Test case Skipped is"+result.getName());
        }
        extent.endTest(extentTest);*/


    }






