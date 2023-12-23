package day_018_Cookies_FluentWait_Scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
