package day_016_Screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;
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
    public void tets1() {
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

        //lustenenen urun sayisinin 7 oldugunu,
        Assert.assertEquals(results.size(), 7);

        // cart a eklenecek urun sayisinin 6 oldugunu assert edin
        List<WebElement> resultWithAddToCart = new ArrayList<>();
        for (WebElement result : results) {
            try {
                WebElement atc = result.findElement(By.xpath(".//input[@value='Add to cart']"));
                resultWithAddToCart.add(result);
            } catch (Exception ignored) {

            }
            System.out.println(resultWithAddToCart.size());


        }

        driver.quit();

    }

    public void open(String url) {
        driver.get(url);
    }
}
