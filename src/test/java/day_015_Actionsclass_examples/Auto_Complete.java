package day_015_Actionsclass_examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BaseClass;

public class Auto_Complete extends BaseClass {

    @Test
    public void test(){
        By complete1=By.xpath("//div[@id='autoCompleteMultipleContainer']/div");
        String url="https://demoqa.com/auto-complete";
        driver.manage().window().maximize();
        driver.get(url);
        WebElement e1= driver.findElement(complete1);
        new Actions(driver)
      .click(e1)
                .keyDown(Keys.SHIFT) // tusa bas
                .pause(100)
                .keyDown("g")
                .keyUp(Keys.SHIFT) // tusu birak
                .pause(100)
                .keyDown(Keys.ARROW_DOWN) // asagi ok dusuna bastik
                .pause(100)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();



    }

}
