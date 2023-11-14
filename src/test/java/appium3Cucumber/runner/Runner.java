package appium3Cucumber.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/appium3Cucumber/features"},
        glue = {"appium3Cucumber/stepdefs"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
