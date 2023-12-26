package day_018_Cookies_FluentWait_Scenario;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;

import java.time.Duration;
import java.util.Set;

public class Cookiess extends BaseClass {

    {
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    String url="https://bonigarcia.dev/selenium-webdriver-java/cookies.html";

    @Test
    public void test_getCookies(){
        driver.get(url);

       // driver.manage().deleteAllCookies();// cookileri sildik

        Set<Cookie> cookis=driver.manage().getCookies(); //cookileri aldik
        for (Cookie cooki : cookis) {
            System.out.println("cooki.getName() = " + cooki.getName());
            System.out.println("cooki.getValue() = " + cooki.getValue());

        }

        Cookie mwcookie=new Cookie("text","selenium");
        driver.manage().addCookie(mwcookie);
        System.out.println("driver.manage().getCookieNamed(\"text\") = " + driver.manage().getCookieNamed("text"));
        driver.quit();


    }
}
