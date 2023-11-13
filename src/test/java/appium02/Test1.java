package appium02;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

public class Test1 {

    AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void beforeTest(){
        driver = Driver.getDriver(Device.SAMSUNG_A33, App.APIDEMO);
    }


    @AfterTest
    public void afterTest(){
        Driver.quit();
    }

    @Test
    public void test1(){



    }


}
