package day_018_Cookies_FluentWait_Scenario;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static day_018_Cookies_FluentWait_Scenario.Locators.*;

import java.time.Duration;

public class WaitAlternative{
    WebDriver driver;
    WebDriverWait wait;
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }



    @Test
    public void test1(){
        driver.get(url);
      // wait.until(ExpectedConditions.visibilityOfElementLocated(searchinput));

       wait.until(d ->{ // wait ile aynidir
           try {
               if (d.findElement(searchinput).isDisplayed())
                   return true;
               return false;
           }catch (Exception e){
               return false;
           }
        });

       // burdada cesitli ozellikler ekleriz
        Wait<WebDriver> wait1=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        wait1.until(d -> {
            return true;
        });



    }
    public void click(By Locator){
        wait.until(d ->{
            try {
                d.findElement(Locator).click();
                return true;


            }catch (Exception e){
                try {
                    new Actions(d)
                            .click(driver.findElement(Locator))
                            .build().perform();
                    return true;

                }catch (Exception e1){
                    try {
                        WebElement element=driver.findElement(Locator);
                        JavascriptExecutor executor= (JavascriptExecutor) driver;
                        executor.executeScript("arguments[0].click",element);
                    }catch (Exception e2){
                        return false;

                    }

                   return false;

                }



            }

        });
    }



}


class Locators{
    public static String url="https://opencart.abstracta.us/";
    public static By searchinput=By.cssSelector("#search input");
    public static By searchButton=By.cssSelector("#search button");


}

