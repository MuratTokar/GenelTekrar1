package day_020_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Test1Base {


    WebDriver driver;


    @BeforeSuite
    public void BeforeSuitee(){
        driver=new ChromeDriver();


    }
    @AfterSuite
    public void aftersuite(){

       // driver.quit();
    }
}
