package day_016_Screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class Ödev {
    /*
    * https://www.snapdeal.com/  sayfasina gidin
    * watch aratin
    * Listelenenler arasinda random bir urun secin
    * o urune scroll edin
    * Ekran göruntusu ve o urunun ekran göruntusunu alin*/
    WebDriver driver;
    WebDriverWait wait;
    String url="https://www.snapdeal.com/";
    By lsearchBox=By.xpath("//input[@id='inputValEnter']");

    {
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Test
    public void snapDealTest(){
        driver.get(url);
       wait.until(ExpectedConditions.visibilityOfElementLocated(lsearchBox)).sendKeys("watch", Keys.ENTER);

    }
}
