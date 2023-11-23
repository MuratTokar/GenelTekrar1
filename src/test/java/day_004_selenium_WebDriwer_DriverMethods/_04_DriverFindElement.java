package day_004_selenium_WebDriwer_DriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _04_DriverFindElement {
    static WebDriver driver;
    static String url="https://www.saucedemo.com/";


    public static void main(String[] args) {


        driver = getDriver();

        driver.get(url);

         driver.findElement(By.id("user-name")).sendKeys("standard_user");
         driver.findElement(By.name("password")).sendKeys("secret_sauce");
         driver.findElement(By.id("login-button")).click();






        sleep(5000);

        //driver.quit();


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

    public static WebDriver getDriver() {
        return getDriver("chrome");
    }

    public static WebDriver getDriver(String browser) {
        switch (browser.toLowerCase().trim()) {
            case "edge":
                return new EdgeDriver();

            case "firefox":
                return new FirefoxDriver();

            default:
                return new ChromeDriver();


        }
    }
}