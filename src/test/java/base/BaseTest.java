package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.App;
import utils.Device;
import utils.Driver;

import java.time.Duration;

public abstract class BaseTest {

    protected AppiumDriver<MobileElement> driver;
    protected WebDriverWait wait;


    @BeforeTest
    public void beforeTest(){
        driver = Driver.getDriver(Device.SAMSUNG_A33, App.APIDEMO);
        wait = new WebDriverWait(driver, 30);
    }


    @AfterTest
    public void afterTest(){
        Driver.quit();
    }


    public void click(String text){
        By locator = getXpathWithText(text);
        click(locator);
    }


    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void senkeys(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }


    public By getXpathWithText(String text){
        return By.xpath("//*[@text='" + text + "'] | //*[@*[contains(., '" + text + "')]]");
    }



    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
