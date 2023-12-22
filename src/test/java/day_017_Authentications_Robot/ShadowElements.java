package day_017_Authentications_Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;

import java.time.Duration;

public class ShadowElements extends BaseClass {
    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void tets1() {
        By shadowRot = By.xpath("//div[@id=\"content\"]");
        String url = "https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html";
        driver.get(url);
        WebElement p = driver.findElement(shadowRot).
                getShadowRoot().
                findElement(By.cssSelector("p"));
        String text = p.getText();
        System.out.println(text);
        driver.quit();
    }
}
