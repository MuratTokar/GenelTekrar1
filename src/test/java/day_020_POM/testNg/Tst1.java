package day_020_POM.testNg;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Tst1 extends Test1Base {

    @Test(priority = 10)
    public void test1(){
       driver.get("https://www.google.com");
    }

    @Test(priority = 2,dependsOnMethods = {"test1"})
    public void test2(){
        driver.findElement(Locators.Google_Accept_Cookie.getLocator()).click();
    }
    @Test(dependsOnMethods = {"test1","test2"})
    public void search(){
        driver.findElement(Locators.Searc_Button.getLocator()).sendKeys("Guidersoft", Keys.ENTER);
    }
}
