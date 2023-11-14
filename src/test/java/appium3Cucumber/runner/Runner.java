package appium3Cucumber.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        features = {"src/test/java/appium3Cucumber/features/Apidemos2.feature"},
        glue = {"appium3Cucumber/stepdefs"}
)
public class Runner extends AbstractTestNGCucumberTests {
    public static boolean runner;
    public static ThreadLocal<Boolean> runners = new ThreadLocal<>();

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("textng before suite");
        runner = true;
        runners.set(true);
    }

    @BeforeTest
    @Parameters({"Device", "App"})
    public void beforeTest(@Optional("SAMSUNG_A33") String device, @Optional("APIDEMO") String app){
        System.out.println("textng before test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("textng before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("textng after class");
    }


    @AfterTest
    public void afterTest(){
        System.out.println("textng after test");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("textng after suite");
    }

}
