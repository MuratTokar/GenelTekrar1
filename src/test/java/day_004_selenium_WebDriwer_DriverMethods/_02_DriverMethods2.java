package day_004_selenium_WebDriwer_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _02_DriverMethods2 {
   static WebDriver driver;
    public static void main(String[] args) {


      driver = getDriver("firefox");
        driver.get("https://guidersoft.com");

       sleep(5000);


        driver.quit();
    }

    public static void sleep(){
        sleep(2000);



    }
    public static void sleep(long milis){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static  WebDriver getDriver(){
        return getDriver("chrome");
    }

    public static WebDriver getDriver(String browser){
        switch (browser.toLowerCase().trim()){
            case "edge":
                return new EdgeDriver();

            case "firefox":
                return new FirefoxDriver();

            default:
                return new ChromeDriver();



        }
    }
}