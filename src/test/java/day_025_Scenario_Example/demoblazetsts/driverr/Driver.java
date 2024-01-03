package day_025_Scenario_Example.demoblazetsts.driverr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {


    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>(); // dirakt ulasilmasin diye private yaptik

    public static WebDriver getdriver() {
        return getdriver("Chrome");
    }

    public static WebDriver getdriver(String browser) {
        if (drivers.get() == null) {

            switch (browser.toLowerCase().trim()) {
                case "edge":
                    drivers.set(new EdgeDriver());
                    break;
                case "firefox":
                    drivers.set(new FirefoxDriver());
                    break;
                default:
                    drivers.set(new ChromeDriver());


            }

        }
        return drivers.get();
    }

    public void quitt() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);

        }
    }
}
