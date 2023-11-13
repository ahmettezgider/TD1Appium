package appium02;

import base.BaseTest;
import org.testng.annotations.Test;


public class Test1 extends BaseTest {


    @Test
    public void test1(){
        click("Weiter");
        click("OK");
        click("OK");

    }

    @Test(dependsOnMethods = "test1")
    public void test2(){
        // click API Demos
        click("API Demos");

        // click Views
        click("Views");

        swipeV(.8, .3);

        // click TextSwitcher
        click("TextSwitcher");

        // Ekrandaki sayi 5 oluncaya kadar Next butonuna tikla

        for (int i = 0; i < 5; i++) {
            click("next");
            waitForVisibilityOf(String.valueOf(i+1));
        }



    }


    @Test(dependsOnMethods = "test1")
    public void test3_swipeVerical(){
        // click API Demos
        click("API Demos");

        // click Views
        click("Views");

        swipeV(.7, .4);
        swipeV(.7, .4);
        swipeV(.4, .7);
        swipeV(.4, .7);

    }

    @Test(dependsOnMethods = "test1")
    public void test4_swipeUntil(){
        // click API Demos
        click("API Demos");

        // click Views
        click("Views");

        swipeUntilVisible("WebView", true);
        swipeUntilVisible("Animation", false);

    }


}
