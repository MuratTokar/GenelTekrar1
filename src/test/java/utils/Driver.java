package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver = null;

    //singelten driver
    public static WebDriver getDriver() {
        return getDriver("Chrome");

    }

    //driver==null kontrolü olamz ise bu metoto her cagrildiginda yeni bir driver create edilir
    //yukarida private olarak define edilmis driver null ise tanimlar ve return eder
    // driver null degilse daha once tanimli ise driver i tanimlamaz ve onceki driver i return eder
    // test1 claass in da driver olarak chrome cagirdigimda ustte deger null oldugu icin
// chrome tanimlayacak ve bana gonderecek.Ikinciye edge driver
// cagirirsam bakacak degeri artik nul degil yine chrome gelecek.ilk ne tanimlandiysa oyle olacak
    //paralelde olsa tek bir driver tanimliyoruz
    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase().trim()) {
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
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
