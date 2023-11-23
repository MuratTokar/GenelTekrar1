package day_004_selenium_WebDriwer_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01_DriverMethods {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("https://guidersoft.com");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.quit();
    }
}