package day_007_selectors;

import day_005_selenium_Senario_click_sendkeys.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Scnenario01 extends BaseClass {
    /*
     * https://demoqa.com/ adresine gidin
     * Elements linkine tiklayin
     * Acilan formu doldurun
     * Submit butonuna tiklayin
     * Girdiginiz verilerin formun alt kisminda oldugubu assert esdin*/


    String url = "https://demoqa.com/text-box";
    By lname = By.cssSelector("#userName");
    By lemail = By.cssSelector("#userEmail");
    By currentAdress = By.cssSelector("#currentAddress");
    By ParentAdress = By.cssSelector("#permanentAddress");
    By submit = By.cssSelector("#submit");


    @Test
    public void test1() {

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        sendkeys(lname, "Murat");
        sendkeys(lemail, "murattokar26@gmail.com");
        sendkeys(currentAdress, "Alstrasse 40");
        sendkeys(ParentAdress, "kkkstrase 10");
        click(submit);
        // WebElement element= driver.findElement(submit);
        //  scrollMovito(element);
        // element.click();

       // Assert.assertTrue(driver.findElement(By.xpath("locator")).getText().contains("murat tokar"));
        // yada hepsini kapsayan div i aliriz
        sleep(5000);

        driver.quit();


    }

}
