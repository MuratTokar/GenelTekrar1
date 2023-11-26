package day_006_selenium_selector;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.util.List;
import java.util.stream.Collectors;

public class Tests01 extends BaseClass {

String url="https://opencart.abstracta.us/";
    @Test
    public void test1() {
        By a = By.xpath("//a");
        // toplam a sayisi kactir
        //text leri nedir consola yazdirin
        driver.get(url);

        List<WebElement> element = driver.findElements(a);
        System.out.println("element.size() = " + element.size());
        for (WebElement webElement : element) {
            if (webElement.getText().length() > 0)
                System.out.println(webElement.getText());
            ;

        }

        driver.quit();

    }

    @Test
    public void test2() {
        By a = By.cssSelector("a");

        driver.get(url);

        List<WebElement> element = driver.findElements(a);
        List<WebElement> newlist=element.stream().filter(e-> e.getText().length()>0).collect(Collectors.toList());
        System.out.println("element.size() = " + newlist.size());
        for (WebElement webElement : newlist) {
            if (webElement.getText().length() > 0)
                System.out.println(webElement.getText());
            ;

        }

        driver.quit();


    }
    @Test
    public void test3(){
        By search=By.xpath("//input[@class='form-control input-lg']");
        By buton=By.xpath("//button[@class='btn btn-default btn-lg']");
        By imac=By.xpath("//a[text()='iMac']");
        driver.get(url);


        sendkeys(search,"imac");
        click(buton);
        Assert.assertTrue(driver.findElement(imac).isDisplayed());
        driver.quit();
    }
}