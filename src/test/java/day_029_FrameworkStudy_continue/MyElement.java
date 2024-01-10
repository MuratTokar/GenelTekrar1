package day_029_FrameworkStudy_continue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class MyElement {

    public static MyElement $(By locator){
        return new MyElement(locator);
    }
    public WebDriver driver;
    private WebDriverWait wait;
    By locator;

    private MyElement(By locator){

       this.locator=locator;
       driver= Driver.getDriver();
       wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public MyElement sendkeys(String tex){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(tex);

        return  this;
    }
    public MyElement click(){
       wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        return  this;
    }
    public MyElement shouldBe(Conditions conditions){
        switch (conditions){
            case visible:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            case clickable:
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            default:
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }

        return  this;
    }

}
