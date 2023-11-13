package appium02;

import base.BaseTest;
import org.testng.annotations.Test;


public class Test1 extends BaseTest {


    @Test
    public void test1(){
        click("Weiter");
        click("OK");
        click("OK");
        click("API Demos");
    }


}
