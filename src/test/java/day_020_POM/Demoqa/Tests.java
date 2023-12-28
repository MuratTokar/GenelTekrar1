package day_020_POM.Demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

public class Tests {
    LoginPage lp;
    WebDriver driver;


    @BeforeTest
    public void befortest() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        lp = new LoginPage(driver); // burdan driver gitti Loginpage ye
        lp.gotosite();
        lp.fieldform("Murat Tokar", "murat26@gmail.com", "prinzenstr.60", "prinsenstr.40");

    }

    @AfterTest
    public void aftertest() {
        driver.quit();
    }


}

