package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.App;
import utils.Device;
import utils.Driver;

import java.time.Duration;

public abstract class BaseTest {

    protected AppiumDriver<MobileElement> driver;
    protected WebDriverWait wait;


    @BeforeTest
    @Parameters({"device", "app"})
    public void beforeTest(@Optional("SAMSUNG_A33") String device, @Optional("APIDEMO") String app) {

        driver = Driver.getDriver(Device.valueOf(device), App.valueOf(app));
        wait = new WebDriverWait(driver, 30);
    }


    @AfterTest
    public void afterTest() {
        Driver.quit();
    }


    public void click(String text) {
        By locator = getXpathWithTextAttr(text);
        click(locator);
    }


    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void senkeys(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }


    public By getXpathWithTextAttr(String text) {
        return By.xpath("//*[@text='" + text + "'] | //*[@*[contains(., '" + text + "')]]");
    }

    public void waitForVisibilityOf(String text) {
        By locator = getXpathWithTextAttr(text);
        waitForVisibilityOf(locator);
    }

    public void waitForVisibilityOf(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void swipeV(double start, double end) {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        if (start < .1) start = .1;
        if (start > .9) start = .9;

        if (end < .1) end = .1;
        if (end > .9) end = .9;

        int startPoint = (int) (height * start);
        int endPoint = (int) (height * end);

        new TouchAction<>(driver)
                .press(PointOption.point(width / 2, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(width / 2, endPoint))
                .release()
                .perform();
    }

    public void swipeH(double start, double end) {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        if (start < .1) start = .1;
        if (start > .9) start = .9;

        if (end < .1) end = .1;
        if (end > .9) end = .9;

        int startPoint = (int) (width * start);
        int endPoint = (int) (width * end);

        new TouchAction<>(driver)
                .press(PointOption.point(startPoint, height/2))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point( endPoint, height/2))
                .release()
                .perform();
    }

    public void swipeUntilVisible(String text, boolean down) {
        By locator = getXpathWithTextAttr(text);
        swipeUntilVisible(locator, down);
    }

    public void swipeUntilVisible(By locator, boolean down) {

        while (true) {
            try {
                if (driver.findElement(locator).isDisplayed())
                    break;
            } catch (Exception e) {
                if (down)
                    swipeV(.6, .5);
                else
                    swipeV(.4, .5);
            }
        }
    }

    public void swipeUntilVisible1(By locator, boolean down) {

        while (true) {
            if (driver.findElements(locator).size() > 0)
                break;

            if (down)
                swipeV(.6, .5);
            else
                swipeV(.4, .5);
        }
    }


    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
