package day_005_selenium_Senario_click_sendkeys;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04Alistirma extends BaseClass{
    String url="http://uitestingplayground.com/";
    By inputText=By.xpath("//a[text()='Text Input']");
    By myButton=By.xpath("//input[@id='newButtonName']");
    By button2=By.xpath("//button[@id='updatingButton']");
    @Test
    public void test(){
        driver.get(url);
         sleep(3000);
         click(inputText);
         sendkeys(myButton,"murat");
         sleep(3000);

        click(button2);


         Assert.assertTrue(driver.findElement(button2).getText().equalsIgnoreCase("murat"));
     //  Assert.assertTrue(driver.findElement(button2).isDisplayed());

        }
    }

