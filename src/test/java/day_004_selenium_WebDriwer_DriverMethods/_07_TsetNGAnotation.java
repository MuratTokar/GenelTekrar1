package day_004_selenium_WebDriwer_DriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _07_TsetNGAnotation {
   WebDriver driver;
    String url="https://www.saucedemo.com/";

    @Test
    public  void test1() {


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
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertTrue (driver.findElement(By.id("shopping_cart_container")).isDisplayed());

         driver.findElement(By.linkText("Sauce Labs Backpack")).click();
         Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-bike-light")).isDisplayed());

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