package day_005_selenium_Senario_click_sendkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {
   public WebDriver driver;
   public WebDriverWait wait;


   public BaseClass(){
        driver=getDriver();


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



    public static void sleep() {
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
        WebElement eUsername=driver.findElement(locator);
        eUsername.clear();
        eUsername.sendKeys(text);


    }
    public void scrollMovito(WebElement element){
       new Actions(driver).scrollToElement(element).perform();
    }
}