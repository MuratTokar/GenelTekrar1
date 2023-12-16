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


public class TestTricentis1 {

    @Test
    public void tets1() throws IOException {
        TricentisHomePage hp=new TricentisHomePage(Driver.getDriver());
        hp.maximize();
        hp.open();
        String title = "Demo Web Shop";
        hp.checkTitle(title);
        hp.search("comp");
        List<WebElement> results=hp.getProductList();

        List<WebElement> resultWithAddToCart = new ArrayList<>();
        for (WebElement result : results) {
            try {
                WebElement atc = result.findElement(By.xpath(".//input[@value='Add to cart']"));
                resultWithAddToCart.add(result);
            } catch (Exception ignored) {

            }
        }

        System.out.println(resultWithAddToCart.size());
        hp.gtakeScreenShot();
        hp.gtakeElementScreenShot(results.get(0));

        utils.BaseClass.sleep(3000);
        Driver.quit();


    }

}

