package day_004_selenium_WebDriwer_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _03_DriverMethods3 {
    static WebDriver driver;

    public static void main(String[] args) {


        driver = getDriver();
        driver.get("https://guidersoft.com");


        // aktif sayfanin title sini return eder
        System.out.println(driver.getTitle());


        if (!driver.getTitle().equalsIgnoreCase("Home - Guider Soft"))
            throw new AssertionError("Home - Guider Soft degildir");


        // kaynak kodlari alir
       // System.out.println(driver.getPageSource());


         // o anki url verir
        System.out.println(driver.getCurrentUrl());


         // aktif syafanin id sini veririr
        System.out.println(driver.getWindowHandle());

        sleep(5000);


        // acik olan tum pencreleri kapatir
        driver.quit();

        //driver.close(); // aktif olan pencereyi kapatir
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