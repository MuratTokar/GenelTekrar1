package day_016_Screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class Snapdeal extends BaseClass {
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
    By produckList=By.cssSelector(".product-row>section>div");

    {
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Test
    public void snapDealTest() throws IOException {
        driver.get(url);
       wait.until(ExpectedConditions.visibilityOfElementLocated(lsearchBox)).sendKeys("watch", Keys.ENTER);
        List<WebElement> lists=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(produckList));
        int num=new Random().nextInt(lists.size());
        WebElement myWatch=lists.get(num);

        new Actions(driver).scrollToElement(myWatch).perform();
/*
        File source=myWatch.getScreenshotAs(OutputType.FILE);
        String now= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd HH-mm-ss"));
        String name="watch"+now+".png";
        File target=new File("ScreeenShot/"+name);
        FileUtils.copyFile(source,target);*/
        gtakeScreenShot("Wat");
        gtakeElementScreenShot(myWatch,"saat");
        driver.quit();



        }

            
        }



