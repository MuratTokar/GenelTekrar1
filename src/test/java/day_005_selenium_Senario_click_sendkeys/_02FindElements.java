package day_005_selenium_Senario_click_sendkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class _02FindElements extends BaseClass{
    String url="https://opencart.abstracta.us/";
    @Test
    public void findElements(){
        driver.get(url);
         //driver.findElement(By.tagName("H4")).click();
        //click(By.tagName("H4"));// yada click metodu ile
        WebElement element=driver.findElement(By.tagName("H4"));
        System.out.println(element.getText());
        List<WebElement> elements=driver.findElements(By.tagName("H4"));
        for (WebElement webElement2 : elements) {
            System.out.println(webElement2.getText());

        }

        sleep(2000);
        driver.quit();
    }
}
