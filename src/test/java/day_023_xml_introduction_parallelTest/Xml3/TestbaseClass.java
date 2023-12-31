package day_023_xml_introduction_parallelTest.Xml3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestbaseClass {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeTest
    @Parameters("browser") // xml de test altina ekledigim parametre ismi ile ayni olmali
    public void befotest(@Optional("chrome") String browser) { // eger burdan run edersek parametre geledi hatasi
        // verecek.buraya optional yapinca paramatre gelemse dahi chrome ile calisir
        if (browser.trim().equalsIgnoreCase("firefox"))
        driver = new FirefoxDriver();
        else
            driver=new ChromeDriver();  // her bir teste ayri browser gonderdik
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterTest
    public void aftertest() {
        driver.quit();

    }
}
