package day_030_estNG_groups_Cucumber_introduction_Gmail.gmailtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class GmailTest {
    String url = "https://mail.google.com";
    By email = By.xpath("//input[@id=\"identifierId\"]");
    By weiter = By.xpath("(//span[@class='VfPpkd-vQzf8d'])[2]");
    String emaill = "murattokar26@gmail.com";

    WebDriver driver;
    WebDriverWait wait;

    public GmailTest() {

    }


    @BeforeTest
    public void beforetest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // bu option ile chrome acilmadan yapilandirdik.
        options.addArguments("user-data-dir=C:\\Users\\murat\\AppData\\Local\\Google\\Chrome\\User Data");
        // driveri istedigimiz gibi ayarlariz.Acilir acilmaz maximize olack.Guvenli kullanicidan dolayi maile girilmiyor.
        // bu yuzden options larda  kullanici yolu verdik
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    @Test
    public void testGmail() {

        driver.get(url);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(emaill);
        // wait.until(ExpectedConditions.elementToBeClickable(weiter)).click();
    }


}
