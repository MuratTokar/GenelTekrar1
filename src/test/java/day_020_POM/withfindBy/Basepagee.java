package day_020_POM.withfindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public  abstract class Basepagee {

     protected WebDriver driver;
     protected WebDriverWait wait;
     protected Basepagee(WebDriver driver){
          this.driver=driver;
          wait=new WebDriverWait(driver, Duration.ofSeconds(10));
     }
     public void click(WebElement element){
          wait.until(ExpectedConditions.elementToBeClickable(element)).click();
     }
     public void sendkeys(WebElement element,String text){
          wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
     }
}
