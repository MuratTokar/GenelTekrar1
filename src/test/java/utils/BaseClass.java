package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BaseClass {
   public WebDriver driver;
  public WebDriverWait wait;


  public BaseClass(){
        driver=getDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));


  }

    public  WebDriver getDriver() {
        return getDriver("chrome");
    }
    public WebDriver getDriver(String browser) {
        switch (browser.toLowerCase().trim()) {
            case "edge":
                return new EdgeDriver();

            case "firefox":
                return new FirefoxDriver();

            default:
                return new ChromeDriver();


        }
    }



    public   void sleep() {
        sleep(2000);


    }
    public static void sleep(long milis) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void click(By locator){
        driver.findElement(locator).click();

    }
    public void sendkeys(By locator,CharSequence...text){
      wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
        scrollMovito(element);
        element.clear();
        element.sendKeys(text);




    }
    public  void scrollMovito(WebElement element){
       new Actions(driver).scrollToElement(element).perform();
    }
    public void jcScroll(int num) {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+num+")");

    }
    public void assertt(By locator) {
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
    }
    public void jcScriptscrollTo(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo("+x+","+y+")");
    }

    public void JcScrollIntoview(WebElement element,boolean b){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element,b);
    }

    public void clickJc(By locator){
      WebElement element=driver.findElement(locator);
      JavascriptExecutor js=(JavascriptExecutor) driver;
      js.executeScript("arguments[0].click();",element);
    }
    public void hover(WebElement element){
      new Actions(driver)
              .moveToElement(element)
              .pause(300)
              .build()
              .perform();


    }
    public void hover(By locator){
      WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
      hover(element);

    }
    public void gtakeScreenShot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String name = "Resim" + now + ".png";
        File target = new File("ScreenShot/" + name);
        FileUtils.copyFile(source, target);
    }
    public void gtakeElementScreenShot(WebElement element) throws IOException {
        File source = element.getScreenshotAs(OutputType.FILE);
        String now= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String name="ResimElement"+now+".png";
        File target = new File("ScreenShot/"+name);
        FileUtils.copyFile(source, target);


    }

}