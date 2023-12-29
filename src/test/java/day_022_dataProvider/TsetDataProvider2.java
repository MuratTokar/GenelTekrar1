package day_022_dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;

import java.io.IOException;
import java.time.Duration;

public class TsetDataProvider2 extends BaseClass {
    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    By lusername = By.xpath("//input[@name=\"username\"]");
    By lpassword = By.xpath("//input[@name=\"password\"]");
    By logbutton = By.xpath("//button[@type=\"submit\"]");
    By notLogin = By.xpath("//p[text()='Invalid credentials']");
    By loginn = By.xpath("//h6[text()='Dashboard']");
    By dropdown = By.xpath("//p[@class=\"oxd-userdropdown-name\"]");
    By logout = By.xpath("//a[text()='Logout']");

    @BeforeTest
    public void beforeTest() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void aftertest() {
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get(url);
    }

    @Test(dependsOnMethods = "test1", dataProvider = "logindata")
    public void login(String username, String password, boolean login) throws IOException {
        sendkeys(lusername, username);
        sendkeys(lpassword, password);
        click(logbutton);
        if (login) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginn));
            click(dropdown);
            wait.until(ExpectedConditions.visibilityOfElementLocated(logout)).click();
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(notLogin));
            gtakeScreenShot("ohr");
        }


    }

    @DataProvider(name = "logindata")
    public Object[][] getdata() {
        return new Object[][]{
                {"admin1", "123", false},
                {"admin", "admin123", true},
                {"admin1", "admin1234", false}

        };
    }
}
