package day_014_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.util.List;

public class Actions2 extends BaseClass {
    @Test
    public void test(){
        String url="https://practice.expandtesting.com/drag-and-drop-circles";
        By drag=By.cssSelector("#target");
        By drags=By.xpath("//div[@draggable='true']");
        driver.manage().window().maximize();
        driver.get(url);

        WebElement dragg=driver.findElement(drag);
        List<WebElement > elemts=driver.findElements(drags);
        for (WebElement elemt : elemts) {
            new Actions(driver).clickAndHold(elemt)
                    .moveToElement(dragg)
                    .release().perform();

        }
        driver.quit();
    }
}
