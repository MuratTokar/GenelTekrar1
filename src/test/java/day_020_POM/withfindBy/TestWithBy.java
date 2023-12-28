package day_020_POM.withfindBy;

import day_020_POM.withBy.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

public class TestWithBy {
    WebDriver driver;
    LoginPagee lp;
    @BeforeTest
    public void beforetest(){
        driver= Driver.getDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1(){
        lp=new LoginPagee(driver);
        lp.gotoSite();
        lp.assertTitle("Swag Labs");
        lp.login("standard_user","secret_sauce");
        lp.assertLogin();

    }

    @AfterTest
    public void tearDown(){
        Driver.quit();
    }
}
