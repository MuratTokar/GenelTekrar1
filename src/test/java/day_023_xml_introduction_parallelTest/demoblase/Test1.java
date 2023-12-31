package day_023_xml_introduction_parallelTest.demoblase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Test1 {
    String url = "https://demoblaze.com/";
    WebDriver driver;
    WebDriverWait wait;
    By contact = By.xpath("//a[text()=\"Contact\"]");
    By contactemail=By.id("recipient-email");

    @BeforeTest
    @Parameters({"browser"})
    public void start(@Optional("chrome") String browser) {
        if (browser.trim().equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (browser.trim().equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();

        else {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @AfterTest
    public void aftertest() {
        // driver.quit();
    }

    @Test
    public void test1() {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(contact)).click();
    }
    @Test(dependsOnMethods ="test1" )
    public void formausfüllen(){

    }

}

