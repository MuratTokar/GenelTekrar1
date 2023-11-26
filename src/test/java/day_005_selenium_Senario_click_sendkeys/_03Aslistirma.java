package day_005_selenium_Senario_click_sendkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;

public class _03Aslistirma extends BaseClass {
    // "imac " serach edin
    //imac urununun sayfaya geldigini assert edin
    By searchButton=By.xpath("//input[@name='search']");
    String search="imac";
    By asert=By.tagName("h4");

    String url="http://opencart.abstracta.us/";
    @Test
    public void test1(){
        driver.get(url);
        driver.manage().window().maximize();

        sendkeys(searchButton,search, Keys.ENTER);
        sleep(5000);

       Assert.assertTrue(driver.findElement(asert).getText().equalsIgnoreCase("imac"));

       driver.quit();

    }
}
