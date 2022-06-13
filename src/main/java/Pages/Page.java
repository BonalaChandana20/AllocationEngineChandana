package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  Page {
    public WebDriver driver;
    public WebDriverWait wait;
    //Page class Constructor
    public Page(WebDriver driver, WebDriverWait wait) {
        this.driver =driver;
        this.wait = wait;

    }
    // create a method with java generics And return a new Page
    //This getInstance method will return the Page class object
    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
