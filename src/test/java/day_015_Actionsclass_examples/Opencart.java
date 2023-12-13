package day_015_Actionsclass_examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.util.List;

public class Opencart extends BaseClass {
    By search=By.xpath("//input[@name='search']");
    By macs=By.xpath("//div[@class='caption']/h4/a[contains(text(),'Mac')]");

    @Test
    public void test(){
        String url="https://opencart.abstracta.us/";
        driver.manage().window().maximize();
        driver.get(url);
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(search));
        new Actions(driver)
                .sendKeys(element,"mac")
                .pause(100)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        List<WebElement> mac=driver.findElements(macs);
        for (WebElement webElement1 : mac) {
            Assert.assertTrue(webElement1.getText().toLowerCase().contains("mac"));
            System.out.println(webElement1.getText());

        }
        driver.quit();
    }
}
