package appium3Cucumber.stepdefs;

import appium3Cucumber.runner.Runner;
import io.cucumber.java.*;
import utils.App;
import utils.Device;
import utils.Driver;

public class Hooks {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("cucumber before all");
    }

    @Before
    public void before(){
        if (Runner.runner) {
            Driver.getDriver(Device.SAMSUNG_A33, App.APIDEMO);
        } else {
            Driver.getDriver(Device.SAMSUNG_A33, App.APIDEMO);
        }
        System.out.println("cucumber before, scenario");
    }

    @BeforeStep
    public void beforeStep(){
        System.out.println("cucumber before step");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("cucumber after step");
    }

    @After
    public void after(){
        System.out.println("cucumber after, scenario");
        Driver.quit();
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("cucumber after all");
    }
}
