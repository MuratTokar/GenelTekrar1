package day_016_Screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class TestTricentis {
    WebDriver driver;
    WebDriverWait wait;

    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    String url = "https://demowebshop.tricentis.com/";
    By lsearchBox = By.xpath("//input[@id='small-searchterms']");
    By lsearchButton = By.xpath("//input[@value='Search']");
    By lresults = By.xpath(".//div[@class='item-box']/div"); // nokta aktif elemnti belirtir
    By lresult = By.xpath("//div[@class='search-results']");

    @Test
    public void tets1() throws IOException {
        String title = "Demo Web Shop";
        driver.manage().window().maximize();
        // anasyfaya gidin
        open(url);


        //sayfanin ekran goruntusunu alin

        //sayfanin title sinin "Demo Web Shop" oldugunu assert edin
        Assert.assertEquals(driver.getTitle(), title);
        System.out.println(driver.getTitle());

        // comp kelimesi ile arama yapin
        wait.until(ExpectedConditions.visibilityOfElementLocated(lsearchBox)).sendKeys("comp");
        wait.until(ExpectedConditions.elementToBeClickable(lsearchButton)).click();

        //search result bekleniyor
        WebElement searchrest = wait.until(ExpectedConditions.presenceOfElementLocated(lresult));

        List<WebElement> results = searchrest.findElements(lresults); // searchrest altinda arar

        //listenenen urun sayisinin 7 oldugunu,
        Assert.assertEquals(results.size(), 7);

        // cart a eklenecek urun sayisinin 6 oldugunu assert edin
        List<WebElement> resultWithAddToCart = new ArrayList<>();
        for (WebElement result : results) {
            try {
                WebElement atc = result.findElement(By.xpath(".//input[@value='Add to cart']"));
                resultWithAddToCart.add(result);
            } catch (Exception ignored) {

            }
        }
            /*
        for (WebElement result : results) {
            if (result.findElements(By.xpath(".//input[@value=Add To cart")).size() > 0)
                resultWithAddToCart.add(result);
        }*/
        System.out.println(resultWithAddToCart.size());

        //sayfanin ekran göruntusunu alin
        TakesScreenshot screenshot = (TakesScreenshot) driver; // objeyi olustirduk

        File source = screenshot.getScreenshotAs(OutputType.FILE); //alinacak goruntu source dosyasi altinda kayedildi

        File target = new File("ScreenShot/resim.png");// diske kaydedecegimiz dosya adi
        FileUtils.copyFile(source, target);// FileUtils driver in aldigi ekran goruntusunu (source) target e yazar


        // Tek Bir elementin screenshot unu almak
        // 1-Locater alinir
        WebElement firstprocuct = searchrest.findElement(By.xpath(".//div[@class='item-box'][1]"));
        File source2 = firstprocuct.getScreenshotAs(OutputType.FILE);
        String now= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));// saat tarih olusturduk
        String name="Resim"+now+".png";// isme tarih saati ekledik
        File target2 = new File("ScreenShot/"+name);
      //  File target2 = new File("ScreenShot/resim.png");

        FileUtils.copyFile(source2, target2);
        utils.BaseClass.sleep(3000);
        driver.quit();


    }

    public void open(String url) {
        driver.get(url);
    }
}

