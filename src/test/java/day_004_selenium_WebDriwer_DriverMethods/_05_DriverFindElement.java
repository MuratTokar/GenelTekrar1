package day_004_selenium_WebDriwer_DriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _05_DriverFindElement {
    static WebDriver driver;
    static String url="https://www.saucedemo.com/";


    public static void main(String[] args) {


        driver = getDriver();
        driver.get(url);


        By lusername=By.id("user-name");
        WebElement username=driver.findElement(lusername);
        username.sendKeys("standard_user");
        System.out.println("username.isEnabled() = " + username.isEnabled());


        By lpassword=By.name("password");
        WebElement password= driver.findElement(lpassword);
        password.sendKeys("secret_sauce");
        System.out.println("password.isDisplayed() = " + password.isDisplayed());


        By llogin=By.id("login-button");
        WebElement login=   driver.findElement(llogin);
        System.out.println("login.getAttribute(\"class\") = " + login.getAttribute("class"));
        System.out.println("login.getCssValue(\"background-color\") = " + login.getCssValue("background-color"));
        login.click();



        sleep(5000);

     driver.quit();


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