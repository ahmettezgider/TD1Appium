package appium3Cucumber.stepdefs;
import appium3Cucumber.base.BaseSteps;
import base.BaseTest;
import io.cucumber.java.en.*;
import utils.App;
import utils.Device;

public class MyStepdefs extends BaseSteps {

    public MyStepdefs(){
        System.out.println("Step defs");
    }

    @Given("^user opens (APIDEMO|CALCULATOR) on (SAMSUNG_A33|EMULATOR1)$")
    public void userOpensAPIDEMOSOnTheSAMSUNG(String app, String device) {
        openApp(Device.valueOf(device), App.valueOf(app));
        click("Weiter");
        click("OK");
        click("OK");
    }

    @When("user clicks {string}")
    public void userClicks(String text) {
        click(text);
    }

    @Then("{string} should be visible")
    public void shouldBeVisible(String text) {
        waitForVisibilityOf(text);
    }

    @And("swipe until the text {string} is visible")
    public void swipeUntilTheTextIsVisible(String text) {
        swipeUntilVisible(text, true);
    }
}
