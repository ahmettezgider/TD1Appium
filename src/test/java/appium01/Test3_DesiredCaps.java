package appium01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Test3_DesiredCaps {

    By continueButton = By.id("com.android.permissioncontroller:id/continue_button");
    By okButton = By.id("android:id/button1");
    By okButton2 = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");
    AppiumDriver<MobileElement> driver;

    // Appium'u programatically run etmek icin
    AppiumDriverLocalService service;


    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        startAppium();
        driver = new AndroidDriver<>(service.getUrl(), getCapabilities());
    }


    @AfterTest
    public void afterTest(){
        driver.closeApp();
        driver.quit();
        service.stop();
    }


    @Test
    public void testConnection() {

        driver.findElement(continueButton).click();

        sleep(1000);
        driver.findElement(okButton).click();

        sleep(1000);

        WebElement ok = driver.findElement(okButton2);
        ok.click();

        sleep(1000);
        By apiDemosLink = By.xpath("//*[@text='API Demos']");
        driver.findElement(apiDemosLink).click();

    }

    public DesiredCapabilities getCapabilities(){

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("appium:udid", "RZCT40MN7MY");
        caps.setCapability("appium:version", "12");
        caps.setCapability("appium:deviceName", "Galaxy A33");
        caps.setCapability("platformName", "Android");

        caps.setCapability("appium:appPackage", "com.touchboarder.android.api.demos");
        caps.setCapability("appium:appActivity", "com.touchboarder.androidapidemos.MainActivity");

        return caps;
    }


    public void startAppium(){

        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1") // Appium 127.0.0.1 adresinden run edilecek
                //.usingPort(4723)          // Appium 4723 portundan run edilecek
                .usingAnyFreePort()         // Appium o an bos olan herhangi bir porttan run edilecek
                .build();

        service.clearOutPutStreams();

        service.start();
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
