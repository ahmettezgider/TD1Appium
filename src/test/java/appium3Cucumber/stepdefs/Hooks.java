package appium3Cucumber.stepdefs;

import io.cucumber.java.After;
import utils.Driver;

public class Hooks {


    @After
    public void after(){
        Driver.quit();
    }
}
