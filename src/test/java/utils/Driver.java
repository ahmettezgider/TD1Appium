package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    //private static AppiumDriver<MobileElement> driver;
    private static AppiumDriver<MobileElement> driver;
    private static AppiumDriverLocalService service;


    public static AppiumDriver<MobileElement> getDriver(Device device, App app)  {
        if (driver == null){
            startAppium();
            driver = new AndroidDriver<>(service.getUrl(), getCapabilities(device, app));

        }
        return driver;
    }



    public static void startAppium(){
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams();
        service.start();
    }


    public static void quit(){
        if (driver != null) {
            driver.quit();
            service.stop();
        }
    }


    public static DesiredCapabilities getCapabilities(Device device, App app){

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("appium:udid", device.getUdid());
        caps.setCapability("appium:version", device.getVersion());
        caps.setCapability("appium:deviceName", device.getDeviceName());
        caps.setCapability("platformName", device.getPlatformName());

        caps.setCapability("appium:appPackage", app.getAppPackage());
        caps.setCapability("appium:appActivity", app.getAppActivity());

        return caps;
    }




}
