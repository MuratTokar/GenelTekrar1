package day_017_Authentications_Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;

import java.time.Duration;

public class Authentication extends BaseClass {

    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    String url = "https://the-internet.herokuapp.com/";
    // String url1 = "https://admin:admin@the-internet.herokuapp.com/basic_auth";// bu sekilde gidebilirim
    By basicAuth = By.xpath("//a[text()='Basic Auth']");

    @Test
    public void test() {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(basicAuth)).click();
        wait.until(ExpectedConditions.urlContains("basic_auth"));

         /*  AUTHBASIC
acilan sayfada alert gibi görünen ve username ,password girililmesi gereken bir uyari cikar.
buraya selenium ile ulasilmaz
*Basic,Digest,Federal Authentication
acilan popup alert deildir

*Burayi asmanin 1.yolu:
https://siteName.com
username:user
password:pass

Basic authentication
https://username:password@siteName.com*/

    }

    @Test
    public void test1() {
        String url1 = "https://admin:admin@the-internet.herokuapp.com/basic_auth";// bu sekilde gidebilirim
        driver.get(url1);


    }

    @Test
    public void test2() {
        String url = "https://the-internet.herokuapp.com/";
        String username = "admin";
        String password = "admin";

        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(basicAuth)).click();
        wait.until(ExpectedConditions.urlContains("basic_auth"));

        String url2 = driver.getCurrentUrl().replace("https://", "https://" + username + ":" + password + "@");
        driver.get(url2);


    }

    @Test
    public void test3() {
        By digestauth = By.xpath("//a[text()='Digest Authentication']");
        String url = "https://the-internet.herokuapp.com/";

        driver.get(url);
        driver.findElement(digestauth).click();
        wait.until(ExpectedConditions.urlContains("digest_auth"));

        String user = "admin";
        String password = "admin";
        String url3 = driver.getCurrentUrl().replace("https://", "https://" + user + ":" + password + "@");
       driver.navigate().to(url3);
       sleep(4000);
        driver.navigate().refresh();
       sleep(4000);
        driver.navigate().back();
        driver.navigate().back();

       sleep(4000);
       driver.navigate().forward();
       sleep(4000);

    }

    @Test
    public void test4() {
        String url = "https://admin:admin@the-internet.herokuapp.com/digest_auth";

        driver.get(url);
    }
    @Test
    public void federalAuthentication() {
        //bu sayfada authentication oldugunu dusunun
        String url = "https://the-internet.herokuapp.com/";
        String username = "admin";
        String password = "admin";
        // önce sayfaya gittik
        driver.get(url);

        String url2 = driver.getCurrentUrl().replace("https://", "https://" + username + ":" + password + "@");
        driver.get(url2);


    }
}
