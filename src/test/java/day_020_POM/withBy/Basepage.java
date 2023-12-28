package day_020_POM.withBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public  abstract class Basepage {

     protected WebDriver driver;
     protected WebDriverWait wait;
     protected Basepage(WebDriver driver){
          this.driver=driver;
          wait=new WebDriverWait(driver, Duration.ofSeconds(10));
     }
     public void click(By locator){
          wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
     }
     public void sendkeys(By locator,String text){
          wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
     }
}
