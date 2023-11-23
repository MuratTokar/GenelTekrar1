package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver = null;
    //singelten driver

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase().trim()) {
                case "edge":
                    //return new EdgeDriver();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    // return new FirefoxDriver();
                    driver = new FirefoxDriver();
                    break;
                default:
                    // new ChromeDriver();
                    driver = new ChromeDriver();
            }

        }
        return driver;
        // burda her seferinde yeni driver acacak.Eger buyuk bir projede calisacak olursak ve her seferinde yeni
        // driver acilmasin ve ayni Driver ile devam etsin istiyorsak return yerine driver = yapariz ve break atariz.
        // driver=Driver.getDriver(); olarak cagirirz.üstte if blogunda eger driver==null bana bana driver gonder
        //test hangi driver ile baslasa onunla biter
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
