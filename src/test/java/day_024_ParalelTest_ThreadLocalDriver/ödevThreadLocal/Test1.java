package day_024_ParalelTest_ThreadLocalDriver.ödevThreadLocal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.Driver;
import utils.DriverStatic;

import java.time.Duration;

public class Test1{
    String url = "https://demoblaze.com/";
    WebDriver driver;
    WebDriverWait wait;
    By lcontact = By.xpath("//a[text()=\"Contact\"]");
    By lcontactemail = By.id("recipient-email");
    By lcontactname = By.cssSelector("#recipient-name");
    By lmesagge = By.cssSelector("#message-text");
    By lsendbutton = By.xpath("//button[text()='Send message']");

    @BeforeTest
    @Parameters({"browser"})
    public void start(@Optional("chrome") String browser) {
        driver= DriverStatic.getDriver(browser);
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(lcontact)).click();
    }

    @Test(dependsOnMethods = "test1")
    @Parameters({"mail", "name", "message"})
    public void formausfüllen(String contactmail, String contactname, String mesaj) {
        sendkeyss(lcontactemail, contactmail);
        sendkeyss(lcontactname, contactname);
        sendkeyss(lmesagge, mesaj);
        click(lsendbutton);
        alertclick();

    }
    public void sendkeyss(By locator, String s) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(s);

    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void alertclick(){
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void algettext() {
        wait.until(ExpectedConditions.alertIsPresent()).getText();

    }

}

