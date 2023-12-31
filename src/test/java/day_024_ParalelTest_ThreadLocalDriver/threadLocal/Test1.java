package day_024_ParalelTest_ThreadLocalDriver.threadLocal;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

public class Test1 {
    WebDriver driver;
    @BeforeTest
    public void beforetest(){
        driver= Driver.getDriver();
    }
    @Test
    public void test1(){
        driver.get("https://google.com");
    }
    @AfterTest
    public void aftertest(){
       Driver.quit();
    }
}
