package day_004_selenium_WebDriwer_DriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _08_TsetNGAnotationÖdev {
   WebDriver driver;
    String url="https://www.saucedemo.com/";
    By lusername=By.id("user-name");
    By lPassword=By.id("password");
    By lLogin=By.id("login-button");
    By lProduck=By.xpath("//span[text()='Products']");


    @Test
    public  void test1() {
     driver=getDriver("chrome");
     driver.get(url);


     WebElement username=driver.findElement(lusername);
     username.clear();
     username.sendKeys("standard_user");

     WebElement pass=driver.findElement(lPassword);
     pass.clear();
     pass.sendKeys("secret_sauce");


     driver.findElement(lLogin).click();

     Assert.assertTrue(driver.findElement(lProduck).isDisplayed());


     driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

     By lsepet=By.id("shopping_cart_container");
     WebElement sepet= driver.findElement(lsepet);
     sepet.click();

     Assert.assertTrue(driver.findElement(By.linkText("Sauce Labs Bike Light")).isDisplayed());


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